/**
 * Created by BonLa1731834 on 2018-01-22.
 */
public class Contact {

    private int numero;
    private String prenom;
    private String nomFamille;
    private Adresse adresse;
    private Occupation occupation;
    private Telephone tabListNum [] = new Telephone[10];
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

    public Telephone[] getTabListNum() {return tabListNum;}

    public void setTabListNum(Telephone[] tabListNum) {this.tabListNum = tabListNum;}

    public int getNbNum() {return nbNum;}

    public void setNbNum(int nbNum) {this.nbNum = nbNum;}
}
