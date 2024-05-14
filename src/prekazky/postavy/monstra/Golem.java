package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

public class Golem extends Postava implements IMonstrum {
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
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/idle_0", "Attack/Attack_"), 14);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

}
