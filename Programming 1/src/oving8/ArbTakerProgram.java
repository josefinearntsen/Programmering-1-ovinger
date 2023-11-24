package oving8;

import java.util.Scanner;

public class ArbTakerProgram {

    //Test klient
    public static void main(String[] args) {
        // Opprett en Person-instans
        Person person1 = new Person("Josefine", "Arntsen", 2001);

        // Opprett en ArbTaker-instans som bruker Person-instansen
        ArbTaker arbTaker1 = new ArbTaker(person1, 12345, 2010, 50000, 20);

        // Kall på ulike metoder for å demonstrere funksjonaliteten
        System.out.println("Arbeidstaker: " + arbTaker1.hentFulltNavn());
        System.out.println("Alder: " + arbTaker1.hentAlder() + " år");
        System.out.println("Antall år ansatt: " + arbTaker1.hentAntallArAnsatt() + " år");
        System.out.println("Har vært ansatt mer enn 5 år? " + arbTaker1.harVærtAnsattMerEnn(5));
        System.out.println("Skattetrekk per måned: " + arbTaker1.beregnSkattPerManed() + " kroner");
        System.out.println("Bruttolønn per år: " + arbTaker1.beregnBruttolonnPerAr() + " kroner");
        System.out.println("Skattetrekk per år: " + arbTaker1.beregnSkattetrekkPerAr() + " kroner");


        //menystyrt program

        Scanner scanner = new Scanner(System.in);

        boolean fortsett = true;

        while (fortsett) {
            System.out.println("Meny:");
            System.out.println("1. Endre månedslønn");
            System.out.println("2. Endre skatteprosent");
            System.out.println("3. Avslutt program");
            System.out.print("Velg en handling: ");

            int valg = scanner.nextInt();

            if (valg == 1) {
                System.out.print("Skriv inn ny månedslønn: ");
                double nyManedslonn = scanner.nextDouble();
                arbTaker1.setManedslonn(nyManedslonn);
            } else if (valg == 2) {
                System.out.print("Skriv inn ny skatteprosent: ");
                double nySkatteprosent = scanner.nextDouble();
                arbTaker1.setSkatteprosent(nySkatteprosent);
            } else if (valg == 3) {
                fortsett = false;
                break;
            } else {
                System.out.println("Ugyldig valg. Prøv igjen.");
            }


            // Skriv ut oppdatert informasjon om arbeidstakeren
            System.out.println("Oppdatert informasjon om arbeidstaker:");
            System.out.println(arbTaker1.hentFulltNavn());
            System.out.println("Skattetrekk per måned: " + arbTaker1.beregnSkattPerManed() + " kroner");
            System.out.println("Bruttolønn per år: " + arbTaker1.beregnBruttolonnPerAr() + " kroner");
            System.out.println("Skattetrekk per år: " + arbTaker1.beregnSkattetrekkPerAr() + " kroner");
        }

        System.out.println("Programmet avsluttet.");
    }
}
