package prekazky;

import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

/**
 * Trieda HernyObjekt, ktorá rozširuje triedu HernaEntita.
 */
public class HernyObjekt extends HernaEntita {
    private final int pocetObrazkov;
    private final String cestaKObrazku;
    private Obrazok obrazok;
    private final DataObrazku data;

    /**
     * Konštruktor pre triedu HernyObjekt.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public HernyObjekt(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        this.pocetObrazkov = pocetObrazkov;
        this.cestaKObrazku = cestaKObrazku;
        super.setX(x);
        super.setY(y);
        this.nastavObrazok();
        data = new DataObrazku(cestaKObrazku + ".png");
    }

    /**
     * Metóda nastavObrazok, ktorá nastavuje obrázok herného objektu.
     */
    public void nastavObrazok() {
        this.obrazok = new Obrazok(cestaKObrazku + ".png");
        this.obrazok.zmenPolohu(super.getX(), super.getY());
        this.obrazok.zobraz();
    }

    /**
     * Metóda getCestaKObrazku, ktorá vráti cestu k obrázku herného objektu.
     *
     * @return String Cesta k obrázku.
     */
    public String getCestaKObrazku() {
        return cestaKObrazku;
    }

    /**
     * Metóda getPocetObrazkov, ktorá vráti počet obrázkov pre animáciu.
     *
     * @return int Počet obrázkov pre animáciu.
     */
    public int getPocetObrazkov() {
        return pocetObrazkov;
    }

    /**
     * Metóda skry, ktorá skryje herný objekt.
     */
    public void skry() {
        this.obrazok.skry();
    }

    /**
     * Metóda getSirka, ktorá vráti šírku herného objektu.
     *
     * @return int Šírka herného objektu.
     */
    public int getSirka() {
        return data.getSirka();
    }

    /**
     * Metóda getVyska, ktorá vráti výšku herného objektu.
     *
     * @return int Výška herného objektu.
     */
    public int getVyska() {
        return data.getVyska();
    }

    /**
     * Metóda getObrazok, ktorá vráti obrázok herného objektu.
     *
     * @return Obrazok Obrázok herného objektu.
     */
    public Obrazok getObrazok() {
        return obrazok;
    }

    /**
     * Metóda setObrazok, ktorá nastavuje obrázok herného objektu.
     *
     * @param url URL obrázku.
     */
    public void setObrazok(String url) {
        this.obrazok = new Obrazok(url);
    }

    /**
     * Metóda zmenObrazok, ktorá mení obrázok herného objektu.
     *
     * @param url URL nového obrázku.
     */
    public void zmenObrazok(String url) {
        this.obrazok.zmenObrazok(url);
    }

    /**
     * Metóda zmenPolohuObrazku, ktorá mení polohu obrázku herného objektu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void zmenPolohuObrazku(int x, int y) {
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
    }

    /**
     * Metóda skryObrazok, ktorá skryje obrázok herného objektu.
     */
    public void skryObrazok() {
        this.obrazok.skry();
    }

    /**
     * Metóda zobrazObrazok, ktorá zobrazí obrázok herného objektu.
     */
    public void zobrazObrazok() {
        this.obrazok.zobraz();
    }

    /**
     * Metóda getData, ktorá vráti dáta obrázku herného objektu.
     *
     * @return DataObrazku Dáta obrázku.
     */
    public DataObrazku getData() {
        return data;
    }
}
