package prekazky.postavy.monstra;
import prekazky.postavy.Postava;

/**
 * Trieda Skeleton, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public class Skeleton extends Postava implements IMonstrum {
    private int pocetBarier;

    /**
     * Konštruktor pre triedu Skeleton.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param hrac Referencia na hráča.
     */
    public Skeleton(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 10);
        this.pocetBarier = 3;
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Ak je bariera aktívna a počet bariér je menší ako 10, zvýši počet bariér.
     * Odoberie HP postave na základe sily tejto postavy.
     *
     * @param postava Postava, s ktorou sa interaguje.
     */
    @Override
    public void interakcia(Postava postava) {
        if (this.jeBarieraAktivna() && this.pocetBarier < 10) {
            this.pocetBarier++;
        }
        postava.uberHp(super.getSila());
    }

    /**
     * Metóda zničí barieru, ak je počet bariér väčší ako 0.
     */
    public void znicBarieru() {
        if (pocetBarier > 0) {
            pocetBarier--;
        }
    }

    /**
     * Metóda vráti true, ak je bariera aktívna (počet bariér je väčší ako 0).
     *
     * @return boolean Hodnota, či je bariera aktívna.
     */
    public boolean jeBarieraAktivna() {
        return pocetBarier > 0;
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 18);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }
}
