package obstacles.characters;

import fri.shapesge.Obdlznik;

/**
 * Trieda HpBar, ktorá reprezentuje zdravotný stav postavy.
 */
public class HpBar {
    private int hp;
    private final Obdlznik outer;
    private final Obdlznik inner;

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
        this.outer = new Obdlznik(x, y);
        this.outer.zmenStrany(104, 12);
        this.outer.zmenFarbu("black");
        this.inner = new Obdlznik(x + 2, y + 2);
        this.inner.zmenStrany(100, 8);
        this.inner.zmenFarbu("green");
        this.show();
        this.x = x;
        this.y = y;
    }

    /**
     * Metóda uberHp, ktorá odoberá zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú odobrať.
     */
    public void reduceHp(float kolko) {
        hp -= kolko;
        if (hp < 0) {
            hp = 0;
        }
        inner.zmenStrany(hp, 8);
    }

    /**
     * Metóda posunNa, ktorá posúva zdravotný stav na danú pozíciu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        outer.zmenPolohu(x - 17, y - 10);
        inner.zmenPolohu(x - 15, y - 8);
        this.show();
    }

    /**
     * Metóda zobraz, ktorá zobrazuje zdravotný stav.
     */
    public void show() {
        outer.zobraz();
        inner.zobraz();
    }

    /**
     * Metóda skry, ktorá skrýva zdravotný stav.
     */
    public void hideHpBar() {
        outer.skry();
        inner.skry();
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
    public void addHp(float kolko) {
        hp += kolko;
        if (hp > 100) {
            hp = 100;
        }
        inner.zmenStrany(hp, 8);
    }
}
