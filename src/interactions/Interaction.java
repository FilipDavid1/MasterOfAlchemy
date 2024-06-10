package interactions;

import obstacles.GameObject;
import obstacles.characters.player.Player;
import obstacles.characters.player.Inventory;
import map.Map;
import obstacles.characters.Character;
import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import things.ingredients.Ingredient;

/**
 * Trieda Interakcia zabezpečuje interakciu medzi hráčom a hernými objektmi.
 */
public class Interaction {
    private Map map;
    private Inventory inventory;
    private Player player;
    private BlokTextu blockOfText;
    private boolean isDisplayed;
    private int timer;
    private BlokTextu hp;

    /**
     * Konštruktor pre triedu Interakcia.
     * @param map Mapa hry
     * @param inventory Inventár hráča
     * @param player Hráč
     */
    public Interaction(Map map, Inventory inventory, Player player) {
        this.map = map;
        this.inventory = inventory;
        this.player = player;
        this.blockOfText = new BlokTextu("Nie si v dosahu na to aby si interagoval");
        this.blockOfText.zmenFarbu("white");
        this.blockOfText.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.timer = 10;
        this.hp = new BlokTextu("HP: " + player.getHp(), 0, 50);
        this.hp.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.hp.zmenFarbu("white");
        this.hp.zobraz();
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav textových blokov a časovača.
     */
    public void tik() {
        if (isDisplayed) {
            timer--;
        }

        if (timer <= 0) {
            this.isDisplayed = false;
            this.blockOfText.skry();
        }
        this.hp.zmenText("HP: " + player.getHp());
        this.hp.zobraz();
    }

    /**
     * Metóda pickPosition sa volá, keď hráč klikne na mapu.
     * Kontroluje, či je na daných súradniciach nejaký objekt na interakciu.
     * @param x X-súradnica kliknutia
     * @param y Y-súradnica kliknutia
     */
    public void pickPosition(int x, int y) {
        if (jeVDosahu((x + Math.abs(this.map.getX())), (y + Math.abs(this.map.getY())))) {
            if (!this.zoberIngredienciu(x, y)) {
                if (!this.vyberPostavu(x, y)) {
                    this.blockOfText.zmenText("Ziadny objekt na interakciu");
                    this.blockOfText.zmenPolohu(0, 30);
                    this.blockOfText.zobraz();
                    this.isDisplayed = true;
                    this.timer = 10;
                }
            }
        } else {
            this.blockOfText.zmenPolohu(0, 30);
            this.blockOfText.zobraz();
            this.isDisplayed = true;
            this.timer = 10;
        }
    }

    /**
     * Metóda vyberPostavu kontroluje, či je na daných súradniciach postava.
     * Ak áno, hráč ju vyberie.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či bola vybraná postava
     */
    private boolean vyberPostavu(int x, int y) {
        for (GameObject gameObject : map.getGameObjects()) {
            if (gameObject instanceof Character character) {
                if (character.getX() < x && character.getX() + character.getWidth() > x && character.getY() < y && character.getY() + character.getHeight() > y) {
                    player.vyberPostavu(character);
                    this.blockOfText.zmenText("Vybral si postavu: " + character.getClass().getSimpleName());
                    this.blockOfText.zmenPolohu(0, 30);
                    this.blockOfText.zobraz();
                    this.isDisplayed = true;
                    this.timer = 20;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metóda zoberIngredienciu kontroluje, či je na daných súradniciach ingrediencia.
     * Ak áno, hráč ju zoberie.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či bola zobraná ingrediencia
     */
    private boolean zoberIngredienciu(int x, int y) {
        for (Ingredient ingredient : map.getIngredients()) {
            if (ingredient.getX() < x && ingredient.getX() + ingredient.getWidth() > x && ingredient.getY() < y && ingredient.getY() + ingredient.getVyska() > y) {
                this.pridajIngredienciuDoInventara(ingredient);
                this.blockOfText.zmenText("Zobral si ingredienciu: " + ingredient.getName());
                this.blockOfText.zmenPolohu(0, 30);
                this.blockOfText.zobraz();
                this.isDisplayed = true;
                this.timer = 5;
                return true;
            }
        }
        return false;
    }

    /**
     * Metóda pridajIngredienciuDoInventara pridá ingredienciu do inventára hráča.
     * @param ingredient Ingrediencia na pridanie
     */
    private void pridajIngredienciuDoInventara(Ingredient ingredient) {
        this.inventory.addThing(ingredient);
        this.map.deleteIngredient(ingredient);
    }

    /**
     * Metóda jeVDosahu kontroluje, či sú dané súradnice v dosahu hráča.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či sú súradnice v dosahu
     */
    private boolean jeVDosahu(int x, int y) {
        int dosah = 500;
        var playerX = (this.player.getX() + Math.abs(this.map.getX()));
        var playerY = (this.player.getY() + Math.abs(this.map.getY()));
        return Math.sqrt(Math.pow(playerX - x, 2) + Math.pow(playerY - y, 2)) <= dosah;
    }
}
