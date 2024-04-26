package prekazky.postavy.hrac;

import veci.ingrediencie.Ingrediencia;
import veci.Vec;

import java.util.ArrayList;

public class Inventar<E extends Vec> {
    private ArrayList< E> veci;

    public Inventar() {
        this.veci = new ArrayList<>();
    }

    public void pridajVec(E vec) {
        this.veci.add(vec);
    }

    public void odstranVec(Vec vec) {
        this.veci.remove(vec);
    }

    public void odstranVeci(ArrayList<Ingrediencia> veci) {
        for (Vec vec : veci) {
            this.odstranVec(vec);
        }
    }

    public Vec getVec(String vec) {
        for (E e : veci) {
            if (e.getNazov().equals(vec)) {
                return e;
            }
        }
        return null;
    }

    public boolean obsahujeVec(Vec vec) {
        return this.veci.contains(vec);
    }

    public void getVeci() {
        for (Vec vec : veci) {
            System.out.println(vec.getNazov());
        }
    }
}
