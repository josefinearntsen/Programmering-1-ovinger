package oving5;

import java.sql.SQLOutput;

// Lag en klasse for å regne med brøk.
// Klassen skal ha to konstruktører:
public class Fraction {
    private int numerator; //nevner
    private int denominator; //teller

    // Den ene konstruktøren tar teller og nevner som argument.
    public Fraction(int numerator, int denominator) {
        // Hvis nevneren er 0, skal et unntaksobjekt av typen IllegalArgumentException kastes.
        if (numerator == 0) {
            throw new IllegalArgumentException("Nevneren kan ikke være 0.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        shorten();
    }

    // Den andre konstruktøren tar kun telleren som argument.
    // Da skal nevneren settes lik 1.
    public Fraction(int numerator){
        this(numerator, 1);
    }

    public int getNumerator() {
        return numerator; // teller (det er motsatt i metoden da)
    }

    public int getDenominator() {
        return denominator; //nevner
    }

    // Klassen skal ha metoder for å summere, subtrahere, multiplisere og dividere
    // en brøk (this) med en annen brøk (parameter til metoden).

    // Metode for å summere brøker
    public void add(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.denominator;
        this.numerator = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
        this.denominator = commonDenominator;
        shorten();
    }

    // Metode for å subtrahere brøker
    public void subtract(Fraction fraction) {
        this.numerator = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
        this.denominator = this.denominator * fraction.denominator;
        shorten();
    }

    // Metode for å multiplisere brøker
    public void multiply(Fraction fraction) {
        this.numerator *= fraction.numerator;
        this.denominator *= fraction.denominator;
        shorten();
    }

    // Metode for å dividere brøker
    public void divide(Fraction fraction) throws IllegalArgumentException {
        if (fraction.numerator == 0) {
            throw new IllegalArgumentException("Kan ikke dele med null.");
        }
        // Bytt om teller og nevner i den angitte brøken for å utføre divisjon
        // Oppdater teller og nevner med resultatet
        this.numerator = this.numerator * fraction.denominator;
        this.denominator = this.denominator * fraction.numerator;

        shorten();
    }

    // Metode for å forkorte brøken
    private void shorten() { // gcd = greatest common divisor
        //kaller paa gcd(int a, int b) med absoluttverdiene til telleren (numerator) og nevneren (denominator) som argumenter.
        //Gjores for aa sikre at gcd alltid blir positiv, uavhengig av om telleren eller nevneren er negative.
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        //Her deler koden telleren (numerator) med gcd.
        //Dette reduserer telleren til en lavere verdi som er relatert til gcd.
        numerator /= gcd;
        //På samme maate deler koden nevneren (denominator) med gcd.
        //Dette reduserer nevneren til en lavere verdi som er relatert til gcd.
        denominator /= gcd;
    }

    // Hjelpemetode for å finne storste felles divisor (gcd)
    private int gcd(int a, int b) {
        // Sjekker om b er lik null
        while (b != 0) {
            // Beregner resten når a deles på b
            int remainder = a % b;

            // Bytter verdien til a med b og verdien til b med resten (remainder)
            a = b;
            b = remainder;
        }
        // Når b blir lik null, er gcd funnet, og resultatet er lagret i a
        return a;
    }


    // Testklient for å demonstrere bruken av klassen
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(1, 3);

        fraction1.add(fraction2);
        System.out.println("Addert: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());

        fraction1.subtract(fraction2);
        System.out.println("Subtrahert: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());

        fraction1.multiply(fraction2);
        System.out.println("Multiplisert: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());

        fraction1.divide(fraction2);
        System.out.println("Dividert: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());
    }
}