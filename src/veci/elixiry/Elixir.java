package veci.elixiry;

import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import veci.ingrediencie.Ingrediencie;
import veci.IVec;
import fri.shapesge.Obrazok;

import java.util.List;

public abstract class Elixir implements IVec {

    private final String nazov;
    private final Ingrediencie[] potrebneIngredience;
    private final Obrazok obrazok;

    public Elixir(String nazov, Ingrediencie[] potrebneIngredience) {
        this.nazov = nazov;
        this.potrebneIngredience = potrebneIngredience;
        this.obrazok = new Obrazok("resources/Obrazky/Elixiry/" + nazov + ".png");
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    public boolean mozemVyrobit(List<Ingrediencia> ingrediencie) {
        for (Ingrediencie ingrediencia : potrebneIngredience) {
            boolean nasla = false;
            for (Ingrediencia i : ingrediencie) {
                if (i.getNazov().equals(ingrediencia.getNazov())) {
                    nasla = true;
                    break;
                }
            }
            if (!nasla) {
                return false;
            }
        }
        return true;
    }

    public Obrazok getObrazok() {
        return obrazok;
    }

    public abstract void pouzi(Postava postava);
}
