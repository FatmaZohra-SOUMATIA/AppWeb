package tp_programmationweb.appweb_fermebio.service;

import tp_programmationweb.appweb_fermebio.dto.ProduitDTO;
import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.modele.Produit;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Client;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Produit;

import java.util.List;

public class GestionProduit {
    private DAO_Produit daoProduit;

    public GestionProduit(DAO_Produit daoProduit) {
        this.daoProduit = daoProduit;
    }

    public void maisAJourQtsProduit(int idProduit, int qts) {

        this.daoProduit.maisAJourQtsProduit(idProduit, qts);
    }

    public List <ProduitDTO>  trouverProduitsParLangue(String langue) {
        return this.daoProduit.trouverProduitsParLangue(langue);   }
}
