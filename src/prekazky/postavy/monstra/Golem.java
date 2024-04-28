package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

public class Golem extends Postava {
    private Postava hrac;
    public Golem(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y);
        this.hrac = hrac;
    }

    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        int nahoda = rand.nextInt(100);
        if (nahoda <= 10) {
            postava.uberHp(10);
        } else {
            postava.uberHp(5);
        }
    }

    public void tik() {
        super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
    }

    public void utok() {
        double vzdialenost = Math.sqrt(Math.pow(super.getX() - hrac.getX(), 2) + Math.pow(super.getY() - hrac.getY(), 2));
        if (vzdialenost < 200) {
            interakcia(hrac);
        }
    }
}
