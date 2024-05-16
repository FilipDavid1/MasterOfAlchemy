package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

import java.util.ArrayList;


public abstract class StrelecMonstrum extends Postava implements IMonstrum {

    private Postava hrac;
    private ArrayList<Strela> strely;

    private int pocetObrazkovStrely;

    public StrelecMonstrum(int pocetObrazkov, String cestaKObrazku, int x, int y, int sila, Postava hrac, int pocetObrazkovStrely) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, sila);
        this.hrac = hrac;
        this.strely = new ArrayList<>();
        this.pocetObrazkovStrely = pocetObrazkovStrely;
    }

    public abstract void tik();

    public void let() {
        ArrayList<Strela> strelyNaVymazanie = new ArrayList<>();
        for (Strela strela : strely) {
            strela.aktualizuj(this.hrac);
            strela.strelaAnimacia( this.pocetObrazkovStrely);
            if (strela.getDlzka() < 10) {
                this.hrac.uberHp(super.getSila());
                strelyNaVymazanie.add(strela);
                strela.skry();
            }
        }
        this.strely.removeAll(strelyNaVymazanie);
    }

    public void zmazStrely() {
        for (Strela strela : strely) {
            strela.skry();
        }
        this.strely.clear();
    }

    public void pridajStrelu(Strela strela) {
        this.strely.add(strela);
    }
}
