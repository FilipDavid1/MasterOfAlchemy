package prekazky.postavy.hrac;
import fri.shapesge.Obrazok;
import veci.elixiry.Elixir;
import veci.ingrediencie.Ingrediencia;
import veci.IVec;

import java.util.ArrayList;

public class Inventar<E extends IVec> {
    private ArrayList< E> veci;

    private Obrazok inventarObrazok;

    private Obrazok inventarElixiryObrazok;

    public Inventar() {
        this.veci = new ArrayList<>();
        this.inventarObrazok = new Obrazok("resources/Obrazky/Hrac/inventory.png");
        this.inventarElixiryObrazok = new Obrazok("resources/Obrazky/Hrac/inventory_potions.png");
        this.inventarElixiryObrazok.zmenPolohu(408, 700);
        this.inventarElixiryObrazok.zobraz();
        this.zobrazElixiry();
    }

    public void pridajVec(E vec) {
        this.veci.add(vec);
        this.zobrazElixiry();
    }

    public void odstranVec(IVec vec) {
        this.veci.remove(vec);
    }

    public void odstranVeci(ArrayList<String> veci) {
        for (String vec : veci) {
            for (E e : this.veci) {
                if (e.getNazov().equals(vec)) {
                    this.veci.remove(e);
                    break;
                }
            }
        }
    }

    public void zobrazElixiry() {
        ArrayList<E> elixiry = new ArrayList<>();
        for (E vec : this.veci) {
            if (vec instanceof Elixir) {
                elixiry.add(vec);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (i < elixiry.size()) {
                elixiry.get(i).getObrazok().zmenPolohu(410 + ((i + 1) * 55) - elixiry.get(i).getSirka(), 750);
                elixiry.get(i).getObrazok().zobraz();
            }
        }
    }

    public void zobrazIngrediencieVInventari() {
        this.inventarObrazok.zmenPolohu(500, 200);
        this.inventarObrazok.zobraz();

        for (int i = 0; i < this.veci.size(); i++) {
            if ((this.veci.get(i) instanceof Ingrediencia ingrediencia)) {
                //inventar ma 6 stlpcov a 5 riadkov
                if (i == 0 || i == 6 || i == 12 || i == 18 || i == 24) {
                    ingrediencia.setX(530, ingrediencia.getObrazok(), ingrediencia.getBlokTextu());
                } else {
                    ingrediencia.setX(530 + (i % 6) * 60, ingrediencia.getObrazok(), ingrediencia.getBlokTextu());
                }
                ingrediencia.setY(230 + (i / 6) * 60, ingrediencia.getObrazok(), ingrediencia.getBlokTextu());
            }
        }
    }

    public void skryIngrediencieSInventara() {
        this.inventarObrazok.skry();
        for (E vec : this.veci) {
            if ((vec instanceof Ingrediencia ingrediencia)) {
                ingrediencia.skry();

            }
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

    public ArrayList<E> getVeciList() {
        return this.veci;
    }
}
