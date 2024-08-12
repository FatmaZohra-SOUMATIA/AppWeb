package tp_programmationweb.appweb_fermebio.persistance;

public class BoxRequeteSQL {

    // Requête pour afficher tous les clients
    final static  String AFFICHER_CLIENTS="SELECT * FROM Client";

    // Requête pour afficher un client par email
    final static  String AFFICHER_CLIENTS_PAR_EMAIL="SELECT * FROM Client WHERE email = ?";

    //Requête pour inserer un nouveau client
    final static  String INSERT_CLIENT ="INSERT INTO Client (nom, email) VALUES (?, ?)";

}



