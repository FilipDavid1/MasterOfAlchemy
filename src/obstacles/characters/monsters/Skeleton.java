package obstacles.characters.monsters;
import obstacles.characters.Character;

/**
 * Trieda Skeleton, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public class Skeleton extends Character implements IMonstrum {
    private int barrierNumber;

    /**
     * Konštruktor pre triedu Skeleton.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param player Referencia na hráča.
     */
    public Skeleton(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage + "0", x, y, 10);
        this.barrierNumber = 3;
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Ak je bariera aktívna a počet bariér je menší ako 10, zvýši počet bariér.
     * Odoberie HP postave na základe sily tejto postavy.
     *
     * @param character Postava, s ktorou sa interaguje.
     */
    @Override
    public void interaction(Character character) {
        if (this.isBarrierActive() && this.barrierNumber < 10) {
            this.barrierNumber++;
        }
        character.uberHp(super.getStrength());
    }

    /**
     * Metóda zničí barieru, ak je počet bariér väčší ako 0.
     */
    public void znicBarieru() {
        if (barrierNumber > 0) {
            barrierNumber--;
        }
    }

    /**
     * Metóda vráti true, ak je bariera aktívna (počet bariér je väčší ako 0).
     *
     * @return boolean Hodnota, či je bariera aktívna.
     */
    public boolean isBarrierActive() {
        return barrierNumber > 0;
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("Idle/Idle_0", "Attack/Attack_"), 18);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }
}
