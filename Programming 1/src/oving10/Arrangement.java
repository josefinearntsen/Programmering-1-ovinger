package oving10;

public class Arrangement {
    private int nummer;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private long tidspunkt;

    public Arrangement(int nummer, String navn, String sted, String arrangor, String type, long tidspunkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getNummer() {
        return nummer;
    }
    public String getNavn() {
        return navn;
    }
    public String getSted() {
        return sted;
    }
    public String getArrangor() {
        return arrangor;
    }
    public String getType() {
        return type;
    }
    public long getTidspunkt() {
        return tidspunkt;
    }

    @Override
    public String toString() {
        return "Arrangement [Nummer: " + nummer + ", Navn: " + navn + ", Sted: " + sted +
                ", Arrangør: " + arrangor + ", Type: " + type + ", Tidspunkt: " + tidspunkt + "]";
    }
}
