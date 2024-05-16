package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirEnergie extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.AmadamovyList, Ingrediencie.Ashwagandha, Ingrediencie.Obilie};

    public ElixirEnergie(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys rychlost postavy na urcity cas
        postava.setSpeed(postava.getSpeed() * 1.1f);
    }

}
