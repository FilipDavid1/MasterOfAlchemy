package Veci.Ingrediencie;

public class Dimethyltryptamin extends Ingrediencia {
    public Dimethyltryptamin(String obrazok, int x, int y) {
        super("Dimethyltryptamin.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Dimethyltryptamin";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
