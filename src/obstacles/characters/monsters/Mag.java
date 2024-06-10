package obstacles.characters.monsters;

import obstacles.characters.Character;

import java.util.Random;

/**
 * Trieda Mag, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public class Mag extends Character implements IMonstrum {

    /**
     * Konštruktor pre triedu Mag.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param player Referencia na hráča.
     */
    public Mag(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage + "0", x, y, 0);
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Otrávi postavu na náhodný čas a náhodný počet životov.
     *
     * @param character Postava, s ktorou sa interaguje.
     */
    @Override
    public void interaction(Character character) {
        Random rand = new Random();
        character.poison((rand.nextInt(3) + 1), rand.nextInt(5));
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    @Override
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("Idle/Idle_0", "Attack/Attack_"), 8);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }
}
