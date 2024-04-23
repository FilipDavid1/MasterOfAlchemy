package Veci.Ingrediencie;

public class MuskatovyOrech extends Ingrediencia {
    public MuskatovyOrech( int x, int y) {
        super("muskatovy_orech.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Muskátový orech";
    }

    @Override
    public int getCena() {
        return 7;
    }

}
