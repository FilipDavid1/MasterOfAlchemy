package prekazky.postavy;

import fri.shapesge.Obdlznik;

/**
 * Trieda HpBar, ktorá reprezentuje zdravotný stav postavy.
 */
public class HpBar {
    private int hp;
    private Obdlznik vonkajsi;
    private Obdlznik vnutorny;

    private int x;
    private int y;

    /**
     * Konštruktor pre triedu HpBar.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public HpBar(int x, int y) {
        this.hp = 100;
        this.vonkajsi = new Obdlznik(x, y);
        this.vonkajsi.zmenStrany(104, 12);
        this.vonkajsi.zmenFarbu("black");
        this.vnutorny = new Obdlznik(x + 2, y + 2);
        this.vnutorny.zmenStrany(100, 8);
        this.vnutorny.zmenFarbu("green");
        this.zobraz();
        this.x = x;
        this.y = y;
    }

    /**
     * Metóda uberHp, ktorá odoberá zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú odobrať.
     */
    public void uberHp(float kolko) {
        hp -= kolko;
        if (hp < 0) {
            hp = 0;
        }
        vnutorny.zmenStrany(hp, 8);
    }

    /**
     * Metóda posunNa, ktorá posúva zdravotný stav na danú pozíciu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void posunNa(int x, int y) {
        this.x = x;
        this.y = y;
        vonkajsi.zmenPolohu(x - 17, y - 10);
        vnutorny.zmenPolohu(x - 15, y - 8);
        this.zobraz();
    }

    /**
     * Metóda zobraz, ktorá zobrazuje zdravotný stav.
     */
    public void zobraz() {
        vonkajsi.zobraz();
        vnutorny.zobraz();
    }

    /**
     * Metóda skry, ktorá skrýva zdravotný stav.
     */
    public void skry() {
        vonkajsi.skry();
        vnutorny.skry();
    }

    /**
     * Metóda getHp, ktorá vráti aktuálne zdravie postavy.
     *
     * @return int Aktuálne zdravie postavy.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Metóda getX, ktorá vráti X-ovú pozíciu zdravotného stavu.
     *
     * @return int X-ová pozícia zdravotného stavu.
     */
    public int getX() {
        return x;
    }

    /**
     * Metóda getY, ktorá vráti Y-ovú pozíciu zdravotného stavu.
     *
     * @return int Y-ová pozícia zdravotného stavu.
     */
    public int getY() {
        return y;
    }

    /**
     * Metóda pridajHp, ktorá pridáva zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú pridať.
     */
    public void pridajHp(float kolko) {
        hp += kolko;
        if (hp > 100) {
            hp = 100;
        }
        vnutorny.zmenStrany(hp, 8);
    }
}
