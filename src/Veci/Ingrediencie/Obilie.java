package Veci.Ingrediencie;

public class Obilie extends Ingrediencia {
    public Obilie( int x, int y) {
        super("obilie.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Obilie";
    }

    @Override
    public int getCena() {
        return 5;
    }

}
