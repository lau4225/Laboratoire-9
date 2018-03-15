import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Telephone {

    private String information;
    private String numero;

    public String getInformation() {return information;}

    public void setInformation(String information) {this.information = information;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public static Scanner sc = new Scanner(System.in);

    public static Telephone nouvTelephone(){

        Telephone numTel = new Telephone();

        System.out.print("À quoi correspond ce numéro? ");
        numTel.information = sc.next();

        System.out.print("Quel est ce numéro? ");
        numTel.numero = sc.next();

        return numTel;
    }

    public void modifier(){
        String modif = "";

        System.out.print( "  " + information);
        System.out.print("  (" + numero + ") : ");
        modif = sc.nextLine().trim();
        if (modif.equals("")) { }
        else {
            setNumero(modif);
            System.out.print("À quoi correspond ce numéro? (Entrée si idem) ");
            modif = sc.nextLine().trim();
            if (modif.equals("")) {}
            else {setInformation(modif);}
        }
    }


}
