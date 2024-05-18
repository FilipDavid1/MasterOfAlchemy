package prekazky.postavy.monstra;

import prekazky.Strela;
import prekazky.postavy.Postava;

import java.util.ArrayList;

/**
 * Abstraktná trieda StrelecMonstrum, ktorá rozširuje triedu Postava a implementuje rozhranie IMonstrum.
 */
public abstract class StrelecMonstrum extends Postava implements IMonstrum {

    private final Postava hrac;
    private ArrayList<Strela> strely;
    private final int pocetObrazkovStrely;

    /**
     * Konštruktor pre triedu StrelecMonstrum.
     *
     * @param pocetObrazkov Počet obrázkov pre animáciu.
     * @param cestaKObrazku Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param sila Sila postavy.
     * @param hrac Referencia na hráča.
     * @param pocetObrazkovStrely Počet obrázkov pre animáciu strely.
     */
    public StrelecMonstrum(int pocetObrazkov, String cestaKObrazku, int x, int y, int sila, Postava hrac, int pocetObrazkovStrely) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, sila);
        this.hrac = hrac;
        this.strely = new ArrayList<>();
        this.pocetObrazkovStrely = pocetObrazkovStrely;
    }

    /**
     * Abstraktná metóda tik, ktorá sa volá v každom tiku hry.
     */
    public abstract void tik();

    /**
     * Metóda let, ktorá aktualizuje strelu a vykonáva animáciu strely.
     * Ak je dĺžka strely menšia ako 10, odoberie HP hráčovi a skryje strelu.
     */
    public void let() {
        ArrayList<Strela> strelyNaVymazanie = new ArrayList<>();
        for (Strela strela : strely) {
            strela.aktualizuj(this.hrac);
            strela.strelaAnimacia( this.pocetObrazkovStrely);
            if (strela.getDlzka() < 10) {
                this.hrac.uberHp(super.getSila());
                strelyNaVymazanie.add(strela);
                strela.skry();
            }
        }
        this.strely.removeAll(strelyNaVymazanie);
    }

    /**
     * Metóda zmazStrely, ktorá skryje všetky strely a vymaže ich zo zoznamu.
     */
    public void zmazStrely() {
        for (Strela strela : strely) {
            strela.skry();
        }
        this.strely.clear();
    }

    /**
     * Metóda pridajStrelu, ktorá pridá strelu do zoznamu striel.
     *
     * @param strela Strela, ktorá sa má pridať do zoznamu.
     */
    public void pridajStrelu(Strela strela) {
        this.strely.add(strela);
    }
}
