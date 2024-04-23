package Veci.Ingrediencie;

public class Psilocybin extends Ingrediencia {
    public Psilocybin( int x, int y) {
        super("Psilocybín.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Psilocybin";
    }

    @Override
    public int getCena() {
        return 10;
    }

}
