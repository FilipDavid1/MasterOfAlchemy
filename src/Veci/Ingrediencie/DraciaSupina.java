package Veci.Ingrediencie;

import Mapa.Mapa;
import fri.shapesge.Obrazok;

public class DraciaSupina implements Ingrediencia {

    private int x;
    private int y;

    private Obrazok obrazok;

    public DraciaSupina(int x, int y, String obrazok) {
        this.x = Mapa.SIRKA - x;
        this.y = Mapa.VYSKA - y;
        this.obrazok = new Obrazok(obrazok);
        //umiestnenie obrazku na dane suradnice na mape
        this.obrazok.zmenPolohu(x, y);
        System.out.println("Dracia supina na suradniciach x: " + this.x + " y: " + this.y);
        this.obrazok.zobraz();
    }

    public void skry() {
        this.obrazok.skry();
    }

    @Override
    public String getNazov() {
        return "Dračia šupina";
    }

    @Override
    public int getCena() {
        return 0;
    }
}
