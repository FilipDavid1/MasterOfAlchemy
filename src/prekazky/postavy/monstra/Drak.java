package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

public class Drak extends StrelecMonstrum {
    public Drak(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 1, hrac, 8);
    }

    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 6);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() + 10, super.getY() + 20, 10, "resources/Obrazky/strela/Drak"));
    }
}
