import Mapa.Mapa;
import Prekazky.Postavy.Hrac.Hrac;

import Veci.Ingrediencie.Ingrediencia;
import Veci.Ingrediencie.Ingrediencie;
import fri.shapesge.Manazer;
import nacitavanie.NacitavaniePrekazok;

public class Main {
    public static void main(String[] args) {
        Manazer manazer = new Manazer();
        Mapa mapa = new Mapa(manazer);


//        HernyObjekt prekazka = new Drak(6, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/Drak/", 600, 100);



//        manazer.spravujObjekt(prekazka);


        Hrac hrac = new Hrac(4, 8, "resources/Obrazky/Hrac/Idle/Idle_Down_0", 725, 450, mapa, manazer);
        manazer.spravujObjekt(hrac);
        mapa.setHrac(hrac);
        NacitavaniePrekazok nacitavaniePrekazok = new NacitavaniePrekazok(mapa, manazer);
    }
}