package tp_programmationweb.appweb_fermebio.persistance;

import jakarta.persistence.*;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import tp_programmationweb.appweb_fermebio.modele.Client;

import java.util.HashMap;

public class DAO_Client {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Client() {
        PersistenceUnitInfo pui = new Ferme_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap<>());
        this.em = emf.createEntityManager();

    }

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
}