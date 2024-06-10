package things.potions;

import obstacles.characters.Character;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirMoci, ktorá rozširuje triedu Elixir.
 */
public class PowerPotion extends Potion {

    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.Ametist, Ingredients.Bufotenin, Ingredients.Zihlava};

    /**
     * Konštruktor pre triedu ElixirMoci.
     *
     * @param name Názov elixíru.
     */
    public PowerPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Zvýši silu postavy o 10%.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        character.setStrength(character.getStrength() * 1.1f);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String getPopisElixira() {
        return "Zvýši silu postavy o 10%.";
    }
}
