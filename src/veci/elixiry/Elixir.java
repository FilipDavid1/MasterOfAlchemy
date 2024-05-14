package veci.elixiry;

import fri.shapesge.DataObrazku;
import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import veci.ingrediencie.Ingrediencie;
import veci.IVec;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

public abstract class Elixir implements IVec {

    private final String nazov;
    private final Ingrediencie[] potrebneIngredience;
    private final Obrazok obrazok;

    private final DataObrazku data;

    public Elixir(String nazov, Ingrediencie[] potrebneIngredience) {
        this.nazov = nazov;
        this.potrebneIngredience = potrebneIngredience;
        this.obrazok = new Obrazok("resources/Obrazky/Elixiry/" + nazov + ".png");
        this.data = new DataObrazku("resources/Obrazky/Elixiry/" + nazov + ".png");
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    public boolean mozemVyrobit(List<Ingrediencia> ingrediencie) {
        for (Ingrediencie ingrediencia : potrebneIngredience) {
            boolean nasla = false;
            for (Ingrediencia i : ingrediencie) {
                if (i.getIngredienciaEnum() == ingrediencia) {
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

    public ArrayList<String> getPotrebneIngredience() {
        return new ArrayList<String>() {{
                for (Ingrediencie i : potrebneIngredience) {
                    add(i.getNazov());
                }
            }};
    }

    @Override
    public int getSirka() {
        return data.getSirka();
    }
}
