package things.potions;

import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.StylFontu;
import obstacles.characters.Character;
import things.ingredients.Ingredient;
import things.ingredients.Ingredients;
import things.IThing;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktná trieda Elixir, ktorá implementuje rozhranie IVec.
 */
public abstract class Potion implements IThing {

    private final String name;
    private final Ingredients[] potrebneIngredience;
    private final Obrazok obrazok;
    private final DataObrazku data;
    private final BlokTextu blockOfText;

    /**
     * Konštruktor pre triedu Elixir.
     *
     * @param name Názov elixíru.
     * @param potrebneIngredience Pole potrebných ingrediencií pre výrobu elixíru.
     */
    public Potion(String name, Ingredients[] potrebneIngredience) {
        this.name = name;
        this.potrebneIngredience = potrebneIngredience;
        this.obrazok = new Obrazok("resources/Obrazky/potions/" + name + ".png");
        this.data = new DataObrazku("resources/Obrazky/potions/" + name + ".png");
        this.blockOfText = new BlokTextu(name.substring(6));
        this.blockOfText.zmenFarbu("white");
        this.blockOfText.zmenFont("Courier New", StylFontu.BOLD, 9);
    }

    /**
     * Metóda getname, ktorá vráti názov elixíru.
     *
     * @return String Názov elixíru.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Metóda mozemVyrobit, ktorá kontroluje, či je možné vyrobiť elixír z daných ingrediencií.
     *
     * @param ingrediencie Zoznam ingrediencií, ktoré máme k dispozícii.
     * @return boolean Hodnota, či je možné vyrobiť elixír.
     */
    public boolean mozemVyrobit(List<Ingredient> ingrediencie) {
        for (Ingredients ingrediencia : potrebneIngredience) {
            boolean nasla = false;
            for (Ingredient i : ingrediencie) {
                if (i.getIngredientEnum() == ingrediencia) {
                    nasla = true;
                    break;
                }
            }
            if (!nasla) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metóda getObrazok, ktorá vráti obrázok elixíru.
     *
     * @return Obrazok Obrázok elixíru.
     */
    public Obrazok getImage() {
        return obrazok;
    }

    /**
     * Abstraktná metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    public abstract void use(Character character);

    /**
     * Metóda getPotrebneIngredience, ktorá vráti zoznam názvov potrebných ingrediencií pre výrobu elixíru.
     *
     * @return ArrayList<String> Zoznam názvov potrebných ingrediencií.
     */
    public ArrayList<String> getPotrebneIngredience() {
        return new ArrayList<>() {{
                for (Ingredients i : potrebneIngredience) {
                    add(i.getName());
                }
            }};
    }

    /**
     * Metóda getSirka, ktorá vráti šírku elixíru.
     *
     * @return int Šírka elixíru.
     */
    @Override
    public int getWidth() {
        return data.getSirka();
    }

    /**
     * Metóda zobrazText, ktorá zobrazuje text na danej pozícii.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void zobrazText(int x, int y) {
        blockOfText.zmenPolohu(x, y);
        blockOfText.zobraz();
    }

    /**
     * Metóda skry, ktorá skryje elixír.
     */
    public void skry() {
        blockOfText.skry();
        this.obrazok.skry();
    }

    /**
     * Abstraktná metóda popisElixira, ktorá vráti popis elixíru.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @return String Popis elixíru.
     */
    public abstract String getPopisElixira();
}
