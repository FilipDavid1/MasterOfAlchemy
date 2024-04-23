package Mapa;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Ingrediencie.Ingrediencie;
import Veci.Ingrediencie.Tekvica;
import fri.shapesge.DataObrazku;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

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

    private ArrayList<Ingrediencia> ingrediencie;


    public Mapa() {

        this.mapaObr = new Obrazok("resources/Obrazky/Mapa/map.png");
        this.data = new DataObrazku("resources/Obrazky/Mapa/map.png");
        this.mapa = new int[data.getSirka()][data.getVyska()];
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.miniX = Math.abs(this.x)/2;
        this.miniY = Math.abs(this.y)/2;
        this.prekazky = new ArrayList<>();
        this.questy = new ArrayList<>();
        this.ingrediencie = new ArrayList<>();
    }

    public void nastavPolohu(String strana, float speed){
        int xBefore = this.x;
        int yBefore = this.y;

        float targetX = this.x;
        float targetY = this.y;

        if (strana.equals("dole") && this.y != -1850) {
            targetY = this.y - 10;
        } else if (strana.equals("hore") && this.y != 0) {
            targetY = this.y + 10;
        } else if (strana.equals("vpravo") && this.x != -2910) {
            targetX = this.x - 10;
        } else if (this.x != 0) {
            targetX = this.x + 10;
        }

        float newX = lerp(this.x, targetX, speed);
        float newY = lerp(this.y, targetY, speed);

        this.mapaObr.zmenPolohu((int)newX, (int)newY);
        this.x = (int)newX;
        this.y = (int)newY;
        this.miniX += (newX - xBefore) * 0.35;
        this.miniY += (newY - yBefore) * 0.35;

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

    public void pridajIngredienciu(Ingrediencia ingrediencia) {
        this.ingrediencie.add(ingrediencia);
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

        for (Ingrediencia ingrediencia : this.ingrediencie) {
            ingrediencia.setX(ingrediencia.getX() + x, ingrediencia.getObrazok());
            ingrediencia.setY(ingrediencia.getY() + y, ingrediencia.getObrazok());
        }
    }

    public void vymazMrtvePrekazky() {
        ArrayList<HernyObjekt> mrtvePrekazky = new ArrayList<>();
        for (HernyObjekt prekazka : this.prekazky) {
            if (prekazka instanceof Postava postava) {
                if (!postava.jeZivy()) {
                    mrtvePrekazky.add(prekazka);
                    Ingrediencia ingrediencia = Ingrediencie.getRandomIngredienciu(postava.getX(), postava.getY());
                    this.ingrediencie.add(ingrediencia);
                }
            }
        }

        this.prekazky.removeAll(mrtvePrekazky);
    }

    public ArrayList<HernyObjekt> getPrekazky() {
        return this.prekazky;
    }
    public float lerp(float start, float end, float speed) {
        return (1 - speed) * start + speed * end;
    }

    public void vymazIngredienciu(Ingrediencia ingrediencia) {
        ingrediencia.skry();
        this.ingrediencie.remove(ingrediencia);
        System.out.println("vymazana ingrediencia");
    }

    public ArrayList<Ingrediencia> getIngrediencie() {
        return this.ingrediencie;
    }
}
