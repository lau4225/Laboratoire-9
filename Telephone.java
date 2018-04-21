import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Telephone implements Serializable {

    private String information;
    private String numero;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static Scanner sc = new Scanner(System.in);

    public static Telephone nouvTelephone() {

        Telephone numTel = new Telephone();

        System.out.print("À quoi correspond ce numéro? ");
        numTel.information = sc.nextLine();

        System.out.print("Quel est ce numéro? ");
        numTel.numero = formatTelephone();

        return numTel;
    }

    public void modifier() {
        String modif = "";

        System.out.print("  " + information);
        System.out.print("  (" + numero + ") : ");
        modif = formatTelephone();
        if (modif.equals("")) {
        } else {
            setNumero(modif);
            System.out.print("À quoi correspond ce numéro? (Entrée si idem) ");
            modif = sc.nextLine().trim();
            if (modif.equals("")) {
            } else {

                setInformation(modif);
            }
        }
    }

    public static String formatTelephone() {
        while (true) {
            String numero = sc.nextLine();

            if (numero.length() == 12) {

                if (numero.charAt(0) >= 48 && numero.charAt(0) <= 57)
                {
                    if (numero.charAt(1) >= 48 && numero.charAt(1) <= 57)
                    {
                        if (numero.charAt(2) >= 48 && numero.charAt(2) <= 57)
                        {
                            if (numero.charAt(3) == 45 && numero.charAt(7) == 45 )
                            {
                                if (numero.charAt(4) >= 48 && numero.charAt(4) <= 57)
                                {
                                    if (numero.charAt(5) >= 48 && numero.charAt(5) <= 57)
                                    {
                                        if (numero.charAt(6) >= 48 && numero.charAt(6) <= 57)
                                        {
                                            if (numero.charAt(7) == 45 && numero.charAt(7) == 45 )
                                            {
                                                if (numero.charAt(8) >= 48 && numero.charAt(8) <= 57)
                                                {
                                                    if (numero.charAt(9) >= 48 && numero.charAt(9) <= 57)
                                                    {
                                                        if (numero.charAt(10) >= 48 && numero.charAt(10) <= 57)
                                                        {
                                                            if (numero.charAt(11) >= 48 && numero.charAt(11) <= 57)
                                                            {
                                                                return numero;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            else if (numero.equals("")){
                return numero;
            }
            System.out.println("Veuillez entrer un numéro du format XXX-XXX-XXXX");
        }
    }

}

