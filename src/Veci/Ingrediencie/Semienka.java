package Veci.Ingrediencie;

public class Semienka extends Ingrediencia {
    public Semienka(int x, int y) {
        super("semienka.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Semienka";
    }

    @Override
    public int getCena() {
        return 3;
    }

}
