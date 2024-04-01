package Mapa;

import Prekazky.HernyObjekt;

import java.util.ArrayList;

public class Lokalita {
    private String nazov;
    private String popis;
    private boolean viditelna;
    private boolean navstivena;

    private int x;
    private int y;

    private ArrayList<HernyObjekt> prekazky;
    private ArrayList<Quest> questy;

    public Lokalita(String nazov, String popis, int x, int y) {
        this.nazov = nazov;
        this.popis = popis;
        this.viditelna = false;
        this.navstivena = false;
        this.x = x;
        this.y = y;
        this.prekazky = new ArrayList<>();
        this.questy = new ArrayList<>();
    }

    public void pridajPrekazku(HernyObjekt prekazka) {
        //set x and y of the object + x and y of the location
        this.prekazky.add(prekazka);
        prekazka.setX(prekazka.getX() + this.x);
        prekazka.setY(prekazka.getY() + this.y);
    }

    public void pridajQuest(Quest quest) {
        this.questy.add(quest);
    }

    public void zobraz() {
        this.viditelna = true;
    }

    public void skry() {
        this.viditelna = false;
    }

    public void navstiv() {
        this.navstivena = true;
    }


    public String getNazov() {
        return this.nazov;
    }

    public String getPopis() {
        return this.popis;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setPoloha(int x, int y) {
        System.out.println("Lokalita na suradniciach x: " + x + " y: " + y);
        for (HernyObjekt hernyObjekt : this.prekazky) {
            hernyObjekt.setX(hernyObjekt.getX() + x);
            hernyObjekt.setY(hernyObjekt.getY() + y);
            System.out.println("Prekazka na suradniciach x: " + x + " y: " + y);
        }
    }

}
