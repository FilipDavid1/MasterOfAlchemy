package Veci.Ingrediencie;

public class Fencyklidin extends Ingrediencia {
    public Fencyklidin(int x, int y) {
        super("Fencyklidín.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Fencyklidín";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
