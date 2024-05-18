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
    private final String[] elixiry = {"ElixirJedu", "ElixirMoci", "ElixirMudrosti", "ElixirObnovenia", "ElixirObrany", "ElixirOdolnosti", "ElixirOdstraneniaKliadby", "ElixirOzivenia", "ElixirRegeneracie", "ElixirSily", "ElixirSkrytia"};
    private final BlokTextu blokTextu;
    public Alchymista(int pocetObrazkov, String cestaKObrazku, int x, int y, Postava hrac) {
        super(pocetObrazkov, cestaKObrazku + "0", x, y, 0);
        this.blokTextu = new BlokTextu("", 450, 30);
        this.blokTextu.zmenFont("Courier New", StylFontu.BOLD, 15);
    }

    @Override
    public void interakcia(Postava postava) {
        Hrac hrac = (Hrac)postava;
        StringBuilder elixiryNaNovychRiadkoch = new StringBuilder();
        for (String elixir : this.elixiry) {
            //vypis meno elixiru aj jeho popis
            try {
                Class<?> clazz = Class.forName("veci.elixiry." + elixir);
                Constructor<?> ctor = clazz.getConstructor(String.class);
                Elixir elixirObj = (Elixir)ctor.newInstance(elixir);
                elixiryNaNovychRiadkoch.append(elixirObj.getNazov()).append(" - ").append(elixirObj.popisElixira()).append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        String nazovElixiru = JOptionPane.showInputDialog(null, "Zadaj nazov elixiru ktory chces Vyrobit: \n" + elixiryNaNovychRiadkoch);
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

    public void tik() {
        super.idleAnimacia(super.getCestaKObrazku().replace("0", ""));
    }
}
