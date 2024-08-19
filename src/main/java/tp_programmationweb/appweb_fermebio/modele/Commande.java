package tp_programmationweb.appweb_fermebio.modele;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private java.sql.Date date;

    @OneToMany
    @JoinColumn(name = "IdCommande")
    private List<LigneCommande> lignesCommande;

    // Constructeurs
    public Commande() {}

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", date=" + date +
                ", lignesCommande=" + lignesCommande +
                '}';
    }

}
