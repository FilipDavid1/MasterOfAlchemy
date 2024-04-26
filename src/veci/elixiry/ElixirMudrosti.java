package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirMudrosti extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Ayahuasca, Ingrediencie.JavorovyList, Ingrediencie.Semienka, Ingrediencie.Lopuch};
    public ElixirMudrosti(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: Implement this method
    }
}
