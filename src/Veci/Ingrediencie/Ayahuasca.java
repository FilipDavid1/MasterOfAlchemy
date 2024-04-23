package Veci.Ingrediencie;

public class Ayahuasca extends Ingrediencia {
    public Ayahuasca(int x, int y) {
        super("Ayahuasca.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Ayahuasca";
    }

    @Override
    public int getCena() {
        return 15;
    }
}
