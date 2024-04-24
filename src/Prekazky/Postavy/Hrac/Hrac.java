package Prekazky.Postavy.Hrac;

import Interakcie.Interakcia;
import Mapa.Mapa;
import Prekazky.HernyObjekt;
import Prekazky.Postavy.Monstra.Drak;
import Prekazky.Postavy.OrientaciaPostavy;
import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Vec;
import fri.shapesge.Kruh;
import fri.shapesge.Manazer;
import fri.shapesge.Obrazok;

public class Hrac extends Postava {
    private final Mapa mapa;
    private final Kruh kruh;
    private Inventar inventar;
    private float speed = 0.7f;

    private Interakcia interakcia;

    public Hrac(int pocetObrazkovIdle, int pocetObrazkovWalk, String nazov, int x, int y, Mapa mapa, Manazer manazer) {
        super(pocetObrazkovIdle, nazov, x, y);
        this.mapa = mapa;
        this.kruh = new Kruh();
        this.inventar = new Inventar();
        this.interakcia = new Interakcia(mapa, this.inventar);
        manazer.spravujObjekt(this.interakcia);
    }

    public void chodDole() {
        float targetY = super.getY() + 10; // Cieľová pozícia.
        float newY = lerp(super.getY(), targetY, speed); // Vypočíta novú pozíciu.
        if (this.mapa.getY() == -1850 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Down_");
        super.setOrientacia(OrientaciaPostavy.DOWN);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.nastavPolohu("dole", speed);
        }
    }

    public void chodHore() {
        float targetY = super.getY() - 10; // Cieľová pozícia.
        float newY = lerp(super.getY(), targetY, speed); // Vypočít
        if (this.mapa.getY() == 0 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Up_");
        super.setOrientacia(OrientaciaPostavy.UP);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.nastavPolohu("hore", speed);
        }
    }

    public void chodVlavo() {
        float targetX = super.getX() - 10; // Cieľová pozícia.
        float newX = lerp(super.getX(), targetX, speed); // Vypočít
        if (this.mapa.getX() == 0 || super.getX() != 725) {
            super.posunNa((int)newX, super.getY());

        }
        this.krok("Walk_Left_");
        super.setOrientacia(OrientaciaPostavy.LEFT);
        this.hybeSa();
        if (super.getX() == 725){
            this.mapa.nastavPolohu("vlavo", speed);
        }
    }

    public void chodVpravo() {
        float targetX = super.getX() + 10; // Cieľová pozícia.
        float newX = lerp(super.getX(), targetX, speed); // Vypočít
        if (this.mapa.getX() == -2910 || super.getX() != 725) {
            super.posunNa((int)newX, super.getY());
        }
        this.krok("Walk_Right_");
        super.setOrientacia(OrientaciaPostavy.RIGHT);
        this.hybeSa();
        if (super.getX() == 725) {
            this.mapa.nastavPolohu("vpravo", speed);
        }
    }


    public void stop() {
        this.nehybeSa();
        this.kruh.skry();
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

    public void pridajVecDoInventara(Vec vec) {
        this.inventar.pridajVec(vec);
    }




    public void utocNaMonstra() {
        Drak najblizsieMonstrum = najdiNajblizsieMonstrum();
        if (najblizsieMonstrum != null) {
            utok(najblizsieMonstrum);
        }
    }



    private Drak najdiNajblizsieMonstrum() {
        Drak najblizsieMonstrum = null;
        double najkratsiaVzdialenost = Double.MAX_VALUE;
        this.mapa.vymazMrtvePrekazky();
        for (HernyObjekt objekt : mapa.getPrekazky()) {
            if (objekt instanceof Drak) {
                Drak drak = (Drak) objekt;
                double vzdialenost = Math.sqrt(Math.pow(super.getX() - drak.getX(), 2) + Math.pow(super.getY() - drak.getY(), 2));

                if (vzdialenost < najkratsiaVzdialenost) {
                    najblizsieMonstrum = drak;
                    najkratsiaVzdialenost = vzdialenost;
                }
            }
        }

        return najblizsieMonstrum;
    }




    private float lerp(float start, float end, float speed) {
        return start + speed * (end - start);
    }

    @Override
    public void utok(Postava postava) {
        //attack animation
        postava.uberHp(10);

        this.attackAnimacia(super.getCestaKObrazku().replace("/Idle/Idle_Down_0", "/Attack/Attack_") + super.getOrientacia() + "_", 6 );
    }


}