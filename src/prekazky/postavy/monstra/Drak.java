package prekazky.postavy.monstra;
import prekazky.postavy.Postava;
import prekazky.Strela;
import java.util.ArrayList;

public class Drak extends Postava {
    private Postava hrac;
    private ArrayList<Strela> strely;
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y);
        this.hrac = hrac;
        this.strely = new ArrayList<>();
    }

    @Override
    public void interakcia(Postava postava) {
//        postava.uberHp(10);
        this.strely.add(new Strela(super.getX(), super.getY(), 10));
    }

    public void tik() {
        super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));

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
        utocNaHraca();
    }

    public void utocNaHraca() {
        double vzdialenost = Math.sqrt(Math.pow(super.getX() - hrac.getX(), 2) + Math.pow(super.getY() - hrac.getY(), 2));
        if (vzdialenost < 200) {
            interakcia(hrac);
        }
    }

}
