package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencie;

public class ElixirRychlosti extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Tekvica, Ingrediencie.TrojListok, Ingrediencie.ZmutovanaJahoda, Ingrediencie.HavajskaRuza};
    public ElixirRychlosti(String nazov, Ingrediencie[] potrebneIngredience) {
        super(nazov, potrebneIngredience);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys rychlost postavy
    }
}
