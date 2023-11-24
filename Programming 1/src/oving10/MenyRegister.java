package oving10;

import java.util.ArrayList;
import java.util.List;

public class MenyRegister {
    private List<Rett> retter = new ArrayList<>();
    private List<Meny> menyer = new ArrayList<>();

    public void registrerRett(Rett rett) {
        retter.add(rett);
    }

    public Rett finnRett(String navn) {
        for (Rett rett : retter) {
            if (rett.getNavn().equals(navn)) {
                return rett;
            }
        }
        return null;
    }

    public List<Rett> finnRetterAvType(String type) {
        List<Rett> retterAvType = new ArrayList<>();
        for (Rett rett : retter) {
            if (rett.getType().equals(type)) {
                retterAvType.add(rett);
            }
        }
        return retterAvType;
    }

    public void registrerMeny(Meny meny) {
        menyer.add(meny);
    }

    public List<Meny> finnMenyerInnenforPrisintervall(double lavPris, double hoyPris) {
        List<Meny> menyerInnenforIntervall = new ArrayList<>();
        for (Meny meny : menyer) {
            if (meny.totalPris() >= lavPris && meny.totalPris() <= hoyPris) {
                menyerInnenforIntervall.add(meny);
            }
        }
        return menyerInnenforIntervall;
    }
}



