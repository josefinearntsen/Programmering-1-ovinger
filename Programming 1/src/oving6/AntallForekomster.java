package oving6;

import java.sql.SQLOutput;

// Fra programmeringsoppgaver kjenner du kanskje nå klassen java.util.Random.
// Lag et objekt av klassen:
// Java.util.Random random = new java.util.Random(); // vi lager en tilfeldigtallgenerator Setningen
// Int tall = random.nextInt(10); gir en verdi i intervallet (0, 9). Opprett en tabell
// Int antall = new int(10);
// Lag et program som går i løkke for eksempel 1000 ganger og henter ut tilfeldige tall.
// I tabellen antall skal du lagre antall ganger hvert enkelt av tallene 0, 1, ..., 9 er hentet ut.
// Til slutt skriver du ut en liste over antall forekomster av hvert enkelt av de ti tallene.
// Prøv gjerne også programmet med 5000 og 10 000 gjennomløp av løkken.
// Ekstraoppgave:
// Skriv ut resultatene med tall og med stjerner, der en stjerne representerer 1/100 av antall ganger et bestemt tall er trukket.
// Med 1000 løkkegjennomløp og tallet 5 trukket 86 ganger vil linjen for tallet 5 kunne se slik ut (86 blir avrundet til 90, og dermed 9 stjerner)
// 5 86 *********
public class AntallForekomster {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random(); // lager en tilfeldigtallgenerator
        int[] antall = new int[10]; // Oppretter en tabell

        int gjennomlop = 1000; // Kan endres til 5000 eller 10000 for ekstra testing

        for (int i = 0; i < gjennomlop; i++) {
            int tall = random.nextInt(10); // gir en verdi i intervallet (0, 9)
            antall[tall]++;
        }

        System.out.println("Antall forekomster av hvert tall:");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + antall[i]); // printer ut indeks og det som indeksen inneholder
        }

        System.out.println("Resultater med stjerner: ");

        for (int i = 0; i < 10; i++) {
            int stars = (int) Math.round(antall[i] / 10.0); // deler resultatet på hver indeks på 10, casting, hvis en av verdien er double får du double tilbajke
            System.out.print(i + " " + antall[i] + " ");
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
