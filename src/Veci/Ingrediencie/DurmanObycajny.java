package Veci.Ingrediencie;

public class DurmanObycajny extends Ingrediencia {
    public DurmanObycajny(String obrazok, int x, int y) {
        super("durman obyčajný.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Durman obyčajný";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
