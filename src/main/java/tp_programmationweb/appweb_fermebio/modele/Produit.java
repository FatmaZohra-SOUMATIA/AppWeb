package tp_programmationweb.appweb_fermebio.modele;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Produit.TROUVER_TOUS_PRODUITS",
                query = "SELECT p FROM Produit p"
        )
})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String nom;

    @Column
    private String description;

    @Column(nullable = false)
    private double prix;

    @Column(nullable = false)
    private int quantiteDisponible;

    // Constructeurs
    public Produit() {}

    public Produit(String nom, String description, double prix, int quantite) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteDisponible = quantite;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantiteDisponible=" + quantiteDisponible +
                '}';
    }

}
