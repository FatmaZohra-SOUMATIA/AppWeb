package tp_programmationweb.appweb_fermebio.modele;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Date date;

    // Constructeurs
    public Message() {}



    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                 ", contenu='" + contenu + '\'' +
                ", date=" + date +
                '}';
    }

}
