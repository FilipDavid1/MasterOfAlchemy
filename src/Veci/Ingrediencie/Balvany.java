package Veci.Ingrediencie;

public class Balvany extends Ingrediencia {
    public Balvany(int x, int y) {
        super("balvany.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Amadamovy list";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
