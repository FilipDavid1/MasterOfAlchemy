package things.potions;

import obstacles.characters.Character;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirObnovenia, ktorá rozširuje triedu Elixir.
 */
public class RestorationPotion extends Potion {
    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.Balvany, Ingredients.Cernice, Ingredients.Dimethyltryptamin};

    /**
     * Konštruktor pre triedu ElixirObnovenia.
     *
     * @param name Názov elixíru.
     */
    public RestorationPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Obnoví 20% životov postavy.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        character.addHp(character.getHp() * 0.2f);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String getPopisElixira() {
        return "Obnoví 20% životov postavy.";
    }
}
