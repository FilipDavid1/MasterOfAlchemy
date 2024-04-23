package Veci.Ingrediencie;

public class Sipky extends Ingrediencia {
    public Sipky( int x, int y) {
        super("sipky.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Sipky";
    }

    @Override
    public int getCena() {
        return 6;
    }

}
