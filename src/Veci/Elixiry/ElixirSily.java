package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencie;

public class ElixirSily extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.SojoveBoby, Ingrediencie.Lisohlavky, Ingrediencie.Gastany};
    public ElixirSily(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys silu postavy
    }
}
