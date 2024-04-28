package prekazky;

import fri.shapesge.Kruh;
import prekazky.postavy.Postava;

import static java.lang.Math.sqrt;

public class Strela {
    private float x;
    private float y;
    private float rychlost;

    private double dlzka;

    private Kruh kruh;

    public Strela(float x, float y, float rychlost) {
        this.x = x;
        this.y = y;
        this.rychlost = rychlost;
        this.kruh = new Kruh();
        this.kruh.zmenPriemer(10);
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
}


