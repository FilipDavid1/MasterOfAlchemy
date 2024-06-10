package obstacles.characters.monsters;

/**
 * Rozhranie IMonstrum, ktoré definuje metódu tik.
 */
public interface IMonstrum {

    /**
     * Metóda tik, ktorá sa volá v každom tiku hry.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá rozhranie implementuje.
     */
    void tik();
}
