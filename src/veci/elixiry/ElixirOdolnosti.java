package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirOdolnosti extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Fencyklidin, Ingrediencie.Koren, Ingrediencie.Psilocybin};
    public ElixirOdolnosti(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zniz damage enemy
    }
}
