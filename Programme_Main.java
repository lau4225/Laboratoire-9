import sun.misc.*;

import java.io.*;
import java.util.*;
import java.util.Queue;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Programme_Main {

    //FAITS IMPORTANTS:
    /*

    Je ne peux plus utiliser les lignes de codes qui me permettaient de changer la clé d'un contact,
    car ça fait disparaitre le contact lorsque je modifie nimporte lequel de ses parametres

    Si on ajoute un contact et qu'on veut le modifier tout de suite apres, sans quitter le programme,
    on ne peut pas modifier le numero de porte de l'entreprise et l'occupation au complet
    Si on le modifie une deuxieme fois, on peut tout modifier sauf le prenom
    Si on quitte le programme, on peut ensuite tout modifier pour les contacts sauvegardés

    */

    public static boolean fin = false;
    public static Map<String, Contact> mapContacts = new HashMap<String, Contact>();
    public static Scanner sc = new Scanner(System.in);
    public static String cle = "";
    public static Queue<Contact> listRappels = new LinkedList<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue à votre liste de contacts électronique, veuillez en faire bon usage :)");

        System.out.println();

        mapContacts = chargerHashMap();
        listRappels = chargerRappel();
        try { afficher();
        }catch(Exception ex){
            System.out.println("Exception lancée: Aucun contact à afficher");
                    //ex.toString()
        }

        int reponse = 0;

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

    public static void sauvegarder(){
        try{
            //Ecrire dans le fichier saveList.dat
            ObjectOutputStream sortie = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("saveList.dat")));

            sortie.writeObject(mapContacts);
            sortie.writeObject(listRappels);
            sortie.close();
        }
        catch (FileNotFoundException e) {System.out.println("EXCEPTION lancée : AUCUNE LISTE SAUVEGARDÉE");
            e.toString();
            //e.printStackTrace();
        } catch (IOException e) { System.out.println("EXCEPTION lancée : ");
            e.toString();
            //e.printStackTrace();
        }
    }

    public static HashMap<String, Contact> chargerHashMap(){

        HashMap<String, Contact> listeContacts = null;

        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("saveList.dat")));

            listeContacts = (HashMap<String, Contact>) entree.readObject();

            entree.close();
        } catch (FileNotFoundException e) {System.out.println("EXCEPTION lancée : AUCUN FICHIER HashMap" );
            e.toString();
            listeContacts = new HashMap<String, Contact>();

        } catch (IOException e) {System.out.println("EXCEPTION lancée : HashMap");
            e.toString();
        } catch (ClassNotFoundException e) {System.out.println("EXCEPTION lancée : AUCUNE CLASSE HashMap");
            e.toString();
        }
        return listeContacts;
    }

    public static Queue<Contact> chargerRappel(){

        //HashMap listeContacts = null;    A ENLEVER
        Queue rappel = null;

        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("saveList.dat")));

            entree.readObject();
            rappel = (Queue<Contact>) entree.readObject();

            entree.close();
        } catch (FileNotFoundException e) {System.out.println("EXCEPTION lancée : AUCUN FICHIER Rappel");
            e.toString();
            rappel = new LinkedList();
            //e.printStackTrace();
        } catch (IOException e) {System.out.println("EXCEPTION lancée : Rappel");
            e.toString();
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {System.out.println("EXCEPTION lancée : AUCUNE CLASSE Rappel");
            e.toString();
            //e.printStackTrace();
        }
        return rappel;
    }

    static String caractere(String chaine) {

        if (chaine.trim().equals(""))
        {
            return chaine;
        }
        else{
            char[] listeCharacter = {'%', '*', '¯', '\\','/','$','&','#','0','1','2','3','4','5','6','7','8','9' };
            boolean bonneLettre = true;

            for (int i = 0; i < chaine.length(); i++) {
                for (int j = 0; j < listeCharacter.length; j++) {
                    if (chaine.charAt(i) == listeCharacter[j]) {
                        bonneLettre = false;
                    }
                }
            }
            if (bonneLettre == false) {
                System.out.println("Entrez une chaine sans caractères spéciaux et sans nombre!");
                chaine = sc.nextLine();
                caractere(chaine);
            }

            return chaine;
        }

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
            cle = sc.next();
            if (mapContacts.containsKey(cle)==false)
            {
                System.out.println("Désoler, ce contact n'est pas présent dans votre liste, veuillez réessayer");
                System.out.println();
            }
            else {
                modifier = true;
                System.out.println();
                System.out.println("Veuillez entrer les informations suivantes (laisser vide si correctes) : ");
                System.out.println();
                sc.nextLine();

                mapContacts.get(cle).modifier();

                /*
                if (mapContacts.get(cle).getPrenom() != cle){
                    mapContacts.put(mapContacts.get(cle).getPrenom(), mapContacts.get(cle));
                    mapContacts.remove(cle);
                }
                */

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
        sauvegarder();
        System.out.println("Au revoir!");
        fin = true;
    }

    public static void supprimer(){
        boolean supprimer = false;
        String ouiNon = "";


        while (supprimer == false) {
            System.out.print("Quel est le prénom du contact à supprimer? ");
            cle = sc.next();
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
                cle = sc.next();
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
