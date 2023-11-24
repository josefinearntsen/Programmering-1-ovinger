package oving8;

import java.util.Calendar;
import java.util.GregorianCalendar;

class ArbTaker {
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesar;
    private double manedslonn;
    private double skatteprosent;

    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesar, double manedslonn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;
        this.skatteprosent = skatteprosent;
    }

    //get-metoder
    public Person getPersonalia() {
        return personalia;
    }
    public int getArbtakernr() {
        return arbtakernr;
    }
    public int getAnsettelsesar() {
        return ansettelsesar;
    }
    public double getManedslonn() {
        return manedslonn;
    }
    public double getSkatteprosent() {
        return skatteprosent;
    }

    // set-metoder
    public void setManedslonn(double nyManedslonn) {
        this.manedslonn = nyManedslonn;
    }
    public void setSkatteprosent(double nySkatteprosent) {
        this.skatteprosent = nySkatteprosent;
    }


    // Hvor mange kroner arbeidstakeren trekkes i skatt per maaned
    // Husk at juni er skattefri og i desember betales halv skatt
    public double beregnSkattPerManed() {
        int naverendeManed = new GregorianCalendar().get(Calendar.MONTH) + 1; // Manedene er 0-indekserte
        if (naverendeManed == 6) {
            return 0; // Juni er skattefri
        } else if (naverendeManed == 12) {
            return (skatteprosent / 2) * manedslonn; // Halv skatt i desember
        } else {
            return (skatteprosent / 100) * manedslonn;
        }
    }

    // Bruttolonn per aar
    public double beregnBruttolonnPerAr() {
        return manedslonn * 12;
    }

    // Skattetrekk per aar
    public double beregnSkattetrekkPerAr() {
        return beregnSkattPerManed() * 12;
    }

    //Navn på formen: etternavn, fornavn, eksempel: Johnsen, Berit
    public String hentFulltNavn() {
        return personalia.toString();
    }

    //Alder
    public int hentAlder() {
        return personalia.beregnAlder();
    }

    // Antall aar ansatt i bedriften
    public int hentAntallArAnsatt() {
        int naverendeAr = new GregorianCalendar().get(Calendar.YEAR);
        return naverendeAr - ansettelsesar;
    }

    // Om personen har vært ansatt mer enn et gitt antall år (parameter)
    public boolean harVærtAnsattMerEnn(int aar) {
        int antallArAnsatt = hentAntallArAnsatt();
        return antallArAnsatt > aar;
    }
}
