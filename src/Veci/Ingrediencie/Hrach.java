package Veci.Ingrediencie;

public class Hrach extends Ingrediencia {
    public Hrach(int x, int y) {
        super("hrach.png", x, y);
    }
    @Override
    public String getNazov() {
        return "Hrach";
    }

    @Override
    public int getCena() {
        return 3;
    }

}
