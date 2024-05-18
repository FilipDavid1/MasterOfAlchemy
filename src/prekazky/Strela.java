package prekazky;

import fri.shapesge.Obrazok;
import prekazky.postavy.Postava;

import static java.lang.Math.sqrt;

/**
 * Trieda Strela, ktorá reprezentuje strelu v hre.
 */
public class Strela {
    private float x;
    private float y;
    private final float rychlost;
    private double dlzka;
    private final Obrazok projektil;
    private int animacia = 0;
    private final String cestaKObrazku;

    /**
     * Konštruktor pre triedu Strela.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param rychlost Rýchlosť strely.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     */
    public Strela(float x, float y, float rychlost, String cestaKObrazku) {
        this.x = x;
        this.y = y;
        this.rychlost = rychlost;
        this.cestaKObrazku = cestaKObrazku;
        this.projektil = new Obrazok(cestaKObrazku + "/tile000.png");
        this.projektil.zmenPolohu((int)x, (int)y);
    }

    /**
     * Metóda aktualizuj, ktorá aktualizuje polohu strely a zobrazuje ju na novej pozícii.
     *
     * @param hrac Postava, ktorá vystrelila strelu.
     */
    public void aktualizuj(Postava hrac) {
        float dx = hrac.getX() - x;
        float dy = hrac.getY() - y;
        this.dlzka = sqrt(dx * dx + dy * dy);

        double normDx = dx / dlzka;
        double normDy = dy / dlzka;

        x += normDx * rychlost;
        y += normDy * rychlost;
        this.projektil.zmenPolohu((int)x, (int)y);
        this.projektil.zobraz();
    }

    /**
     * Metóda getDlzka, ktorá vráti dĺžku strely.
     *
     * @return double Dĺžka strely.
     */
    public double getDlzka() {
        return dlzka;
    }

    /**
     * Metóda skry, ktorá skryje strelu.
     */
    public void skry() {
        this.projektil.skry();
    }

    /**
     * Metóda strelaAnimacia, ktorá vykonáva animáciu strely.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     */
    public void strelaAnimacia(int pocetObrazkov) {
        animacia++;
        if (animacia >= pocetObrazkov) {
            animacia = 0;
        }

        if (animacia < 10)  {
            this.projektil.zmenObrazok(this.cestaKObrazku + "/tile00" + animacia + ".png");
        } else {
            this.projektil.zmenObrazok(this.cestaKObrazku + "/tile0" + animacia + ".png");
        }
    }
}
