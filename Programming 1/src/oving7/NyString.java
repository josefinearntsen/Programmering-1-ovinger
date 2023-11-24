package oving7;

public class NyString {
    private final String nyString; // Objektvariabelen som lagrer den opprinnelige strengen

    public NyString(String nyString) {
        this.nyString = nyString; // Konstruktør som tar en String som argument og lagrer den
    }

    public String forkort() {
        StringBuilder forkortetTekst = new StringBuilder();
        String[] ord = nyString.split(" "); // Deler opp strengen i ord ved hjelp av mellomrom som skille
        for (String s : ord) {
            if (!s.isEmpty()) { // Sjekker om ordet ikke er tomt (for å unngå mellomrom)
                forkortetTekst.append(s.charAt(0)); // Legger til første bokstav i hvert ord i den forkortede teksten
            }
        }
        return forkortetTekst.toString(); // Returnerer den forkortede teksten som en String
    }

    public String fjernTegn(char tegn) {
        StringBuilder nyTekst = new StringBuilder();
        int indeks = nyString.indexOf(tegn); // Finn indeksen til første forekomst av tegnet
        int startIndeks = 0;
        while (indeks != -1) {
            nyTekst.append(nyString.substring(startIndeks, indeks)); // Legger til delen av teksten før tegnet
            startIndeks = indeks + 1; // Oppdaterer startindeksen for å hoppe over den nåværende forekomsten
            indeks = nyString.indexOf(tegn, startIndeks); // Finn indeksen til neste forekomst av tegnet
        }
        nyTekst.append(nyString.substring(startIndeks)); // Legger til resten av teksten etter siste forekomst av tegnet
        return nyTekst.toString(); // Returnerer den resulterende teksten som en String
    }

    public static void main(String[] args) {
        String tekst = "denne setningen kan forkortes";
        System.out.println("Tekst: " + tekst);
        NyString nyTekstObjekt = new NyString(tekst);

        String forkortetTekst = nyTekstObjekt.forkort();
        System.out.println("Forkortet tekst: " + forkortetTekst);

        char tegnSomSkalFjernes = 'e';
        String tekstUtenTegn = nyTekstObjekt.fjernTegn(tegnSomSkalFjernes);
        System.out.println("Tekst uten '" + tegnSomSkalFjernes + "': " + tekstUtenTegn);
    }
}


