package things.ingredients;

import obstacles.GameEntity;
import things.IThing;
import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

/**
 * Trieda Ingrediencia je podtriedou triedy HernaEntita a implementuje rozhranie IVec.
 * Reprezentuje ingredienciu, ktorá sa môže použiť v hre.
 */
public class Ingredient extends GameEntity implements IThing {

    private final Obrazok obrazok;
    private final String name;
    private final DataObrazku dataObrazku;
    private final BlokTextu blockOfText;
    private final Ingredients ingredienciaEnum;

    /**
     * Konštruktor pre Ingredienciu.
     *
     * @param name Názov ingrediencie.
     * @param x X-ová súradnica polohy ingrediencie.
     * @param y Y-ová súradnica polohy ingrediencie.
     */
    public Ingredient(String name, int x, int y) {
        this.obrazok = new Obrazok("resources/Obrazky/ingredients/" + name + ".png");
        this.obrazok.zmenPolohu(x, y);
        this.obrazok.zobraz();
        super.setX(x);
        super.setY(y);
        this.name = name;
        this.dataObrazku = new DataObrazku("resources/Obrazky/ingredients/" + name + ".png");
        this.blockOfText = new BlokTextu(name);
        this.blockOfText.zmenFarbu("white");
        this.blockOfText.zmenPolohu(x, y - 10);
        this.blockOfText.zobraz();
        this.ingredienciaEnum = Ingredients.valueOf(name);
    }

    /**
     * Získa názov ingrediencie.
     *
     * @return Názov ingrediencie.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Získa obrázok ingrediencie.
     *
     * @return Obrázok ingrediencie.
     */
    @Override
    public Obrazok getImage() {
        return obrazok;
    }

    /**
     * Skryje ingredienciu.
     */
    public void skry() {
        obrazok.skry();
        blockOfText.skry();
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
    public int getWidth() {
        return dataObrazku.getSirka();
    }

    /**
     * Získa blok textu ingrediencie.
     *
     * @return Blok textu ingrediencie.
     */
    public BlokTextu getBlockOfText() {
        return blockOfText;
    }

    /**
     * Získa enum hodnotu ingrediencie.
     *
     * @return Enum hodnota ingrediencie.
     */
    public Ingredients getIngredientEnum() {
        return this.ingredienciaEnum;
    }
}
