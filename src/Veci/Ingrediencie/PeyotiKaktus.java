package Veci.Ingrediencie;

public class PeyotiKaktus extends Ingrediencia {
    public PeyotiKaktus(int x, int y) {
        super("Peyotl kaktus.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Peyotikaktus";
    }

    @Override
    public int getCena() {
        return 15;
    }

}
