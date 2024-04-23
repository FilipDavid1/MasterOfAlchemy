package Veci.Ingrediencie;

public class LieskovyOrech extends Ingrediencia {
    public LieskovyOrech( int x, int y) {
        super("lieskovy_orech.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Lieskový orech";
    }

    @Override
    public int getCena() {
        return 8;
    }

}
