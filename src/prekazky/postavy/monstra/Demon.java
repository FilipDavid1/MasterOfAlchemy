package prekazky.postavy.monstra;

import prekazky.postavy.Postava;

import java.util.Random;

public class Demon extends Postava {
    private Postava hrac;

    private boolean utoci = false;
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
        if (this.utoci) {
            super.attackAnimacia(super.getCestaKObrazku().replace("demon_idle_0", "Attack/demon_cleave_"), 15);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }
        if (!super.jeZivy()) {
            this.hrac.oslabenie(0);
        }

    }

    public void utok() {
        double vzdialenost = Math.sqrt(Math.pow(super.getX() - hrac.getX(), 2) + Math.pow(super.getY() - hrac.getY(), 2));
        if (vzdialenost < 200) {
            interakcia(hrac);
            this.utoci = true;
        } else {
            this.utoci = false;
        }
    }

}