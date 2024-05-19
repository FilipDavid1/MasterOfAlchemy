package prekazky.postavy;

import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import prekazky.HernyObjekt;
import prekazky.postavy.hrac.Hrac;

/**
 * Abstraktná trieda Postava, ktorá rozširuje triedu HernyObjekt.
 */
public abstract class Postava extends HernyObjekt {
    private int animacia;
    private boolean hybeSa = false;
    private OrientaciaPostavy orientacia;
    private final HpBar hpBar;
    private float rychlost = 0.7f;
    private int casOslabenia = 0;
    private boolean utoci = false;
    private float sila;
    private final float originalnaSila;
    private boolean jeOtraveny = false;
    private float ubraneneZivoty = 0;
    private BlokTextu meno;

    /**
     * Konštruktor pre triedu Postava.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param sila Sila postavy.
     */
    public Postava(int pocetObrazkov, String cestaKObrazku, int x, int y, int sila) {
        super(pocetObrazkov, cestaKObrazku, x, y);
        this.orientacia = OrientaciaPostavy.DOWN;
        this.hpBar = new HpBar(x - 20 , y - 15);
        System.out.println(super.getSirka() + "  " + super.getVyska() + "  " + cestaKObrazku + "  " + x + "  " + y);
        this.sila = sila;
        this.originalnaSila = sila;
        this.meno = new BlokTextu(this.getClass().getSimpleName(), x, y - 20);
        this.meno.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.meno.zmenFarbu("white");
        this.meno.zobraz();
    }

    /**
     * Abstraktná metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @param postava Postava, s ktorou sa interaguje.
     */
    public abstract void interakcia(Postava postava);

    /**
     * Metóda nastavObrazok, ktorá nastavuje obrázok postavy.
     */
    @Override
    public void nastavObrazok() {
        super.setObrazok(getCestaKObrazku().replace("0", "") + animacia + ".png");
        super.zmenPolohuObrazku(super.getX(), super.getY());
    }

    /**
     * Metóda krok, ktorá vykonáva animáciu pohybu postavy.
     *
     * @param imgName Názov obrázku pre animáciu.
     */
    public void krok(String imgName) {
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        super.zmenObrazok(super.getCestaKObrazku().replace("Idle/Idle_Down_0", "") + "Walk/" + imgName + animacia + ".png");
    }

    /**
     * Metóda idleAnimacia, ktorá vykonáva animáciu nečinnosti postavy.
     *
     * @param imgNazov Názov obrázku pre animáciu.
     */
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

    /**
     * Metóda posunNa, ktorá posúva postavu na danú pozíciu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void posunNa(int x, int y) {
        super.setX(x, super.getObrazok(), hpBar, super.getData());
        super.setY(y, super.getObrazok(), hpBar, super.getData());
        if (!(this instanceof Hrac)) {
            this.meno.zmenPolohu(x - 20, y - 20);
        } else {
            this.meno.zmenPolohu(x, y - 20);
        }
    }

    /**
     * Metóda skry, ktorá skrýva postavu.
     */
    public void skry() {
        super.skryObrazok();
        this.hpBar.skry();
        this.meno.skry();
    }

    /**
     * Metóda zobraz, ktorá zobrazuje postavu.
     */
    public void zobraz() {
        super.zobrazObrazok();
        this.hpBar.zobraz();
    }

    /**
     * Metóda setHybeSa, ktorá nastavuje, či sa postava hýbe.
     *
     * @param hybeSa Boolean hodnota, či sa postava hýbe.
     */
    public void setHybeSa(boolean hybeSa) {
        this.hybeSa = hybeSa;
    }

    /**
     * Metóda getHybeSa, ktorá vráti, či sa postava hýbe.
     *
     * @return boolean Hodnota, či sa postava hýbe.
     */
    public boolean getHybeSa() {
        return hybeSa;
    }

    /**
     * Metóda setOrientacia, ktorá nastavuje orientáciu postavy.
     *
     * @param orientacia Orientácia postavy.
     */
    public void setOrientacia(OrientaciaPostavy orientacia) {
        this.orientacia = orientacia;
    }

    /**
     * Metóda getOrientacia, ktorá vráti orientáciu postavy.
     *
     * @return String Orientácia postavy.
     */
    protected String getOrientacia() {
        return orientacia.toString();
    }

    /**
     * Metóda uberHp, ktorá odoberá zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú odobrať.
     */
    public void uberHp(float kolko) {
        this.hpBar.uberHp(kolko);
        if (this.hpBar.getHp() <= 0) {
            this.skry();
        }
    }

    /**
     * Metóda pridajHp, ktorá pridáva zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú pridať.
     */
    public void pridajHp(float kolko) {
        this.hpBar.pridajHp(kolko);
        this.zobraz();
    }

    /**
     * Metóda jeMrtvy, ktorá vráti, či je postava mŕtva.
     *
     * @return boolean Hodnota, či je postava mŕtva.
     */
    public boolean jeMrtvy() {
        return this.hpBar.getHp() <= 0;
    }

    /**
     * Metóda attackAnimacia, ktorá vykonáva animáciu útoku postavy.
     *
     * @param imgNazov Názov obrázku pre animáciu.
     * @param i Počet obrázkov pre animáciu.
     */
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

    /**
     * Metóda getSpeed, ktorá vráti rýchlosť postavy.
     *
     * @return float Rýchlosť postavy.
     */
    public float getRychlost() {
        return rychlost;
    }

    /**
     * Metóda oslabenie, ktorá nastavuje čas oslabenia postavy.
     * Ak je čas oslabenia nulový, rýchlosť postavy je nastavená na 0.7f, inak je nastavená na 0.3f.
     *
     * @param sekundy Čas oslabenia v sekundách.
     */
    public void oslabenie(int sekundy) {
        this.casOslabenia = sekundy;

        if (this.casOslabenia == 0) {
            this.rychlost = 0.7f;
        } else {
            this.rychlost = 0.3f;
        }
    }

    /**
     * Metóda getCasOslabenia, ktorá vráti čas oslabenia postavy v milisekundách.
     *
     * @return int Čas oslabenia v milisekundách.
     */
    public int getCasOslabenia() {
        return casOslabenia * 1000;
    }

    /**
     * Metóda setUtoci, ktorá nastavuje, či postava útočí.
     *
     * @param utoci Boolean hodnota, či postava útočí.
     */
    public void setUtoci(boolean utoci) {
        this.utoci = utoci;
    }

    /**
     * Metóda getUtoci, ktorá vráti, či postava útočí.
     *
     * @return boolean Hodnota, či postava útočí.
     */
    public boolean getUtoci() {
        return utoci;
    }

    /**
     * Metóda getHp, ktorá vráti aktuálne zdravie postavy.
     *
     * @return float Aktuálne zdravie postavy.
     */
    public float getHp() {
        return hpBar.getHp();
    }

    /**
     * Metóda getSila, ktorá vráti silu postavy.
     *
     * @return float Sila postavy.
     */
    public float getSila() {
        return sila;
    }

    /**
     * Metóda setSila, ktorá nastavuje silu postavy.
     *
     * @param sila Sila postavy.
     */
    public void setSila(float sila) {
        this.sila = sila;
    }

    /**
     * Metóda setSila, ktorá nastavuje silu postavy a čas oslabenia.
     *
     * @param sila Sila postavy.
     * @param cas Čas oslabenia v sekundách.
     */
    public void setSila(float sila, int cas) {
        this.sila = sila;
        this.casOslabenia = cas * 1000;
    }

    /**
     * Metóda otrav, ktorá nastavuje čas oslabenia, nastavuje postavu ako otrávenú a nastavuje ubrané životy na 0.5f.
     *
     * @param cas Čas oslabenia v sekundách.
     */
    public void otrav(int cas) {
        this.casOslabenia = cas * 1000;
        this.jeOtraveny = true;
        this.ubraneneZivoty = 0.5f;
    }

    /**
     * Metóda otrav, ktorá nastavuje čas oslabenia, nastavuje postavu ako otrávenú a nastavuje ubrané životy.
     *
     * @param cas Čas oslabenia v sekundách.
     * @param zivoty Počet ubraných životov.
     */
    public void otrav(int cas, int zivoty) {
        this.casOslabenia = cas * 1000;
        this.jeOtraveny = true;
        this.ubraneneZivoty = zivoty;
    }

    /**
     * Metóda getJeOtraveny, ktorá vráti, či je postava otrávená.
     *
     * @return boolean Hodnota, či je postava otrávená.
     */
    protected boolean getJeOtraveny() {
        return jeOtraveny;
    }

    /**
     * Metóda setMeno, ktorá nastavuje meno postavy a mení polohu mena.
     *
     * @param s Meno postavy.
     * @param x X-ová pozícia mena na mape.
     * @param y Y-ová pozícia mena na mape.
     */
    public void setMeno(String s, int x, int y) {
        this.meno.zmenPolohu(x, y);
        this.meno.zmenText(s);
    }
}

