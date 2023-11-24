package oving9;

public class Student {
    private String navn; // entydig(!)
    private int antOppg; //antOppg holder orden på hvor mange av de oppgavene studenten har levert inn, som er godkjent.

    public Student (String navn) {
        this.navn = navn;
        this.antOppg = 0;
    }

    public String getNavn() {
        return navn;
    }
    public int getAntOppg() {
        return antOppg;
    }
    public void okAntOppg(int okning) {
        antOppg += okning;
    }

    @Override
    public String toString(){
        return "Student [Navn: " + navn + ", Antall oppgaver: " + antOppg + "]";
    }

    public static void main(String [] args) {
        Student student1 = new Student("Josefine");

        System.out.println(student1.toString());
        System.out.println("Studenten heter: " + student1.getNavn());
        System.out.println("Antall oppgaver: " + student1.getAntOppg());
        student1.okAntOppg(2);
        System.out.println("Øker antall oppgaver med 2. " + "\nNå er antall oppgaver: "+ student1.getAntOppg());
        System.out.println(student1.toString());
    }
}
