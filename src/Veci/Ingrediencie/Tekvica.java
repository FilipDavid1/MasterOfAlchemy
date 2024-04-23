package Veci.Ingrediencie;

import fri.shapesge.Obrazok;

public class Tekvica extends Ingrediencia {


    public Tekvica(int x, int y) {
        super("resources/Obrazky/Ingrediencie/Black.png", x, y);
    }

    @Override
    public String getNazov() {
        return "Tekvica";
    }

    @Override
    public int getCena() {
        return 10;
    }
}
