package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirMoci extends Elixir {

    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Ametist, Ingrediencie.Bufotenin, Ingrediencie.Zihlava};
    public ElixirMoci(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: zvys silu postavy
        postava.setSila(postava.getSila() * 1.1f);
    }

    @Override
    public String popisElixira() {
        return "Zvýši silu postavy o 10%.";
    }
}
