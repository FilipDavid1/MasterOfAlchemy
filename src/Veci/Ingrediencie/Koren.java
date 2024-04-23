package Veci.Ingrediencie;

public class Koren extends Ingrediencia {
    public Koren( int x, int y) {
        super("koren.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Koren";
    }

    @Override
    public int getCena() {
        return 4;
    }

}
