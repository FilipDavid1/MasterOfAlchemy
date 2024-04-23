package Veci.Ingrediencie;

public class Fazula extends Ingrediencia {
    public Fazula(int x, int y) {
        super("fazula.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Fazula";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
