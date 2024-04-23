package Veci.Ingrediencie;

public class Cernice extends Ingrediencia {
    public Cernice(int x, int y) {
        super("cernice.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Cernice";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
