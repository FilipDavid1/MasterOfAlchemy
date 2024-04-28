package prekazky.postavy.monstra;
import prekazky.postavy.Postava;
import prekazky.Strela;
import java.util.ArrayList;

public class Drak extends Postava {
    private Postava hrac;
    private ArrayList<Strela> strely;
    private boolean utoci = false;
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y);
        this.hrac = hrac;
        this.strely = new ArrayList<>();
    }

    @Override
    public void interakcia(Postava postava) {
        this.strely.add(new Strela(super.getX() + (super.getSirka() / 2), super.getY() + (super.getVyska() / 2), 10));
    }

    public void tik() {
        if (this.utoci) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 6);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    public void let() {
        ArrayList<Strela> strelyNaVymazanie = new ArrayList<>();
        for (Strela strela : strely) {
            strela.aktualizuj(this.hrac);
            if (strela.getDlzka() < 10) {
                this.hrac.uberHp(1);
                strelyNaVymazanie.add(strela);
                strela.skry();
            }
        }
        this.strely.removeAll(strelyNaVymazanie);
    }

    public void utok() {
        double vzdialenost = Math.sqrt(Math.pow(super.getX() - hrac.getX(), 2) + Math.pow(super.getY() - hrac.getY(), 2));
        if (vzdialenost < 200) {
            interakcia(hrac);
            this.utoci = true;
        } else {
            this.utoci = false;
        }
    }

}
