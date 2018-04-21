import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Adresse implements Serializable {

    private int numPorte;
    private String nomRue;
    private String appart;
    private String ville;
    private String province;
    private String pays;


    public int getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    int repNb = 0;


    public static Scanner sc = new Scanner(System.in);

    public static Adresse nouvAdresse() {

        Adresse adresse = new Adresse();
        String repPhrase = "";

        System.out.println("    Adresse : ");
        System.out.print("        Numéro de porte : ");
        try {
            adresse.numPorte = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrez un nombre");
            adresse.numPorte = Integer.parseInt(sc.nextLine().trim());
        }


        System.out.print("        Rue : ");
        adresse.nomRue = Programme_Main.caractere(sc.nextLine());

        System.out.print("        Appartement (facultatif, Entrée si inexistant) : ");
        repPhrase = sc.nextLine().trim();
        if (repPhrase.equals("")) {
        } else {
            adresse.appart = repPhrase;
        }

        System.out.print("        Ville : ");
        adresse.ville = Programme_Main.caractere(sc.nextLine());


        System.out.print("        Pays : ");
        adresse.pays = pays();


        System.out.print("        Province : ");
        if (adresse.pays.equals("Canada")) {adresse.province = provinces(); }
        else { adresse.province = sc.nextLine().trim(); }



        return adresse;
    }

    public void afficher() {
        System.out.println("    Adresse : ");
        System.out.println("        Numéro de porte : " + numPorte);
        System.out.println("        Rue : " + nomRue);
        System.out.println("        Appartement : " + appart);
        System.out.println("        Ville : " + ville);
        System.out.println("        Province : " + province);
        System.out.println("        Pays : " + pays);

    }

    public void modifier() {

        String modif = "";
        System.out.println();
        System.out.println("Adresse : ");
        System.out.println();
        System.out.print("    Numéro de porte (" + numPorte + ") : ");

        try {
            modif = sc.nextLine().trim();
            if (modif.equals("")) {
            } else { setNumPorte(Integer.parseInt(modif)); }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Entrez un nombre");
            setNumPorte(Integer.parseInt(sc.nextLine().trim()));
        }


        System.out.println();
        System.out.print("    Rue (" + nomRue + ") : ");
        modif = Programme_Main.caractere(sc.nextLine());
        if (modif.equals("")) {
        } else {
            setNomRue(modif);
        }

        System.out.println();
        System.out.print("    Appart (" + appart + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {
        } else {
            setAppart(modif);
        }

        System.out.println();
        System.out.print("    Ville (" + ville + ") : ");
        modif = Programme_Main.caractere(sc.nextLine());
        if (modif.equals("")) {
        } else {
            setVille(modif);
        }

        System.out.println();
        System.out.print("    Pays (" + pays + ") : ");
        modif = pays();
        if (modif.equals("")) {
        } else {
            setPays(modif);
        }


        System.out.println();
        System.out.print("    Province (" + province + ") : ");
        if (pays.equals("Canada")) {modif = provinces(); }
        else { modif = sc.nextLine().trim(); }
        if (modif.equals("")) {
        } else {
            setProvince(modif);
        }


    }


    public static String pays() {

        String tabPays[] = {"Canada", "États-Unis", "Chili", "Mexique", "France", "Espagne", "Portugal", "Italie", "Australie", "Maroc","d"};

        while (true) {
            String reponse = sc.nextLine().trim();

            if (reponse.equals(""))
            {
                return reponse;
            }
            else {
                for (int i = 0; i < tabPays.length; i++) {
                    if (tabPays[i].equals(reponse)) {
                        return reponse;
                    } else if (i >= 9) {
                        System.out.println("Le pays n'existe pas. Réessayez");
                    }
                }
            }
        }
    }

    public static String provinces() {

        String tabProvinces[] = {"Québec", "Ontario", "Colombie-Britannique", "Alberta", "Manitoba", "Nouvelle-Écosse", "Nouveau-Brunswick",
                "Saskatchewan", "Terre-Neuve-et-Labrador", "Ile-du-Prince-Edouard","d"};

        while (true) {
            String reponse = sc.nextLine().trim();

            if (reponse.equals("")){
                return reponse;
            }
            else {
                for (int i = 0; i < tabProvinces.length; i++) {
                    if (tabProvinces[i].equals(reponse)) {
                        return reponse;
                    } else if (i >= 9) {
                        System.out.println("La Province n'existe pas. Réessayez");
                    }
                }
            }

        }
    }



}
