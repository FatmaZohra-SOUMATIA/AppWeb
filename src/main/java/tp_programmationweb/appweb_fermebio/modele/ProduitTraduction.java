package tp_programmationweb.appweb_fermebio.modele;


import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "ProduitTraduction.trouverProduitsParLangue",
                query = "SELECT pt FROM ProduitTraduction pt WHERE pt.langue = :langue"
        )
})

public class ProduitTraduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private String langue; // "fr", "en", etc.

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String description;

    // Constructeurs
    public ProduitTraduction() {}

    public ProduitTraduction(Produit produit, String langue, String nom, String description) {
        this.produit = produit;
        this.langue = langue;
        this.nom = nom;
        this.description = description;
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
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

    @Override
    public String toString() {
        return "ProduitTraduction{" +
                "id=" + id +
                ", langue='" + langue + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

