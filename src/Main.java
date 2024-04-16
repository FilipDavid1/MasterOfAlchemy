import Mapa.Mapa;
import Prekazky.HernyObjekt;
import Prekazky.Postavy.Carodejnik.Carodejnik;

import Prekazky.Postavy.Monstra.Drak;
import Prekazky.Postavy.Postava;
import fri.shapesge.Manazer;
import nacitavanie.NacitavaniePrekazok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(4350, 2700);
        NacitavaniePrekazok nacitavaniePrekazok = new NacitavaniePrekazok(mapa);

//        HernyObjekt prekazka = new Drak(6, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/Drak/", 600, 100);

        Manazer manazer = new Manazer();

//        manazer.spravujObjekt(prekazka);


        Carodejnik carodejnik = new Carodejnik(4, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Carodejnik_obrazky/", 725, 450, mapa);
        manazer.spravujObjekt(carodejnik);
    }
}