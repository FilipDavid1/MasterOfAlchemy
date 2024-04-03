import Mapa.Mapa;
import Prekazky.HernyObjekt;
import Prekazky.Postavy.Carodejnik.Carodejnik;

import Prekazky.Postavy.Monstra.Drak;
import fri.shapesge.Manazer;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(4350, 2700);
        Carodejnik carodejnik = new Carodejnik(4, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Carodejnik_obrazky/", 725, 450, mapa);
//        HernyObjekt prekazka = new Drak(6, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/Drak/", 600, 100);

        Manazer manazer = new Manazer();
        manazer.spravujObjekt(carodejnik);
//        manazer.spravujObjekt(prekazka);
    }
}