package Veci.Ingrediencie;

public class Slivka extends Ingrediencia {
    public Slivka( int x, int y) {
        super("slivka.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Slivka";
    }

    @Override
    public int getCena() {
        return 4;
    }

}
