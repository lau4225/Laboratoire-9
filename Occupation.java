import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Occupation {

    private String poste;
    private Entreprise entreprise;

    public String getPoste() {return poste;}

    public void setPoste(String poste) {this.poste = poste;}

    public Entreprise getEntreprise() {return entreprise;}

    public void setEntreprise(Entreprise entreprise) {this.entreprise = entreprise;}

    public static Scanner sc = new Scanner(System.in);

    public static Occupation nouvOccupation(){

        Occupation occupation = new Occupation();

        System.out.println("Occupation : ");
        System.out.print("    Poste : ");
        occupation.poste = sc.next();

        occupation.setEntreprise(Entreprise.nouvEntreprise());

        return occupation;
    }

    public void afficher(){
        System.out.println("Occupation : ");
        System.out.println("    Poste : " + poste);
        entreprise.afficher();
    }

    public void modifier(){
        String modif = "";
        System.out.println();
        System.out.println("Occupation : ");
        System.out.print("    Poste (" + poste + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) {}
        else {setPoste(modif);}
        entreprise.modifier();
    }
}
