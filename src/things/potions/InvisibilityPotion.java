package things.potions;

import obstacles.characters.Character;
import obstacles.characters.player.Player;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirSkrytia je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže skryť postavu pred nepriateľmi.
 */
public class InvisibilityPotion extends Potion {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.CervenyList, Ingredients.List, Ingredients.Slivka, Ingredients.Ibogain};

    /**
     * Konštruktor pre ElixirSkrytia.
     *
     * @param name Názov elixíru.
     */
    public InvisibilityPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Použitie elixíru na postavu.
     * Nepriatelia nemôžu útočiť na postavu počas 5 sekúnd.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        Player player = (Player)character;
        player.getVybrataPostava().setStrength(0.0f, 5);
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String getPopisElixira() {
        return "Nepriatelia nemôžu útočiť na postavu počas 5 sekúnd.";
    }
}
