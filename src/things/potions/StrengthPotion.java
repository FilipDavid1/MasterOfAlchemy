package things.potions;

import obstacles.characters.Character;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirSily je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže zvýšiť silu postavy.
 */
public class StrengthPotion extends Potion {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.SojoveBoby, Ingredients.Lisohlavky, Ingredients.Gastany};

    /**
     * Konštruktor pre ElixirSily.
     *
     * @param name Názov elixíru.
     */
    public StrengthPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Použitie elixíru na postavu.
     * Zvýši silu postavy o 20%.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        character.setStrength(character.getStrength() + 0.2f);
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String getPopisElixira() {
        return "Zvýši silu postavy o 20%.";
    }
}
