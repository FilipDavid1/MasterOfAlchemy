package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirMoci, ktorá rozširuje triedu Elixir.
 */
public class ElixirMoci extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Ametist, Ingrediencie.Bufotenin, Ingrediencie.Zihlava};

    /**
     * Konštruktor pre triedu ElixirMoci.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirMoci(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Zvýši silu postavy o 10%.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        postava.setSila(postava.getSila() * 1.1f);
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
