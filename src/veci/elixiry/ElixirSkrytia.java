package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirSkrytia je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže skryť postavu pred nepriateľmi.
 */
public class ElixirSkrytia extends Elixir {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.CervenyList, Ingrediencie.List, Ingrediencie.Slivka, Ingrediencie.Ibogain};

    /**
     * Konštruktor pre ElixirSkrytia.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirSkrytia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Použitie elixíru na postavu.
     * Nepriatelia nemôžu útočiť na postavu počas 5 sekúnd.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        Hrac hrac = (Hrac)postava;
        hrac.getVybrataPostava().setSila(0.0f, 5);
    }

    /**
     * Popis elixíru.
     *
     * @return String, ktorý popisuje, čo elixír robí.
     */
    @Override
    public String popisElixira() {
        return "Nepriatelia nemôžu útočiť na postavu počas 5 sekúnd.";
    }
}
