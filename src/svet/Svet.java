package svet;

import fri.shapesge.Manazer;
import mapa.Mapa;
import nacitavanie.NacitavaniePrekazok;
import prekazky.postavy.hrac.Hrac;

public class Svet {
    public static void main(String[] args) {
        Manazer manazer = new Manazer();
        Mapa mapa = new Mapa(manazer);

        Hrac hrac = new Hrac(4, "resources/Obrazky/Hrac/Idle/Idle_Down_0", 725, 450, mapa, manazer);
        manazer.spravujObjekt(hrac);
        mapa.setHrac(hrac);
        NacitavaniePrekazok nacitavaniePrekazok = new NacitavaniePrekazok(mapa, manazer);
    }
}
