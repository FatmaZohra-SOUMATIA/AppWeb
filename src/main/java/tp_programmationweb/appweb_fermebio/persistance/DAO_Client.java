package tp_programmationweb.appweb_fermebio.persistance;

import jakarta.persistence.*;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import tp_programmationweb.appweb_fermebio.modele.Client;


import java.util.HashMap;


public class DAO_Client implements IClientDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Client() {
        PersistenceUnitInfo pui = new Ferme_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap<>());
        this.em = emf.createEntityManager();

    }

    @Override
    public void insererClient(Client nouveauClient) {

        if (nouveauClient != null && nouveauClient.getNom() != null && nouveauClient.getEmail() != null) {
            // Début de la transaction
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                // Persister l'entité Client dans la base de données
                em.persist(nouveauClient);
                transaction.commit(); // Valider la transaction

            } catch (Exception e) {

                e.printStackTrace();

            }
        } else {
            throw new IllegalArgumentException("Client ou ses attributs ne peuvent pas être null.");
        }
    }

    @Override
    public Client trouverClientParId(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public Client trouverParMail(String email) {
        try {
            TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la recherche du client par email", e);
        }
    }

    @Override
    public void mettreAJourClient(Client client) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la mise à jour du client", e);
        }
    }

    @Override
    public void supprimerClient(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Client client = em.find(Client.class, id);
            if (client != null) {
                em.remove(client);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression du client", e);
        }
    }

    @Override
    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}