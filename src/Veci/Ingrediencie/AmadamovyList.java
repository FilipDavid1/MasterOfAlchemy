package Veci.Ingrediencie;

public class AmadamovyList extends Ingrediencia {
    public AmadamovyList(int x, int y) {
        super("amadamovy_list.png", x, y);
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
