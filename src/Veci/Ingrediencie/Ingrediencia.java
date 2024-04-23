package Veci.Ingrediencie;

import Prekazky.HernaEntita;
import Veci.Vec;
import fri.shapesge.Obrazok;

public abstract class Ingrediencia extends HernaEntita implements Vec {

    private Obrazok obrazok;
    private int x;
    private int y;
    public Ingrediencia(String obrazok, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/Ingrediencie/" + obrazok);
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        this.x = x;

    }
    @Override
    public String getNazov() {
        return null;
    }

    @Override
    public int getCena() {
        return 0;
    }

    @Override
    public Obrazok getObrazok() {
        return obrazok;
    }


    public void skry() {
        obrazok.skry();
    }
}
