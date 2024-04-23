package Veci.Ingrediencie;

public class Gastany extends Ingrediencia {
    public Gastany(int x, int y) {
        super("gastany.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Gastany";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
