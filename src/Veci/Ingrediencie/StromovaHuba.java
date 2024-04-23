package Veci.Ingrediencie;

public class StromovaHuba extends Ingrediencia {
    public StromovaHuba( int x, int y) {
        super("stromova_huba.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Stromovahuba";
    }

    @Override
    public int getCena() {
        return 9;
    }

}
