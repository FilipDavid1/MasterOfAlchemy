package Veci.Ingrediencie;

public class Ibogain extends Ingrediencia {
    public Ibogain(int x, int y) {
        super("Ibogain.png", x, y);
    }
    @Override
    public String getNazov() {
        return "Ibogain";
    }

    @Override
    public int getCena() {
        return 20;
    }

}
