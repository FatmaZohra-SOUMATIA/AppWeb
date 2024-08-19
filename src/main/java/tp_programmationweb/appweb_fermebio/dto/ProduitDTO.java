package tp_programmationweb.appweb_fermebio.dto;


public class ProduitDTO {
    private String nom;
    private double prix;
    private int quantiteDisponible;
    private String descriptionTraductionFr;

    public ProduitDTO() {
    }

    public ProduitDTO(String nom, double prix, int quantiteDisponible, String descriptionTraductionFr) {
        this.nom = nom;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
        this.descriptionTraductionFr = descriptionTraductionFr;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getDescriptionTraductionFr() {
        return descriptionTraductionFr;
    }

    public void setDescriptionTraductionFr(String descriptionTraductionFr) {
        this.descriptionTraductionFr = descriptionTraductionFr;
    }

    @Override
    public String toString() {
        return "ProduitDTO{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantiteDisponible=" + quantiteDisponible +
                ", descriptionTraductionFr='" + descriptionTraductionFr + '\'' +
                '}';
    }
}