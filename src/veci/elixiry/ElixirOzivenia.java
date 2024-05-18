package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirOzivenia extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.MuskatovyOrech, Ingrediencie.Plevel, Ingrediencie.StromovaHuba};
    public ElixirOzivenia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE );
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: ak je postava mrtva, oziv ju
        if (postava.getHp() <= 0) {
            postava.pridajHp(100);
        }
    }

    @Override
    public String popisElixira() {
        return "Oživí postavu.";
    }
}
