import java.awt.*;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Entreprise implements Serializable{

    private String nom;
    private Adresse adresse;


    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public Adresse getAdresse() {return adresse;}

    public void setAdresse(Adresse adresse) {this.adresse = adresse;}

    public static Scanner sc = new Scanner(System.in);

    public static Entreprise nouvEntreprise(){

        Entreprise entreprise = new Entreprise();

        System.out.println("    Entreprise : ");
        System.out.print("        Nom : ");
        entreprise.nom = sc.next();

        entreprise.setAdresse(Adresse.nouvAdresse());
        return entreprise;
    }

    public void afficher(){
        System.out.println("    Entreprise : ");
        System.out.println("        Nom : " + nom);
        adresse.afficher();
    }

    public void modifier(){
        String modif = "";
        System.out.println();
        System.out.println("    Entreprise : ");
        System.out.println();
        System.out.print("        Nom (" + nom + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setNom(modif);}
        adresse.modifier();
    }

}
