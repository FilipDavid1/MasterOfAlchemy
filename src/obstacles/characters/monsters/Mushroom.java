package obstacles.characters.monsters;

import obstacles.Bullet;
import obstacles.characters.Character;

/**
 * Trieda Hribik, ktorá rozširuje triedu StrelecMonstrum.
 */
public class Mushroom extends StrelecMonstrum {

    /**
     * Konštruktor pre triedu Hribik.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param player Referencia na hráča.
     */
    public Mushroom(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage, x, y, 3, player, 8);
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu útoku alebo nečinnosti.
     */
    @Override
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("0", ""), 11);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Vystrelí strelu na postavu.
     *
     * @param character Postava, s ktorou sa interaguje.
     */
    @Override
    public void interaction(Character character) {
        super.pridajStrelu(new Bullet(super.getX() , super.getY() , 10, "resources/Obrazky/bullet/Hribik"));
    }
}
