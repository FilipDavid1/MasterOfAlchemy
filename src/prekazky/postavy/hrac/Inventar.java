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

    private Elixir[] elixiry;


    public Inventar() {
        this.veci = new ArrayList<>();
        this.inventarObrazok = new Obrazok("resources/Obrazky/Hrac/inventory.png");
        this.inventarElixiryObrazok = new Obrazok("resources/Obrazky/Hrac/inventory_potions.png");
        this.inventarElixiryObrazok.zmenPolohu(408, 750);
        this.inventarElixiryObrazok.zobraz();
        this.elixiry = new Elixir[10];
        this.zobrazElixiry();
    }

    public void pridajVec(E vec) {
        if (vec instanceof Elixir) {
            for (int i = 0; i < this.elixiry.length; i++) {
                if (this.elixiry[i] == null) {
                    this.elixiry[i] = (Elixir)vec;
                    break;
                }
            }
        } else {
            this.veci.add(vec);
        }
        this.zobrazElixiry();
    }

    public void odstranVec(IVec vec) {
        if (vec instanceof Elixir) {
            for (int i = 0; i < this.elixiry.length; i++) {
                if (this.elixiry[i] == vec) {
                    this.elixiry[i] = null;
                    break;
                }
            }
        } else {
            this.veci.remove(vec);
        }
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
        int zaciatokX = 450;
        int medzera = 60;

        for (int i = 0; i < 10; i++) {
            if (i < elixiry.length && elixiry[i] != null) {
                int poziciaX = zaciatokX + i * medzera;
                elixiry[i].getObrazok().zmenPolohu(poziciaX, 790);
                elixiry[i].zobrazText(poziciaX - 15, 830);
                elixiry[i].getObrazok().zobraz();
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

    public void pouziElixir(int index, Hrac hrac) {
        if (index < this.elixiry.length && this.elixiry[index] != null) {
            System.out.println(index);
            this.elixiry[index].pouzi(hrac);
            this.elixiry[index].skry();
            this.elixiry[index] = null;  // Odstráni elixír zo zoznamu po jeho použití
        }
    }
}
