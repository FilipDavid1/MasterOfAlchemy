package obstacles.characters.monsters;

import obstacles.characters.Character;

import java.util.Random;

/**
 * Trieda Golem predstavuje jednu z postáv v hre, ktorá je typom Postava a implementuje rozhranie IMonstrum.
 */
public class Golem extends Character implements IMonstrum {

    /**
     * Konštruktor pre triedu Golem.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia golema na mape.
     * @param y Y-ová pozícia golema na mape.
     * @param player Referencia na hráča.
     */
    public Golem(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage + "0", x, y, 5);
    }

    /**
     * Metóda interakcia riadi interakciu golema s inými postavami.
     * Golemovi sa nastaví sila podľa náhodného čísla a postava, s ktorou golem interaguje, stratí životy.
     *
     * @param character Postava, s ktorou golem interaguje.
     */
    @Override
    public void interaction(Character character) {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance <= 10) {
            super.setStrength(10);
        } else {
            super.setStrength(5);
        }
        character.uberHp(super.getStrength());
    }

    /**
     * Metóda tik sa volá v každom cykle hry a riadi animáciu golema.
     */
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("Idle/idle_0", "Attack/Attack_"), 14);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
    }

}
