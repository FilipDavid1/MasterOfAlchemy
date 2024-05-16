package prekazky;

import fri.shapesge.DataObrazku;
import prekazky.postavy.HpBar;
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

    public void setX(int x, Obrazok obrazok, HpBar hpBar, DataObrazku dataObrazku) {
        this.x = x;
        hpBar.posunNa(x - 5 , y - (dataObrazku.getVyska() / 10));
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setY(int y, Obrazok obrazok, HpBar hpBar, DataObrazku dataObrazku) {
        this.y = y;
        hpBar.posunNa(x - 5 , y - (dataObrazku.getVyska() / 10));
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
    }

    public void setX(int x, Obrazok obrazok, BlokTextu blokTextu) {
        this.x = x;
        blokTextu.zmenPolohu(x, y + 140);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
        blokTextu.zobraz();
    }

    public void setY(int y, Obrazok obrazok, BlokTextu blokTextu) {
        this.y = y;
        blokTextu.zmenPolohu(x, y + 40);
        obrazok.zmenPolohu(x, y);
        obrazok.zobraz();
        blokTextu.zobraz();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
