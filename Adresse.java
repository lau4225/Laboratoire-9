import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Adresse {

    private int numPorte;
    private String nomRue;
    private String appart;
    private String ville;
    private String province;
    private String pays;



    public int getNumPorte() {return numPorte;}

    public void setNumPorte(int numPorte) {this.numPorte = numPorte;}

    public String getNomRue() {return nomRue;}

    public void setNomRue(String nomRue) {this.nomRue = nomRue;}

    public String getAppart() {return appart;}

    public void setAppart(String appart) {this.appart = appart;}

    public String getVille() {return ville;}

    public void setVille(String ville) {this.ville = ville;}

    public String getProvince() {return province;}

    public void setProvince(String province) {this.province = province;}

    public String getPays() {return pays;}

    public void setPays(String pays) {this.pays = pays;}

    int repNb = 0;


    public static Scanner sc = new Scanner(System.in);

    public static Adresse nouvAdresse() {

        Adresse adresse = new Adresse();
        String repPhrase = "";

        System.out.println("    Adresse : ");
        System.out.print("        Numéro de porte : ");
        adresse.numPorte = sc.nextInt();

        System.out.print("        Rue : ");
        adresse.nomRue = sc.next();

        System.out.print("        Appartement (facultatif, Entrée si inexistant) : ");
        sc.nextLine();
        repPhrase = sc.nextLine().trim();
        if (repPhrase.equals("")) {
        } else {
            adresse.appart = repPhrase;
        }

        System.out.print("        Ville : ");
        adresse.ville = sc.next();

        System.out.print("        Province : ");
        adresse.province = sc.next();

        System.out.print("        Pays : ");
        adresse.pays = sc.next();

        return adresse;
    }

    public void afficher(){
        System.out.println("    Adresse : ");
        System.out.println("        Numéro de porte : " + numPorte);
        System.out.println("        Rue : " + nomRue);
        System.out.println("        Appartement : " + appart);
        System.out.println("        Ville : " + ville);
        System.out.println("        Province : " + province);
        System.out.println("        Pays : " + pays);

    }

    public void modifier(){

        String modif = "";
        System.out.println();
        System.out.println("Adresse : ");
        System.out.print("    Numéro de porte (" + numPorte + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setNumPorte(Integer.parseInt(modif));}

        System.out.println();
        System.out.print("    Rue (" + nomRue + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setNomRue(modif);}

        System.out.println();
        System.out.print("    Appart (" + appart + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setAppart(modif);}

        System.out.println();
        System.out.print("    Ville (" + ville + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setVille(modif);}

        System.out.println();
        System.out.print("    Province (" + province + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setProvince(modif);}

        System.out.println();
        System.out.print("    Pays (" + pays + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setPays(modif);}
    }


}
