package Veci.Ingrediencie;

public class CervenyList extends Ingrediencia {
    public CervenyList(int x, int y) {
        super("cerveny_list.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Cerveny list";
    }

    @Override
    public int getCena() {
        return 5;
    }
}
