package things.potions;

import obstacles.characters.Character;
import obstacles.characters.player.Player;
import things.ingredients.Ingredients;

/**
 * Trieda ElixirJedu, ktorá rozširuje triedu Elixir.
 */
public class PoisonPotion extends Potion {

    private static final Ingredients[] POTREBNE_INGREDIENTS = {Ingredients.AmadamovyList, Ingredients.Ashwagandha, Ingredients.Obilie};

    /**
     * Konštruktor pre triedu ElixirJedu.
     *
     * @param name Názov elixíru.
     */
    public PoisonPotion(String name) {
        super(name, POTREBNE_INGREDIENTS);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Otrávi vybranú postavu na 10 sekúnd.
     *
     * @param character Postava, na ktorú sa elixír použije.
     */
    @Override
    public void use(Character character) {
        Player player = (Player)character;
        player.getVybrataPostava().poison(10);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String getPopisElixira() {
        return "Otrávi vybranú postavu na 10 sekúnd.";
    }
}
