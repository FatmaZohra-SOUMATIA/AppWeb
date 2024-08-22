package tp_programmationweb.appweb_fermebio.persistance;
import tp_programmationweb.appweb_fermebio.dto.ProduitDTO;
import tp_programmationweb.appweb_fermebio.modele.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import tp_programmationweb.appweb_fermebio.modele.ProduitTraduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DAO_Produit implements IProduitDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Produit() {
        PersistenceUnitInfo pui = new Ferme_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap<>());
        this.em = emf.createEntityManager();

    }

    @Override
    public void ajouterProduit(Produit produit) {
        try {
            em.getTransaction().begin();
            em.persist(produit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout du produit", e);
        }
    }

    @Override
    public void mettreAJourProduit(Produit produit) {
        try {
            em.getTransaction().begin();
            em.merge(produit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la mise à jour du produit", e);
        }
    }

    @Override
    public void supprimerProduit(int id) {
        try {
            em.getTransaction().begin();
            Produit produit = em.find(Produit.class, id);
            if (produit != null) {
                em.remove(produit);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression du produit", e);
        }
    }

    @Override
    public Produit trouverProduitParId(int id) {
        return em.find(Produit.class, id);
    }

    @Override
    public List<Produit> trouverTousLesProduits() {
        TypedQuery<Produit> query = em.createNamedQuery("Produit.TROUVER_TOUS_PRODUITS", Produit.class);
        return query.getResultList();
    }

    @Override
    public List<ProduitDTO> trouverProduitsParLangue(String langue) {
        TypedQuery<ProduitTraduction> query = em.createNamedQuery("ProduitTraduction.trouverProduitsParLangue", ProduitTraduction.class);
        query.setParameter("langue", langue);

        List<ProduitTraduction> traductions = query.getResultList();
        List<ProduitDTO> produits = new ArrayList<>();

        for (ProduitTraduction traduction : traductions) {
            Produit produit = traduction.getProduit();
            ProduitDTO produitDTO = new ProduitDTO(
                    traduction.getNom(),
                    produit.getPrix(),
                    produit.getQuantiteDisponible(),
                    traduction.getDescription());
            produits.add(produitDTO);
        }

        return produits;
    }
    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public void maisAJourQtsProduit(int idProduit, int qts) {

    }
}
