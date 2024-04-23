package Veci.Ingrediencie;

public class Lekno extends Ingrediencia {
    public Lekno(int x, int y) {
        super("lekno.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Lekno";
    }

    @Override
    public int getCena() {
        return 6;
    }

}
