package Veci.Ingrediencie;

import Prekazky.HernaEntita;
import Veci.Vec;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

public class Ingrediencia extends HernaEntita implements Vec {

    private final Obrazok obrazok;

    private final String nazov;
    private final DataObrazku dataObrazku;
    public Ingrediencia(String nazov, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        super.setX(x);
        super.setY(y);
        this.nazov = nazov;
        this.dataObrazku = new DataObrazku("resources/Obrazky/Ingrediencie/" + nazov + ".png");
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

    public int getVyska() {
        return dataObrazku.getVyska();
    }

    public int getSirka() {
        return dataObrazku.getSirka();
    }
}
