package oving5;

import java.sql.SQLOutput;
import java.util.Random;
public class MinRandom {

    // Klassen skal ha et objekt av klassen java.util.Random som objektvariabel.
    final Random randomGenerator;

    public MinRandom() {
        randomGenerator = new Random();
    }
    public int nesteHeltall(int nedre, int ovre) { // intervallet (nedre, ovre)
        if (nedre >= ovre) {
            throw new IllegalArgumentException("Nedre grense må være mindre enn øvre grense.");
        }
        int randomNumber = randomGenerator.nextInt(ovre - nedre + 1);
        System.out.println("returnerer randomNumber og nedre");
        // + nedre for å få det innenfor intervallet
        return randomNumber + nedre;
    }

    // intervallet >nedre, ovre> 15.
    // Denne notasjonen betyr at 0,0 er med, mens 1,0 ikke er med.
    public double nesteDesimaltall(double nedre, double ovre) throws IllegalArgumentException {
        if (nedre >= ovre) {
            throw new IllegalArgumentException("Nedre grense må være mindre enn øvre grense.");
        }
        double randomDesiNumber = randomGenerator.nextDouble();
        System.out.println("returnerer randomDesiNumber gange ovre*nedre og nedre");
        return randomDesiNumber * (ovre - nedre) + nedre;
    }

    // Metodene foran skal implementeres ved at man bruker dette objektet til å generere neste tilfeldige tall.
    // Resultatet skal så transformeres til det ønskede intervallet.

    // Prøv klassen ved å lage mange tilfeldige tall av begge typer og forsikre deg om at de ligger i de oppgitte intervallene.

    public static void main(String[] args) {
        MinRandom minRandom = new MinRandom();

        try {
            // Test generering av tilfeldige heltall i intervallet [10, 20]
            for (int i = 0; i < 10; i++) {
                int tilfeldigHeltall = minRandom.nesteHeltall(10, 20);
                System.out.println("Tilfeldig heltall: " + tilfeldigHeltall);
            }

            // Test generering av tilfeldige desimaltall i intervallet [5.0, 10.0]
            for (int i = 0; i < 10; i++) {
                double tilfeldigDesimaltall = minRandom.nesteDesimaltall(5.0, 10.0);
                System.out.println("Tilfeldig desimaltall: " + tilfeldigDesimaltall);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
