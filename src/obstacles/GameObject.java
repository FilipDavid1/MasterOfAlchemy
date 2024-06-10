package obstacles;

import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

/**
 * Trieda HernyObjekt, ktorá rozširuje triedu HernaEntita.
 */
public class GameObject extends GameEntity {
    private final int numberOfImages;
    private final String pathToImage;
    private Obrazok image;
    private final DataObrazku data;

    /**
     * Konštruktor pre triedu HernyObjekt.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public GameObject(int numberOfImages, String pathToImage, int x, int y) {
        this.numberOfImages = numberOfImages;
        this.pathToImage = pathToImage;
        super.setX(x);
        super.setY(y);
        this.setImage();
        data = new DataObrazku(pathToImage + ".png");
    }

    /**
     * Metóda nastavObrazok, ktorá nastavuje obrázok herného objektu.
     */
    public void setImage() {
        this.image = new Obrazok(pathToImage + ".png");
        this.image.zmenPolohu(super.getX(), super.getY());
        this.image.zobraz();
    }

    /**
     * Metóda getpathToImage, ktorá vráti cestu k obrázku herného objektu.
     *
     * @return String Cesta k obrázku.
     */
    public String getPathToImage() {
        return pathToImage;
    }

    /**
     * Metóda getnumberOfImages, ktorá vráti počet obrázkov pre animáciu.
     *
     * @return int Počet obrázkov pre animáciu.
     */
    public int getNumberOfImages() {
        return numberOfImages;
    }

    /**
     * Metóda skry, ktorá skryje herný objekt.
     */
    public void hideImage() {
        this.image.skry();
    }

    /**
     * Metóda getSirka, ktorá vráti šírku herného objektu.
     *
     * @return int Šírka herného objektu.
     */
    public int getWidth() {
        return data.getSirka();
    }

    /**
     * Metóda getVyska, ktorá vráti výšku herného objektu.
     *
     * @return int Výška herného objektu.
     */
    public int getHeight() {
        return data.getVyska();
    }

    /**
     * Metóda getObrazok, ktorá vráti obrázok herného objektu.
     *
     * @return Obrazok Obrázok herného objektu.
     */
    public Obrazok getImage() {
        return image;
    }

    /**
     * Metóda setObrazok, ktorá nastavuje obrázok herného objektu.
     *
     * @param url URL obrázku.
     */
    public void setImage(String url) {
        this.image = new Obrazok(url);
    }

    /**
     * Metóda zmenObrazok, ktorá mení obrázok herného objektu.
     *
     * @param url URL nového obrázku.
     */
    public void changeImage(String url) {
        this.image.zmenObrazok(url);
    }

    /**
     * Metóda zmenPolohuObrazku, ktorá mení polohu obrázku herného objektu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void changeImagePosition(int x, int y) {
        this.image.zmenPolohu(x, y);
        this.image.zobraz();
    }

    /**
     * Metóda zobrazObrazok, ktorá zobrazí obrázok herného objektu.
     */
    public void showImage() {
        this.image.zobraz();
    }

    /**
     * Metóda getData, ktorá vráti dáta obrázku herného objektu.
     *
     * @return DataObrazku Dáta obrázku.
     */
    public DataObrazku getData() {
        return data;
    }
}
