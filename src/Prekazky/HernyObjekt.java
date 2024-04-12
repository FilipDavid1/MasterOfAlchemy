package Prekazky;

import fri.shapesge.Obrazok;

public class HernyObjekt {
    private int pocetObrazkov;
    private String cestaKObrazku;
    private int x;
    private int y;

    protected Obrazok obrazok;

    public HernyObjekt(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        this.pocetObrazkov = pocetObrazkov;
        this.cestaKObrazku = cestaKObrazku;
        this.x = x;
        this.y = y;
        this.nastavObrazok();
    }

    public void nastavObrazok() {
        this.obrazok = new Obrazok(cestaKObrazku + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
    }

    public void setY(int y) {
        this.y = y;
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
    }

    public String getCestaKObrazku() {
        return cestaKObrazku;
    }

    public int getPocetObrazkov() {
        return pocetObrazkov;
    }
}
