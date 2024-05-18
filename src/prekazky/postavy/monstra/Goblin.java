package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

/**
 * Trieda Goblin predstavuje jednu z postáv v hre, ktorá je typom StrelecMonstrum.
 */
public class Goblin extends StrelecMonstrum {

    /**
     * Konštruktor pre triedu Goblin.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia goblina na mape.
     * @param y Y-ová pozícia goblina na mape.
     * @param hrac Referencia na hráča.
     */
    public Goblin(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 1, hrac, 19);
    }

    /**
     * Metóda tik sa volá v každom cykle hry a riadi animáciu goblina.
     */
    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("0", ""), 12);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia umožní Drakovi interagovať s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param postava Postava, s ktorou goblin interaguje.
     */
    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() - 10, super.getY() - 15, 8, "resources/Obrazky/strela/Goblin"));
    }
}
