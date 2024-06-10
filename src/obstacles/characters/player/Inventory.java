package obstacles.characters.player;
import fri.shapesge.Obrazok;
import things.potions.Potion;
import things.ingredients.Ingredient;
import things.IThing;

import java.util.ArrayList;

/**
 * Trieda Inventar reprezentuje inventár hráča.
 */
public class Inventory<E extends IThing> {
    private ArrayList< E> things;

    private Obrazok inventoryImage;

    private Obrazok potionInventoryImage;

    private Potion[] potions;

    /**
     * Konštruktor pre triedu Inventar.
     */
    public Inventory() {
        this.things = new ArrayList<>();
        this.inventoryImage = new Obrazok("resources/Obrazky/player/inventory.png");
        this.potionInventoryImage = new Obrazok("resources/Obrazky/player/inventory_potions.png");
        this.potionInventoryImage.zmenPolohu(408, 750);
        this.potionInventoryImage.zobraz();
        this.potions = new Potion[10];
        this.displayPotions();
    }

    /**
     * Metóda pridajVec pridá vec do inventára.
     * @param vec Vec na pridanie
     */
    public void addThing(E vec) {
        if (vec instanceof Potion) {
            for (int i = 0; i < this.potions.length; i++) {
                if (this.potions[i] == null) {
                    this.potions[i] = (Potion)vec;
                    break;
                }
            }
        } else {
            this.things.add(vec);
        }
        this.displayPotions();
    }

    /**
     * Metóda odstranVec odstráni vec z inventára.
     * @param vec Vec na odstránenie
     */
    public void deleteThing(IThing vec) {
        if (vec instanceof Potion) {
            for (int i = 0; i < this.potions.length; i++) {
                if (this.potions[i] == vec) {
                    this.potions[i] = null;
                    break;
                }
            }
        } else {
            this.things.remove(vec);
        }
    }

    /**
     * Metóda odstranVeci odstráni zoznam vecí z inventára.
     * @param veci Zoznam vecí na odstránenie
     */
    public void deleteThings(ArrayList<String> veci) {
        for (String vec : veci) {
            for (E e : this.things) {
                if (e.getName().equals(vec)) {
                    this.things.remove(e);
                    break;
                }
            }
        }
    }

    /**
     * Metóda zobrazpotions zobrazí elixíry v inventári.
     */
    public void displayPotions() {
        int startXPosition = 450;
        int space = 60;

        for (int i = 0; i < 10; i++) {
            if (i < potions.length && potions[i] != null) {
                int poziciaX = startXPosition + i * space;
                potions[i].getImage().zmenPolohu(poziciaX, 790);
                potions[i].zobrazText(poziciaX - 15, 830);
                potions[i].getImage().zobraz();
            }
        }
    }

    /**
     * Metóda zobrazIngrediencieVInventari zobrazí ingrediencie v inventári.
     */
    public void displayIngredientsInInventory() {
        this.inventoryImage.zmenPolohu(500, 200);
        this.inventoryImage.zobraz();

        for (int i = 0; i < this.things.size(); i++) {
            if ((this.things.get(i) instanceof Ingredient ingredient)) {
                if (i == 0 || i == 6 || i == 12 || i == 18 || i == 24) {
                    ingredient.setX(530, ingredient.getImage(), ingredient.getBlockOfText());
                } else {
                    ingredient.setX(530 + (i % 6) * 60, ingredient.getImage(), ingredient.getBlockOfText());
                }
                ingredient.setY(230 + (i / 6) * 60, ingredient.getImage(), ingredient.getBlockOfText());
            }
        }
    }

    /**
     * Metóda skryIngrediencieSInventara skryje ingrediencie v inventári.
     */
    public void hideIngredientsInInventory() {
        this.inventoryImage.skry();
        for (E vec : this.things) {
            if ((vec instanceof Ingredient ingredient)) {
                ingredient.skry();
            }
        }
    }

    /**
     * Metóda getVec vráti vec z inventára podľa názvu.
     * @param vec Názov veci
     * @return Vec s daným názvom
     */
    public IThing getThing(String vec) {
        for (E e : things) {
            if (e.getName().equals(vec)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Metóda getVeciList vráti zoznam všetkých vecí v inventári.
     * @return Zoznam vecí v inventári
     */
    public ArrayList<E> getThingsAsList() {
        return this.things;
    }

    /**
     * Metóda usePotion umožní hráčovi použiť elixír z inventára.
     * @param index Index elixíru v inventári
     * @param player Hráč, ktorý používa elixír
     */
    public void usePotion(int index, Player player) {
        if (index < this.potions.length && this.potions[index] != null) {
            System.out.println(index);
            this.potions[index].use(player);
            this.potions[index].skry();
            this.potions[index] = null;
        }
    }
}
