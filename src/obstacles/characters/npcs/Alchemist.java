package obstacles.characters.npcs;

import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import obstacles.characters.Character;
import obstacles.characters.player.Player;
import obstacles.characters.player.Inventory;
import things.potions.Potion;
import javax.swing.JOptionPane;
import java.lang.reflect.Constructor;

/**
 * Trieda Alchymista, ktorá rozširuje triedu Postava.
 */
public class Alchemist extends Character {
    private final String[] potions = {"ElixirJedu", "ElixirMoci", "ElixirObnovenia", "ElixirOdolnosti", "ElixirOzivenia", "ElixirRegeneracie", "ElixirSily", "ElixirSkrytia"};
    private final BlokTextu blockOfText;

    /**
     * Konštruktor pre triedu Alchymista.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param player Referencia na hráča.
     */
    public Alchemist(int numberOfImages, String pathToImage, int x, int y, Character player) {
        super(numberOfImages, pathToImage + "0", x, y, 0);
        this.blockOfText = new BlokTextu("", 450, 30);
        this.blockOfText.zmenFont("Courier New", StylFontu.BOLD, 15);
    }

    /**
     * Metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Vytvára a pridáva elixír do inventára hráča.
     *
     * @param character Postava, s ktorou sa interaguje.
     */
    @Override
    public void interaction(Character character) {
        Player player = (Player)character;
        StringBuilder formattedPotions = new StringBuilder();
        for (String elixir : this.potions) {
            try {
                Class<?> clazz = Class.forName("things.potions." + elixir);
                Constructor<?> ctor = clazz.getConstructor(String.class);
                Potion potionObj = (Potion)ctor.newInstance(elixir);
                formattedPotions.append(potionObj.getName()).append(" - ").append(potionObj.getPopisElixira()).append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String potionName = JOptionPane.showInputDialog(null, "Zadaj name elixiru ktory chces Vyrobit: \n" + formattedPotions);
        if (potionName != null) {
            Potion potion = createPotion(potionName, player.getInventar());
            if (potion != null) {
                player.getInventar().addThing(potion);
                player.getInventar().displayPotions();
                this.blockOfText.zmenText("Vyrobeny elixir: " + potionName);
                this.blockOfText.zobraz();
            }
        }
    }

    /**
     * Metóda vyrobitElixir, ktorá vytvára elixír a odoberá potrebné ingrediencie z inventára.
     *
     * @param nameElixiru Názov elixíru, ktorý sa má vytvoriť.
     * @param inventory Inventár, z ktorého sa odoberajú ingrediencie.
     * @return Elixir Vytvorený elixír.
     */
    public Potion createPotion(String nameElixiru, Inventory inventory) {
        String potionClassName = "veci.potions." + nameElixiru;

        try {
            Class<?> clazz = Class.forName(potionClassName);
            Constructor<?> ctor = clazz.getConstructor(String.class);
            Potion potion = (Potion)ctor.newInstance(nameElixiru);
            if (potion.mozemVyrobit(inventory.getThingsAsList())) {
                inventory.deleteThings(potion.getPotrebneIngredience());
                return potion;
            } else {
                this.blockOfText.zmenText("Nemozem vyrobit elixir: " + nameElixiru + " - nemas vsetky potrebne ingrediencie");
                this.blockOfText.zobraz();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Vykonáva animáciu nečinnosti.
     */
    public void tik() {
        super.idleAnimation(super.getPathToImage().replace("0", ""));
    }
}
