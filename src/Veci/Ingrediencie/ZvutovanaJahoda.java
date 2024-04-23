package Veci.Ingrediencie;

public class ZvutovanaJahoda extends Ingrediencia {
    public ZvutovanaJahoda( int x, int y) {
        super("zmutovana_jahoda.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Zmutovana jahoda";
    }

    @Override
    public int getCena() {
        return 10;
    }

}
