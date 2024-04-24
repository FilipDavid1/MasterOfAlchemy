package Interakcie;

import Prekazky.HernyObjekt;
import Prekazky.Postavy.Hrac.Inventar;
import Mapa.Mapa;
import Prekazky.Postavy.Postava;
import Veci.Ingrediencie.Ingrediencia;

public class Interakcia {
    private Mapa mapa;
    private Inventar inventar;
    public Interakcia(Mapa mapa, Inventar inventar) {
        this.mapa = mapa;
        this.inventar = inventar;
    }


    public void vyberSuradnice(int x, int y) {
        if (!this.zoberIngredienciu(x, y)) {
            if (!this.rozhovorNPC(x, y)) {
                this.utokMonstrum(x, y);
            }
        }
    }

    private void utokMonstrum(int x, int y) {
        for (HernyObjekt hernyObjekt : mapa.getPrekazky()) {
            if (hernyObjekt instanceof Postava postava) {
                if (postava.getX() < x && postava.getX() + postava.getSirka() > x && postava.getY() < y && postava.getY() + postava.getVyska() > y) {
                    System.out.println("Utok na postavu" + postava.getCestaKObrazku());
                }
            }
        }
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
}
