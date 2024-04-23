package Veci.Ingrediencie;

public class Salvia extends Ingrediencia {
    public Salvia( int x, int y) {
        super("salvia.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Salvia";
    }

    @Override
    public int getCena() {
        return 8;
    }

}
