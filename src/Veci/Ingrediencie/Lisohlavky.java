package Veci.Ingrediencie;

public class Lisohlavky extends Ingrediencia {
    public Lisohlavky(int x, int y) {
        super("lisohlavky", x, y);
    }

    @Override
    public String getNazov() {
        return "Lisohlávky";
    }

    @Override
    public int getCena() {
        return 12;
    }

}
