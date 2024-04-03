package Svet;

import Mapa.Lokalita;

public class Svet {
    public Svet() {
        Lokalita[] lokality = new Lokalita[9];
        for (int i = 0; i < 9; i++) {
            int x = (i % 3) * 1450;
            int y = (i / 3) * 900;
            lokality[i] = new Lokalita("Lokalita " + (i + 1), "popis", x, y);
        }
    }
}
