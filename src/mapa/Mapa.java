package mapa;

import prekazky.HernyObjekt;
import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import veci.ingrediencie.Ingrediencie;
import fri.shapesge.DataObrazku;
import fri.shapesge.Manazer;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private final Obrazok mapaObr;

    private final DataObrazku data;
    private int x;
    private int y;

    private ArrayList<HernyObjekt> prekazky;
    private ArrayList<Quest> questy;

    private ArrayList<Ingrediencia> ingrediencie;

    private Postava hrac;
    private final Manazer manazer;

    private double velX;
    private double velY;

    public Mapa(Manazer manazer) {

        this.mapaObr = new Obrazok("resources/Obrazky/Mapa/map.png");
        this.data = new DataObrazku("resources/Obrazky/Mapa/map.png");
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.prekazky = new ArrayList<>();
        this.questy = new ArrayList<>();
        this.ingrediencie = new ArrayList<>();
        this.manazer = manazer;
        manazer.spravujObjekt(this);
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void stopX() {
        this.setVelX(0);
    }

    public void stopY() {
        this.setVelY(0);
    }

    public void mapTik() {
        this.vymazMrtvePrekazky();
        int stareX = this.x;
        int stareY = this.y;

        this.x += this.velX;
        this.y += this.velY;

        if (this.y >= 0) {
            this.y = 0;
        } else if (this.y <= -1840) {
            this.y = -1840;
        }

        if (this.x >= 0) {
            this.x = 0;
        } else if (this.x <= -2910) {
            this.x = -2910;
        }

        int noveX = this.x;
        int noveY = this.y;
        this.mapaObr.zmenPolohu(this.x, this.y);

        this.posunHerneObjekty(noveX - stareX, noveY - stareY);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    private void pridajIngredienciu(Ingrediencia ingrediencia) {
        this.ingrediencie.add(ingrediencia);
    }

    public void pridajQuest(Quest quest) {
        this.questy.add(quest);
    }

    public void posunHerneObjekty(int x, int y) {
        for (HernyObjekt hernyObjekt : this.prekazky) {
            if (hernyObjekt instanceof Postava) {
                Postava drak = (Postava)hernyObjekt;
                drak.posunNa(drak.getX() + x, drak.getY() + y);
            } else {
                hernyObjekt.setX(hernyObjekt.getX() + x);
                hernyObjekt.setY(hernyObjekt.getY() + y);
            }

        }

        for (Ingrediencia ingrediencia : this.ingrediencie) {
            ingrediencia.setX(ingrediencia.getX() + x, ingrediencia.getObrazok(), ingrediencia.getBlokTextu());
            ingrediencia.setY(ingrediencia.getY() + y, ingrediencia.getObrazok(), ingrediencia.getBlokTextu());
        }
    }

    private void vymazMrtvePrekazky() {
        ArrayList<HernyObjekt> mrtvePrekazky = new ArrayList<>();
        for (HernyObjekt prekazka : this.prekazky) {
            if (prekazka instanceof Postava postava) {
                if (!postava.jeZivy()) {
                    mrtvePrekazky.add(prekazka);
                    //manazer prestane spravovat objekt
                    manazer.prestanSpravovatObjekt(postava);
                    Ingrediencia ingrediencia = new Ingrediencia(Ingrediencie.getRandomIngredienciu(), postava.getX(), postava.getY());
                    this.pridajIngredienciu(ingrediencia);
                }
            }
        }

        this.prekazky.removeAll(mrtvePrekazky);
    }

    public ArrayList<HernyObjekt> getPrekazky() {
//        return Collections.unmodifiableList(this.prekazky);
//        return this.prekazky.stream();
        return new ArrayList<>(this.prekazky);
    }
    public void vymazIngredienciu(Ingrediencia ingrediencia) {
        ingrediencia.skry();
        this.ingrediencie.remove(ingrediencia);
        System.out.println("vymazana ingrediencia");
    }

    public ArrayList<Ingrediencia> getIngrediencie() {
        return new ArrayList<>(this.ingrediencie);
    }

    public void setHrac(Postava hrac) {
        this.hrac = hrac;
    }

    public Postava getHrac() {
        Postava hrac1 = this.hrac;
        return hrac1;
    }
}
