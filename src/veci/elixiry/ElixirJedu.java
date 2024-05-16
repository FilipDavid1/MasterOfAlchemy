package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

public class ElixirJedu extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.AmadamovyList, Ingrediencie.Ashwagandha, Ingrediencie.Obilie};

    public ElixirJedu(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: postava sa otravi
        Hrac hrac = (Hrac)postava;
        hrac.getVybrataPostava().otrav(10);
    }

}
