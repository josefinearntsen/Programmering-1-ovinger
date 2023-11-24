package oving4;

import java.util.Random;

public class Player {
    private int sumPoints;

    public Player() {
        sumPoints = 0;
    }

    public int getSumPoints() {
        return sumPoints;
    }

    //I metoden throwDice() henter jeg et tilfeldig tall i intervallet (0, 5) på følgende måte:
    public void throwDice() {
        Random dice = new Random(); //lager en tilfeldigtallgenerator
        int diceThrow = dice.nextInt(6)+1; //Int terningkast = terning.nextint(6);
        // Legg til 1 for å få et gyldig terningkast
        System.out.println("Terningkast: " + diceThrow);

        if (sumPoints + diceThrow > 100) {
            System.out.println("Du gikk over 100 poeng!");
            return;
        }

        sumPoints += diceThrow;

        if (sumPoints == 100) {
            System.out.println("Du vant!");
        }

        if (diceThrow == 1) {
            sumPoints = 0;
        }
    }
    public boolean isFinnished() {
        return sumPoints >= 100;
    }
}