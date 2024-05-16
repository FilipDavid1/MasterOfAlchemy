package interakcie;

import prekazky.HernyObjekt;
import prekazky.postavy.hrac.Hrac;
import prekazky.postavy.hrac.Inventar;
import mapa.Mapa;
import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;

public class Interakcia {
    private Mapa mapa;
    private Inventar inventar;

    private Hrac hrac;
    private BlokTextu blokTextu;
    private boolean jeZobrazeny;
    private int casovac;

    private BlokTextu hp;
    public Interakcia(Mapa mapa, Inventar inventar, Hrac hrac) {
        this.mapa = mapa;
        this.inventar = inventar;
        this.hrac = hrac;
        this.blokTextu = new BlokTextu("Nie si v dosahu na to aby si interagoval");
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.casovac = 10;
        this.hp = new BlokTextu("HP: " + hrac.getHp(), 0, 50);
        this.hp.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.hp.zmenFarbu("white");
        this.hp.zobraz();
    }

    public void tik() {
        if (jeZobrazeny) {
            casovac--;
        }

        if (casovac <= 0) {
            this.jeZobrazeny = false;
            this.blokTextu.skry();
        }
        this.hp.zmenText("HP: " + hrac.getHp());
        this.hp.zobraz();
    }


    public void vyberSuradnice(int x, int y) {
        if (jeVDosahu((x + Math.abs(this.mapa.getX())), (y + Math.abs(this.mapa.getY())))) {
            if (!this.zoberIngredienciu(x, y)) {
                if (!this.vyberPostavu(x, y)) {
                    this.blokTextu.zmenText("Ziadny objekt na interakciu");
                    this.blokTextu.zmenPolohu(0, 30);
                    this.blokTextu.zobraz();
                    this.jeZobrazeny = true;
                    this.casovac = 10;
                }
            }
        } else {
            this.blokTextu.zmenPolohu(0, 30);
            this.blokTextu.zobraz();
            this.jeZobrazeny = true;
            this.casovac = 10;
        }
    }

    private boolean vyberPostavu(int x, int y) {
        for (HernyObjekt hernyObjekt : mapa.getPrekazky()) {
            if (hernyObjekt instanceof Postava postava) {
                if (postava.getX() < x && postava.getX() + postava.getSirka() > x && postava.getY() < y && postava.getY() + postava.getVyska() > y) {
                    hrac.vyberPostavu(postava);
                    this.blokTextu.zmenText("Vybral si postavu: " + postava.getClass().getSimpleName());
                    this.blokTextu.zmenPolohu(0, 30);
                    this.blokTextu.zobraz();
                    this.jeZobrazeny = true;
                    this.casovac = 20;
                    return true;
                }
            }
        }
        return false;
    }


    private boolean zoberIngredienciu(int x, int y) {
        System.out.println("x: " + x + " y: " + y);
        //prejdi ingrediencie z mapy ak tam nejake su a zober tu kde som klikol +- velkost obrazka
        for (Ingrediencia ingrediencia : mapa.getIngrediencie()) {
            System.out.println("ingrediencia x: " + ingrediencia.getX() + " y: " + ingrediencia.getY());
            if (ingrediencia.getX() < x && ingrediencia.getX() + ingrediencia.getSirka() > x && ingrediencia.getY() < y && ingrediencia.getY() + ingrediencia.getVyska() > y) {
                this.pridajIngredienciuDoInventara(ingrediencia);
                this.blokTextu.zmenText("Zobral si ingredienciu: " + ingrediencia.getNazov());
                this.blokTextu.zmenPolohu(0, 30);
                this.blokTextu.zobraz();
                this.jeZobrazeny = true;
                this.casovac = 5;
                return true;
            }
        }
        return false;
    }

    private void pridajIngredienciuDoInventara(Ingrediencia ingrediencia) {
        this.inventar.pridajVec(ingrediencia);
        this.mapa.vymazIngredienciu(ingrediencia);
    }

    private boolean jeVDosahu(int x, int y) {
        //ak je x alebo y v mape rovne 0 tak over hracove x alebo y inak overuj v mape
        int dosah = 500;
        var hracX = (this.hrac.getX() + Math.abs(this.mapa.getX()));
        var hracY = (this.hrac.getY() + Math.abs(this.mapa.getY()));
        return Math.sqrt(Math.pow(hracX - x, 2) + Math.pow(hracY - y, 2)) <= dosah;
    }
}
