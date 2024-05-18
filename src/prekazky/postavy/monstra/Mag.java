package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

/**
 * Trieda Mag, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public class Mag extends Postava implements IMonstrum {

    /**
     * Konštruktor pre triedu Mag.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param hrac Referencia na hráča.
     */
    public Mag(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 0);
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Otrávi postavu na náhodný čas a náhodný počet životov.
     *
     * @param postava Postava, s ktorou sa interaguje.
     */
    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        postava.otrav((rand.nextInt(3) + 1), rand.nextInt(5));
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 8);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }
}
