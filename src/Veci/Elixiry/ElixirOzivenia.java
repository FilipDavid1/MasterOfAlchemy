package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencie;

public class ElixirOzivenia extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.MuskatovyOrech, Ingrediencie.Plevel, Ingrediencie.StromovaHuba};
    public ElixirOzivenia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE );
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: ak je postava mrtva, oziv ju
    }
}
