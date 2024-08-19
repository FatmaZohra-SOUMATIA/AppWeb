package tp_programmationweb.appweb_fermebio.modele;

import jakarta.persistence.*;

@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdProduit", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private int quantite;

    @Column(nullable = false)
    private double prix;

    // Constructeurs
    public LigneCommande() {}

    public LigneCommande(Produit produit, int quantite, double prix) {

        this.produit = produit;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", produit=" + produit +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }

}
