package things.potions;

import obstacles.characters.Character;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirOzivenia je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže oživiť postavu.
 */
public class RevivalPotion extends Potion {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.MuskatovyOrech, Ingredients.Plevel, Ingredients.StromovaHuba};

    /**
     * Konštruktor pre ElixirOzivenia.
     *
     * @param name Názov elixíru.
     */
    public RevivalPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Použitie elixíru na postavu.
     * Ak je HP postavy menšie alebo rovné 0, pridá sa jej 100 HP.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        if (character.getHp() <= 0) {
            character.addHp(100);
        }
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String getPopisElixira() {
        return "Oživí postavu.";
    }
}
