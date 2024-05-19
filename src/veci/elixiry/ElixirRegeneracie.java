package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirRegeneracie je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže regenerovať zdravie postavy.
 */
public class ElixirRegeneracie extends Elixir {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Mrkva, Ingrediencie.Rohace, Ingrediencie.Sipky};

    /**
     * Konštruktor pre ElixirRegeneracie.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirRegeneracie(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Použitie elixíru na postavu.
     * Regeneruje 5 HP postavy na 5 sekúnd.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        Hrac hrac = (Hrac)postava;
        hrac.regenerujHp(5);
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
