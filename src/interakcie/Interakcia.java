package interakcie;

import prekazky.HernyObjekt;
import prekazky.postavy.hrac.Hrac;
import prekazky.postavy.hrac.Inventar;
import mapa.Mapa;
import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;

/**
 * Trieda Interakcia zabezpečuje interakciu medzi hráčom a hernými objektmi.
 */
public class Interakcia {
    private Mapa mapa;
    private Inventar inventar;

    private Hrac hrac;
    private BlokTextu blokTextu;
    private boolean jeZobrazeny;
    private int casovac;

    private BlokTextu hp;

    /**
     * Konštruktor pre triedu Interakcia.
     * @param mapa Mapa hry
     * @param inventar Inventár hráča
     * @param hrac Hráč
     */
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

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav textových blokov a časovača.
     */
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

    /**
     * Metóda vyberSuradnice sa volá, keď hráč klikne na mapu.
     * Kontroluje, či je na daných súradniciach nejaký objekt na interakciu.
     * @param x X-súradnica kliknutia
     * @param y Y-súradnica kliknutia
     */
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

    /**
     * Metóda vyberPostavu kontroluje, či je na daných súradniciach postava.
     * Ak áno, hráč ju vyberie.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či bola vybraná postava
     */
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

    /**
     * Metóda zoberIngredienciu kontroluje, či je na daných súradniciach ingrediencia.
     * Ak áno, hráč ju zoberie.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či bola zobraná ingrediencia
     */
    private boolean zoberIngredienciu(int x, int y) {
        for (Ingrediencia ingrediencia : mapa.getIngrediencie()) {
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

    /**
     * Metóda pridajIngredienciuDoInventara pridá ingredienciu do inventára hráča.
     * @param ingrediencia Ingrediencia na pridanie
     */
    private void pridajIngredienciuDoInventara(Ingrediencia ingrediencia) {
        this.inventar.pridajVec(ingrediencia);
        this.mapa.vymazIngredienciu(ingrediencia);
    }

    /**
     * Metóda jeVDosahu kontroluje, či sú dané súradnice v dosahu hráča.
     * @param x X-súradnica
     * @param y Y-súradnica
     * @return Pravdivostná hodnota, či sú súradnice v dosahu
     */
    private boolean jeVDosahu(int x, int y) {
        int dosah = 500;
        var hracX = (this.hrac.getX() + Math.abs(this.mapa.getX()));
        var hracY = (this.hrac.getY() + Math.abs(this.mapa.getY()));
        return Math.sqrt(Math.pow(hracX - x, 2) + Math.pow(hracY - y, 2)) <= dosah;
    }
}
