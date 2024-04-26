package prekazky.postavy.hrac;

import veci.ingrediencie.Ingrediencia;
import veci.IVec;

import java.util.ArrayList;

public class Inventar<E extends IVec> {
    private ArrayList< E> veci;

    public Inventar() {
        this.veci = new ArrayList<>();
    }

    public void pridajVec(E vec) {
        this.veci.add(vec);
    }

    public void odstranVec(IVec vec) {
        this.veci.remove(vec);
    }

    public void odstranVeci(ArrayList<Ingrediencia> veci) {
        for (IVec vec : veci) {
            this.odstranVec(vec);
        }
    }

    public IVec getVec(String vec) {
        for (E e : veci) {
            if (e.getNazov().equals(vec)) {
                return e;
            }
        }
        return null;
    }

    public boolean obsahujeVec(IVec vec) {
        return this.veci.contains(vec);
    }

    public void getVeci() {
        for (IVec vec : veci) {
            System.out.println(vec.getNazov());
        }
    }
}
