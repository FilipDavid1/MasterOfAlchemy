package prekazky.postavy;

import prekazky.HernyObjekt;

public abstract class Postava extends HernyObjekt {
    private int animacia;
    private boolean hybeSa = false;

    private OrientaciaPostavy orientacia;

    private final HpBar hpBar;

    private float speed = 0.7f;

    private int casOslabenia = 0;

    private boolean utoci = false;

    private float sila;

    private final float originalnaSila;

    private boolean jeOtraveny = false;

    private float ubraneneZivoty = 0;


    public Postava(int pocetObrazkov, String cestaKObrazku, int x, int y, int sila) {
        super(pocetObrazkov, cestaKObrazku, x, y);
        this.orientacia = OrientaciaPostavy.DOWN;
        this.hpBar = new HpBar(x - 20 , y - 15);
        System.out.println(super.getSirka() + "  " + super.getVyska() + "  " + cestaKObrazku + "  " + x + "  " + y);
        this.sila = sila;
        this.originalnaSila = sila;
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

        if (casOslabenia > 0 && jeOtraveny) {
            casOslabenia = casOslabenia - 200;
        } else {
            this.jeOtraveny = false;
        }

        if (this.jeOtraveny) {
            this.hpBar.uberHp(ubraneneZivoty);
        }
    }

    public void posunNa(int x, int y) {
        super.setX(x, super.getObrazok(), hpBar, super.getData());
        super.setY(y, super.getObrazok(), hpBar, super.getData());
    }

    public void skry() {
        super.skryObrazok();
        this.hpBar.skry();
    }

    public void zobraz() {
        super.zobrazObrazok();
        this.hpBar.zobraz();
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

    public void uberHp(float kolko) {
        this.hpBar.uberHp(kolko);
        if (this.hpBar.getHp() <= 0) {
            this.skry();
        }
    }

    public void pridajHp(float kolko) {
        this.hpBar.pridajHp(kolko);
        this.zobraz();
    }

    public boolean jeMrtvy() {
        return this.hpBar.getHp() <= 0;
    }


    protected void attackAnimacia(String imgNazov, int i) {
        animacia++;
        if (animacia >= i) {
            animacia = 0;
        }
        super.zmenObrazok(  imgNazov + animacia + ".png");

        if (casOslabenia > 0) {
            casOslabenia = casOslabenia - 200;
        } else {
            this.sila = originalnaSila;
            this.jeOtraveny = false;
        }

        if (this.jeOtraveny) {
            this.hpBar.uberHp(0.5f);
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void oslabenie(int sekundy) {
        this.casOslabenia = sekundy;

        if (this.casOslabenia == 0) {
            this.speed = 0.7f;
        } else {
            this.speed = 0.3f;
        }
    }

    public int getCasOslabenia() {
        return casOslabenia * 1000;
    }

    public void setUtoci(boolean utoci) {
        this.utoci = utoci;
    }

    public boolean getUtoci() {
        return utoci;
    }

    public float getHp() {
        return hpBar.getHp();
    }

    public float getSila() {
        return sila;
    }

    public void setSila(float sila) {
        this.sila = sila;
    }

    public void setSila(float sila, int cas) {
        this.sila = sila;
        this.casOslabenia = cas * 1000;
    }

    public void otrav(int cas) {
        this.casOslabenia = cas * 1000;
        this.jeOtraveny = true;
        this.ubraneneZivoty = 0.5f;
    }

    public void otrav(int cas, int zivoty) {
        this.casOslabenia = cas * 1000;
        this.jeOtraveny = true;
        this.ubraneneZivoty = zivoty;
    }

    protected boolean getJeOtraveny() {
        return jeOtraveny;
    }
}
