package Prekazky.Postavy;

public enum OrientaciaPostavy {
    WEST, EAST, NORTH, SOUTH;


    public String toString() {
        switch (this) {
            case WEST:
                return "West";
            case EAST:
                return "East";
            case NORTH:
                return "North";
            case SOUTH:
                return "South";
            default:
                return "Neznama orientacia";
        }
    }
}
