package oving4;/*
Lag en klasse oving4.Valuta med minst en konstruktør.
Klassen skal ha metoder for å regne fra og til norske kroner.
Lag et klientprogram som oppretter minst tre objekter som representerer forskjellige valutaer.
Brukeren skal få tilbud om å regne om flere ulike beløp i de forskjellige valutaene til norske kroner.
Programmet må altså presentere en meny for brukeren.
Den kan for eksempel se sånn ut:
Velg valuta:
        1: dollar
        2: euro
        3: svenske kroner
        4: avslutt
Brukeren skriver inn ett av tallene 1, 2 eller 3 (eller 4 for avslutt).
Dette skal styre programflyten slik at riktig valutaobjekt blir brukt.
*/
import java.util.Scanner;

public class Valuta {
    private String name;
    private double rate;

    public Valuta(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public double fromNok(double amount) {
        return amount / rate; //belop / kurs
    }

    public double toNok(double amount) {
        return amount * rate; //belop * kurs
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Lager tre objekter som representerer forskjellige valutaer

        Valuta dollar = new Valuta("Dollar", 10.73);
        Valuta euro = new Valuta("Euro", 11.54);
        Valuta sek = new Valuta("Svenske kroner", 0.97);

        boolean running = true;

        while (running) {
            System.out.println("MENY FOR VALUTA\n Velg valuta: \n 1: dollar \n 2: euro \n 3: svenske kroner \n 4: avlsutt");

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Programmet er avsluttet.");
                running = false;
                System.exit(0);
            }

            else if (choice == 1) {
                System.out.println("Hvor mange dollar vil du omgjøre til NOK?");
                double dollarAmount = scanner.nextDouble();
                double nokAmount1 = dollar.toNok(dollarAmount);
                System.out.println(dollarAmount + " dollar = " + nokAmount1 + " kr");
            }

            else if (choice == 2) {
                System.out.println("Hvor mange euro vil du omgjøre til NOK?");
                double euroAmount = scanner.nextDouble();
                double nokAmount2 = euro.toNok(euroAmount);
                System.out.println(euroAmount + " euro = " + nokAmount2 + " kr");
            }

            else if (choice == 3) {
                System.out.println("Hvor mange svenske kroner vil du omgjøre til NOK?");
                double sekAmount = scanner.nextDouble();
                double nokAmount3 = sek.toNok(sekAmount);
                System.out.println(sekAmount + " SEK = " + nokAmount3 + " kr");
            }

            else { //funker kun for int
                System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }
}