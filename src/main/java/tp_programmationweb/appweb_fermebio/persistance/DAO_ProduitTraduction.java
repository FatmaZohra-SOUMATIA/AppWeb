package tp_programmationweb.appweb_fermebio.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import tp_programmationweb.appweb_fermebio.modele.ProduitTraduction;

import java.util.HashMap;
import java.util.List;

public class DAO_ProduitTraduction implements IProduitTraductionDAO{
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_ProduitTraduction() {
        PersistenceUnitInfo pui = new Ferme_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap<>());
        this.em = emf.createEntityManager();

    }


    @Override
    public void ajouterProduitTraduction(ProduitTraduction produitTraduction) {
        try {
            em.getTransaction().begin();
            em.persist(produitTraduction);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout de la traduction du produit", e);
        }
    }

    @Override
    public void mettreAJourProduitTraduction(ProduitTraduction produitTraduction) {
        try {
            em.getTransaction().begin();
            em.merge(produitTraduction);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la mise à jour de la traduction du produit", e);
        }
    }

    @Override
    public void supprimerProduitTraduction(int id) {
        try {
            em.getTransaction().begin();
            ProduitTraduction produitTraduction = em.find(ProduitTraduction.class, id);
            if (produitTraduction != null) {
                em.remove(produitTraduction);
            }
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression de la traduction du produit", e);
        }
    }

    @Override
    public ProduitTraduction trouverProduitTraductionParId(int id) {
        try {
            return em.find(ProduitTraduction.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la recherche de la traduction du produit par ID", e);
        }
    }

    @Override
    public List<ProduitTraduction> trouverTousLesProduitTraductions() {
        try {
            TypedQuery<ProduitTraduction> query = em.createQuery("SELECT pt FROM ProduitTraduction pt", ProduitTraduction.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la recherche de toutes les traductions de produits", e);
        }
    }

    @Override
    public List<ProduitTraduction> trouverTraductionsParProduitId(int produitId) {
        try {
            TypedQuery<ProduitTraduction> query = em.createQuery("SELECT pt FROM ProduitTraduction pt WHERE pt.produit.id = :produitId", ProduitTraduction.class);
            query.setParameter("produitId", produitId);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la recherche des traductions par ID de produit", e);
        }
    }

    @Override
    public List<ProduitTraduction> trouverTraductionsParLangue(String langue) {
        try {
            TypedQuery<ProduitTraduction> query = em.createQuery("SELECT pt FROM ProduitTraduction pt WHERE pt.langue = :langue", ProduitTraduction.class);
            query.setParameter("langue", langue);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la recherche des traductions par langue", e);
        }
    }
        public void close() {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }