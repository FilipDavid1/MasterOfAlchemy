package Veci.Ingrediencie;

public class Plevel extends Ingrediencia {
    public Plevel(int x, int y) {
        super("plevel.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Plevel";
    }

    @Override
    public int getCena() {
        return 2;
    }

}
