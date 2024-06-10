package things.potions;

import obstacles.characters.Character;
import obstacles.characters.player.Player;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirOdolnosti, ktorá rozširuje triedu Elixir.
 */
public class ResistancePotion extends Potion {

    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.Fencyklidin, Ingredients.Koren, Ingredients.Psilocybin};

    /**
     * Konštruktor pre triedu ElixirOdolnosti.
     *
     * @param name Názov elixíru.
     */
    public ResistancePotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Zníži silu vybranej postavy o 10%.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        Player player = (Player)character;
        player.getVybrataPostava().setStrength(player.getVybrataPostava().getStrength() * 0.9f);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String getPopisElixira() {
        return "Zníži silu nepriateľa o 10%.";
    }
}
