package oving11;

import oving10.Arrangement;

import java.util.List;
import java.util.Scanner;

public class KlientProgram {

    EiendomsRegister eiendomsRegister = new EiendomsRegister();
    /**
     * Presents the menu for the user, and awaits input from the user. The menu * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1. * If 0 is returned, the user has entered a wrong value
     */
    private int showMenu() {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("0. Quit");
        System.out.println("\nPlease enter a number between 1 and 4.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user, * and executing the selected functionality.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        boolean finished = false;
        // The while-loop will run as long as the user has not selected // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY:
                    System.out.println("Har du bruksnavn? Tast 1 for ja eller 2 for nei.");
                    int harBruksNavn = scanner.nextInt();
                    scanner.nextLine();
                    if (harBruksNavn==1) {
                        System.out.print("Skriv inn kommunenummer: ");
                        int kommuneNummer = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn kommunenavn: ");
                        String kommuneNavn = scanner.nextLine();
                        System.out.print("Skriv inn gårdsnummer: ");
                        int gnr = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn bruksnummer: ");
                        int bnr = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn bruksnavn: ");
                        String bruksNavn = scanner.nextLine();
                        System.out.print("Skriv inn areal: ");
                        double areal = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Skriv inn eier: ");
                        String eier = scanner.nextLine();
                        Eiendom eiendom = new Eiendom(kommuneNummer,kommuneNavn,gnr,bnr,bruksNavn,areal,eier);
                        eiendomsRegister.registrerEiendom(eiendom);

                        System.out.println("Eiendommen er registrert.");
                        break;
                    } else if (harBruksNavn==2) {
                        System.out.print("Skriv inn kommunenummer: ");
                        int kommuneNummer = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn kommunenavn: ");
                        String kommuneNavn = scanner.nextLine();
                        System.out.print("Skriv inn gårdsnummer: ");
                        int gnr = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn bruksnummer: ");
                        int bnr = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Skriv inn areal: ");
                        double areal = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Skriv inn eier: ");
                        String eier = scanner.nextLine();
                        Eiendom eiendom = new Eiendom(kommuneNummer,kommuneNavn,gnr,bnr,areal,eier);
                        eiendomsRegister.registrerEiendom(eiendom);

                        System.out.println("Eiendommen er registrert.");
                        break;
                    }

                case LIST_ALL_PROPERTIES:
                    System.out.println("Her er alle eiendommmene: ");
                    System.out.println(eiendomsRegister);

                    break;
                case FIND_PROPERTY:
                    System.out.print("Skriv inn kommunenummer: ");
                    int kommuneNummer = scanner.nextInt();
                    System.out.print("Skriv inn gårdsnummer: ");
                    int gnr = scanner.nextInt();
                    System.out.print("Skriv inn bruksnummer: ");
                    int bnr = scanner.nextInt();
                    System.out.println(eiendomsRegister.getEiendom(kommuneNummer,gnr,bnr));


                    break;
                case CALCULATE_AVERAGE_AREA:
                    System.out.println("Gjennomsnittareal: \n" + eiendomsRegister.gjennomsnittAreal());
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }
    //... der følgende konstanter er definert:
    // Constants representing the different menu choices
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int EXIT = 0;

    public static void main(String[] args) {
        KlientProgram klientprogram = new KlientProgram();
        klientprogram.start();
    }
}
