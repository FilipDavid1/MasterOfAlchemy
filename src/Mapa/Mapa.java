package Mapa;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Monstra.Drak;
import Veci.Ingrediencie.DraciaSupina;
import fri.shapesge.Obrazok;

public class Mapa {
    private int[][] mapa;
    private Obrazok mapaObr;
    private int x;
    private int y;

    private double miniX;
    private double miniY;

    private Lokalita[] lokality;

    public static final int SIRKA = 4350;
    public static final int VYSKA = 2700;

    public Mapa(int sirka, int vyska) {

        this.mapa = new int[sirka][vyska];
        this.mapaObr = new Obrazok("/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Mapa/Obrazky/map.png");
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.miniX = Math.abs(this.x)/2;
        this.miniY = Math.abs(this.y)/2;
        this.lokality = new Lokalita[9];
        this.lokality[0] = new Lokalita("lokalita1", "popis lokality", 1450, 900);
        HernyObjekt prekazka = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 700, 800);
        HernyObjekt prekazka1 = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 1000, 800);
        HernyObjekt prekazka2 = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 1200, 400);
        this.lokality[0].pridajPrekazku(prekazka);
        this.lokality[0].pridajPrekazku(prekazka1);
        this.lokality[0].pridajPrekazku(prekazka2);
    }

    public void nastavPolohu(String strana){
        int xBefore = this.x;
        int yBefore = this.y;

        if (strana.equals("dole")) {
            if (this.y != -1850){
                this.mapaObr.zmenPolohu(this.x, this.y -10);
                this.y-=10;
                this.miniY +=3.5;
            }
        } else if (strana.equals("hore")) {
            if (this.y != 0){
                this.mapaObr.zmenPolohu(this.x, this.y +10);
                this.y+=10;
                this.miniY -=3.5;
            }
        } else if (strana.equals("vpravo")) {
            if (this.x != -2910) {
                this.mapaObr.zmenPolohu(this.x - 10, this.y);
                this.x -= 10;
                this.miniX +=3.5;
            }
        } else {
            if (this.x != 0) {
                this.mapaObr.zmenPolohu(this.x + 10, this.y);
                this.x += 10;
                this.miniX -=3.5;
            }
        }

        this.lokality[0].setPoloha( this.x - xBefore , this.y - yBefore);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getMiniX() {
        return miniX;
    }

    public double getMiniY() {
        return miniY;
    }
}
