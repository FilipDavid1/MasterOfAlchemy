package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirOdstraneniaKliadby extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Hrach, Ingrediencie.LieskovyOrech, Ingrediencie.Salvia, Ingrediencie.PeyotiKaktus};
    public ElixirOdstraneniaKliadby(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: neuber prve 2 utoky
    }
}
