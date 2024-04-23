package Veci.Ingrediencie;

public class Ametist extends Ingrediencia {
    public Ametist(int x, int y) {
        super("ametist.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Ametist";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
