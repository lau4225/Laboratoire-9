import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Programme_Main {

    public static int posiContacts = -1;
    public static boolean fin = false;
    public static Contact tabContact [] = new Contact[20];
    public static Scanner sc = new Scanner(System.in);
    public static int reponse = 0;

    public static void main(String[] args) {


        /*
        appartement ne fonctionne pas  sc.nextLine marche pas ??? truc qu'il avait expliquer à max???

        donc toutes les nextLine dans modifier ne marcheront pas ??

        quand on rentre un string ou il demande un int ?? inverse aussi

        modifier linformation dun numero de telephone? possible?

        modifier prenom au debut marche pas

        maniere plus optimale decrire le code ??



        changer les reponses quand on ajoute les informations d'un contact (pas trop important)


         */


        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue à votre liste de contacts électronique, veuillez en faire bon usage :)");

        System.out.println();


        int reponse = 0;


        // Premier tour
        afficherMenu();
        reponse = sc.nextInt();

        if (reponse == 2 || reponse == 3)
        {
            System.out.println("Vous devez ajouter un contact pour commencer");
        }
        else
        {
            switch (reponse)
            {
                case 1 : ajouter();break;
                case 2 : modifier(); break;
                case 3 : afficher(); break;
                case 4 : quitter(); break;

            }

        }


        //Autres tours
        while (fin==false) {

            afficherMenu();

            reponse = sc.nextInt();
            switch (reponse)
            {
                case 1 : ajouter();break;
                case 2 : modifier(); break;
                case 3 : afficher(); break;
                case 4 : quitter(); break;

            }
        }
    }

    public static void afficherMenu () {

        System.out.println();
        System.out.println("1. Ajouter un contact");
        System.out.println("2. Modifier un contact");
        System.out.println("3. Afficher les contacts");
        System.out.println("4. Quitter");
        System.out.println("Que souhaitez-vous faire?");
    }

    public static void ajouter () {


        int repNb = 0;
        String repPhrase = "";
        boolean repValide = false;
        posiContacts++;
        reponse = posiContacts;


        if (posiContacts >19)
        {
            System.out.println("Vous avez atteint le nombre maximum de 20 contacts");
            System.out.println("Vous pouvez toutefois modifier un contact déjà existant");
            posiContacts = 19;
        }
        else {
            tabContact[posiContacts] = new Contact();
            tabContact[posiContacts].setNumero(posiContacts);

            System.out.println("Ce contact sera entré à la position #" + (posiContacts + 1));
            System.out.println("Veuillez entrer les informations suivantes : ");

            System.out.print("Prénom : ");
            tabContact[posiContacts].setPrenom(sc.next());


            System.out.print("Nom : ");
            tabContact[posiContacts].setNomFamille(sc.next());

            tabContact[posiContacts].setAdresse(new Adresse());
            System.out.println("Adresse : ");
            System.out.print("    Numéro de porte : ");
            repNb = sc.nextInt();
            tabContact[posiContacts].getAdresse().setNumPorte(repNb);

            System.out.print("    Rue : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getAdresse().setNomRue(repPhrase);

            System.out.print("    Appartement (facultatif, Entrée si inexistant) : ");
            sc.nextLine();
            repPhrase = sc.nextLine().trim();
            if (repPhrase.equals("")) {
            } else {
                tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setAppart(repPhrase);
            }

            System.out.println();
            System.out.print("    Ville : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getAdresse().setVille(repPhrase);

            System.out.print("    Province : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getAdresse().setProvince(repPhrase);

            System.out.print("    Pays : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getAdresse().setPays(repPhrase);

            tabContact[posiContacts].setOccupation(new Occupation());
            System.out.println("Occupation : ");
            System.out.print("    Poste : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().setPoste(repPhrase);

            tabContact[posiContacts].getOccupation().setEntreprise(new Entreprise());
            System.out.println("    Entreprise : ");
            System.out.print("        Nom : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().getEntreprise().setNom(repPhrase);


            tabContact[posiContacts].getOccupation().getEntreprise().setAdresse(new Adresse());
            System.out.println("        Adresse : ");
            System.out.print("            Numéro de porte : ");
            repNb = sc.nextInt();
            tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setNumPorte(repNb);


            System.out.print("            Rue : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setNomRue(repPhrase);

            System.out.print("    Appartement (facultatif, Entrée si inexistant) : ");
            sc.nextLine();
            repPhrase = sc.nextLine().trim();
            if (repPhrase.equals("")) {
            } else {
                tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setAppart(repPhrase);
            }


            System.out.println();
            System.out.print("            Ville : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setVille(repPhrase);

            System.out.print("            Province : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setProvince(repPhrase);

            System.out.print("            Pays : ");
            repPhrase = sc.next();
            tabContact[posiContacts].getOccupation().getEntreprise().getAdresse().setPays(repPhrase);

            ajoutNumTel();
        }

    }

    public static void modifier () {


        boolean modifier = false;
        String modif = "";

        while (modifier == false) {
            System.out.print("Quel est le numéro du contact? ");
            reponse = sc.nextInt() - 1;
            if (reponse > posiContacts || reponse <0)
            {
                System.out.println("Entrez un nombre valide");
                System.out.println();
            }
            else {
                modifier = true;
            }
        }
        modifier = false;

        System.out.println();
        System.out.println("Veuillez entrer les informations suivantes (laisser vide si correct) : ");
        System.out.println();
        System.out.print("Prénom (" + tabContact[reponse].getPrenom() + ") : ");
        sc.nextLine();
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].setPrenom(modif);}

        System.out.println();
        System.out.println();
        System.out.print("Nom (" + tabContact[reponse].getNomFamille() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].setNomFamille(modif);}

        System.out.println();
        System.out.println("Adresse : ");
        System.out.print("    Numéro de porte (" + tabContact[reponse].getAdresse().getNumPorte() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setNumPorte(Integer.parseInt(modif));}

        System.out.println();
        System.out.print("    Rue (" + tabContact[reponse].getAdresse().getNomRue() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setNomRue(modif);}

        System.out.println();
        System.out.print("    Appart (" + tabContact[reponse].getAdresse().getAppart() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setAppart(modif);}

        System.out.println();
        System.out.print("    Ville (" + tabContact[reponse].getAdresse().getVille() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setVille(modif);}

        System.out.println();
        System.out.print("    Province (" + tabContact[reponse].getAdresse().getProvince() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setProvince(modif);}

        System.out.println();
        System.out.print("    Pays (" + tabContact[reponse].getAdresse().getPays() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getAdresse().setPays(modif);}

        System.out.println();
        System.out.println("Occupation : ");
        System.out.print("    Poste (" + tabContact[reponse].getOccupation().getPoste() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().setPoste(modif);}

        System.out.println("    Entreprise : ");
        System.out.print("        Nom (" + tabContact[reponse].getOccupation().getEntreprise().getNom() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().setNom(modif);}

        System.out.println();
        System.out.println("        Adresse : ");
        System.out.print("            Numéro de porte (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getNumPorte() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setNumPorte(Integer.parseInt(modif));}

        System.out.println();
        System.out.print("            Rue (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getNomRue() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setNomRue(modif);}

        System.out.println();
        System.out.print("            Appart (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getAppart() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setAppart(modif);}

        System.out.println();
        System.out.print("            Ville (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getVille() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setVille(modif);}

        System.out.println();
        System.out.print("            Province (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getProvince() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setProvince(modif);}

        System.out.println();
        System.out.print("            Pays (" + tabContact[reponse].getOccupation().getEntreprise().getAdresse().getPays() + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {tabContact[reponse].getOccupation().getEntreprise().getAdresse().setPays(modif);}

        System.out.println();
        System.out.println();


        if (tabContact[reponse].getNbNum() > 0) {


            System.out.println("Téléphones : ");
            for (int j=0; j<=tabContact[reponse].getNbNum(); j++)
            {
                System.out.print( "  " + tabContact[reponse].getTabListNum()[j].getInformation());
                System.out.print("  (" + tabContact[reponse].getTabListNum()[j].getNumero() + ") : ");
                modif = sc.nextLine().trim();
                if (modif.equals("")) { }
                else {
                    tabContact[reponse].getTabListNum()[j].setNumero(modif);
                    System.out.print("À quoi correspond ce numéro? (Entrée si idem) ");
                    modif = sc.nextLine().trim();
                    if (modif.equals("")) {}
                    else {
                        tabContact[reponse].getTabListNum()[j].setInformation(modif);
                    }
                }
            }
        }
        else {
            System.out.println("Vous n'avez présentement aucun numéro de téléphone");
        }


       ajoutNumTel();

    }

    public static void afficher () {

        System.out.println("Vous avez " + (posiContacts+1) + " contact(s) : ");

        for (int i = 0; i<=posiContacts; i++) {

            System.out.println();
            System.out.println();

            System.out.println("Contact #" + (i+1) + " :");
            System.out.println("------------");

            System.out.println("Prénom  : " + tabContact[i].getPrenom());
            System.out.println("Nom : " + tabContact[i].getNomFamille());
            System.out.println("Adresse : ");
            System.out.println("    Numéro de porte : " + tabContact[i].getAdresse().getNumPorte());
            System.out.println("    Rue : " + tabContact[i].getAdresse().getNomRue());
            System.out.println("    Appartement : " + tabContact[i].getAdresse().getAppart());
            System.out.println("    Ville : " + tabContact[i].getAdresse().getVille());
            System.out.println("    Province : " + tabContact[i].getAdresse().getProvince());
            System.out.println("    Pays : " + tabContact[i].getAdresse().getPays());
            System.out.println("Occupation : ");
            System.out.println("    Poste : " + tabContact[i].getOccupation().getPoste());
            System.out.println("    Entreprise : ");
            System.out.println("        Nom : " + tabContact[i].getOccupation().getEntreprise().getNom());
            System.out.println("        Adresse : ");
            System.out.println("            Numéro de porte : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getNumPorte());
            System.out.println("            Rue : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getNomRue());
            System.out.println("            Appartement : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getAppart());
            System.out.println("            Ville : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getVille());
            System.out.println("            Province : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getProvince());
            System.out.println("            Pays : " + tabContact[i].getOccupation().getEntreprise().getAdresse().getPays());

            System.out.println();
            System.out.println("Téléphones :");

            for (int j=0; j<=tabContact[i].getNbNum(); j++)
            {
                System.out.print(tabContact[i].getTabListNum()[j].getInformation() + " : ");
                System.out.println(tabContact[i].getTabListNum()[j].getNumero());
            }
        }



    }

    public static void quitter () {
        System.out.println("Au revoir!");
        fin = true;
    }


    public static void ajoutNumTel (){
        // Telephone
        boolean ajoutNum = false;
        while (ajoutNum == false) {
            System.out.println();
            System.out.print("Entrer un numéro de téléphone (o/n)? ");
            String repTel = "";
            repTel = sc.next();



            if (repTel.equals("o")) {

                tabContact[reponse].setNbNum(tabContact[reponse].getNbNum() + 1);

                if (tabContact[posiContacts].getNbNum() > 8)
                {
                    System.out.println("Vous avez atteint le nombre maximum de 10 numéros de téléphone pour ce contact");
                    System.out.println("Vous pouvez toutefois modifier un numéro déjà existant");
                    ajoutNum = true;
                    tabContact[reponse].setNbNum(tabContact[reponse].getNbNum() - 1);
                }
                else {
                    tabContact[reponse].getTabListNum()[tabContact[reponse].getNbNum()] = new Telephone();
                    System.out.print("À quoi correspond ce numéro? ");
                    tabContact[reponse].getTabListNum()[tabContact[reponse].getNbNum()].setInformation(sc.next());

                    System.out.println();
                    System.out.print("Quel est ce numéro? ");
                    tabContact[reponse].getTabListNum()[tabContact[reponse].getNbNum()].setNumero(sc.next());
                }


            }
            else if (repTel.equals("n")) {
                ajoutNum = true;
            }
            else
            {
                System.out.println("Entrez une réponse valide");
            }
        }
        ajoutNum = false;
    }


}
