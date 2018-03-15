import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Contact {

    private int numero;
    private String prenom;
    private String nomFamille;
    private Adresse adresse;
    private Occupation occupation;
    private List<Telephone> listNum = new ArrayList<Telephone>();



    private int nbNum = -1;

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getNomFamille() {return nomFamille;}

    public void setNomFamille(String nomFamille) {this.nomFamille = nomFamille;}

    public Adresse getAdresse() {return adresse;}

    public void setAdresse(Adresse adresse) {this.adresse = adresse;}

    public Occupation getOccupation() {return occupation;}

    public void setOccupation(Occupation occupation) {this.occupation = occupation;}

    public List<Telephone> getListNum() {return listNum;}

    public void setListNum(List<Telephone> listNum) {this.listNum = listNum;}

    public int getNbNum() {return nbNum;}

    public void setNbNum(int nbNum) {this.nbNum = nbNum;}

    public static Scanner sc = new Scanner(System.in);

     int posiContacts = -1;

    public int getPosiContacts() { return posiContacts; }

    public void setPosiContacts(int posiContacts) { this.posiContacts = posiContacts; }

    public static Contact nouvContact(){

        Contact contact = new Contact();

        System.out.println();
        System.out.println("Veuillez entrer les informations suivantes : ");

        System.out.println();
        System.out.print("Prénom : ");
        contact.prenom = sc.next().toLowerCase();

        System.out.print("Nom : ");
        contact.nomFamille = sc.next();

        contact.setAdresse(Adresse.nouvAdresse());

        contact.setOccupation(Occupation.nouvOccupation());

        boolean ajoutNum = false;
        while (ajoutNum == false) {
            System.out.println();
            System.out.print("Entrer un numéro de téléphone (o/n)? ");
            String repTel = "";
            repTel = sc.next();


            if (repTel.equals("o")) {

                contact.setNbNum(contact.getNbNum()+1);
                contact.listNum.add(contact.getNbNum(), Telephone.nouvTelephone());
            }
            else if (repTel.equals("n")) {
                ajoutNum = true;
            }
            else
            {
                System.out.println("Entrez une réponse valide");
            }

        }

        return contact;
    }

    public void afficher(){
        System.out.println("Prénom  : " + prenom);
        System.out.println("Nom : " + nomFamille);
        adresse.afficher();
        occupation.afficher();


        System.out.println("Téléphones :");

        for (Telephone t: listNum)
        {
            System.out.println("   " + t.getInformation() + " : " + t.getNumero());
        }
    }



    public void modifier(){
        String modif = "";
        System.out.print("Prénom (" + prenom + ") : ");
        sc.nextLine();
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setPrenom(modif);}

        System.out.println();
        System.out.println();
        System.out.print("Nom (" + nomFamille + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setNomFamille(modif);}

        adresse.modifier();
        occupation.modifier();

        if (nbNum > 0) {

            System.out.println("Téléphones : ");

            for (Telephone t : listNum) {
                t.modifier();
            }
        }
        else {
            System.out.println("Ce contact n'a présentement aucun numéro de téléphone");
        }
    }



}
