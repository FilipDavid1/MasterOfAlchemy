package Prekazky;

import Prekazky.Postavy.HpBar;
import fri.shapesge.BlokTextu;
import fri.shapesge.Obrazok;

public class HernaEntita {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x, Obrazok obrazok) {
        this.x = x;
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setY(int y, Obrazok obrazok) {
        this.y = y;
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setX(int x, Obrazok obrazok, HpBar hpBar) {
        this.x = x;
        hpBar.posunNa(x, hpBar.getY());
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setY(int y, Obrazok obrazok, HpBar hpBar) {
        this.y = y;
        hpBar.posunNa(hpBar.getX(), y);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setX(int x, Obrazok obrazok, BlokTextu blokTextu) {
        this.x = x;
        blokTextu.zmenPolohu(x, y - 10);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setY(int y, Obrazok obrazok, BlokTextu blokTextu) {
        this.y = y;
        blokTextu.zmenPolohu(x, y - 10);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
