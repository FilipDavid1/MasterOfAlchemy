package prekazky.postavy;

/**
 * Enum OrientaciaPostavy, ktorý reprezentuje možné orientácie postavy.
 */
public enum OrientaciaPostavy {
    LEFT, RIGHT, UP, DOWN;

    /**
     * Metóda toString, ktorá vráti reťazec reprezentujúci orientáciu postavy.
     *
     * @return String Reťazec reprezentujúci orientáciu postavy.
     */
    public String toString() {
        switch (this) {
            case LEFT:
                return "Left";
            case RIGHT:
                return "Right";
            case UP:
                return "Up";
            case DOWN:
                return "Down";
            default:
                return "Neznama orientacia";
        }
    }
}
