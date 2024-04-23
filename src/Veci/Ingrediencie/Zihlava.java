package Veci.Ingrediencie;

public class Zihlava extends Ingrediencia {
    public Zihlava( int x, int y) {
        super("zihlava.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Zihlava";
    }

    @Override
    public int getCena() {
        return 4;
    }

}
