package Veci.Ingrediencie;

public class TrojListok extends Ingrediencia {
    public TrojListok(String obrazok, int x, int y) {
        super("troj_listok.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Trojlistok";
    }

    @Override
    public int getCena() {
        return 2;
    }

}
