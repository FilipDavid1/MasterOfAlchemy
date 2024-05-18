package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirOzivenia je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže oživiť postavu.
 */
public class ElixirOzivenia extends Elixir {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.MuskatovyOrech, Ingrediencie.Plevel, Ingrediencie.StromovaHuba};

    /**
     * Konštruktor pre ElixirOzivenia.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirOzivenia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE );
    }

    /**
     * Použitie elixíru na postavu.
     * Ak je HP postavy menšie alebo rovné 0, pridá sa jej 100 HP.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        if (postava.getHp() <= 0) {
            postava.pridajHp(100);
        }
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String popisElixira() {
        return "Oživí postavu.";
    }
}
