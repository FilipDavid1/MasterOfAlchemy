package Veci.Ingrediencie;

public class Lopuch extends Ingrediencia {
    public Lopuch(int x, int y) {
        super("lopuch.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Lopúch";
    }

    @Override
    public int getCena() {
        return 3;
    }

}
