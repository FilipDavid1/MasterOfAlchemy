package veci.elixiry;

import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import veci.ingrediencie.Ingrediencie;

public class ElixirSkrytia extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.CervenyList, Ingrediencie.List, Ingrediencie.Slivka, Ingrediencie.Ibogain};
    public ElixirSkrytia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: enemy nemozu utocit na postavu 5s
        Hrac hrac = (Hrac)postava;
        hrac.getVybrataPostava().setSila(0.0f, 5);
    }

    @Override
    public String popisElixira() {
        return "Nepriatelia nemôžu útočiť na postavu počas 5 sekúnd.";
    }
}
