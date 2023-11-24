package oving12;
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TrainDeparture {
    private String departureTime;
    private String line;
    private String trainNumber;
    private String destination;
    private String delay;
    private int track;

    public TrainDeparture(String departureTime, String line, String trainNumber, String destination, String delay, int track) {
        this.departureTime = departureTime;
        this.line = line;
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.delay = delay;
        this.track = track;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    // Implement getter and setter methods for other attributes as needed
}

public class TrainDispatchSystem {
    private static ArrayList<TrainDeparture> trainSchedule = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVelg en operasjon:");
            System.out.println("1. Vis timeplan");
            System.out.println("2. Legg til togavgang");
            System.out.println("3. Tildele spor");
            System.out.println("4. Legg til forsinkelse");
            System.out.println("5. Søk etter togavgang");
            System.out.println("6. Oppdater klokken");
            System.out.println("7. Avslutt");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displaySchedule();
                    break;
                case "2":
                    addDeparture();
                    break;
                case "3":
                    assignTrack();
                    break;
                // Implementer de andre valgene her
                case "7":
                    System.out.println("Applikasjonen avsluttes.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }

    private static void displaySchedule() {
        if (trainSchedule.isEmpty()) {
            System.out.println("Ingen tog i timeplanen.");
            return;
        }

        Collections.sort(trainSchedule, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()));

        for (TrainDeparture departure : trainSchedule) {
            System.out.println("Avgangstid: " + departure.getDepartureTime() + ", Linje: " + departure.getLine() + ", Tognummer: " + departure.getTrainNumber() + ", Destinasjon: " + departure.getDestination() + ", Forsinkelse: " + departure.getDelay() + ", Spor: " + (departure.getTrack() == -1 ? "Ingen" : departure.getTrack()));
        }
    }

    private static void addDeparture() {
        // Implementer legg til togavgang funksjonalitet her
    }

    private static void assignTrack() {
        // Implementer tildel spor funksjonalitet her
    }

    // Implementer de andre funksjonene (forsinkelse, søk etter togavganger, oppdater klokken) på lignende måte
}

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Scanner;

class TrainDeparture {
    private String departureTime;
    private String line;
    private String trainNumber;
    private String destination;
    private String delay;
    private int track;

    public TrainDeparture(String departureTime, String line, String trainNumber, String destination, String delay, int track) {
        this.departureTime = departureTime;
        this.line = line;
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.delay = delay;
        this.track = track;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getLine() {
        return line;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDelay() {
        return delay;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}

public class TrainDispatchSystem {
    private static ArrayList<TrainDeparture> trainSchedule = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVelg en operasjon:");
            System.out.println("1. Vis timeplan");
            System.out.println("2. Legg til togavgang");
            System.out.println("3. Tildele spor");
            System.out.println("4. Legg til forsinkelse");
            System.out.println("5. Søk etter togavgang");
            System.out.println("6. Oppdater klokken");
            System.out.println("7. Avslutt");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displaySchedule();
                    break;
                case "2":
                    addDeparture();
                    break;
                case "3":
                    assignTrack();
                    break;
                case "4":
                    addDelay();
                    break;
                case "5":
                    searchTrain();
                    break;
                case "6":
                    updateClock();
                    break;
                case "7":
                    System.out.println("Applikasjonen avsluttes.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }

    private static void displaySchedule() {
        if (trainSchedule.isEmpty()) {
            System.out.println("Ingen tog i timeplanen.");
            return;
        }

        Collections.sort(trainSchedule, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()));

        for (TrainDeparture departure : trainSchedule) {
            System.out.println("Avgangstid: " + departure.getDepartureTime() + ", Linje: " + departure.getLine() + ", Tognummer: " + departure.getTrainNumber() + ", Destinasjon: " + departure.getDestination() + ", Forsinkelse: " + departure.getDelay() + ", Spor: " + (departure.getTrack() == -1 ? "Ingen" : departure.getTrack()));
        }
    }

    private static void addDeparture() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv inn avgangstid (hh:mm): ");
        String departureTime = scanner.nextLine();
        System.out.print("Skriv inn linje: ");
        String line = scanner.nextLine();
        System.out.print("Skriv inn tognummer: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Skriv inn destinasjon: ");
        String destination = scanner.nextLine();
        System.out.print("Skriv inn forsinkelse (hh:mm): ");
        String delay = scanner.nextLine();
        int track = -1;

        for (TrainDeparture departure : trainSchedule) {
            if (departure.getTrainNumber().equals(trainNumber)) {
                System.out.println("Tognummeret er allerede i bruk. Legg til et unikt tognummer.");
                return;
            }
        }

        TrainDeparture newDeparture = new TrainDeparture(departureTime, line, trainNumber, destination, delay, track);
        trainSchedule.add(newDeparture);
        System.out.println("Togavgang lagt til i timeplanen.");
    }

    private static void assignTrack() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv inn tognummer for å tildele spor: ");
        String trainNumber = scanner.nextLine();

        for (TrainDeparture departure : trainSchedule) {
            if (departure.getTrainNumber().equals(trainNumber)) {
                System.out.print("Skriv inn spor: ");
                int track = Integer.parseInt(scanner.nextLine());
                departure.setTrack(track);
                System.out.println("Spor tildelt for tognummer " + trainNumber + ".");
                return;
            }
        }

        System.out.println("Tognummeret " + trainNumber + " ble ikke funnet i timeplanen.");
    }

    private static void addDelay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv inn tognummer for å legge til forsinkelse: ");
        String trainNumber = scanner.nextLine();

        for (TrainDeparture departure : trainSchedule) {
            if (departure.getTrainNumber().equals(trainNumber)) {
                System.out.print("Skriv inn forsinkelse (hh:mm): ");
                String delay = scanner.nextLine();
                departure.delay = delay;
                System.out.println("Forsinkelse lagt til for tognummer " + trainNumber + ".");
                return;
            }
        }

        System.out.println("Tognummeret " + trainNumber + " ble ikke funnet i timeplanen.");
    }

    private static void searchTrain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv inn tognummer for å søke: ");
        String trainNumber = scanner.nextLine();

        for (TrainDeparture departure : trainSchedule) {
            if (departure.getTrainNumber().equals(trainNumber)) {
                System.out.println("Avgangstid: " + departure.getDepartureTime() + ", Linje: " + departure.getLine() + ", Tognummer: " + departure.getTrainNumber() + ", Destinasjon: " + departure.getDestination() + ", Forsinkelse: " + departure.getDelay() + ", Spor: " + (departure.getTrack() == -1 ? "Ingen" : departure.getTrack()));
                return;
            }
        }

        System.out.println("Tognummeret " + trainNumber + " ble ikke funnet i timeplanen.");
    }

    private static void updateClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv inn det nye klokkeslettet (hh:mm): ");
        String newTime = scanner.nextLine();

        // Legg til logikk for å oppdatere klokken her (slik at den ikke kan settes tilbake i tid)
        System.out.println("Klokken oppdatert til " + newTime + ".");
    }
}

*/
