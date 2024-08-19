package tp_programmationweb.appweb_fermebio.persistance;

import tp_programmationweb.appweb_fermebio.modele.ProduitTraduction;
import java.util.List;

public interface IProduitTraductionDAO {
    void ajouterProduitTraduction(ProduitTraduction produitTraduction);
    void mettreAJourProduitTraduction(ProduitTraduction produitTraduction);
    void supprimerProduitTraduction(int id);
    ProduitTraduction trouverProduitTraductionParId(int id);
    List<ProduitTraduction> trouverTousLesProduitTraductions();
    List<ProduitTraduction> trouverTraductionsParProduitId(int produitId);
    List<ProduitTraduction> trouverTraductionsParLangue(String langue);
}
