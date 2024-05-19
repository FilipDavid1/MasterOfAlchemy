package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

/**
 * Trieda ElixirObnovenia, ktorá rozširuje triedu Elixir.
 */
public class ElixirObnovenia extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Balvany, Ingrediencie.Cernice, Ingrediencie.Dimethyltryptamin};

    /**
     * Konštruktor pre triedu ElixirObnovenia.
     *
     * @param nazov Názov elixíru.
     */
    public ElixirObnovenia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    /**
     * Metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Obnoví 20% životov postavy.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    @Override
    public void pouzi(Postava postava) {
        postava.pridajHp(postava.getHp() * 0.2f);
    }

    /**
     * Metóda popisElixira, ktorá vráti popis elixíru.
     *
     * @return String Popis elixíru.
     */
    @Override
    public String getPopisElixira() {
        return "Obnoví 20% životov postavy.";
    }
}
