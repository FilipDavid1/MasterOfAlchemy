package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

/**
 * Trieda Golem predstavuje jednu z postáv v hre, ktorá je typom Postava a implementuje rozhranie IMonstrum.
 */
public class Golem extends Postava implements IMonstrum {

    /**
     * Konštruktor pre triedu Golem.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia golema na mape.
     * @param y Y-ová pozícia golema na mape.
     * @param hrac Referencia na hráča.
     */
    public Golem(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 5);
    }

    /**
     * Metóda interakcia riadi interakciu golema s inými postavami.
     * Golemovi sa nastaví sila podľa náhodného čísla a postava, s ktorou golem interaguje, stratí životy.
     *
     * @param postava Postava, s ktorou golem interaguje.
     */
    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        int nahoda = rand.nextInt(100);
        if (nahoda <= 10) {
            super.setSila(10);
        } else {
            super.setSila(5);
        }
        postava.uberHp(super.getSila());
    }

    /**
     * Metóda tik sa volá v každom cykle hry a riadi animáciu golema.
     */
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/idle_0", "Attack/Attack_"), 14);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

}
