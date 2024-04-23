//package Veci.Elixiry;
//
//import Prekazky.Postavy.Hrac.Hrac;
//import Veci.Ingrediencie.Ingrediencia;
//
//import java.util.ArrayList;
//
//public class ElixirSily implements Elixir {
//
//    private Ingrediencia[] POTREBNE_INGREDIENCIE = {new JednoroziaHriva("d", 0,0), new FenixovoPero()};
//
//    public ElixirSily(Hrac hrac, ArrayList<Ingrediencia> ingrediencie){
//        //vytvor elixir ak su vsetky ingrediencie
//
//        if (hrac.vyrobElixir(POTREBNE_INGREDIENCIE)){
//            System.out.println("Vytvoril si elixir sily");
//            //pridaj elixir do inventara
//            hrac.getInventar().odstranVeci(ingrediencie);
//            hrac.getInventar().pridajVec(this);
//        }
//        else{
//            System.out.println("Nepodarilo sa ti vytvorit elixir sily");
//        }
//
//    }
//    @Override
//    public void pouzi() {
//
//    }
//
//    @Override
//    public String getNazov() {
//        return null;
//    }
//
//    @Override
//    public int getCena() {
//        return 0;
//    }
//}
