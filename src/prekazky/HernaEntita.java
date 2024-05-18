package prekazky;

import fri.shapesge.DataObrazku;
import prekazky.postavy.HpBar;
import fri.shapesge.BlokTextu;
import fri.shapesge.Obrazok;

/**
 * Trieda HernaEntita, ktorá reprezentuje hernú entitu.
 */
public class HernaEntita {
    private int x;
    private int y;

    /**
     * Metóda setX, ktorá nastavuje X-ovú pozíciu entity.
     *
     * @param x X-ová pozícia na mape.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metóda setY, ktorá nastavuje Y-ovú pozíciu entity.
     *
     * @param y Y-ová pozícia na mape.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metóda setX, ktorá nastavuje X-ovú pozíciu entity a zobrazuje obrázok na tejto pozícii.
     *
     * @param x X-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     */
    public void setX(int x, Obrazok obrazok) {
        this.x = x;
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    /**
     * Metóda setY, ktorá nastavuje Y-ovú pozíciu entity a zobrazuje obrázok na tejto pozícii.
     *
     * @param y Y-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     */
    public void setY(int y, Obrazok obrazok) {
        this.y = y;
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    /**
     * Metóda setX, ktorá nastavuje X-ovú pozíciu entity, posúva HP bar a zobrazuje obrázok na tejto pozícii.
     *
     * @param x X-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     * @param hpBar HP bar, ktorý sa má posunúť.
     * @param dataObrazku Dáta obrázku, ktoré sa používajú na výpočet pozície HP baru.
     */
    public void setX(int x, Obrazok obrazok, HpBar hpBar, DataObrazku dataObrazku) {
        this.x = x;
        hpBar.posunNa(x - 5 , y - (dataObrazku.getVyska() / 10));
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    /**
     * Metóda setY, ktorá nastavuje Y-ovú pozíciu entity, posúva HP bar a zobrazuje obrázok na tejto pozícii.
     *
     * @param y Y-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     * @param hpBar HP bar, ktorý sa má posunúť.
     * @param dataObrazku Dáta obrázku, ktoré sa používajú na výpočet pozície HP baru.
     */
    public void setY(int y, Obrazok obrazok, HpBar hpBar, DataObrazku dataObrazku) {
        this.y = y;
        hpBar.posunNa(x - 5 , y - (dataObrazku.getVyska() / 10));
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    /**
     * Metóda setX, ktorá nastavuje X-ovú pozíciu entity, mení polohu textového bloku a zobrazuje obrázok na tejto pozícii.
     *
     * @param x X-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     * @param blokTextu Textový blok, ktorého poloha sa má zmeniť.
     */
    public void setX(int x, Obrazok obrazok, BlokTextu blokTextu) {
        this.x = x;
        blokTextu.zmenPolohu(x, y + 140);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
        blokTextu.zobraz();
    }

    /**
     * Metóda setY, ktorá nastavuje Y-ovú pozíciu entity, mení polohu textového bloku a zobrazuje obrázok na tejto pozícii.
     *
     * @param y Y-ová pozícia na mape.
     * @param obrazok Obrázok, ktorý sa má zobraziť.
     * @param blokTextu Textový blok, ktorého poloha sa má zmeniť.
     */
    public void setY(int y, Obrazok obrazok, BlokTextu blokTextu) {
        this.y = y;
        blokTextu.zmenPolohu(x, y + 40);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
        blokTextu.zobraz();
    }

    /**
     * Metóda getX, ktorá vráti X-ovú pozíciu entity.
     *
     * @return int X-ová pozícia entity.
     */
    public int getX() {
        return x;
    }

    /**
     * Metóda getY, ktorá vráti Y-ovú pozíciu entity.
     *
     * @return int Y-ová pozícia entity.
     */
    public int getY() {
        return y;
    }
}
