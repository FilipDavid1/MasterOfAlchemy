package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirObrany extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.DurmanObycajny, Ingrediencie.Fazula, Ingrediencie.Lekno};
    public ElixirObrany(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys obranu postavy
    }

    @Override
    public String popisElixira() {
        return "Zvýši obranu postavy o 10%.";
    }
}
