package obstacles.characters.monsters;

import obstacles.Bullet;
import obstacles.characters.Character;

/**
 * Trieda Drak reprezentuje monštrum typu Drak v hre.
 */
public class Dragon extends StrelecMonstrum {
    /**
     * Konštruktor pre triedu Drak.
     * @param numberOfImages Počet obrázkov pre animáciu
     * @param pathToImage Cesta k obrázku Draka
     * @param x X-súradnica Draka
     * @param y Y-súradnica Draka
     * @param player Hráč, s ktorým môže Drak interagovať
     */
    public Dragon(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage, x, y, 1, player, 8);
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav Draka.
     */
    @Override
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("Idle/Idle_0", "Attack/Attack_"), 6);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia umožní Drakovi interagovať s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param character Postava na interakciu
     */
    @Override
    public void interaction(Character character) {
        super.pridajStrelu(new Bullet(super.getX() + 10, super.getY() + 20, 10, "resources/Obrazky/bullet/Drak"));
    }
}
