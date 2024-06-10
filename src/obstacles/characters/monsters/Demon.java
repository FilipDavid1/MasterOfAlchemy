package obstacles.characters.monsters;

import obstacles.characters.Character;

import java.util.Random;

/**
 * Trieda Demon reprezentuje monštrum typu Démon v hre.
 */
public class Demon extends Character implements IMonstrum {
    private final Character player;

    /**
     * Konštruktor pre triedu Demon.
     * @param numberOfImages Počet obrázkov pre animáciu
     * @param pathToImage Cesta k obrázku Démona
     * @param x X-súradnica Démona
     * @param y Y-súradnica Démona
     * @param player Hráč, s ktorým môže Démon interagovať
     */
    public Demon(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage + "0", x, y, 5);
        this.player = player;
    }

    /**
     * Metóda interakcia umožní Démonovi interagovať s postavou.
     * Démonovi sa nastaví sila podľa náhodného čísla a postava, s ktorou Démon interaguje, stratí životy.
     *
     * @param character Postava na interakciu
     */
    @Override
    public void interaction(Character character) {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance <= 15) {
            super.setStrength(15);
            character.weakness(2);
            System.out.println("Demon oslabuje playera");
        } else if (chance <= 50) {
            super.setStrength(10);
            character.weakness(1);
            System.out.println("Demon oslabuje playera");
        } else {
            super.setStrength(5);
        }

        character.uberHp(super.getStrength());
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav Démona.
     */
    public void tik() {
        if (super.getAttacking()) {
            super.attackAnimation(super.getPathToImage().replace("demon_idle_0", "Attack/demon_cleave_"), 15);
        } else {
            super.idleAnimation(super.getPathToImage().replace("0", ""));
        }
        if (super.isDead()) {
            this.player.weakness(0);
        }
    }
}
