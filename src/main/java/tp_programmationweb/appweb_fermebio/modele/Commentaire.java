package tp_programmationweb.appweb_fermebio.modele;

import java.util.Date;

public class Commentaire {
    private Long id;
    private Client client;
    private Produit produit;
    private String texte;
    private Date date;

    // Constructeurs
    public Commentaire() {}

    public Commentaire(Long id, Client client, Produit produit, String texte, Date date) {
        this.id = id;
        this.client = client;
        this.produit = produit;
        this.texte = texte;
        this.date = date;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

