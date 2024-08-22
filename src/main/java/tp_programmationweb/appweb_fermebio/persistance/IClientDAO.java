
package tp_programmationweb.appweb_fermebio.persistance;

import tp_programmationweb.appweb_fermebio.modele.Client;
import tp_programmationweb.appweb_fermebio.modele.Message;

import java.util.List;

public interface IClientDAO {
    void insererClient(Client nouveauClient);
    Client trouverClientParId(int id);
    Client trouverParMail(String email);
    void mettreAJourClient(Client client);
    void supprimerClient(int id);
    void close();
}
