package oving6;

import java.util.Scanner;
public class Tekstanalyse {

    final private int[] antallTegn = new int[30];

    // Konstruktøren skal ta den aktuelle teksten som argument
    // og fylle opp tabellen antallTegn med antall tegn av hver type.
    public Tekstanalyse(String tekst) {
        analyse(tekst);
    }

    // Etter at tabellen antallTegn er fylt opp, skal en klient kunne få utført følgende tjenester:
    public void analyse(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            char tegn = tekst.toLowerCase().charAt(i);
            if (erBokstav(tegn)) {
                if (tegn == 'æ') {
                    antallTegn[26]++;
                } else if (tegn == 'ø') {
                    antallTegn[27]++;
                } else if (tegn == 'å') {
                    antallTegn[28]++;
                }
                // Hvis tegnet er en bokstav (a-z), øker jeg telleren for riktig indeks i antallTegn-tabellen
                else {
                    int indeks = tegn - 'a'; //Konverterer tegnet til en indeks (a=0, b=1, osv.)
                    antallTegn[indeks]++;
                }
            } else {
                // Hvis tegnet ikke er en bokstav, øk telleren for siste indeks (indeks 29)
                antallTegn[29]++;
            }
        }
    }
    public boolean erBokstav(char tegn) {
        if (tegn == 'æ' || tegn == 'ø' || tegn == 'å') {
            return true;
        }
        return (tegn >= 'a' && tegn <= 'z') || (tegn >= 'A' && tegn <= 'Z');
    }

    // Finn antall forskjellige bokstaver i teksten. Her ser vi altså bort fra alle andre tegn enn bokstaver.
    public int antallForskjelligeBokstaver() {
        int antall = 0;
        for (int i = 0; i < 29; i++){
            if (antallTegn[i] > 0) {
                antall++;
            }
        }
        return antall;
    }

    // Finn totalt antall bokstaver i teksten.
    public int totaltAntallBokstaver() {
        int antall = 0;
        for (int i = 0; i < 29; i++) {
            antall += antallTegn[i];
        }
        return antall;
    }

    // Hvor stor del av teksten (prosent) er ikke bokstaver?
    public double prosentIkkeBokstaver() {
        int ikkeBokstaver = antallTegn[29];
        int totalt = totaltAntallBokstaver() + ikkeBokstaver;
        return ((double) ikkeBokstaver / totalt) * 100;
    }
    // Finn antall forekomster av en bestemt bokstav.
    // Bokstaven skal være parameter til metoden.
    public int antallForekomsterAvBokstav(char bokstav) {
        //sjekker om den innsendte bokstaven er en gyldig bokstav (a-z eller A-Z).
        if (erBokstav((bokstav))) {
            if (bokstav == 'æ') {
                return antallTegn[26];
            } else if (bokstav == 'ø') {
                return antallTegn[27];
            } else if (bokstav == 'å') {
                return antallTegn[28];
            } else {
                // Hvis bokstav er en gyldig bokstav, konverteres den til små bokstaver ved å bruke Character.toLowerCase(bokstav).
                // Dette gjør det mulig å telle både store og små bokstaver som like.

                // Metoden beregner deretter indeksen til bokstav i det interne arrayet antallTegn.
                // Indeksen tilsvarer bokstavens plassering i alfabetet minus 'a', slik at a blir 0, b blir 1, c blir 2, osv.
                int indeks = Character.toLowerCase(bokstav) - 'a';
                // Til slutt henter metoden antallet forekomster av den gitte bokstaven fra antallTegn-arrayet ved hjelp av indeksen og returnerer det.
                return antallTegn[indeks];
            }
        }
        //Hvis bokstaven ikke er en gyldig bokstav, returnerer metoden 0, siden jeg bare teller forekomster av bokstaver.
        return 0;
    }

    // Hvilken – eller hvilke, om det er flere som forekommer like ofte – bokstaver forekommer oftest i teksten?
    public char[] bokstaverMedMaksForekomster() {
        int maksAntall = 0;
        for (int i = 0; i < 30; i++) { //itererer gjennom bokstavene (0  til 28)
            //Sjekker om antall forekomster av bokstaven representert ved indeks 'i' i antallTegn-arrayet er større enn maksAntall.
            if (antallTegn[i] > maksAntall) {
                //Hvis det er tilfelle, oppdaterer den maksAntall til å være verdien av antall forekomster av den nåværende bokstaven.
                maksAntall = antallTegn[i];
            }
        }
        // En StringBuilder kalt bokstaver initialiseres.
        // Denne brukes til å samle bokstavene som har maksimalt antall forekomster.
        StringBuilder bokstaver = new StringBuilder();
        // En annen løkke itererer deretter gjennom de samme indeksene fra 0 til 28 i antallTegn-arrayet på nytt.
        for (int i = 0; i < 29; i++) {
            // Inne i denne løkken sjekker den om antall forekomster av bokstaven representert ved indeks 'i' er lik maksAntall.
            if (antallTegn[i] == maksAntall) {
                // Hvis det er tilfelle, betyr det at denne bokstaven har maksimalt antall forekomster.
                // Hvis en bokstav har maksimalt antall forekomster,
                // legger den til denne bokstaven i bokstaver-strengen ved å
                // konvertere indeksen 'i' til den tilsvarende bokstaven (for eksempel 'a' for indeks 0).

                if (i == 26) { //hvis i er lik 26 så legger den til æ i indeks 26
                    bokstaver.append('æ');
                } else if (i == 27) {
                    bokstaver.append('ø');
                } else if (i == 28) {
                    bokstaver.append('å');
                } else {
                    char bokstav = (char) ('a' + i);
                    bokstaver.append(bokstav);
                }
            }
        }
        //Til slutt konverteres bokstaver-strengen til en char-array ved hjelp av toString().toCharArray()
        // og returneres som resultat av metoden.
        return bokstaver.toString().toCharArray();
    }

    // Lag et klientprogram som går i løkke. I hvert løkkegjennomløp skal klienten skrive inn en tekst,
    // og resultatet av alle analysene foran skal skrives ut.
    public static void main(String[] args) {
        // Klientprogrammet
        while (true) {
            System.out.print("Skriv inn teksten (eller 'q' for å avslutte): ");
            Scanner scanner = new Scanner(System.in);
            String tekst = scanner.nextLine();

            if (tekst.equals("q")) {
                break;
            }

            Tekstanalyse analyse = new Tekstanalyse(tekst);
            System.out.println("Antall forskjellige bokstaver: " + analyse.antallForskjelligeBokstaver());
            System.out.println("Totalt antall bokstaver: " + analyse.totaltAntallBokstaver());
            System.out.println("Prosent ikke-bokstaver: " + analyse.prosentIkkeBokstaver() + "%");

            System.out.print("Skriv inn en bokstav for å finne antall forekomster (eller 'q' for å avslutte): ");
            char bokstav = scanner.nextLine().charAt(0);

            if (bokstav == 'q') {
                break;
            }

            int antallForekomster = analyse.antallForekomsterAvBokstav(bokstav);
            System.out.println("Antall forekomster av bokstaven '" + bokstav + "': " + antallForekomster);

            char[] bokstaverMedMaksForekomster = analyse.bokstaverMedMaksForekomster();
            System.out.println("Bokstav(er) som forekommer oftest: " + new String(bokstaverMedMaksForekomster));
        }
    }
}

