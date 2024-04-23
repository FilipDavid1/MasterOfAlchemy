package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencie;

public class ElixirSkrytia extends Elixir {
private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.CervenyList, Ingrediencie.List, Ingrediencie.Slivka, Ingrediencie.Ibogain};
    public ElixirSkrytia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: enemy nemozu utocit na postavu 5s
    }
}
