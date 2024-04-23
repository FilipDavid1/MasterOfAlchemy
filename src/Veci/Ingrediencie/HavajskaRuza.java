package Veci.Ingrediencie;

public class HavajskaRuza extends Ingrediencia {
    public HavajskaRuza(int x, int y) {
        super("Havajská ruža.png", x, y);
    }
    @Override
    public String getNazov() {
        return "HavajskaRuza";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
