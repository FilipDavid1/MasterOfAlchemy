package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirOdolnosti, ktorá rozširuje triedu Elixir.
 */
public class ElixirOdolnosti extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Fencyklidin, Ingrediencie.Koren, Ingrediencie.Psilocybin};

    /**
     * Konštruktor pre triedu ElixirOdolnosti.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirOdolnosti(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Zníži silu vybranej postavy o 10%.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        Hrac hrac = (Hrac)postava;
        hrac.getVybrataPostava().setSila(hrac.getVybrataPostava().getSila() * 0.9f);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String popisElixira() {
        return "Zníži silu nepriateľa o 10%.";
    }
}
