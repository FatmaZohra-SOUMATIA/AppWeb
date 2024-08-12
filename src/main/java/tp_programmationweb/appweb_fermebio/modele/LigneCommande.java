package tp_programmationweb.appweb_fermebio.modele;

public class LigneCommande {
    private Long id;
    private Produit produit;
    private int quantite;
    private double prix;

    // Constructeurs
    public LigneCommande() {}

    public LigneCommande(Long id, Produit produit, int quantite, double prix) {
        this.id = id;
        this.produit = produit;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
