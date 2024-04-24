package Veci.Ingrediencie;

import Prekazky.HernaEntita;
import Prekazky.Postavy.HpBar;
import Veci.Vec;
import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

public class Ingrediencia extends HernaEntita implements Vec {

    private final Obrazok obrazok;

    private final String nazov;
    private final DataObrazku dataObrazku;
    private final BlokTextu blokTextu;
    public Ingrediencia(String nazov, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        super.setX(x);
        super.setY(y);
        this.nazov = nazov;
        this.dataObrazku = new DataObrazku("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.blokTextu = new BlokTextu(nazov);
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenPolohu(x, y - 10);
        this.blokTextu.zobraz();
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
        blokTextu.skry();
    }

    public int getVyska() {
        return dataObrazku.getVyska();
    }

    public int getSirka() {
        return dataObrazku.getSirka();
    }

    public BlokTextu getBlokTextu() {
        return blokTextu;
    }
}
