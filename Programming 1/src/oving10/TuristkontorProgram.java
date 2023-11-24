package oving10;

import java.util.List;
import java.util.Scanner;

public class TuristkontorProgram {
    public static void main(String[] args) {
        ArrangementRegister arrangementRegister = new ArrangementRegister();
        Scanner scanner = new Scanner(System.in);

        boolean fortsett = true;

        while (fortsett) {
            System.out.println("Meny:");
            System.out.println("1. Registrer nytt arrangement");
            System.out.println("2. Finn arrangementer på et gitt sted");
            System.out.println("3. Finn arrangementer på en gitt dato");
            System.out.println("4. Finn arrangementer innenfor et tidsintervall");
            System.out.println("5. Lag liste sortert etter sted");
            System.out.println("6. Lag liste sortert etter type");
            System.out.println("7. Lag liste sortert etter tidspunkt");
            System.out.println("8. Avslutt program");
            System.out.print("Velg en handling: ");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Leser newline-karakteren

            switch (valg) {
                case 1:
                    System.out.print("Skriv inn arrangementets navn: ");
                    String navn = scanner.nextLine();
                    System.out.print("Skriv inn arrangementets sted: ");
                    String sted = scanner.nextLine();
                    System.out.print("Skriv inn arrangøren: ");
                    String arrangor = scanner.nextLine();
                    System.out.print("Skriv inn arrangementets type: ");
                    String type = scanner.nextLine();
                    System.out.print("Skriv inn tidspunkt (ddmmåååå): ");
                    long tidspunkt = scanner.nextInt();
                    Arrangement nyttArrangement = new Arrangement(1, navn, sted, arrangor, type, tidspunkt);
                    // arrangementRegister.finnArrangementerPåDato(navn).size() + 1;
                    arrangementRegister.registrerArrangement(nyttArrangement);
                    System.out.println("Arrangementet er registrert.");
                    break;
                case 2:
                    System.out.print("Skriv inn stedet du vil søke på: ");
                    String søkeSted = scanner.nextLine();
                    List<Arrangement> arrangementerPåSted = arrangementRegister.finnArrangementerPåSted(søkeSted);
                    if (arrangementerPåSted.isEmpty()) {
                        System.out.println("Ingen arrangementer på dette stedet.");
                    } else {
                        System.out.println("Arrangementer på " + søkeSted + ":");
                        for (Arrangement arrangement : arrangementerPåSted) {
                            System.out.println(arrangement.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Skriv inn datoen du vil søke på (ååååmmdd): ");
                    int søkeDato = scanner.nextInt();
                    List<Arrangement> arrangementerPåDato = arrangementRegister.finnArrangementerPåDato(søkeDato);
                    if (arrangementerPåDato.isEmpty()) {
                        System.out.println("Ingen arrangementer på denne datoen.");
                    } else {
                        System.out.println("Arrangementer på " + søkeDato + ":");
                        for (Arrangement arrangement : arrangementerPåDato) {
                            System.out.println(arrangement.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Skriv inn startdato for tidsintervallet (ååååmmdd): ");
                    int startDato = scanner.nextInt();
                    System.out.print("Skriv inn sluttdato for tidsintervallet (ååååmmdd): ");
                    int sluttDato = scanner.nextInt();
                    List<Arrangement> arrangementerInnenforTidsintervall = arrangementRegister.finnArrangementerInnenforTidsintervall(startDato, sluttDato);
                    if (arrangementerInnenforTidsintervall.isEmpty()) {
                        System.out.println("Ingen arrangementer innenfor dette tidsintervallet.");
                    } else {
                        System.out.println("Arrangementer innenfor tidsintervallet:");
                        for (Arrangement arrangement : arrangementerInnenforTidsintervall) {
                            System.out.println(arrangement.toString());
                        }
                    }
                    break;
                case 5:
                    List<Arrangement> listeSortertEtterSted = arrangementRegister.lagListeSortertEtterSted();
                    System.out.println("Arrangementer sortert etter sted:");
                    for (Arrangement arrangement : listeSortertEtterSted) {
                        System.out.println(arrangement.toString());
                    }
                    break;
                case 6:
                    List<Arrangement> listeSortertEtterType = arrangementRegister.lagListeSortertEtterType();
                    System.out.println("Arrangementer sortert etter type:");
                    for (Arrangement arrangement : listeSortertEtterType) {
                        System.out.println(arrangement.toString());
                    }
                    break;
                case 7:
                    List<Arrangement> listeSortertEtterTidspunkt = arrangementRegister.lagListeSortertEtterTidspunkt();
                    System.out.println("Arrangementer sortert etter tidspunkt:");
                    for (Arrangement arrangement : listeSortertEtterTidspunkt) {
                        System.out.println(arrangement.toString());
                    }
                    break;
                case 8:
                    fortsett = false;
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }

        System.out.println("Programmet avsluttet.");
    }
}

