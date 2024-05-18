package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencie;

public class ElixirObnovenia extends Elixir {
    private static final Ingrediencie[] POTREBNE_INGREDIENCIE = {Ingrediencie.Balvany, Ingrediencie.Cernice, Ingrediencie.Dimethyltryptamin};
    public ElixirObnovenia(String nazov) {
        super(nazov, POTREBNE_INGREDIENCIE);
    }

    @Override
    public void pouzi(Postava postava) {
        // TODO: obnov 20% zivotov postavy
        postava.pridajHp(postava.getHp() * 0.2f);
    }

    @Override
    public String popisElixira() {
        return "Obnoví 20% životov postavy.";
    }
}
