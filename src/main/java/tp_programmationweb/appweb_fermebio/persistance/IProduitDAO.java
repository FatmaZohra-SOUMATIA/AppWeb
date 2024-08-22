package tp_programmationweb.appweb_fermebio.persistance;
import tp_programmationweb.appweb_fermebio.dto.ProduitDTO;
import tp_programmationweb.appweb_fermebio.modele.Produit;

import java.util.List;

public interface IProduitDAO {
    void ajouterProduit(Produit produit);
    void mettreAJourProduit(Produit produit);
    void supprimerProduit(int id);
    Produit trouverProduitParId(int id);
    List<Produit> trouverTousLesProduits();
    List<ProduitDTO> trouverProduitsParLangue(String langue)   ;

    void maisAJourQtsProduit(int idProduit, int qts);
}
