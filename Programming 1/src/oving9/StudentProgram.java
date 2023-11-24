package oving9;

public class StudentProgram {
    // Lag et enkelt klientprogram.
    public static void main(String[] args) {
        Oppgaveoversikt oppgaveoversikt = new Oppgaveoversikt(10); // Opprett oppgaveoversikt med plass til 10 studenter

        // Registrer nye studenter
        oppgaveoversikt.registrerNyStudent("Student1");
        oppgaveoversikt.registrerNyStudent("Student2");

        // Øk antall oppgaver for studenter
        oppgaveoversikt.okAntallOppgaverForStudent("Student1", 3);
        oppgaveoversikt.okAntallOppgaverForStudent("Student2", 5);

        // Skriv ut informasjon om antall studenter og antall oppgaver for hver student
        System.out.println("Antall studenter: " + oppgaveoversikt.finnAntallStudenter());
        System.out.println(oppgaveoversikt.toString());

        // Finn antall oppgaver for en bestemt student
        int antallOppgaver = oppgaveoversikt.finnAntallOppgaverForStudent("Student1");
        if (antallOppgaver != -1) {
            System.out.println("Antall oppgaver for Student1: " + antallOppgaver);
        } else {
            System.out.println("Studenten ble ikke funnet.");
        }
    }
}
