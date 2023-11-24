package oving6;

public class Matrise {
    private final int[][] data; // en todimensjonal tabell som svarer til en matrise i matematikken
    private final int rows;
    private final int cols;

    public Matrise(int[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }
    public int[][] getData() {
        return data;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public Matrise addMatrise(Matrise other) { //Addere en matrise til denne matrisen
        // sjekke om matrisene passer med hverandre
        if (other == null || this.rows != other.rows || this.cols != other.cols) {
            return null; // umulig å addere matrisene sammen
        }

        int[][] resultData = new int[rows][cols]; // hvis de passer, så lager jeg en ny matrise
        for (int r = 0; r < rows; r++) { //går gjennom rader og kolonner
            for (int k = 0; k < cols; k++) {
                resultData[r][k] = this.data[r][k] + other.data[r][k]; //addere matrisene sammen
            }
        }
        return new Matrise(resultData);
    }
    public Matrise multipliserMatrise(Matrise other) { //Multiplisere denne matrisen med en annen matrise
        // sjekke om jeg kan gange de sammen
        if (other == null || this.cols != other.rows) {
            return null; // kan ikke multiplisere matrisene
        }

        //ellers, lage ny matrise;
        int[][] resultData = new int[this.rows][other.cols];
        for (int r= 0; r < this.rows; r++) { //går gjennom hver rad i den nåværende matrisen
            for (int o_k = 0; o_k < other.cols; o_k++) { //går gjennom hver kolonne i den andre matrisen (other kolonne = o_k)
                int sum = 0; // den nested løkken er for å beregne hvert element i den resulterende matrisen
                for (int k = 0; k < this.cols; k++) { //itererer gjennom elementene i raden fra den nåværende matrisen (indeksert med k) og tilsvarende elementer i kolonnen fra den andre matrisen.
                    sum += this.data[r][k] * other.data[k][o_k]; // koden beregner hvert element i resultatmatrisen ved å utføre matrisemultiplikasjonen
                }
                resultData[r][o_k] = sum;
            }
        }
        return new Matrise(resultData);
     }

    public Matrise transponereMatrise() { //Transponere matrisen
        int[][] transposedData = new int[cols][rows]; //bytte om på rader og kolonner
        for (int k = 0; k < cols; k++) {
            for (int r = 0; r < rows; r++) {
                transposedData[k][r] = data[r][k];
            }
        }
        return new Matrise(transposedData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Oppretter en ny StringBuilder for å bygge strengen
        for (int[] row : data) { // Går gjennom hver rad i matrisen
            for (int value : row) { // Går gjennom hver verdi (element) i raden
                sb.append(value).append(" "); // Legger verdien til i StringBuilder, etterfulgt av mellomrom
            }
            sb.append("\n"); // Legger til en linjeskift etter hver rad for å skille dem
        }
        return sb.toString(); // Konverterer StringBuilder til en vanlig streng og returnerer den
    }


    public static void main(String[] args) {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{7, 8, 9}, {10, 11, 12}};
        int[][] data3 = {{1, 2}, {3, 4}, {5, 6}};

        Matrise matrise1 = new Matrise(data1);
        Matrise matrise2 = new Matrise(data2);
        Matrise matrise3 = new Matrise(data3);

        // Test addisjon
        Matrise resultatAddisjon = matrise1.addMatrise(matrise2);
        if (resultatAddisjon != null) {
            System.out.println("Addisjon:");
            System.out.println(resultatAddisjon);
        }

        // Test multiplikasjon
        Matrise resultatMultiplikasjon = matrise1.multipliserMatrise(matrise3);
        if (resultatMultiplikasjon != null) {
            System.out.println("Multiplikasjon:");
            System.out.println(resultatMultiplikasjon);
        }

        // Test transponering
        Matrise transponertMatrise = matrise3.transponereMatrise();
        System.out.println("Transponert matrise:");
        System.out.println(transponertMatrise);

    }
}

