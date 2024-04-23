package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencie;

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
