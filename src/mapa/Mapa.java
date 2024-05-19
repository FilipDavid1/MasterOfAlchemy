package mapa;

import prekazky.HernyObjekt;
import prekazky.postavy.Postava;
import prekazky.postavy.monstra.IMonstrum;
import prekazky.postavy.monstra.StrelecMonstrum;
import prekazky.postavy.npc.Alchymista;
import veci.ingrediencie.Ingrediencia;
import veci.ingrediencie.Ingrediencie;
import fri.shapesge.Manazer;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

/**
 * Trieda Mapa reprezentuje hernú mapu.
 */
public class Mapa {
    private final Obrazok mapaObr; // Obrázok mapy

    private int x;
    private int y;
    private ArrayList<HernyObjekt> prekazky;
    private ArrayList<Ingrediencia> ingrediencie;
    private Postava hrac;
    private final Manazer manazer;
    private double velX;
    private double velY;

    /**
     * Konštruktor pre triedu Mapa.
     * @param manazer Manažér pre správu objektov
     */
    public Mapa(Manazer manazer) {
        this.mapaObr = new Obrazok("resources/Obrazky/Mapa/map.png");
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.prekazky = new ArrayList<>();
        this.ingrediencie = new ArrayList<>();
        this.manazer = manazer;
        manazer.spravujObjekt(this);
    }

    /**
     * Metóda setVelX nastaví rýchlosť pohybu mapy v osi X.
     * @param velX Rýchlosť pohybu
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }

    /**
     * Metóda setVelY nastaví rýchlosť pohybu mapy v osi Y.
     * @param velY Rýchlosť pohybu
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Metóda stopX zastaví pohyb mapy v osi X.
     */
    public void stopX() {
        this.setVelX(0);
    }

    /**
     * Metóda stopY zastaví pohyb mapy v osi Y.
     */
    public void stopY() {
        this.setVelY(0);
    }

    /**
     * Metóda mapTik sa volá v každom cykle hry.
     * Aktualizuje polohu mapy a objektov na mape.
     */
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

    /**
     * Metóda utok sa volá, keď hráč útočí.
     * Kontroluje interakciu medzi hráčom a postavami na mape.
     */
    public void utok() {
        this.interakciaPostav();
    }

    /**
     * Metóda interakciaPostav kontroluje interakciu medzi hráčom a postavami na mape.
     */
    private void interakciaPostav() {
        for (HernyObjekt prekazka : this.prekazky) {
            if (prekazka instanceof Postava postava) {
                double vzdialenost = Math.sqrt(Math.pow(postava.getX() - hrac.getX(), 2) + Math.pow(postava.getY() - hrac.getY(), 2));
                if (vzdialenost < 200 && !(postava instanceof Alchymista)) {
                    postava.interakcia(this.hrac);
                    postava.setUtoci(true);
                } else {
                    postava.setUtoci(false);
                }
            }
        }
    }

    /**
     * Metóda getX vráti X-súradnicu mapy.
     * @return X-súradnica mapy
     */
    public int getX() {
        return x;
    }

    /**
     * Metóda getY vráti Y-súradnicu mapy.
     * @return Y-súradnica mapy
     */
    public int getY() {
        return y;
    }

    /**
     * Metóda pridajPrekazku pridá prekážku na mapu.
     * @param prekazka Prekážka na pridanie
     */
    public void pridajPrekazku(HernyObjekt prekazka) {
        this.prekazky.add(prekazka);
        prekazka.setX(prekazka.getX() + this.x);
        prekazka.setY(prekazka.getY() + this.y);
        if (prekazka instanceof Postava postava) {
            if (postava instanceof IMonstrum) {
                postava.setMeno("Monstrum: " + postava.getClass().getSimpleName(), postava.getX() - 20, postava.getY() - 20);
            }
        }
    }

    /**
     * Metóda pridajPrekazky pridá zoznam prekážok na mapu.
     * @param prekazky Zoznam prekážok na pridanie
     */
    public void pridajPrekazky(List<HernyObjekt> prekazky) {
        for (HernyObjekt prekazka : prekazky) {
            this.pridajPrekazku(prekazka);
        }
    }

    /**
     * Metóda pridajIngredienciu pridá ingredienciu na mapu.
     * @param ingrediencia Ingrediencia na pridanie
     */
    private void pridajIngredienciu(Ingrediencia ingrediencia) {
        this.ingrediencie.add(ingrediencia);
    }

    /**
     * Metóda posunHerneObjekty posunie herné objekty na mape.
     * @param x Posun v osi X
     * @param y Posun v osi Y
     */
    public void posunHerneObjekty(int x, int y) {
        for (HernyObjekt hernyObjekt : this.prekazky) {
            if (hernyObjekt instanceof Postava) {
                Postava postava = (Postava)hernyObjekt;
                postava.posunNa(postava.getX() + x, postava.getY() + y);
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

    /**
     * Metóda vymazMrtvePrekazky vymaže mŕtve prekážky z mapy.
     */
    private void vymazMrtvePrekazky() {
        ArrayList<HernyObjekt> mrtvePrekazky = new ArrayList<>();
        for (HernyObjekt prekazka : this.prekazky) {
            if (prekazka instanceof Postava postava) {
                if (postava.jeMrtvy()) {
                    if (postava instanceof StrelecMonstrum strelec) {
                        strelec.zmazStrely();
                    }
                    postava.skry();
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

    /**
     * Metóda getPrekazky vráti zoznam prekážok na mape.
     * @return Zoznam prekážok na mape
     */
    public ArrayList<HernyObjekt> getPrekazky() {
        return new ArrayList<>(this.prekazky);
    }

    /**
     * Metóda vymazIngredienciu vymaže ingredienciu z mapy.
     * @param ingrediencia Ingrediencia na vymazanie
     */
    public void vymazIngredienciu(Ingrediencia ingrediencia) {
        ingrediencia.skry();
        this.ingrediencie.remove(ingrediencia);
        System.out.println("vymazana ingrediencia");
    }

    /**
     * Metóda getIngrediencie vráti zoznam ingrediencií na mape.
     * @return Zoznam ingrediencií na mape
     */
    public ArrayList<Ingrediencia> getIngrediencie() {
        return new ArrayList<>(this.ingrediencie);
    }

    /**
     * Metóda setHrac nastaví hráča na mape.
     * @param hrac Hráč na nastavenie
     */
    public void setHrac(Postava hrac) {
        this.hrac = hrac;
    }

    /**
     * Metóda getHrac vráti hráča na mape.
     * @return Hráč na mape
     */
    public Postava getHrac() {
        Postava hrac1 = this.hrac;
        return hrac1;
    }

}
