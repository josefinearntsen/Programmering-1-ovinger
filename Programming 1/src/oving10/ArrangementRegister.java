package oving10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangementRegister {
    private List<Arrangement> arrangementer;

    public ArrangementRegister() {
        arrangementer = new ArrayList<>();
    }

    public void registrerArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    // Finne alle arrangementer som foregår på et spesifikt sted.

    public List<Arrangement> finnArrangementerPåSted(String sted) { // Tar inn et stedsnavn som parameter
        List<Arrangement> resultater_sted = new ArrayList<>(); // ny arraylist
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getSted().equalsIgnoreCase(sted)) { //ignorer stor/liten bokstav
                resultater_sted.add(arrangement);
            }
        }
        return resultater_sted; // Returnerer en liste med alle arrangementene som matchet det gitte stedet

    }

    // Finne alle arrangementer som foregår på en bestemt dato.
    public List<Arrangement> finnArrangementerPåDato(int dato) { // tar inn en dato som parameter (i formatet ååååmmdd)
        List<Arrangement> resultater_dato = new ArrayList<>();
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getTidspunkt() / 10000 == dato / 10000) {
            //long arrangementDato = arrangement.getTidspunkt() % 1000000;
            //if (arrangementDato == dato) {
                resultater_dato.add(arrangement);
            }
        }
        return resultater_dato; //returnerer en liste med alle arrangementene som matchet den gitte datoen
    }

    //Finne arrangementer innenfor et tidsintervall
    public List<Arrangement> finnArrangementerInnenforTidsintervall(int startDato, int sluttDato) {
        List<Arrangement> resultater_tidsintervall = new ArrayList<>();
        for (Arrangement arrangement : arrangementer) { // gå gjennom alle arrangementer i registeret
            long tidspunkt = arrangement.getTidspunkt(); // hent ut tidspunkt for arrangementet
            if (tidspunkt >= startDato && tidspunkt <= sluttDato) { // ligger det innenfor tidsintervallet?
                resultater_tidsintervall.add(arrangement); //hvis true: legg til i listen
            }
        }
        // Sortere resultater_tidsintervall basert på tidspunktene til arrangementene
        // Dette gir en sortert liste over arrangementer innenfor tidsintervallet
        Collections.sort(resultater_tidsintervall, Comparator.comparingLong(Arrangement::getTidspunkt));
        return resultater_tidsintervall;
    }


    // lage lister sortert etter sted
    public List<Arrangement> lagListeSortertEtterSted() {
        List<Arrangement> resultater = new ArrayList<>(arrangementer);
        Collections.sort(resultater, Comparator.comparing(Arrangement::getSted));
        return resultater;
    }

    // lage lister sortert etter type
    public List<Arrangement> lagListeSortertEtterType() {
        List<Arrangement> resultater = new ArrayList<>(arrangementer);
        Collections.sort(resultater, Comparator.comparing(Arrangement::getType));
        return resultater;
    }

    // lage lister sortert etter tidspunkt
    public List<Arrangement> lagListeSortertEtterTidspunkt() {
        List<Arrangement> resultater = new ArrayList<>(arrangementer);
        Collections.sort(resultater, Comparator.comparingLong(Arrangement::getTidspunkt));
        return resultater;
    }
}
