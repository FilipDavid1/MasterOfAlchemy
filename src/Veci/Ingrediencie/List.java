package Veci.Ingrediencie;

public class List extends Ingrediencia {
    public List( int x, int y) {
        super("list.png", x, y);
    }

    @Override
    public String getNazov() {
        return "List";
    }

    @Override
    public int getCena() {
        return 1;
    }

}
