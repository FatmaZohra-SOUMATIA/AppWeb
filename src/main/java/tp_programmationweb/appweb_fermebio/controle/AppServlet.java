package tp_programmationweb.appweb_fermebio.controle;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Client;
import tp_programmationweb.appweb_fermebio.service.GestionClient;

@WebServlet(name = "AppServlet", value = "/app-servlet")
public class AppServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Récupérer le type de client
        String clientType = request.getParameter("clientType");

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
            response.sendRedirect("confirmation.html");

        } else if ("existing".equals(clientType)) {
            // Traitement pour les anciens clients
            String email = request.getParameter("email");

            // Vous pouvez ajouter une logique pour vérifier si le client existe, par exemple
            // Client existingClient = clientService.getClientByEmail(email);
            // Si le client existe, rediriger vers une page appropriée

            // Rediriger vers une page de confirmation ou d'accueil
            response.sendRedirect("index.html");

        } else {
            // Gestion des erreurs ou redirection en cas de type de client invalide
            response.sendRedirect("error.html");
        }
    }


    public void destroy() {
    }

}

