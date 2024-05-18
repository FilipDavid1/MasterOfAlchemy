package veci.ingrediencie;

import prekazky.HernaEntita;
import veci.IVec;
import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

/**
 * Trieda Ingrediencia je podtriedou triedy HernaEntita a implementuje rozhranie IVec.
 * Reprezentuje ingredienciu, ktorá sa môže použiť v hre.
 */
public class Ingrediencia extends HernaEntita implements IVec {

    private final Obrazok obrazok;
    private final String nazov;
    private final DataObrazku dataObrazku;
    private final BlokTextu blokTextu;
    private final Ingrediencie ingredienciaEnum;

    /**
     * Konštruktor pre Ingredienciu.
     *
     * @param nazov Názov ingrediencie.
     * @param x X-ová súradnica polohy ingrediencie.
     * @param y Y-ová súradnica polohy ingrediencie.
     */
    public Ingrediencia(String nazov, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        super.setX(x);
        super.setY(y);
        this.nazov = nazov;
        this.dataObrazku = new DataObrazku("resources/Obrazky/Ingrediencie/" + nazov + ".png");
        this.blokTextu = new BlokTextu(nazov);
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenPolohu(x, y - 10);
        this.blokTextu.zobraz();
        this.ingredienciaEnum = Ingrediencie.valueOf(nazov);
    }

    /**
     * Získa názov ingrediencie.
     *
     * @return Názov ingrediencie.
     */
    @Override
    public String getNazov() {
        return this.nazov;
    }

    /**
     * Získa obrázok ingrediencie.
     *
     * @return Obrázok ingrediencie.
     */
    @Override
    public Obrazok getObrazok() {
        return obrazok;
    }

    /**
     * Skryje ingredienciu.
     */
    public void skry() {
        obrazok.skry();
        blokTextu.skry();
    }

    /**
     * Získa výšku ingrediencie.
     *
     * @return Výška ingrediencie.
     */
    public int getVyska() {
        return dataObrazku.getVyska();
    }

    /**
     * Získa šírku ingrediencie.
     *
     * @return Šírka ingrediencie.
     */
    public int getSirka() {
        return dataObrazku.getSirka();
    }

    /**
     * Získa blok textu ingrediencie.
     *
     * @return Blok textu ingrediencie.
     */
    public BlokTextu getBlokTextu() {
        return blokTextu;
    }

    /**
     * Získa enum hodnotu ingrediencie.
     *
     * @return Enum hodnota ingrediencie.
     */
    public Ingrediencie getIngredienciaEnum() {
        return this.ingredienciaEnum;
    }
}
