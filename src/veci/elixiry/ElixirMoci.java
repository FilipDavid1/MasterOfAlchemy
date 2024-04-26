package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirMoci extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Ametist, Ingrediencie.Bufotenin, Ingrediencie.Zihlava};
    public ElixirMoci(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys silu postavy
    }
}
