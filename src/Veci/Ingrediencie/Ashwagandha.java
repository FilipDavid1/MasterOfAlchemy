package Veci.Ingrediencie;

public class Ashwagandha extends Ingrediencia {
    public Ashwagandha(int x, int y) {
        super("ashwagandha.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Ashwagandha";
    }

    @Override
    public int getCena() {
        return 10;
    }
}
