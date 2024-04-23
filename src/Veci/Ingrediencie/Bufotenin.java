package Veci.Ingrediencie;

public class Bufotenin extends Ingrediencia {
    public Bufotenin(int x, int y) {
        super("Bufotenin.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Bufotenin";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
