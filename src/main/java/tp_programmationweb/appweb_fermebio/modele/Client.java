package tp_programmationweb.appweb_fermebio.modele;

import jakarta.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(unique=true, nullable=false)
    private String email;


    // Constructeurs
    public Client() {}

    public Client( String nom, String email, String adresse) {

        this.nom = nom;
        this.email = email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

