import Mapa.Mapa;
import Prekazky.Postavy.Carodejnik.Carodejnik;
import Veci.Ingrediencie.DraciaSupina;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Vec;
import fri.shapesge.Manazer;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(4350, 2700);
        Carodejnik carodejnik = new Carodejnik(4, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Carodejnik_obrazky/", 725, 450, mapa);
        Ingrediencia ingrediencia = new DraciaSupina(-20, 0, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Mapa/Obrazky/armor_01a.png");
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(carodejnik);
    }
}