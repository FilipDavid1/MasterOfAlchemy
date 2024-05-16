package veci.elixiry;

import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.StylFontu;
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

    private final BlokTextu blokTextu;

    public Elixir(String nazov, Ingrediencie[] potrebneIngredience) {
        this.nazov = nazov;
        this.potrebneIngredience = potrebneIngredience;
        this.obrazok = new Obrazok("resources/Obrazky/Elixiry/" + nazov + ".png");
        this.data = new DataObrazku("resources/Obrazky/Elixiry/" + nazov + ".png");
        this.blokTextu = new BlokTextu(nazov);
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 7);
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

    public void zobrazText(int x, int y) {
        blokTextu.zmenPolohu(x, y);
        blokTextu.zobraz();
    }

    public void skry() {
        blokTextu.skry();
        this.obrazok.skry();
    }
}
