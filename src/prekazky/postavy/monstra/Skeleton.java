package prekazky.postavy.monstra;
import prekazky.postavy.Postava;

public class Skeleton extends Postava implements IMonstrum {
    private int pocetBarier;

    public Skeleton(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 10);
        this.pocetBarier = 3;
    }



    @Override
    public void interakcia(Postava postava) {
        if (this.jeBarieraAktivna() && this.pocetBarier < 10) {
            this.pocetBarier++;
        }
        postava.uberHp(super.getSila());
    }


    public void znicBarieru() {
        if (pocetBarier > 0) {
            pocetBarier--;
        }
    }

    public boolean jeBarieraAktivna() {
        return pocetBarier > 0;
    }

    public void tik() {
        if (super.getUtoci()) {
            super.attackAnimacia(super.getCestaKObrazku().replace("Idle/Idle_0", "Attack/Attack_"), 18);
        } else {
            super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
        }

    }

}
