package oving9;

// Lag en klasse Oppgaveoversikt som holder orden på hvor mange oppgaver hver enkelt student har fått godkjent.
public class Oppgaveoversikt {

    private Student [] studenter; // tabellen opprettes i konstruktøren
    private int antStud; // økes med 1 for hver ny student

    public Oppgaveoversikt(int maxAntStudenter) {
        studenter = new Student[maxAntStudenter];
        antStud = 0;
    }

    // Finn antall studenter registrert
    public int finnAntallStudenter() {
        return antStud;
    }

    // Finn antall oppgaver som en bestemt student har løst
    public int finnAntallOppgaverForStudent(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // Returnerer -1 hvis studenten ikke finnes
    }

    // Registrer en ny student
    public void registrerNyStudent(String navn) {
        if (antStud < studenter.length) {
            studenter[antStud] = new Student(navn);
            antStud++;
        } else {
            System.out.println("Maksimalt antall studenter er nådd.");
        }
    }

    // Øk antall oppgaver for en bestemt student.
    public void okAntallOppgaverForStudent(String navn, int okning) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                studenter[i].okAntOppg(okning);
                return;
            }
        }
        System.out.println("Studenten med navn " + navn + " ble ikke funnet.");
    }

    //I tillegg skal du lage toString()-metode.
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Oppgaveoversikt:\n");
        for (int i = 0; i < antStud; i++) {
            result.append(studenter[i].toString()).append("\n");
        }
        return result.toString();
    }
}
