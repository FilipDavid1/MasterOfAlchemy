package Veci.Elixiry;

import Prekazky.Postavy.Carodejnik.Carodejnik;
import Veci.Ingrediencie.FenixovoPero;
import Veci.Ingrediencie.Ingrediencia;
import Veci.Ingrediencie.JednoroziaHriva;

import java.util.ArrayList;

public class ElixirSily implements Elixir {

    private Ingrediencia[] POTREBNE_INGREDIENCIE = {new JednoroziaHriva(), new FenixovoPero()};

    public ElixirSily(Carodejnik carodejnik, ArrayList<Ingrediencia> ingrediencie){
        //vytvor elixir ak su vsetky ingrediencie

        if (carodejnik.vyrobElixir(POTREBNE_INGREDIENCIE)){
            System.out.println("Vytvoril si elixir sily");
            //pridaj elixir do inventara
            carodejnik.getInventar().odstranVeci(ingrediencie);
            carodejnik.getInventar().pridajVec(this);
        }
        else{
            System.out.println("Nepodarilo sa ti vytvorit elixir sily");
        }

    }
    @Override
    public void pouzi() {

    }

    @Override
    public String getNazov() {
        return null;
    }

    @Override
    public int getCena() {
        return 0;
    }
}
