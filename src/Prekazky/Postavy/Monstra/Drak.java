package Prekazky.Postavy.Monstra;

import Prekazky.Postavy.Postava;

public class Drak extends Postava {
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y) {
        super(pocetObrazkov, cestaKObrazku, x, y);
    }

    @Override
    public void utok(Postava postava) {
        postava.uberHp(10);
    }

    public void tik() {
        super.idleAnimacia(super.getCestaKObrazku() + "Attack/Attack_");
    }


}
