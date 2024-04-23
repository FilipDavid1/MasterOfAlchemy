package Veci.Elixiry;

import Veci.Ingrediencie.Ingrediencia;
import Veci.Vec;

import java.util.ArrayList;
import java.util.List;

public abstract class Elixir implements Vec {

    private final String nazov;
    private final ArrayList<Ingrediencia> potrebneIngredience;

    public Elixir(String nazov, ArrayList<Ingrediencia> potrebneIngredience) {
        this.nazov = nazov;
        this.potrebneIngredience = potrebneIngredience;
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    public boolean mozemVyrobit(List<Ingrediencia> ingrediencie) {
        for (Ingrediencia ingrediencia : potrebneIngredience) {
            if (!ingrediencie.contains(ingrediencia)) {
                return false;
            }
        }
        return true;
    }

    public abstract void pouzi();
}
