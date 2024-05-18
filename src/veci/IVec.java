package veci;

import fri.shapesge.Obrazok;

/**
 * Rozhranie IVec definuje metódy, ktoré musia byť implementované všetkými triedami, ktoré implementujú toto rozhranie.
 */
public interface IVec {

    /**
     * Získa názov veci.
     *
     * @return Názov veci.
     */
    String getNazov();

    /**
     * Získa obrázok veci.
     *
     * @return Obrázok veci.
     */
    Obrazok getObrazok();

    /**
     * Získa šírku veci.
     *
     * @return Šírka veci.
     */
    int getSirka();
}
