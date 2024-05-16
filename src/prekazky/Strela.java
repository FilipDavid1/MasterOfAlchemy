package prekazky;

import fri.shapesge.Obrazok;
import prekazky.postavy.Postava;

import static java.lang.Math.sqrt;

public class Strela {
    private float x;
    private float y;
    private final float rychlost;

    private double dlzka;

    private final Obrazok kruh;

    private int animacia = 0;

    private final String cestaKObrazku;

    public Strela(float x, float y, float rychlost, String cestaKObrazku) {
        this.x = x;
        this.y = y;
        this.rychlost = rychlost;
        this.cestaKObrazku = cestaKObrazku;
        this.kruh = new Obrazok(cestaKObrazku + "/tile000.png");
//        this.kruh.zmenPriemer(10);
        this.kruh.zmenPolohu((int)x, (int)y);
    }

    public void aktualizuj(Postava hrac) {
        float dx = hrac.getX() - x;
        float dy = hrac.getY() - y;
        this.dlzka = sqrt(dx * dx + dy * dy);

        double normDx = dx / dlzka;
        double normDy = dy / dlzka;

        x += normDx * rychlost;
        y += normDy * rychlost;
        this.kruh.zmenPolohu((int)x, (int)y);
        this.kruh.zobraz();
    }

    public double getDlzka() {
        return dlzka;
    }

    public void skry() {
        this.kruh.skry();
    }

    public void strelaAnimacia(int pocetObrazkov) {
        animacia++;
        if (animacia >= pocetObrazkov) {
            animacia = 0;
        }

        if (animacia < 10)  {
            this.kruh.zmenObrazok(this.cestaKObrazku + "/tile00" + animacia + ".png");
        } else {
            this.kruh.zmenObrazok(this.cestaKObrazku + "/tile0" + animacia + ".png");
        }

    }
}


