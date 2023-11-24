package oving10;

import java.util.Scanner;

public class RestaurantKjede {
    public static void main(String[] args) {
        Rett rett1 = new Rett("Pasta Carbonara", "hovedrett", 150, "Bland pasta med egg, ost og bacon.");
        Rett rett2 = new Rett("Tiramisu", "dessert", 80, "Laget med kaffe, mascarpone og ladyfingers.");
        Meny meny1 = new Meny();
        meny1.leggTilRett(rett1);
        meny1.leggTilRett(rett2);

        Rett rett3 = new Rett("Bruschetta", "forrett", 60, "Ristet brød med tomater, hvitløk og basilikum.");
        Meny meny2 = new Meny();
        meny2.leggTilRett(rett3);
        meny2.leggTilRett(rett2);

        MenyRegister menyRegister = new MenyRegister();
        menyRegister.registrerRett(rett1);
        menyRegister.registrerRett(rett2);
        menyRegister.registrerRett(rett3);

        menyRegister.registrerMeny(meny1);
        menyRegister.registrerMeny(meny2);

        Scanner scanner = new Scanner(System.in);
        int valg;

        do {
            System.out.println("\nVelg en operasjon:");
            System.out.println("1. Finn en rett");
            System.out.println("2. Finn retter av en bestemt type");
            System.out.println("3. Registrer en ny rett");
            System.out.println("4. Registrer en ny meny");
            System.out.println("5. Finn menyer innenfor prisintervall");
            System.out.println("0. Avslutt");

            valg = scanner.nextInt();

            switch (valg) {
                case 1:
                    System.out.println("Skriv inn navn på retten du vil finne:");
                    scanner.nextLine(); // For å konsumere linjeskift
                    String rettNavn = scanner.nextLine();
                    Rett funnetRett = menyRegister.finnRett(rettNavn);
                    if (funnetRett != null) {
                        System.out.println("Rett funnet: " + funnetRett.getNavn());
                    } else {
                        System.out.println("Rett ikke funnet.");
                    }
                    break;

                case 2:
                    System.out.println("Skriv inn rettetype (forrett, hovedrett, dessert, osv.):");
                    scanner.nextLine(); // For å konsumere linjeskift
                    String rettType = scanner.nextLine();
                    System.out.println("Retter av type " + rettType + ":");
                    for (Rett rett : menyRegister.finnRetterAvType(rettType)) {
                        System.out.println(rett.getNavn());
                    }
                    break;

                case 3:
                    System.out.println("Skriv inn navn på den nye retten:");
                    scanner.nextLine(); // For å konsumere linjeskift
                    String nyRettNavn = scanner.nextLine();
                    System.out.println("Skriv inn type:");
                    String nyRettType = scanner.nextLine();
                    System.out.println("Skriv inn pris:");
                    double nyRettPris = scanner.nextDouble();
                    scanner.nextLine(); // For å konsumere linjeskift
                    System.out.println("Skriv inn oppskrift:");
                    String nyRettOppskrift = scanner.nextLine();

                    Rett nyRett = new Rett(nyRettNavn, nyRettType, nyRettPris, nyRettOppskrift);
                    menyRegister.registrerRett(nyRett);
                    System.out.println("Ny rett registrert: " + nyRett.getNavn());
                    break;

                case 4:
                    Meny nyMeny = new Meny();
                    System.out.println("Legg til retter i menyen (avslutt med 0):");
                    while (true) {
                        System.out.println("Skriv inn navn på retten du vil legge til:");
                        scanner.nextLine(); // For å konsumere linjeskift
                        String menyRettNavn = scanner.nextLine();
                        if (menyRettNavn.equals("0")) {
                            break;
                        }
                        Rett menyRett = menyRegister.finnRett(menyRettNavn);
                        if (menyRett != null) {
                            nyMeny.leggTilRett(menyRett);
                        } else {
                            System.out.println("Rett ikke funnet. Prøv på nytt.");
                        }
                    }
                    menyRegister.registrerMeny(nyMeny);
                    System.out.println("Ny meny registrert med totalpris: " + nyMeny.totalPris());
                    break;

                case 5:
                    System.out.println("Skriv inn nedre prisgrense:");
                    double lavPris = scanner.nextDouble();
                    System.out.println("Skriv inn øvre prisgrense:");
                    double hoyPris = scanner.nextDouble();
                    System.out.println("Menyer med totalpris innenfor intervallet:");
                    for (Meny meny : menyRegister.finnMenyerInnenforPrisintervall(lavPris, hoyPris)) {
                        System.out.println("Meny med totalpris: " + meny.totalPris());
                    }
                    break;

                case 0:
                    System.out.println("Avslutter programmet.");
                    break;

                default:
                    System.out.println("Ugyldig valg. Prøv på nytt.");
                    break;
            }

        } while (valg != 0);

        scanner.close();
    }
}
