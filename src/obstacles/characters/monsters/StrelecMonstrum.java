package obstacles.characters.monsters;

import obstacles.Bullet;
import obstacles.characters.Character;

import java.util.ArrayList;

/**
 * Abstraktná trieda StrelecMonstrum, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public abstract class StrelecMonstrum extends Character implements IMonstrum {

    private final Character player;
    private ArrayList<Bullet> bullets;
    private final int numberOfImagesBullets;

    /**
     * Konštruktor pre triedu StrelecMonstrum.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param sila Sila postavy.
     * @param player Referencia na hráča.
     * @param numberOfImagesBullets Počet obrázkov pre animáciu strely.
     */
    public StrelecMonstrum(int numberOfImages, String pathToImage, int x, int y, int sila, Character player, int numberOfImagesBullets) {
        super(numberOfImages, pathToImage + "0", x, y, sila);
        this.player = player;
        this.bullets = new ArrayList<>();
        this.numberOfImagesBullets = numberOfImagesBullets;
    }

    /**
     * Abstraktná metóda tik, ktorá sa volá v každom tiku hry.
     */
    public abstract void tik();

    /**
     * Metóda let, ktorá aktualizuje strelu a vykonáva animáciu strely.
     * Ak je dĺžka strely menšia ako 10, odoberie HP hráčovi a skryje strelu.
     */
    public void fly() {
        ArrayList<Bullet> strelyNaVymazanie = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.update(this.player);
            bullet.bulletAnimation( this.numberOfImagesBullets);
            if (bullet.getLength() < 10) {
                this.player.uberHp(super.getStrength());
                strelyNaVymazanie.add(bullet);
                bullet.hideBullet();
            }
        }
        this.bullets.removeAll(strelyNaVymazanie);
    }

    /**
     * Metóda zmazStrely, ktorá skryje všetky strely a vymaže ich zo zoznamu.
     */
    public void zmazStrely() {
        for (Bullet bullet : bullets) {
            bullet.hideBullet();
        }
        this.bullets.clear();
    }

    /**
     * Metóda pridajStrelu, ktorá pridá strelu do zoznamu striel.
     *
     * @param bullet bullet, ktorá sa má pridať do zoznamu.
     */
    public void pridajStrelu(Bullet bullet) {
        this.bullets.add(bullet);
    }
}
