package obstacles;

import fri.shapesge.Obrazok;
import obstacles.characters.Character;

import static java.lang.Math.sqrt;

/**
 * Trieda bullet, ktorá reprezentuje strelu v hre.
 */
public class Bullet {
    private float x;
    private float y;
    private final float speed;
    private double length;
    private final Obrazok projectile;
    private int animation = 0;
    private final String pathToImage;

    /**
     * Konštruktor pre triedu bullet.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param speed Rýchlosť strely.
     * @param pathToImage Cesta k obrázku pre animáciu.
     */
    public Bullet(float x, float y, float speed, String pathToImage) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.pathToImage = pathToImage;
        this.projectile = new Obrazok(pathToImage + "/tile000.png");
        this.projectile.zmenPolohu((int)x, (int)y);
    }

    /**
     * Metóda aktualizuj, ktorá aktualizuje polohu strely a zobrazuje ju na novej pozícii.
     *
     * @param player Postava, ktorá vystrelila strelu.
     */
    public void update(Character player) {
        float dx = player.getX() - x;
        float dy = player.getY() - y;
        this.length = sqrt(dx * dx + dy * dy);

        double normDx = dx / length;
        double normDy = dy / length;

        x += normDx * speed;
        y += normDy * speed;
        this.projectile.zmenPolohu((int)x, (int)y);
        this.projectile.zobraz();
    }

    /**
     * Metóda getDlzka, ktorá vráti dĺžku strely.
     *
     * @return double Dĺžka strely.
     */
    public double getLength() {
        return length;
    }

    /**
     * Metóda skry, ktorá skryje strelu.
     */
    public void hideBullet() {
        this.projectile.skry();
    }

    /**
     * Metóda bulletAnimacia, ktorá vykonáva animáciu strely.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     */
    public void bulletAnimation(int numberOfImages) {
        animation++;
        if (animation >= numberOfImages) {
            animation = 0;
        }

        if (animation < 10)  {
            this.projectile.zmenObrazok(this.pathToImage + "/tile00" + animation + ".png");
        } else {
            this.projectile.zmenObrazok(this.pathToImage + "/tile0" + animation + ".png");
        }
    }
}
