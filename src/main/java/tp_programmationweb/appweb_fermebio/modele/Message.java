package tp_programmationweb.appweb_fermebio.modele;

import java.util.Date;

public class Message {
    private Long id;
    private Client client;
    private String contenu;
    private Date date;

    // Constructeurs
    public Message() {}

    public Message(Long id, Client client, String contenu, Date date) {
        this.id = id;
        this.client = client;
        this.contenu = contenu;
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
}

