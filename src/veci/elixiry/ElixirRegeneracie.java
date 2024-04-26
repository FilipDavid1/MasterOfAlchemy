package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirRegeneracie extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Mrkva, Ingrediencie.Rohace, Ingrediencie.Sipky};
    public ElixirRegeneracie(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: regeneruj 5hp postavy na 5 sekund
    }
}
