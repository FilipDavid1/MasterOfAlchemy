package Prekazky.Postavy.Monstra;

import Prekazky.Postavy.Postava;

public class Drak extends Postava {
    private Postava hrac;
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y);
        this.hrac = hrac;
    }

    @Override
    public void interakcia(Postava postava) {
        postava.uberHp(10);
    }

    public void tik() {
        super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));

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
