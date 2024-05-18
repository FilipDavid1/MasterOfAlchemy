package veci.elixiry;

import fri.shapesge.BlokTextu;
import fri.shapesge.DataObrazku;
import fri.shapesge.StylFontu;
import prekazky.postavy.Postava;
import veci.ingrediencie.Ingrediencia;
import veci.ingrediencie.Ingrediencie;
import veci.IVec;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktná trieda Elixir, ktorá implementuje rozhranie IVec.
 */
public abstract class Elixir implements IVec {

    private final String nazov;
    private final Ingrediencie[] potrebneIngredience;
    private final Obrazok obrazok;
    private final DataObrazku data;
    private final BlokTextu blokTextu;

    /**
     * Konštruktor pre triedu Elixir.
     *
     * @param nazov Názov elixíru.
     * @param potrebneIngredience Pole potrebných ingrediencií pre výrobu elixíru.
     */
    public Elixir(String nazov, Ingrediencie[] potrebneIngredience) {
        this.nazov = nazov;
        this.potrebneIngredience = potrebneIngredience;
        this.obrazok = new Obrazok("resources/Obrazky/Elixiry/" + nazov + ".png");
        this.data = new DataObrazku("resources/Obrazky/Elixiry/" + nazov + ".png");
        this.blokTextu = new BlokTextu(nazov.substring(6));
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 9);
    }

    /**
     * Metóda getNazov, ktorá vráti názov elixíru.
     *
     * @return String Názov elixíru.
     */
    @Override
    public String getNazov() {
        return nazov;
    }

    /**
     * Metóda mozemVyrobit, ktorá kontroluje, či je možné vyrobiť elixír z daných ingrediencií.
     *
     * @param ingrediencie Zoznam ingrediencií, ktoré máme k dispozícii.
     * @return boolean Hodnota, či je možné vyrobiť elixír.
     */
    public boolean mozemVyrobit(List<Ingrediencia> ingrediencie) {
        for (Ingrediencie ingrediencia : potrebneIngredience) {
            boolean nasla = false;
            for (Ingrediencia i : ingrediencie) {
                if (i.getIngredienciaEnum() == ingrediencia) {
                    nasla = true;
                    break;
                }
            }
            if (!nasla) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metóda getObrazok, ktorá vráti obrázok elixíru.
     *
     * @return Obrazok Obrázok elixíru.
     */
    public Obrazok getObrazok() {
        return obrazok;
    }

    /**
     * Abstraktná metóda pouzi, ktorá sa volá pri použití elixíru na postavu.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @param postava Postava, na ktorú sa elixír použije.
     */
    public abstract void pouzi(Postava postava);

    /**
     * Metóda getPotrebneIngredience, ktorá vráti zoznam názvov potrebných ingrediencií pre výrobu elixíru.
     *
     * @return ArrayList<String> Zoznam názvov potrebných ingrediencií.
     */
    public ArrayList<String> getPotrebneIngredience() {
        return new ArrayList<>() {{
                for (Ingrediencie i : potrebneIngredience) {
                    add(i.getNazov());
                }
            }};
    }

    /**
     * Metóda getSirka, ktorá vráti šírku elixíru.
     *
     * @return int Šírka elixíru.
     */
    @Override
    public int getSirka() {
        return data.getSirka();
    }

    /**
     * Metóda zobrazText, ktorá zobrazuje text na danej pozícii.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void zobrazText(int x, int y) {
        blokTextu.zmenPolohu(x, y);
        blokTextu.zobraz();
    }

    /**
     * Metóda skry, ktorá skryje elixír.
     */
    public void skry() {
        blokTextu.skry();
        this.obrazok.skry();
    }

    /**
     * Abstraktná metóda popisElixira, ktorá vráti popis elixíru.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @return String Popis elixíru.
     */
    public abstract String popisElixira();
}
