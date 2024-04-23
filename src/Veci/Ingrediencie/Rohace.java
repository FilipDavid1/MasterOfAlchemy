package Veci.Ingrediencie;

public class Rohace extends Ingrediencia {
    public Rohace( int x, int y) {
        super("rohace.png", x, y);
    }
    @Override
    public String getNazov() {
        return "Rohace";
    }

    @Override
    public int getCena() {
        return 5;
    }

}
