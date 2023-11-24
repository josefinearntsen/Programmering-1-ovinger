package oving3;// Øving 3 Kontrollstrukturen Løkke
// Du skal i alle oppgavene lese data fra brukeren. Løs først oppgavene uten kontroll av inndata.
// Du kan så, der det er relevant, legge inn kontroll av inndata med enkel bruk av do-setningen (teknikk 1, programliste 4,3).

// Merk at denne teknikken ikke omfatter det tilfellet at brukeren skriver inn en tekst der et tall er forventet.
// Denne feilen gir NumberFormatException, og du må ha kunnskap om unntakshåndtering for å behandle feil av denne typen.

// Oppgave 1:
// Lag et program som skriver ut en del av multiplikasjonstabellen, for eksempel fra 13-15.
// Da skal utskriften se omtrent slik ut (prikkene skal erstattes med regnestykker).
// 13-gangen: 13 x 1 = 13 13 x 2 = 26 ... 13 x 10 = 130
// 14-gangen: 14 x 1 = 14 14 x 2 = 28 ... 14 x 10 = 140
// 15-gangen: 15 x 1 = 15 15 x 2 = 30 ... 15 x 10 = 150

// Brukeren skal velge hvilken del av tabellen som skal skrives ut.

import java.util.Scanner;

public class Multi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start, slutt;

        do {
            System.out.println("Skriv inn startnummer for MultiplikasjonsTabellen: ");
            while (!scanner.hasNextInt()) { // saa lenge scanner ikke faar et int heltall
                System.out.println("Feilmelding: Du må skrive et heltall!");
                scanner.next(); // Leser og forkaster ugyldig input
            }
            start = scanner.nextInt();

            System.out.println("Skriv inn sluttnummer for MultiplikasjonsTabellen: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Feilmelding: Du må skrive et heltall!");
                scanner.next(); // Leser og forkaster ugyldig input
            }
            slutt = scanner.nextInt();

            if (start > slutt) {
                System.out.println("Feilmelding: Startnummer må være mindre enn sluttnummer!");
            }
        } while (start > slutt); //saa lenge start er storre enn slutt, saa gaar denne do-whilen!

        for (int tall = start; tall <= slutt; tall++) { //fra start, saa lenge input-tall er mindre enn eller lik slutt, oek tall
            System.out.println(tall + "-gangen:"); // naar tall kommer til slutt, saa printer den ut dette

            for (int faktor = 1; faktor <= 10; faktor++) { //faktor starter aa gange med 1 og frem til 10, oeker med en for hvert tall
                int produkt = tall * faktor; //ganger faktor og tallet fra input sammen
                System.out.println(tall + " x " + faktor + " = " + produkt); // printer ut gangetabellen
            }
            System.out.println();
        }
        scanner.close();
    }
}
