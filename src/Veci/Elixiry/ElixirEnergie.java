package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Ingrediencie.Ingrediencie;
import fri.shapesge.Obrazok;

import java.util.ArrayList;

public class ElixirEnergie extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.AmadamovyList, Ingrediencie.Ashwagandha, Ingrediencie.Obilie};

    public ElixirEnergie(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys rychlost postavy na urcity cas
    }

}
