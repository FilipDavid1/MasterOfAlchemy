package Interakcie;

import Prekazky.Postavy.Carodejnik.Carodejnik;
import Svet.Svet;
import Veci.Vec;

public class Zbieranie implements Interakcia {

    private Carodejnik postava;
    private Vec predmet;
    public Zbieranie(Carodejnik postava, Vec predmet) {
        this.postava = postava;
        this.predmet = predmet;
    }

    @Override
    public String getNazov() {
        return null;
    }

    @Override
    public void vykonaj(Svet svet) {
        this.postava.pridajVecDoInventara(this.predmet);
    }
}
