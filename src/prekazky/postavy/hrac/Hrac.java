package prekazky.postavy.hrac;

import interakcie.Interakcia;
import mapa.Mapa;
import prekazky.postavy.OrientaciaPostavy;
import prekazky.postavy.Postava;
import prekazky.postavy.monstra.IMonstrum;
import prekazky.postavy.monstra.Skeleton;
import veci.elixiry.*;
import veci.ingrediencie.Ingrediencia;
import veci.IVec;
import fri.shapesge.Kruh;
import fri.shapesge.Manazer;

public class Hrac extends Postava {
    private final Mapa mapa;
    private final Kruh kruh;
    private Inventar inventar;
    private Interakcia interakcia;
    private Postava vybrataPostava;
    private int casRegeneracie;

    public Hrac(int pocetObrazkovIdle, String nazov, int x, int y, Mapa mapa, Manazer manazer) {
        super(pocetObrazkovIdle, nazov, x, y, 10);
        this.mapa = mapa;
        this.kruh = new Kruh();
        this.inventar = new Inventar();
        this.interakcia = new Interakcia(mapa, this.inventar, this);
        manazer.spravujObjekt(this.interakcia);
        this.vybrataPostava = null;


        //pridaj elixir moci
        this.inventar.pridajVec(new ElixirObnovenia("ElixirObnovenia"));
        this.inventar.pridajVec(new ElixirMoci("ElixirMoci"));
        this.inventar.pridajVec(new ElixirOdolnosti("ElixirOdolnosti"));
        this.inventar.pridajVec(new ElixirOzivenia("ElixirOzivenia"));
        this.inventar.pridajVec(new ElixirRegeneracie("ElixirRegeneracie"));
        this.inventar.pridajVec(new ElixirSkrytia("ElixirSkrytia"));
        this.inventar.pridajVec(new ElixirJedu("ElixirJedu"));


    }

    public void chodDole() {
        float targetY = super.getY() + 10;
        float newY = lerp(super.getY(), targetY, super.getSpeed());
        if (this.mapa.getY() <= -1840 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Down_");
        super.setOrientacia(OrientaciaPostavy.DOWN);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.setVelY(-5 * ( super.getSpeed()));
        }
    }

    public void chodHore() {
        float targetY = super.getY() - 10;
        float newY = lerp(super.getY(), targetY, super.getSpeed());
        if (this.mapa.getY() >= 0 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Up_");
        super.setOrientacia(OrientaciaPostavy.UP);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.setVelY(5 * ( super.getSpeed()));
        }
    }

    public void chodVlavo() {
        float targetX = super.getX() - 10;
        float newX = lerp(super.getX(), targetX, super.getSpeed());
        if (this.mapa.getX() >= 0 || super.getX() <= 725) {
            super.posunNa((int)newX, super.getY());
        }
        this.krok("Walk_Left_");
        super.setOrientacia(OrientaciaPostavy.LEFT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.mapa.setVelX(5 * ( super.getSpeed()));
        }
    }

    public void chodVpravo() {
        float targetX = super.getX() + 10;
        float newX = lerp(super.getX(), targetX, super.getSpeed());
        if (this.mapa.getX() <= -2910 || super.getX() <= 725) {
            super.posunNa((int)newX, super.getY());
        }
        this.krok("Walk_Right_");
        super.setOrientacia(OrientaciaPostavy.RIGHT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.mapa.setVelX(-5 * ( super.getSpeed()));
        }
    }


    public void stop() {
        this.nehybeSa();
        this.kruh.skry();
        this.inventar.skryIngrediencieSInventara();
    }

    public void nehybeSa() {
        super.setHybeSa(false);
    }

    public void hybeSa() {
        super.setHybeSa(true);
    }

    public void tik() {
        if (!super.getHybeSa()) {
            this.idleAnimacia(  super.getCestaKObrazku().replace("Down_0", "") + super.getOrientacia() + "_");
        }

        if (super.getCasOslabenia() > 0) {
            super.oslabenie((super.getCasOslabenia() / 1000) - 1);
        }

        if (casRegeneracie > 0) {
            if (casRegeneracie % 1000 == 0) {
                super.pridajHp(5);
            }
            casRegeneracie -= 200;
        }
    }

    public boolean vyrobElixir(Ingrediencia[] potrebneIngrediencie) {
        for (Ingrediencia i : potrebneIngrediencie) {
            if (!this.inventar.obsahujeVec(i)) {
                return false;
            }
        }
        return true;
    }

    public Inventar getInventar() {
        return this.inventar;
    }

    public void pridajVecDoInventara(IVec vec) {
        this.inventar.pridajVec(vec);
    }




    public void utocNaMonstra() {
        System.out.println(super.getSila());
        if (this.vybrataPostava != null) {
            double vzdialenost = Math.sqrt(Math.pow(vybrataPostava.getX() - this.getX(), 2) + Math.pow(vybrataPostava.getY() - this.getY(), 2));
            if (vzdialenost < 200) {
                this.interakcia(this.vybrataPostava);
            }
        }
    }

    public void vyberPostavu(Postava monstum) {
        this.vybrataPostava = monstum;
    }


    @Override
    public void interakcia(Postava postava) {
        if (postava instanceof IMonstrum ) {
            if (postava instanceof Skeleton skeleton) {
                if (!skeleton.jeBarieraAktivna()) {
                    postava.uberHp(super.getSila());
                } else {
                    skeleton.znicBarieru();
                }
            } else {
                postava.uberHp(super.getSila());
            }
            this.attackAnimacia(super.getCestaKObrazku().replace("/Idle/Idle_Down_0", "/Attack/Attack_") + super.getOrientacia() + "_", 6 );
        } else {
            postava.interakcia(this);
        }

    }

    private float lerp(float start, float end, float speed) {
        return start + speed * (end - start);
    }

    public void zobrazInventar() {
        this.inventar.zobrazIngrediencieVInventari();
    }

    public void pouziElixir1() {
        inventar.pouziElixir(0, this);
    }

    public void pouziElixir2() {
        inventar.pouziElixir(1, this);
    }

    public void pouziElixir3() {
        inventar.pouziElixir(2, this);
    }

    public void pouziElixir4() {
        inventar.pouziElixir(3, this);
    }

    public void pouziElixir5() {
        inventar.pouziElixir(4, this);
    }

    public void pouziElixir6() {
        inventar.pouziElixir(5, this);
    }

    public void pouziElixir7() {
        inventar.pouziElixir(6, this);
    }

    public void pouziElixir8() {
        inventar.pouziElixir(7, this);
    }

    public void pouziElixir9() {
        inventar.pouziElixir(8, this);
    }

    public void pouziElixir10() {
        inventar.pouziElixir(9, this);
    }


    public Postava getVybrataPostava() {
        return this.vybrataPostava;
    }

    public void regenerujHp(int sekundy) {
        this.casRegeneracie = sekundy * 1000;
    }
}