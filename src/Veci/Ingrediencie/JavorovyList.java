package Veci.Ingrediencie;

public class JavorovyList extends Ingrediencia {
    public JavorovyList(int x, int y) {
        super("javorovy_list.png", x, y);

    }
    @Override
    public String getNazov() {
        return "Javorový list";
    }

    @Override
    public int getCena() {
        return 2;
    }

}
