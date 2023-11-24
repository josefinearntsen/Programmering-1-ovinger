package oving8;

import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Person {
    private final String fornavn;
    private final String etternavn;
    private final int fødselsar;

    public Person(String fornavn, String etternavn, int fødselsar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsar = fødselsar;
    }

    // get-metoder
    public String getFornavn() {
        return fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }
    public int getFødselsar() {
        return fødselsar;
    }

    // La til en metode for å beregne alder
    public int beregnAlder() {
        int nåværendeÅr = new GregorianCalendar().get(Calendar.YEAR);
        return nåværendeÅr - fødselsar;
    }

    @Override
    public String toString() {
        return etternavn + ", " + fornavn;
    }
}
