package Interakcie;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Hrac.Hrac;
import Prekazky.Postavy.Hrac.Inventar;
import Mapa.Mapa;
import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;

public class Interakcia {
    private Mapa mapa;
    private Inventar inventar;

    private Hrac hrac;
    private BlokTextu blokTextu;
    private boolean jeZobrazeny;
    private int casovac;
    public Interakcia(Mapa mapa, Inventar inventar, Hrac hrac) {
        this.mapa = mapa;
        this.inventar = inventar;
        this.hrac = hrac;
        this.blokTextu = new BlokTextu("Nie si v dosahu na to aby si interagoval");
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.casovac = 10;
    }

    public void tik() {
        if (jeZobrazeny) {
            casovac--;
        }

        if (casovac <= 0) {
            this.jeZobrazeny = false;
            this.blokTextu.skry();
        }
    }


    public void vyberSuradnice(int x, int y) {
        if (jeVDosahu(x, y)) {
            if (!this.zoberIngredienciu(x, y)) {
                if (!this.rozhovorNPC(x, y)) {
                    if (!this.utokMonstrum(x, y)) {
                        this.blokTextu.zmenText("Ziadny objekt na interakciu");
                        this.blokTextu.zmenPolohu(0, 30);
                        this.blokTextu.zobraz();
                        this.jeZobrazeny = true;
                        this.casovac = 10;
                    }
                }
            }
        } else {
            this.blokTextu.zmenPolohu(0, 30);
            this.blokTextu.zobraz();
            this.jeZobrazeny = true;
            this.casovac = 10;
        }
    }

    private boolean utokMonstrum(int x, int y) {
        for (HernyObjekt hernyObjekt : mapa.getPrekazky()) {
            if (hernyObjekt instanceof Postava postava) {
                if (postava.getX() < x && postava.getX() + postava.getSirka() > x && postava.getY() < y && postava.getY() + postava.getVyska() > y) {
                    hrac.vyberMonstrum(postava);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean rozhovorNPC(int x, int y) {
        return false;
    }

    private boolean zoberIngredienciu(int x, int y) {
        System.out.println("x: " + x + " y: " + y);
        //prejdi ingrediencie z mapy ak tam nejake su a zober tu kde som klikol +- velkost obrazka
        for (Ingrediencia ingrediencia : mapa.getIngrediencie()) {
            System.out.println("ingrediencia x: " + ingrediencia.getX() + " y: " + ingrediencia.getY());
            if (ingrediencia.getX() < x && ingrediencia.getX() + ingrediencia.getSirka() > x && ingrediencia.getY() < y && ingrediencia.getY() + ingrediencia.getVyska() > y) {
                this.pridajIngredienciuDoInventara(ingrediencia);
                System.out.println("Zobral som ingredienciu");
                return true;
            }
        }
        return false;
    }

    private void pridajIngredienciuDoInventara(Ingrediencia ingrediencia){
        this.inventar.pridajVec(ingrediencia);
        this.mapa.vymazIngredienciu(ingrediencia);
    }

    private boolean jeVDosahu(int x, int y) {
        //ak je x alebo y v mape rovne 0 tak over hracove x alebo y inak overuj v mape
        int dosah = 100;
        if (mapa.getX() == 0) {
            if (mapa.getY() == 0) {
                return Math.sqrt(Math.pow(hrac.getX() - x, 2) + Math.pow(hrac.getY() - y, 2)) <= dosah;
            } else {
                return Math.sqrt(Math.pow(hrac.getX() - x, 2) + Math.pow(mapa.getY() - y, 2)) <= dosah;
            }
        } else {
            return Math.sqrt(Math.pow(mapa.getX() - x, 2) + Math.pow(mapa.getY() - y, 2)) <= dosah;
        }
    }
}
