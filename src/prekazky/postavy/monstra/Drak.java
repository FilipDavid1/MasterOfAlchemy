package prekazky.postavy.monstra;
import prekazky.postavy.Postava;
import prekazky.Strela;
import java.util.ArrayList;

public class Drak extends Postava implements IMonstrum {
    private Postava hrac;
    private ArrayList<Strela> strely;
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 1);
        this.hrac = hrac;
        this.strely = new ArrayList<>();
    }

    @Override
    public void interakcia(Postava postava) {
        this.strely.add(new Strela(super.getX() + (super.getSirka() / 2), super.getY() + (super.getVyska() / 2), 10, "resources/Obrazky/strela/Drak"));
    }

    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 6);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    public void let() {
        ArrayList<Strela> strelyNaVymazanie = new ArrayList<>();
        for (Strela strela : strely) {
            strela.aktualizuj(this.hrac);
            strela.idleAnimacia( 8);
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
}
