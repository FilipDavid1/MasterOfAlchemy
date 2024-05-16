package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

public class Goblin extends StrelecMonstrum {
    public Goblin(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku, x, y, 1, hrac, 19);
//        super.posunHpBar(x + 5, y + 20);
    }

    @Override
    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("0", ""), 12);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
    }

    @Override
    public void interakcia(Postava postava) {
        super.pridajStrelu(new Strela(super.getX() - 10, super.getY() - 15, 8, "resources/Obrazky/strela/Goblin"));
    }
}
