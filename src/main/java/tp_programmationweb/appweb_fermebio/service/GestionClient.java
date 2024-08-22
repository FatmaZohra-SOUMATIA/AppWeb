package tp_programmationweb.appweb_fermebio.service;

import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.persistance.DAO_Client;

public class GestionClient {

    private DAO_Client daoClient;

    public GestionClient(DAO_Client daoClient) {
        this.daoClient = daoClient;
    }

    public void ajouterClient(Client client) {

        this.daoClient.insererClient(client);
    }

    public Client trouverClient(String email) {
        return this.daoClient.trouverParMail(email);   }

}
