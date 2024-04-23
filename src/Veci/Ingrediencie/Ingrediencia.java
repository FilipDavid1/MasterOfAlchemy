package Veci.Ingrediencie;

import Prekazky.HernaEntita;
import Veci.Vec;
import fri.shapesge.Obrazok;

public class Ingrediencia extends HernaEntita implements Vec {

    private Obrazok obrazok;

    private String nazov;
    private int x;
    private int y;
    public Ingrediencia(String nazov, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        this.x = x;
        this.nazov = nazov;
    }
    @Override
    public String getNazov() {
        return this.nazov;
    }


    @Override
    public Obrazok getObrazok() {
        return obrazok;
    }


    public void skry() {
        obrazok.skry();
    }
}
