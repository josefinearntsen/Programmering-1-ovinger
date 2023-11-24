package oving10;

import java.util.ArrayList;
import java.util.List;

public class Meny {
    private List<Rett> retter = new ArrayList<>();

    public void leggTilRett(Rett rett) {
        retter.add(rett);
    }

    public double totalPris() {
        double total = 0;
        for (Rett rett : retter) {
            total += rett.getPris();
        }
        return total;
    }
}
