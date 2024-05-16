package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

public class Hribik extends StrelecMonstrum {
    public Hribik(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 3, hrac, 8);
    }

    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("0", ""), 11);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() , super.getY() , 10, "resources/Obrazky/strela/Hribik"));
    }
}
