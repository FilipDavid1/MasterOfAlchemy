package Veci.Ingrediencie;

public class SojoveBoby extends Ingrediencia {
    public SojoveBoby( int x, int y) {
        super("sojove boby.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Sojoveboby";
    }

    @Override
    public int getCena() {
        return 7;
    }

}
