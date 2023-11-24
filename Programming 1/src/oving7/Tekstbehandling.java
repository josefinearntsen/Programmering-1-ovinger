package oving7;

// Lag en klasse for enkel tekstbehandling.
// Konstruktøren skal ta en tekst som argument. Klassen skal tilby følgende tjenester:

import java.text.Normalizer;

public class Tekstbehandling {
    private final String tekst;
    public Tekstbehandling(String tekst) {
        this.tekst = tekst;
    }

    public int antallOrd() { //Finne antall ord i teksten
        // Deler teksten opp i ord ved hjelp av whitespace som skilletegn
        String[] antallOrd = tekst.split("\\s+");
        return antallOrd.length; //lengden på String-listen
    }

    //Finne gjennomsnittlig ordlengde. Skilletegn er ikke en del av ordene.
    public double gjennomsnittligOrdlengde() {
        // Deler teksten opp i ord ved hjelp av whitespace (mellomrom, tabulator, linjeskift) som skilletegn
        String[] ordListe = tekst.split("\\s+");
        int totalLengde = 0;

        for (String ord : ordListe) { // går gjennom hvert ord i ordliste
            //Fjern eventuelle diakritiske tegn ( for eksempel: æ, ø, å) ved hjelp av Normalizer.
            //Dette trinnet sikrer at vi behandler teksten med ASCII-tegn for å unngå feil i lengdeberegningen.
            ord = Normalizer.normalize(ord, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            totalLengde += ord.length();
        }
        // Beregn gjennomsnittlig ordlengde ved å dele den totale lengden av alle ord på antall ord
        return (double) totalLengde / antallOrd();
    }

    /*
    public double gjennomsnittligOrdlengde() {
        String[] ordliste = tekst.split("\\s+");
        int totalLengde = 0;

        for (String ord : ordliste) {
            // Fjern diakritiske tegn (æ, ø, å) uten å bruke Normalizer
            String rentOrd = fjernDiakritiskeTegn(ord);
            totalLengde += rentOrd.length();
        }

        return (double) totalLengde / antallOrd();
    }


    private String fjernDiakritiskeTegn(String input) {
        String[] diakritiske = {"æ", "ø", "å", "Æ", "Ø", "Å"};
        String[] utenDiakritiske = {"ae", "o", "a", "AE", "O", "A"};

        for (int i = 0; i < diakritiske.length; i++) {
            input = input.replace(diakritiske[i], utenDiakritiske[i]);
        }

        return input;
    }
    */

    // Finne gjennomsnittlig antall ord per periode.
    // Bruk punktum, utropstegn, kolon og spørretegn som skilletegn mellom periodene.
    // Anta at teksten er feilfri, slik at ikke to eller flere slike tegn følger etter hverandre.
    public double gjennomsnittligAntallOrdPerPeriode() {
        // Deler teksten opp i perioder ved hjelp av punktum, kolon, utropstegn og spørsmålstegn som skilletegn
        String[] perioder = tekst.split("[.:!?]");
        int totalAntallOrd = 0;

        for (String periode : perioder) { //itererer gjennom hver periode
            String[] ordliste = periode.split("\\s+"); // Deler hver periode opp i ord ved hjelp av mellomrom som skilletegn
            totalAntallOrd += ordliste.length; // Legger til antall ord i denne perioden til totalen
        }
        // Beregner og returnerer gjennomsnittlig antall ord per periode
        // ved å dele det totale antallet ord på antall perioder
        return (double) totalAntallOrd / perioder.length;
    }

    //Skifte ut et ord med et annet gjennom hele teksten.
    // For eksempel kan en ønske å skifte ut ordet «finnes» med «fins».
    public String byttOrd(String gammeltOrd, String nyttOrd) {
        // Erstatter alle forekomster av gammeltOrd med nyttOrd
        return tekst.replaceAll(gammeltOrd, nyttOrd);
    }

    //Hente ut teksten slik den står, uten endringer.
    public String hentOriginaltekst() {
        return tekst;
    }

    //Hente ut teksten, men slik at alle bokstaver er store.
    public String hentStoreBokstaver() {
        // Konverterer hele teksten til store bokstaver
        return tekst.toUpperCase();
    }

    // Lag en enkel testklient.
    // Husk å prøve klassen for tekster som inneholder æ, ø og å.
    public static void main(String[] args) {
        String tekst = "Dette er en enkel test. Den skal brukes for å demonstrere tekstbehandlingsklassen. Finnes det ærlige øyeblikk i livet?";
        Tekstbehandling tb = new Tekstbehandling(tekst);

        System.out.println("Antall ord i teksten: " + tb.antallOrd());
        System.out.println("Gjennomsnittlig ordlengde: " + tb.gjennomsnittligOrdlengde());
        System.out.println("Gjennomsnittlig antall ord per periode: " + tb.gjennomsnittligAntallOrdPerPeriode());
        System.out.println("Tekst med byttet ord: " + tb.byttOrd("Finnes", "Fins"));
        System.out.println("Originaltekst: " + tb.hentOriginaltekst());
        System.out.println("Tekst med store bokstaver: " + tb.hentStoreBokstaver());
    }
}
