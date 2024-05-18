package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirSily extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.SojoveBoby, Ingrediencie.Lisohlavky, Ingrediencie.Gastany};
    public ElixirSily(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys silu postavy
        postava.setSila(postava.getSila() + 0.2f);
    }

    @Override
    public String popisElixira() {
        return "Zvýši silu postavy o 20%.";
    }
}
