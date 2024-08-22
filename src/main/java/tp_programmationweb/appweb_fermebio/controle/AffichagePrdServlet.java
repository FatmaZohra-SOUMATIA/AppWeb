package tp_programmationweb.appweb_fermebio.controle;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp_programmationweb.appweb_fermebio.dto.ProduitDTO;
import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.modele.Produit;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Client;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Produit;
import tp_programmationweb.appweb_fermebio.service.GestionClient;
import tp_programmationweb.appweb_fermebio.service.GestionProduit;


@WebServlet(name = "AffichagePrdServlet", value = "/AffichagePrdServlet")
public class  AffichagePrdServlet  extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      //  HttpSession session = request.getSession();
       // String langue = request.getParameter("langue");
        String langue= "FR";

        List<ProduitDTO> produits = new ArrayList<>();
        DAO_Produit daoProduit = new DAO_Produit();

        GestionProduit gestionProduitService = new GestionProduit(daoProduit);
        //produits = gestionProduitService.trouverProduitsParLangue(langue);

        //demo
        produits.add(new ProduitDTO("apple",2,20,"good appel"));
        produits.add(new ProduitDTO("bleuet",3,30,"good bleuet"));
        produits.add(new ProduitDTO("citrouille",4,40,"good citrouille"));
        produits.add(new ProduitDTO("laitue",3,30,"good laitue"));
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("/jsp/nosProduits.jsp").forward(request, response);
    }


    public void destroy() {
    }

}

