package prekazky;

import fri.shapesge.Kruh;
import prekazky.postavy.Postava;

import static java.lang.Math.sqrt;

public class Strela {
    private float x; // Poloha strely
    private float y; // Poloha strely
    private float rychlost; // Rýchlosť strely

    private double dlzka;

    private Kruh kruh; // Obrazok strely

    // Konštruktor pre strelu
    public Strela(float x, float y, float rychlost) {
        this.x = x;
        this.y = y;
        this.rychlost = rychlost;
        this.kruh = new Kruh();
        this.kruh.zmenPriemer(10);
        this.kruh.zmenPolohu((int)x, (int)y);
    }

    // Metóda na aktualizáciu polohy strely
    public void aktualizuj(Postava hrac) {
        // Vypočítaj vektor medzi strelou a hráčom
        float dx = hrac.getX() - x;
        float dy = hrac.getY() - y;
        this.dlzka = sqrt(dx * dx + dy * dy);

        // Normalizuj vektor na dĺžku 1
        double normDx = dx / dlzka;
        double normDy = dy / dlzka;

        // Aktualizuj polohu strely
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


