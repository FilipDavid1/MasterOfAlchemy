package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirJedu, ktorá rozširuje triedu Elixir.
 */
public class ElixirJedu extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.AmadamovyList, Ingrediencie.Ashwagandha, Ingrediencie.Obilie};

    /**
     * Konštruktor pre triedu ElixirJedu.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirJedu(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Otrávi vybranú postavu na 10 sekúnd.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        Hrac hrac = (Hrac)postava;
        hrac.getVybrataPostava().otrav(10);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String popisElixira() {
        return "Otrávi vybranú postavu na 10 sekúnd.";
    }
}
