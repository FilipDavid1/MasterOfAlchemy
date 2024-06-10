package things;

import fri.shapesge.Obrazok;

/**
 * Rozhranie IVec definuje metódy, ktoré musia byť implementované všetkými triedami, ktoré implementujú toto rozhranie.
 */
public interface IThing {

    /**
     * Získa názov veci.
     *
     * @return Názov veci.
     */
    String getName();

    /**
     * Získa obrázok veci.
     *
     * @return Obrázok veci.
     */
    Obrazok getImage();

    /**
     * Získa šírku veci.
     *
     * @return Šírka veci.
     */
    int getWidth();
}
