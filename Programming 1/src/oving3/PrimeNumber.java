package oving3;// Oppgave 2
// Skriv et program som finner ut om et tall er et primtall.
// Et primtall er et tall som kun kan deles med 1 og med seg selv uten å få rest.
// Les inn tallet fra brukeren og la programmet repetere slik at flere tall kan analyseres.

// I konteksten av primtallsjekken brukes dette uttrykket til å se om tallet tall er jevnt delt på et annet tall "i" uten rest.
// Hvis resultatet av uttrykket "tall % i == 0" er sant, betyr det at tall kan deles med "i" uten å etterlate noen rest,
// noe som betyr at tall ikke er et primtall.

import java.sql.SQLOutput;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        int number;

        System.out.println("Ønsker du å avslutte programmet? Tast x");
        System.out.println("Skriv inn et tall: ");

        while (running) {
            String input = String.valueOf(scanner.hasNext());
            //hvis den er lik "x", så EXIT programmet!
            if (input.equalsIgnoreCase("x")) { //driter i om det er stor eller liten bokstav
                System.exit(0);

            }
            else {
                do {
                    //System.out.println("Skriv inn et tall: ");
                    number = scanner.nextInt(); //lagrer inputen

                    boolean isPrime = true;

                    // Sjekker om tallet er delelig med noen tall mellom 2 og tallet selv minus 1
                    for (int i = 2; i < number; i++) { // i er lik 2, så lenge i er under input, mens den okes med 1 for hver loop
                        if (number % i == 0) { // hvis input er delelig med i - 1 er lik 0 (altsa ingen rest)
                            isPrime = false;
                            break; //ikke behov for flere sjekker
                        }
                    }
                    if (isPrime) {
                        System.out.println("Tallet " + number + " er et primtall.");

                    } else {
                        System.out.println("Tallet " + number + " er ikke et primtall.");
                    }
                    System.out.println("Skriv inn et tall: ");
                } while (!scanner.hasNextInt());
                while (!scanner.hasNextInt()) {
                    System.out.println("Du må skrive et heltall!");
                    scanner.next();
                }
            }
        }
    }
}

