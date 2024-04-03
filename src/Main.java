import Mapa.Mapa;
import Prekazky.Postavy.Carodejnik.Carodejnik;

import fri.shapesge.Manazer;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(4350, 2700);
        Carodejnik carodejnik = new Carodejnik(4, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Carodejnik_obrazky/", 725, 450, mapa);
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(carodejnik);
    }
}