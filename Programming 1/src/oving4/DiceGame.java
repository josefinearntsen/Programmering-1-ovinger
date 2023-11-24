package oving4;

import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        Player playerA = new Player();
        Player playerB = new Player();
        int round = 1;

        while (true) {
            System.out.println("Runde " + round);
            System.out.println("Spiller A: " + playerA.getSumPoints() + " poeng");
            System.out.println("Spiller B: " + playerB.getSumPoints() + " poeng");

            if (round % 2 == 1) { //Linjen if (round % 2 == 1) sjekker om det er en oddetallsrunde.
                playerA.throwDice(); //Hvis det er tilfelle, betyr det at det er spiller A sin tur til å kaste terningen.
            } else { //Hvis det ikke er en oddetallsrunde (altså en partallsrunde), er det spiller B sin tur til å kaste terningen.
                playerB.throwDice();
            }

            if (playerA.isFinnished()) {
                System.out.println("Spiller A har vunnet!");
                break;
            } else if (playerB.isFinnished()) {
                System.out.println("Spiller B har vunnet!");
                break;
            }

            System.out.println();
            round++; //oker runden med 1 for hver gang
        }
    }
}
