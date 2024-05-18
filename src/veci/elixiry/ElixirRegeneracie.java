package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

public class ElixirRegeneracie extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Mrkva, Ingrediencie.Rohace, Ingrediencie.Sipky};
    public ElixirRegeneracie(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: regeneruj 5hp postavy na 5 sekund
        Hrac hrac = (Hrac)postava;
        hrac.regenerujHp(5);
    }

    @Override
    public String popisElixira() {
        return "Regeneruje 5HP postavy na 5 sekúnd.";
    }
}
