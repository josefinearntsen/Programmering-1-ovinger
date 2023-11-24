package oving11;

import java.util.ArrayList;

/**
 *
 */
public class EiendomsRegister {
    /*
    velger ArrayList fordi man kan legge til flere elementer i listen
     */

    final private ArrayList<Eiendom> eiendommer;

    public EiendomsRegister() {
        this.eiendommer = new ArrayList<>();
    }

    public void registrerEiendom(Eiendom eiendom) {
        if (eiendommer.contains(eiendom)) {
            System.out.println("Eiendommen ligger allerede i listen.");
        } else {
            eiendommer.add(eiendom);
        }
    }

    public void slettEiendom(Eiendom eiendom) {
        if (eiendommer.contains(eiendom)) {
            eiendommer.remove(eiendom);
        } else {
            System.out.println("Denne eiendommen finnes ikke i listen.");
        }
    }

    public int getAntallEiendommer() {
        return eiendommer.size();
    }

    /**
     * Henter eiendom
     * @param kommuneNr
     * @param gnr
     * @param bnr
     * @return
     */
    public Eiendom getEiendom(int kommuneNr, int gnr, int bnr) {
        for (Eiendom eiendom : eiendommer) {
            if ((eiendom.getKommuneNummer()==kommuneNr)&&(eiendom.getGnr()==gnr)&&(eiendom.getBnr()==bnr)){
                return eiendom;
            }
        }
        return null;
    }

    public double gjennomsnittAreal(){
        double total = 0;
        for (Eiendom eiendom : eiendommer) {
            total += eiendom.getAreal();
        }
        return total / eiendommer.size();
    }

    public ArrayList<Eiendom> finnGnrEiendommer(int gnr){
        ArrayList<Eiendom> gnrEiendommer= new ArrayList<>();
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getGnr()==gnr) {
                gnrEiendommer.add(eiendom);
            }
        }
        return gnrEiendommer;
    }

    public String toString() {
        String resultat = " ";
        for (Eiendom eiendom : eiendommer) {
            resultat += eiendom + " \n";
        }
        return resultat + " ";
    }
}
