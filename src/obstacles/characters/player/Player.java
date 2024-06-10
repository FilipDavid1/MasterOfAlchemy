package obstacles.characters.player;

import interactions.Interaction;
import map.Map;
import obstacles.characters.CharacterOrientation;
import obstacles.characters.Character;
import obstacles.characters.monsters.IMonstrum;
import obstacles.characters.monsters.Skeleton;
import things.potions.PoisonPotion;
import things.potions.PowerPotion;
import things.potions.ResistancePotion;
import things.potions.RevivalPotion;
import things.potions.RegenerationPotion;
import things.potions.InvisibilityPotion;
import things.potions.RestorationPotion;
import fri.shapesge.Manazer;
import things.ingredients.Ingredient;

/**
 * Trieda player reprezentuje hráča v hre.
 */
public class Player extends Character {
    private final Map map;
    private Inventory inventory;
    private Interaction interaction;
    private Character selectedCharacter;
    private int regenerationTime;

    /**
     * Konštruktor pre triedu player.
     * @param numberOfImagesIdle Počet obrázkov pre animáciu nečinnosti
     * @param name Názov hráča
     * @param x X-súradnica hráča
     * @param y Y-súradnica hráča
     * @param map Mapa hry
     * @param manazer Manažér pre správu objektov
     */
    public Player(int numberOfImagesIdle, String name, int x, int y, Map map, Manazer manazer) {
        super(numberOfImagesIdle, name, x, y, 10);
        this.map = map;
        this.inventory = new Inventory();
        this.interaction = new Interaction(map, this.inventory, this);
        manazer.spravujObjekt(this.interaction);
        this.selectedCharacter = null;

        // Pridanie elixírov do inventára
        this.inventory.addThing(new RestorationPotion("ElixirObnovenia"));
        this.inventory.addThing(new PowerPotion("ElixirMoci"));
        this.inventory.addThing(new ResistancePotion("ElixirOdolnosti"));
        this.inventory.addThing(new RevivalPotion("ElixirOzivenia"));
        this.inventory.addThing(new RegenerationPotion("ElixirRegeneracie"));
        this.inventory.addThing(new InvisibilityPotion("ElixirSkrytia"));
        this.inventory.addThing(new PoisonPotion("ElixirJedu"));

//        Ingrediencie.AmadamovyList, Ingrediencie.Ashwagandha, Ingrediencie.Obilie
        this.inventory.addThing(new Ingredient("AmadamovyList", 0, 0));
        this.inventory.addThing(new Ingredient("Ashwagandha", 0, 0));
        this.inventory.addThing(new Ingredient("Obilie", 0, 0));
    }

    /**
     * Metóda moveDown posunie hráča dole.
     */
    public void moveDown() {
        float targetY = super.getY() + 10;
        float newY = lerp(super.getY(), targetY, super.getMovementSpeed());
        if (this.map.getY() <= -1840 || super.getY() != 450) {
            super.moveTo(super.getX(), (int)newY);
        }
        this.step("Walk_Down_");
        super.setOrientation(CharacterOrientation.DOWN);
        this.hybeSa();
        if (super.getY() == 450) {
            this.map.setVelY(-5 * ( super.getMovementSpeed()));
        }
    }

    /**
     * Metóda moveUp posunie hráča hore.
     */
    public void moveUp() {
        float targetY = super.getY() - 10;
        float newY = lerp(super.getY(), targetY, super.getMovementSpeed());
        if (this.map.getY() >= 0 || super.getY() != 450) {
            super.moveTo(super.getX(), (int)newY);
        }
        this.step("Walk_Up_");
        super.setOrientation(CharacterOrientation.UP);
        this.hybeSa();
        if (super.getY() == 450) {
            this.map.setVelY(5 * ( super.getMovementSpeed()));
        }
    }

    /**
     * Metóda moveLeft posunie hráča vľavo.
     */
    public void moveLeft() {
        float targetX = super.getX() - 10;
        float newX = lerp(super.getX(), targetX, super.getMovementSpeed());
        if (this.map.getX() >= 0 || super.getX() <= 725) {
            super.moveTo((int)newX, super.getY());
        }
        this.step("Walk_Left_");
        super.setOrientation(CharacterOrientation.LEFT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.map.setVelX(5 * ( super.getMovementSpeed()));
        }
    }

    /**
     * Metóda moveRight posunie hráča vpravo.
     */
    public void moveRight() {
        float targetX = super.getX() + 10;
        float newX = lerp(super.getX(), targetX, super.getMovementSpeed());
        if (this.map.getX() <= -2910 || super.getX() <= 725) {
            super.moveTo((int)newX, super.getY());
        }
        this.step("Walk_Right_");
        super.setOrientation(CharacterOrientation.RIGHT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.map.setVelX(-5 * ( super.getMovementSpeed()));
        }
    }

    /**
     * Metóda stop zastaví hráča.
     */
    public void stop() {
        this.nehybeSa();
        this.inventory.hideIngredientsInInventory();
    }

    /**
     * Metóda nehybeSa nastaví hráča do stavu nehybe sa.
     */
    public void nehybeSa() {
        super.setMoving(false);
    }

    /**
     * Metóda hybeSa nastaví hráča do stavu hybe sa.
     */
    public void hybeSa() {
        super.setMoving(true);
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav hráča.
     */
    public void tik() {
        if (!super.getMoving()) {
            this.idleAnimation(  super.getPathToImage().replace("Down_0", "") + super.getOrientation() + "_");
        }

        if (super.getWeaknessDuration() > 0 && !super.getIsPoisoned()) {
            super.weakness((super.getWeaknessDuration() / 1000) - 1);
        }

        if (regenerationTime > 0) {
            if (regenerationTime % 1000 == 0) {
                super.addHp(5);
            }
            regenerationTime -= 200;
        }

        if (super.getY() <= 0) {
            super.moveTo(super.getX(), 0);
        }

        if (super.getY() >= 800) {
            super.moveTo(super.getX(), 800);
        }

    }

    /**
     * Metóda getInventar vráti inventár hráča.
     * @return Inventár hráča
     */
    public Inventory getInventar() {
        return this.inventory;
    }

    /**
     * Metóda attackMonsters umožní hráčovi útočiť na monštrá.
     */
    public void attackMonsters() {
        if (this.selectedCharacter != null) {
            double vzdialenost = Math.sqrt(Math.pow(selectedCharacter.getX() - this.getX(), 2) + Math.pow(selectedCharacter.getY() - this.getY(), 2));
            if (vzdialenost < 200) {
                this.interaction(this.selectedCharacter);
            }
        }
    }

    /**
     * Metóda vyberPostavu umožní hráčovi vybrať postavu.
     * @param character Postava na výber
     */
    public void vyberPostavu(Character character) {
        this.selectedCharacter = character;
    }


    /**
     * Metóda interakcia umožní hráčovi interagovať s postavou.
     * @param character Postava na interakciu
     */
    @Override
    public void interaction(Character character) {
        if (character instanceof IMonstrum ) {
            if (character instanceof Skeleton skeleton) {
                if (!skeleton.isBarrierActive()) {
                    character.uberHp(super.getStrength());
                } else {
                    skeleton.znicBarieru();
                }
            } else {
                character.uberHp(super.getStrength());
            }
            this.attackAnimation(super.getPathToImage().replace("/Idle/Idle_Down_0", "/Attack/Attack_") + super.getOrientation() + "_", 6 );
        } else {
            character.interaction(this);
        }
    }

    /**
     * Metóda lerp vypočíta lineárnu interpoláciu medzi dvoma hodnotami.
     * @param zaciatok Začiatočná hodnota
     * @param koniec Konečná hodnota
     * @param rychlost Rýchlosť interpolácie
     * @return Výsledok lineárnej interpolácie
     */
    private float lerp(float zaciatok, float koniec, float rychlost) {
        return zaciatok + rychlost * (koniec - zaciatok);
    }

    /**
     * Metóda showInventory zobrazí inventár hráča.
     */
    public void showInventory() {
        this.inventory.displayIngredientsInInventory();
    }

    /**
     * Metóda usePotion1 umožní hráčovi použiť elixír 1.
     */
    public void usePotion1() {
        inventory.usePotion(0, this);
    }

    /**
     * Metóda usePotion2 umožní hráčovi použiť elixír 2.
     */
    public void usePotion2() {
        inventory.usePotion(1, this);
    }

    /**
     * Metóda usePotion3 umožní hráčovi použiť elixír 3.
     */
    public void usePotion3() {
        inventory.usePotion(2, this);
    }

    /**
     * Metóda usePotion4 umožní hráčovi použiť elixír 4.
     */
    public void usePotion4() {
        inventory.usePotion(3, this);
    }

    /**
     * Metóda usePotion5 umožní hráčovi použiť elixír 5.
     */
    public void usePotion5() {
        inventory.usePotion(4, this);
    }

    /**
     * Metóda usePotion6 umožní hráčovi použiť elixír 6.
     */
    public void usePotion6() {
        inventory.usePotion(5, this);
    }

    /**
     * Metóda usePotion7 umožní hráčovi použiť elixír 7.
     */
    public void usePotion7() {
        inventory.usePotion(6, this);
    }

    /**
     * Metóda usePotion8 umožní hráčovi použiť elixír 8.
     */
    public void usePotion8() {
        inventory.usePotion(7, this);
    }

    /**
     * Metóda usePotion9 umožní hráčovi použiť elixír 9.
     */
    public void usePotion9() {
        inventory.usePotion(8, this);
    }

    /**
     * Metóda usePotion10 umožní hráčovi použiť elixír 10.
     */
    public void usePotion10() {
        inventory.usePotion(9, this);
    }

    /**
     * Metóda getVybrataPostava vráti vybratú postavu hráčom.
     * @return Vybratá postava
     */
    public Character getVybrataPostava() {
        return this.selectedCharacter;
    }

    /**
     * Metóda regenerujHp umožní hráčovi regenerovať zdravie.
     * @param sekundy Počet sekúnd pre regeneráciu
     */
    public void regenerujHp(int sekundy) {
        this.regenerationTime = sekundy * 1000;
    }
}
