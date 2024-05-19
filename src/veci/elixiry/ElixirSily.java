package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirSily je podtriedou triedy Elixir.
 * Reprezentuje elixír, ktorý môže zvýšiť silu postavy.
 */
public class ElixirSily extends Elixir {
    // Definícia potrebných ingrediencií pre tento elixír
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.SojoveBoby, Ingrediencie.Lisohlavky, Ingrediencie.Gastany};

    /**
     * Konštruktor pre ElixirSily.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirSily(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Použitie elixíru na postavu.
     * Zvýši silu postavy o 20%.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        postava.setSila(postava.getSila() + 0.2f);
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
