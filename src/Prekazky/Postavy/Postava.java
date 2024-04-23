package Prekazky.Postavy;

import Prekazky.HernyObjekt;
import fri.shapesge.Obrazok;

public abstract class Postava extends HernyObjekt {
    protected int animacia;
    private boolean hybeSa = false;

    private OrientaciaPostavy orientacia;

    private HpBar hpBar;


    public Postava(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        super(pocetObrazkov, cestaKObrazku, x, y);
        this.orientacia = OrientaciaPostavy.SOUTH;
        this.hpBar = new HpBar(x-20, y - 10);
    }

    public abstract void utok(Postava postava);

    @Override
    public void nastavObrazok() {
        this.obrazok = new Obrazok( getCestaKObrazku().replace("0", "") + animacia + ".png");
        this.obrazok.zmenPolohu(super.getX(), super.getY());
        this.obrazok.zobraz();
    }

    public void krok(String imgName){
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        obrazok.zmenObrazok(super.getCestaKObrazku().replace("Idle/Idle_South_0", "") + "Walk/" + imgName + animacia + ".png");
    }

    public void idleAnimacia(String imgNazov){
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        obrazok.zmenObrazok(  imgNazov + animacia + ".png");
    }

    public void posunNa(int x, int y) {
        super.setX(x, obrazok, hpBar);
        super.setY(y, obrazok, hpBar);
    }

    public void skry() {
        obrazok.skry();
        this.hpBar.skry();
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

    public void uberHp(int kolko) {
        this.hpBar.uberHp(kolko);
        if (this.hpBar.getHp() <= 0) {
            this.hpBar.skry();
            this.skry();
        }
    }

    public boolean jeZivy() {
        return this.hpBar.getHp() > 0;
    }

    public Obrazok getObrazok() {
        return obrazok;
    }

    protected void attackAnimacia(String imgNazov, int i) {
        animacia++;
        if (animacia >= i) {
            animacia = 0;
        }
        obrazok.zmenObrazok(  imgNazov + animacia + ".png");
    }
}
