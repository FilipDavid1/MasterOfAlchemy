package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

public class Mag extends Postava implements IMonstrum {
    public Mag(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 0);
    }

    @Override
    public void interakcia(Postava postava) {
        Random rand = new Random();
        postava.otrav((rand.nextInt(3) + 1), rand.nextInt(5));
    }


    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 8);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }
}
