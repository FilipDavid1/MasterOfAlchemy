package Interakcie;

import Svet.Svet;

public interface Interakcia {
    //nazov interakcie
    String getNazov();
    //vykonanie interakcie
    void vykonaj(Svet svet);
}
