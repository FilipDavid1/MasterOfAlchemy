package Prekazky.Postavy.Carodejnik;

import Mapa.Mapa;
import Prekazky.Postavy.OrientaciaPostavy;
import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Vec;
import fri.shapesge.Kruh;
import fri.shapesge.Obrazok;

public class Carodejnik extends Postava {
    private final Mapa mapa;
    private final Obrazok miniMapa;
    private final Kruh kruh;

    private Inventar inventar;
    public Carodejnik(int pocetObrazkov, String nazov, int x, int y, Mapa mapa) {
        super(pocetObrazkov, nazov, x, y);
        this.mapa = mapa;
        this.miniMapa = new Obrazok("/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Mapa/Obrazky/miniMap.png");
        this.miniMapa.zmenPolohu(0, 0);
        this.kruh = new Kruh();
        this.kruh.zmenPriemer(5);
        this.inventar = new Inventar();
    }

    //nefunguje treba opravit
    public void chodDole() {
        if (this.mapa.getY() == -1850 || super.getY() != 450) {
            super.posunNa(super.getX(), super.getY() + 10);
        }
        this.krok("Walk_South_");
        super.setOrientacia(OrientaciaPostavy.SOUTH);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.nastavPolohu("dole");
        }
    }

    public void chodHore() {
        if (this.mapa.getY() == 0 || super.getY() != 450) {
            super.posunNa(super.getX(), super.getY() - 10);
        }
        this.krok("Walk_North_");
        super.setOrientacia(OrientaciaPostavy.NORTH);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.nastavPolohu("hore");
        }
    }

    public void chodVlavo() {
        if (this.mapa.getX() == 0 || super.getX() != 725) {
            super.posunNa(super.getX() - 10, super.getY());

        }
        this.krok("Walk_West_");
        super.setOrientacia(OrientaciaPostavy.WEST);
        this.hybeSa();
        if (super.getX() == 725){
            this.mapa.nastavPolohu("vlavo");
        }
    }

    public void chodVpravo() {
        if (this.mapa.getX() == -2910 || super.getX() != 725) {
            super.posunNa(super.getX() + 10, super.getY());
        }
        this.krok("Walk_East_");
        super.setOrientacia(OrientaciaPostavy.EAST);
        this.hybeSa();
        if (super.getX() == 725) {
            this.mapa.nastavPolohu("vpravo");
        }
    }

    public void ukazMiniMapu() {
        this.miniMapa.zobraz();
        if (super.getX() == 725 && super.getY() == 450) {
            this.kruh.zmenPolohu(this.mapa.getMiniX() + 242, this.mapa.getMiniY()+150);
        } else {
            this.kruh.zmenPolohu(super.getX(), super.getY());
        }
        this.kruh.zobraz();

    }

    public void stop() {
        this.nehybeSa();
        this.miniMapa.skry();
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
            this.idleAnimacia(  super.getCestaKObrazku() + "Idle/Idle_" + super.getOrientacia() + "_");
        }
    }

    @Override
    public void krok(String imgName) {
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        obrazok.zmenObrazok(super.getCestaKObrazku() + "Walk/" + imgName + animacia + ".png");
    }

    @Override
    public void idleAnimacia(String imgNazov) {
        animacia++;
        if (animacia >= super.getPocetObrazkov()) {
            animacia = 0;
        }
        obrazok.zmenObrazok(  imgNazov + animacia + ".png");
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
}
