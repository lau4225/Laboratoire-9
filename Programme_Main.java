import java.util.*;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Programme_Main {

    public static boolean fin = false;
    public static Map<String, Contact> mapContacts = new HashMap<String, Contact>();
    public static Scanner sc = new Scanner(System.in);
    public static String cle = "";
    public static Queue<Contact> listRappels = new LinkedList<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue à votre liste de contacts électronique, veuillez en faire bon usage :)");

        System.out.println();


        int reponse = 0;


        // Premier tour
        afficherMenu();
        reponse = sc.nextInt();

        if (reponse == 2 || reponse == 3 || reponse == 4 || reponse == 5)
        {
            System.out.println("Vous devez ajouter un contact pour commencer");
        }
        else
        {
            switch (reponse)
            {
                case 1 : ajouter(); break;
                case 2 : supprimer(); break;
                case 3 : listRappel(); break;
                case 4 : modifier(); break;
                case 5 : afficher(); break;
                case 6 : quitter(); break;

            }

        }


        //Autres tours
        while (fin==false) {

            afficherMenu();

            reponse = sc.nextInt();
            switch (reponse)
            {
                case 1 : ajouter(); break;
                case 2 : supprimer(); break;
                case 3 : listRappel(); break;
                case 4 : modifier(); break;
                case 5 : afficher(); break;
                case 6 : quitter(); break;

            }
        }
    }

    public static void afficherMenu () {

        System.out.println();
        System.out.println("1. Ajouter un contact");
        System.out.println("2. Supprimer un contact");
        System.out.println("3. Gérer la liste de rappels");
        System.out.println("4. Modifier un contact");
        System.out.println("5. Afficher les contacts");
        System.out.println("6. Quitter");

        System.out.println();
        System.out.println("Que souhaitez-vous faire?");
    }

    public static void ajouter () {

        Contact contact = Contact.nouvContact();
        mapContacts.put(contact.getPrenom(), contact);

    }



    public static void modifier () {

        boolean modifier = false;
        String modif = "";

        while (modifier == false) {
            System.out.print("Quel est le prénom du contact? ");
            cle = sc.next().toLowerCase();
            if (mapContacts.containsKey(cle)==false)
            {
                System.out.println("Désoler, ce contact n'est pas présent dans votre liste, veuillez réessayer");
                System.out.println();
            }
            else {
                modifier = true;
                System.out.println();
                System.out.println("Veuillez entrer les informations suivantes (laisser vide si correct) : ");
                System.out.println();

                mapContacts.get(cle).modifier();

                if (mapContacts.get(cle).getPrenom() != cle){
                    mapContacts.put(mapContacts.get(cle).getPrenom(), mapContacts.get(cle));
                    mapContacts.remove(cle);
                }


            }
        }
        modifier = false;
    }

    public static void afficher () {



        System.out.println("Vous avez " + mapContacts.size() + " contact(s) : ");

        for (Contact c: mapContacts.values())
              {
            System.out.println();
            System.out.println("--------------------------------");

            c.afficher();

        }

    }

    public static void quitter () {
        System.out.println("Au revoir!");
        fin = true;
    }

    public static void supprimer(){
        boolean supprimer = false;
        String ouiNon = "";


        while (supprimer == false) {
            System.out.print("Quel est le prénom du contact à supprimer? ");
            cle = sc.next().toLowerCase();
            if (mapContacts.containsKey(cle)==false)
            {
                System.out.println("Désoler, ce contact n'est pas présent dans votre liste, veuillez réessayer");
                System.out.println();
            }
            else {

                System.out.print("Êtes-vous sûre de vouloir supprimer " + mapContacts.get(cle).getPrenom() + " de votre liste de contacts pour toujours? :(    o/n");
                ouiNon = sc.next().toLowerCase();
                if (ouiNon.equals("o"))
                {
                    mapContacts.remove(cle);
                    System.out.println();
                    System.out.println("Votre contact a été supprimé avec succès!");
                }
                supprimer = true;
            }
        }
        supprimer = false;

    }


    public static void listRappel(){

        //for each pour afficher les contacts
        int rep = 0;
        boolean rappel = false;

        System.out.println("Bienvenue dans votre de liste de rappels");
        System.out.println("Voulez-vous 1. ajouter ou 2. rappeler un contact?");
        rep = sc.nextInt();
        if (rep == 1)
        {
            while (rappel== false) {
                System.out.print("Quel est le prénom du contact à ajouter à la liste de rappels? ");
                cle = sc.next().toLowerCase();
                if (mapContacts.containsKey(cle)==false)
                {
                    System.out.println("Désoler, ce contact n'est pas présent dans votre liste, veuillez réessayer");
                    System.out.println();
                }
                else {

                    listRappels.add(mapContacts.get(cle));
                    System.out.println();
                    System.out.println("Votre contact " + mapContacts.get(cle).getPrenom() + " a été ajouté avec succès dans la liste de rappels!");

                    rappel = true;

                }
            }
            rappel = false;
        }
        else if (rep == 2)
        {
            if (listRappels.isEmpty())
            {
                System.out.println("Vous n'avez présentement aucun contact dans votre liste de rappels");
            }
            else {
                System.out.println("Vous avez rappelé " + listRappels.remove().getPrenom() + ", il était bien content de ravoir de vos nouvelles :)");
            }

        }
    }



}
