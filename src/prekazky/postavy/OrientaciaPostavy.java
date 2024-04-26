package prekazky.postavy;

public enum OrientaciaPostavy {
    LEFT, RIGHT, UP, DOWN;


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
