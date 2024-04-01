package Prekazky.Postavy.Carodejnik;

import Veci.Ingrediencie.Ingrediencia;
import Veci.Vec;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventar {
    private HashMap<String, Vec> veci;

    public Inventar() {
        this.veci = new HashMap<>();
    }

    public void pridajVec(Vec vec) {
        this.veci.put(vec.getNazov(), vec);
    }

    public void odstranVec(Vec vec) {
        this.veci.remove(vec);
    }

    public void odstranVeci(ArrayList<Ingrediencia> veci) {
        for (Vec vec : veci) {
            this.odstranVec(vec);
        }
    }

    public Vec getVec(Vec vec) {
        return this.veci.get(vec.getNazov());
    }

    public boolean obsahujeVec(Vec vec) {
        return this.veci.containsKey(vec.getNazov());
    }
}
