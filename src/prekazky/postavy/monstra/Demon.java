package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

public class Demon extends Postava implements IMonstrum {
    private Postava hrac;

    public Demon(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y);
        this.hrac = hrac;
    }

    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        int nahoda = rand.nextInt(100);
        if (nahoda <= 15) {
            postava.uberHp(15);
            postava.oslabenie(2);
            System.out.println("Demon oslabuje hraca");
        } else if (nahoda <= 50) {
            postava.uberHp(10);
            postava.oslabenie(1);
            System.out.println("Demon oslabuje hraca");
        } else {
            postava.uberHp(5);
        }
    }

    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("demon_idle_0", "Attack/demon_cleave_"), 15);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
        if (!super.jeZivy()) {
            this.hrac.oslabenie(0);
        }

    }
}
