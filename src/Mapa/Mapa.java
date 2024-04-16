package Mapa;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Carodejnik.Carodejnik;
import Prekazky.Postavy.Monstra.Drak;
import Prekazky.Postavy.Postava;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;
import nacitavanie.NacitavaniePrekazok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mapa {
    private int[][] mapa;
    private Obrazok mapaObr;

    private DataObrazku data;
    private int x;
    private int y;

    private double miniX;
    private double miniY;

    private ArrayList<HernyObjekt> prekazky;
    private ArrayList<Quest> questy;


    public Mapa() {

        this.mapaObr = new Obrazok("/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Mapa/Obrazky/map.png");
        this.data = new DataObrazku("/Users/filipdavid/Desktop/inf2/MasterOfAlchemy/src/Mapa/Obrazky/map.png");
        this.mapa = new int[data.getSirka()][data.getVyska()];
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.miniX = Math.abs(this.x)/2;
        this.miniY = Math.abs(this.y)/2;
        this.prekazky = new ArrayList<>();
        this.questy = new ArrayList<>();



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

        this.posunHerneObjekty( this.x - xBefore , this.y - yBefore);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiniX() {
        return (int) (Math.abs(this.x) / (double) data.getSirka() );
    }

    public int getMiniY() {
        return (int) (Math.abs(this.y) / (double) data.getVyska());
    }


    public void pridajPrekazku(HernyObjekt prekazka) {
        //set x and y of the object + x and y of the location
        this.prekazky.add(prekazka);
        prekazka.setX(prekazka.getX() + this.x);
        prekazka.setY(prekazka.getY() + this.y);
        System.out.println(prekazka.getX() + " " + prekazka.getY());
    }

    public void pridajPrekazky(List<HernyObjekt> prekazky) {
        for (HernyObjekt prekazka : prekazky) {
            this.pridajPrekazku(prekazka);
            System.out.println(prekazka.getX() + " " + prekazka.getY());
        }
    }

    public void pridajQuest(Quest quest) {
        this.questy.add(quest);
    }

    public void posunHerneObjekty(int x, int y) {
        for (HernyObjekt hernyObjekt : this.prekazky) {
            if (hernyObjekt instanceof Postava) {
                Postava drak = (Postava) hernyObjekt;
                drak.posunNa(drak.getX() + x, drak.getY() + y);
            } else {
                hernyObjekt.setX(hernyObjekt.getX() + x);
                hernyObjekt.setY(hernyObjekt.getY() + y);
            }

        }
    }

    public void vymazMrtvePrekazky() {
        ArrayList<HernyObjekt> mrtvePrekazky = new ArrayList<>();
        for (HernyObjekt prekazka : this.prekazky) {
            if (prekazka instanceof Postava postava) {
                if (!postava.jeZivy()) {
                    mrtvePrekazky.add(prekazka);
                }
            }
        }

        this.prekazky.removeAll(mrtvePrekazky);
    }

    public ArrayList<HernyObjekt> getPrekazky() {
        return this.prekazky;
    }
}
