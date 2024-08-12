package tp_programmationweb.appweb_fermebio.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Query;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.transaction.Transactional;
import org.hibernate.jpa.HibernatePersistenceProvider;
import tp_programmationweb.appweb_fermebio.modele.Client;


import java.util.HashMap;
import java.util.List;


public class DAO_Client {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Client() {
        PersistenceUnitInfo pui = new Ferme_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap());
        this.em = emf.createEntityManager();
    }

    @Transactional
    public void insererClient(Client nouveauClient) {
        if (nouveauClient != null && nouveauClient.getNom() != null && nouveauClient.getEmail() != null) {
            // Persister l'entité Client dans la base de données
            em.persist(nouveauClient);
           // em.flush();
        } else {
            throw new IllegalArgumentException("Client ou ses attributs ne peuvent pas être null.");
        }




    }

}
