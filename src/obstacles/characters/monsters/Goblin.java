package obstacles.characters.monsters;

import obstacles.Bullet;
import obstacles.characters.Character;

/**
 * Trieda Goblin predstavuje jednu z postáv v hre, ktorá je typom StrelecMonstrum.
 */
public class Goblin extends StrelecMonstrum {

    /**
     * Konštruktor pre triedu Goblin.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia goblina na mape.
     * @param y Y-ová pozícia goblina na mape.
     * @param player Referencia na hráča.
     */
    public Goblin(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage, x, y, 1, player, 19);
    }

    /**
     * Metóda tik sa volá v každom cykle hry a riadi animáciu goblina.
     */
    @Override
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("0", ""), 12);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia umožní Drakovi interagovať s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param character Postava, s ktorou goblin interaguje.
     */
    @Override
    public void interaction(Character character) {
        super.pridajStrelu(new Bullet(super.getX() - 10, super.getY() - 15, 8, "resources/Obrazky/bullet/Goblin"));
    }
}
