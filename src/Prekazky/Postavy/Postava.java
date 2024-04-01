package Prekazky.Postavy;

import Prekazky.HernyObjekt;
import fri.shapesge.Obrazok;

public abstract class Postava extends HernyObjekt {
    protected int animacia;
    private boolean hybeSa = false;

    private OrientaciaPostavy orientacia;


    public Postava(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        super(pocetObrazkov, cestaKObrazku, x, y);
        this.orientacia = OrientaciaPostavy.SOUTH;
    }

    @Override
    public void nastavObrazok() {
        this.obrazok = new Obrazok( getCestaKObrazku() + animacia + ".png");
        this.obrazok.zmenPolohu(super.getX(), super.getY());
        this.obrazok.zobraz();
    }

    protected abstract void krok(String nazov);

    protected abstract void idleAnimacia(String imgNazov);

    protected void posunNa(int x, int y) {
        obrazok.zmenPolohu(x, y);
        super.setX(x);
        super.setY(y);
        this.obrazok.zobraz();
    }

    public void skry() {
        obrazok.skry();
    }

    public void setHybeSa(boolean hybeSa) {
        this.hybeSa = hybeSa;
    }

    public boolean getHybeSa() {
        return hybeSa;
    }

    public void setOrientacia(OrientaciaPostavy orientacia) {
        this.orientacia = orientacia;
    }

    protected String getOrientacia() {
        return orientacia.toString();
    }
}
