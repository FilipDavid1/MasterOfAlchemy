package things.potions;

import obstacles.characters.Character;
import obstacles.characters.player.Player;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirRegeneracie je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže regenerovať zdravie postavy.
 */
public class RegenerationPotion extends Potion {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.Mrkva, Ingredients.Rohace, Ingredients.Sipky};

    /**
     * Konštruktor pre ElixirRegeneracie.
     *
     * @param name Názov elixíru.
     */
    public RegenerationPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Použitie elixíru na postavu.
     * Regeneruje 5 HP postavy na 5 sekúnd.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        Player player = (Player)character;
        player.regenerujHp(5);
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String getPopisElixira() {
        return "Regeneruje 5HP postavy na 5 sekúnd.";
    }
}
