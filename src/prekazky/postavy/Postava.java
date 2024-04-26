package prekazky.postavy;

import prekazky.HernyObjekt;
import fri.shapesge.Obrazok;

public abstract class Postava extends HernyObjekt {
    private int animacia;
    private boolean hybeSa = false;

    private OrientaciaPostavy orientacia;

    private HpBar hpBar;


    public Postava(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        super(pocetObrazkov, cestaKObrazku, x, y);
        this.orientacia = OrientaciaPostavy.DOWN;
        this.hpBar = new HpBar(x - 20, y - 10);
    }

    public abstract void interakcia(Postava postava);

    @Override
    public void nastavObrazok() {
        super.setObrazok(getCestaKObrazku().replace("0", "") + animacia + ".png");
        super.zmenPolohuObrazku(super.getX(), super.getY());
    }

    public void krok(String imgName) {
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        super.zmenObrazok(super.getCestaKObrazku().replace("Idle/Idle_Down_0", "") + "Walk/" + imgName + animacia + ".png");
    }

    public void idleAnimacia(String imgNazov) {
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        super.zmenObrazok(  imgNazov + animacia + ".png");
    }

    public void posunNa(int x, int y) {
        super.setX(x, super.getObrazok(), hpBar);
        super.setY(y, super.getObrazok(), hpBar);
    }

    public void skry() {
        super.skryObrazok();
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


    protected void attackAnimacia(String imgNazov, int i) {
        animacia++;
        if (animacia >= i) {
            animacia = 0;
        }
        super.zmenObrazok(  imgNazov + animacia + ".png");
    }
}
