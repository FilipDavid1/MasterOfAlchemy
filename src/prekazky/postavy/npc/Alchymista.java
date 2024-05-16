package prekazky.postavy.npc;

import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import prekazky.postavy.Postava;
import prekazky.postavy.hrac.Hrac;
import prekazky.postavy.hrac.Inventar;
import veci.elixiry.Elixir;
import javax.swing.JOptionPane;
import java.lang.reflect.Constructor;

public class Alchymista extends Postava {
    private final String[] elixiry = {"ElixirEnergie", "ElixirMoci", "ElixirMudrosti", "ElixirObnovenia", "ElixirObrany", "ElixirOdolnosti", "ElixirOdstraneniaKliadby", "ElixirOzivenia", "ElixirRegeneracie", "ElixirRychlosti", "ElixirSily", "ElixirSkrytia"};
    private final BlokTextu blokTextu;
    public Alchymista(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 0);
        this.blokTextu = new BlokTextu("", 0, 30);
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 15);
    }

    @Override
    public void interakcia(Postava postava) {
        Hrac hrac = (Hrac)postava;
        StringBuilder elixiryNaNovychRiadkoch = new StringBuilder();
        for (String elixir : this.elixiry) {
            elixiryNaNovychRiadkoch.append(elixir).append("\n");
        }
        this.blokTextu.zmenText("Ponukane elixiry: \n" + elixiryNaNovychRiadkoch);
        this.blokTextu.zmenFarbu("white");
        this.blokTextu.zobraz();

        String nazovElixiru = JOptionPane.showInputDialog(null, "Zadaj nazov elixiru ktory chces Vyrobit: ");
        if (nazovElixiru != null) {
            Elixir elixir = vyrobitElixir(nazovElixiru, hrac.getInventar());
            if (elixir != null) {
                hrac.getInventar().pridajVec(elixir);
                hrac.getInventar().zobrazElixiry();
                this.blokTextu.zmenText("Vyrobeny elixir: " + nazovElixiru);
                this.blokTextu.zobraz();
            }
        }
    }

    public Elixir vyrobitElixir(String nazovElixiru, Inventar inventar) {
        String elixirTrieda = "veci.elixiry." + nazovElixiru;

        try {
            Class<?> clazz = Class.forName(elixirTrieda);
            Constructor<?> ctor = clazz.getConstructor(String.class);
            Elixir elixir = (Elixir)ctor.newInstance(nazovElixiru);
            if (elixir.mozemVyrobit(inventar.getVeciList())) {
                // odstran ingrediencie z inventara pouzite na vyrobu elixiru
                inventar.odstranVeci(elixir.getPotrebneIngredience());
                return elixir;
            } else {
                this.blokTextu.zmenText("Nemozem vyrobit elixir: " + nazovElixiru + " - nemas vsetky potrebne ingrediencie");
                this.blokTextu.zobraz();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
