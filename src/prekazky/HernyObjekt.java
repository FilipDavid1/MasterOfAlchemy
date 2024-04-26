package prekazky;

import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

public class HernyObjekt extends HernaEntita {
    private int pocetObrazkov;
    private String cestaKObrazku;

    private Obrazok obrazok;

    private DataObrazku data;

    public HernyObjekt(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        this.pocetObrazkov = pocetObrazkov;
        this.cestaKObrazku = cestaKObrazku;
        super.setX(x);
        super.setY(y);
        this.nastavObrazok();
        data = new DataObrazku(cestaKObrazku + ".png");
    }

    public void nastavObrazok() {
        this.obrazok = new Obrazok(cestaKObrazku + ".png");
        this.obrazok.zmenPolohu(super.getX(), super.getY());
        this.obrazok.zobraz();
    }

    public String getCestaKObrazku() {
        return cestaKObrazku;
    }

    public int getPocetObrazkov() {
        return pocetObrazkov;
    }

    public void skry() {
        this.obrazok.skry();
    }

    public int getSirka() {
        return data.getSirka();
    }

    public int getVyska() {
        return data.getVyska();
    }

    public Obrazok getObrazok() {
        return obrazok;
    }

    public void setObrazok(String url) {
        this.obrazok = new Obrazok(url);
    }

    public void zmenObrazok(String url) {
        this.obrazok.zmenObrazok(url);
    }

    public void zmenPolohuObrazku(int x, int y) {
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
    }

    public void skryObrazok() {
        this.obrazok.skry();
    }
}
