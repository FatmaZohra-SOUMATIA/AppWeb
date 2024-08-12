package tp_programmationweb.appweb_fermebio.modele;

import java.util.Date;
import java.util.List;

public class Commande {
    private Long id;
    private Date date;
    private Client client;
    private List<LigneCommande> lignesCommande;

    // Constructeurs
    public Commande() {}

    public Commande( Date date, Client client, List<LigneCommande> lignesCommande) {

        this.date = date;
        this.client = client;
        this.lignesCommande = lignesCommande;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
}

