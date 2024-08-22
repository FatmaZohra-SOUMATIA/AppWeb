package tp_programmationweb.appweb_fermebio.controle;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Client;
import tp_programmationweb.appweb_fermebio.service.GestionClient;

@WebServlet(name = "GestionClientServlet", value = "/gestionClient-servlet")
public class GestionClientServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Récupérer le type de client
        String clientType = request.getParameter("clientType");
        HttpSession session = request.getSession();



        if ("new".equals(clientType)) {
            // Traitement pour les nouveaux clients
            String nom = request.getParameter("name");
            String email = request.getParameter("email");

            // Créer un nouvel objet Client
            Client newClient = new Client();
            newClient.setNom(nom);
            newClient.setEmail(email);


            // Appeler la méthode du service pour ajouter le client à la base de données
            DAO_Client dao = new DAO_Client();
            GestionClient service = new GestionClient(dao);
            service.ajouterClient(newClient);

            // Rediriger vers une page de confirmation ou d'accueil
            //response.sendRedirect("confirmation.html");
            session.setAttribute("client", newClient);
        } else if ("existing".equals(clientType)) {
            // Traitement pour les anciens clients
            String email = request.getParameter("email");

            Client ancienClient = new Client();

            DAO_Client dao = new DAO_Client();
            GestionClient service = new GestionClient(dao);
            ancienClient= service.trouverClient(email);
            if (ancienClient != null) {

                session.setAttribute("client", ancienClient);
            } else{
                // Rediriger vers une page de confirmation ou d'accueil
                response.sendRedirect("index.html");
            }



        } else {
            // Gestion des erreurs ou redirection en cas de type de client invalide
            response.sendRedirect("error.html");
        }
        request.getRequestDispatcher("/jsp/accueil.jsp").forward(request, response);

    }


    public void destroy() {
    }

}

