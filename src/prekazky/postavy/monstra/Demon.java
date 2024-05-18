package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

/**
 * Trieda Demon reprezentuje monštrum typu Démon v hre.
 */
public class Demon extends Postava implements IMonstrum {
    private final Postava hrac;

    /**
     * Konštruktor pre triedu Demon.
     * @param pocetObrazkov Počet obrázkov pre animáciu
     * @param cestaKObrazku Cesta k obrázku Démona
     * @param x X-súradnica Démona
     * @param y Y-súradnica Démona
     * @param hrac Hráč, s ktorým môže Démon interagovať
     */
    public Demon(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 5);
        this.hrac = hrac;
    }

    /**
     * Metóda interakcia umožní Démonovi interagovať s postavou.
     * Démonovi sa nastaví sila podľa náhodného čísla a postava, s ktorou Démon interaguje, stratí životy.
     *
     * @param postava Postava na interakciu
     */
    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        int nahoda = rand.nextInt(100);
        if (nahoda <= 15) {
            super.setSila(15);
            postava.oslabenie(2);
            System.out.println("Demon oslabuje hraca");
        } else if (nahoda <= 50) {
            super.setSila(10);
            postava.oslabenie(1);
            System.out.println("Demon oslabuje hraca");
        } else {
            super.setSila(5);
        }

        postava.uberHp(super.getSila());
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav Démona.
     */
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("demon_idle_0", "Attack/demon_cleave_"), 15);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
        if (super.jeMrtvy()) {
            this.hrac.oslabenie(0);
        }
    }
}
