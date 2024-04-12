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
        Carodejnik carodejnik = new Carodejnik(4, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Carodejnik_obrazky/", 725, 450, mapa);
//        HernyObjekt prekazka = new Drak(6, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/Drak/", 600, 100);

        Manazer manazer = new Manazer();
        manazer.spravujObjekt(carodejnik);
//        manazer.spravujObjekt(prekazka);

        List<Map<String, String>> prekazkyData = null;
        try {
            NacitavaniePrekazok nacitavanie = new NacitavaniePrekazok();
            prekazkyData = nacitavanie.nacitajPrekazky("/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/nacitavanie/prekazky.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (prekazkyData != null) {
            List<HernyObjekt> prekazky = new ArrayList<>();
            for (Map<String, String> prekazkaData : prekazkyData) {
                String typ = prekazkaData.get("typ");
                int pocetObrazkov = Integer.parseInt(prekazkaData.get("pocetObrazkov"));
                String cestaKObrazku = prekazkaData.get("cestaKObrazku");
                int x = Integer.parseInt(prekazkaData.get("x"));
                int y = Integer.parseInt(prekazkaData.get("y"));

                HernyObjekt prekazka = null;
                if (typ.equals("prekazka")) {
                    prekazka = new HernyObjekt(pocetObrazkov, cestaKObrazku, x, y);
                } else if (typ.equals("NPC")) {
                    // Vytvor NPC objekt
                    System.out.println("NPC");
                } else if (typ.equals("monstrum")) {
                    // Vytvor monštrum objekt
                    System.out.println("Monstrum");
                }

                if (prekazka != null) {
                    prekazky.add(prekazka);
                }
            }
        }
    }
}