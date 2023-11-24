package oving11;

public class Eiendom {

    final private int kommuneNummer;
    final private String kommuneNavn;
    final private int gnr;
    final private int bnr;
    private String bruksNavn;
    final private double areal;
    private String eier;

    //konstruktør som innholder alt

    /**
     * Construcrot
     *
     * @param kommuneNummer
     * @param kommuneNavn
     * @param gnr
     * @param bnr
     * @param bruksNavn
     * @param areal
     * @param eier
     */
    public Eiendom(int kommuneNummer, String kommuneNavn, int gnr, int bnr, String bruksNavn, double areal, String eier) {
        this.kommuneNummer = kommuneNummer;
        this.kommuneNavn = kommuneNavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eier = eier;
    }

    // konstruktør uten bruksnavn
    public Eiendom(int kommuneNummer, String kommuneNavn, int gnr, int bnr, double areal, String eier) {
        this.kommuneNummer = kommuneNummer;
        this.kommuneNavn = kommuneNavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.areal = areal;
        this.eier = eier;
        this.bruksNavn = ""; // for at det skal være blankt
    }


    // get metoder for alle
    public int getKommuneNummer() {
        return kommuneNummer;
    }

    public String getKommuneNavn() {
        return kommuneNavn;
    }

    public int getGnr() {
        return gnr;
    }

    public int getBnr() {
        return bnr;
    }

    public String getBruksNavn() {
        return bruksNavn;
    }

    public double getAreal() {
        return areal;
    }

    public String getEier() {
        return eier;
    }

    /*
    Trenger set-metoder for bruksnavn og eier fordi det er disse to som sannsynligvis blir å endres
     */

    public void setBruksNavn(String bruksNavn) {
        this.bruksNavn = bruksNavn;
    }

    public void setEier(String eier) {
        this.eier = eier;
    }

    public String alleNr() {
        return "kommunenr-gnr*/bnr: " + kommuneNummer + "-" + gnr + "/" + bnr;
    }

    @Override
    public String toString() {
        return "Eiendom - " + "Nummer: " + kommuneNummer + "-" + gnr + "/" + bnr +
                ", Kommunenavn: " + kommuneNavn +
                ", Bruksnavn: " + bruksNavn +
                ", Areal: " + areal +
                ", Eier: " + eier;
    }
}
