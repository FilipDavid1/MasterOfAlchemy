package Veci.Ingrediencie;

public class Mrkva extends Ingrediencia {
    public Mrkva(int x, int y) {
        super("mrkva.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Mrkva";
    }

    @Override
    public int getCena() {
        return 2;
    }

}
