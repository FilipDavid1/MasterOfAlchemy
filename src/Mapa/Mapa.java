package Mapa;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Monstra.Drak;
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

    private Lokalita aktualnaLokalita;

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
        for (int i = 0; i < 9; i++) {
            int x = (i % 3) * 1450;
            int y = (i / 3) * 900;
            this.lokality[i] = new Lokalita("Lokalita " + (i + 1), "popis", x, y);
        }
        HernyObjekt prekazka = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 700, 800);
        HernyObjekt prekazka1 = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 1000, 800);
        HernyObjekt prekazka2 = new Drak(7, "/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Prekazky/Postavy/Monstra/Obrazky/idle_", 1200, 400);
        this.lokality[0].pridajPrekazku(prekazka);
        this.lokality[0].pridajPrekazku(prekazka1);
        this.lokality[0].pridajPrekazku(prekazka2);
        this.nastavAktualnuLokalitu();
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
        this.nastavAktualnuLokalitu();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiniX() {
        return (int) (Math.abs(this.x) / (double) SIRKA * Lokalita.SIRKA_LOKALITY);
    }

    public int getMiniY() {
        return (int) (Math.abs(this.y) / (double) VYSKA * Lokalita.VYSKA_LOKALITY);
    }





    private void nastavAktualnuLokalitu() {
        for (int i = 0; i < this.lokality.length; i++) {
            if (this.lokality[i] != null) {
                if (Math.abs(this.x) + Lokalita.SIRKA_LOKALITY / 2 >= lokality[i].getX() && Math.abs(this.x) + Lokalita.SIRKA_LOKALITY / 2 < lokality[i].getX() + Lokalita.SIRKA_LOKALITY &&
                        Math.abs(this.y) + Lokalita.VYSKA_LOKALITY / 2 >= lokality[i].getY() && Math.abs(this.y) + Lokalita.VYSKA_LOKALITY / 2 < lokality[i].getY() + Lokalita.VYSKA_LOKALITY) {
                    this.aktualnaLokalita = this.lokality[i];
                    System.out.println("Aktualna lokalita: " + this.aktualnaLokalita.getNazov());
                    break;
                }
            }
        }
    }



}
