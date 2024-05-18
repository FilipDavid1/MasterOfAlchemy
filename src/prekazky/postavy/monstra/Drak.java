package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

/**
 * Trieda Drak reprezentuje monštrum typu Drak v hre.
 */
public class Drak extends StrelecMonstrum {
    /**
     * Konštruktor pre triedu Drak.
     * @param pocetObrazkov Počet obrázkov pre animáciu
     * @param cestaKObrazku Cesta k obrázku Draka
     * @param x X-súradnica Draka
     * @param y Y-súradnica Draka
     * @param hrac Hráč, s ktorým môže Drak interagovať
     */
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 1, hrac, 8);
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav Draka.
     */
    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 6);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia umožní Drakovi interagovať s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param postava Postava na interakciu
     */
    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() + 10, super.getY() + 20, 10, "resources/Obrazky/strela/Drak"));
    }
}
