package Veci.Elixiry;

import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Ingrediencie.Ingrediencie;
import Veci.Vec;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

public abstract class Elixir implements Vec {

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
