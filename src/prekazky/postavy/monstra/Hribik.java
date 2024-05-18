package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

/**
 * Trieda Hribik, ktorá rozširuje triedu StrelecMonstrum.
 */
public class Hribik extends StrelecMonstrum {

    /**
     * Konštruktor pre triedu Hribik.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param hrac Referencia na hráča.
     */
    public Hribik(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 3, hrac, 8);
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("0", ""), 11);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param postava Postava, s ktorou sa interaguje.
     */
    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() , super.getY() , 10, "resources/Obrazky/strela/Hribik"));
    }
}
