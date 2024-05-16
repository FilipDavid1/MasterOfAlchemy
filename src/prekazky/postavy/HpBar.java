package prekazky.postavy;

import fri.shapesge.Obdlznik;

public class HpBar {
    private int hp;
    private Obdlznik vonkajsi;
    private Obdlznik vnutorny;

    private int x;
    private int y;

    public HpBar(int x, int y) {
        this.hp = 100;
        this.vonkajsi = new Obdlznik(x, y);
        this.vonkajsi.zmenStrany(104, 12);
        this.vonkajsi.zmenFarbu("black");
        this.vnutorny = new Obdlznik(x + 2, y + 2);
        this.vnutorny.zmenStrany(100, 8);
        this.vnutorny.zmenFarbu("green");
        this.zobraz();
        this.x = x;
        this.y = y;
    }

    public void uberHp(float kolko) {
        hp -= kolko;
        if (hp < 0) {
            hp = 0;
        }
        vnutorny.zmenStrany(hp, 8);
    }

    public void posunNa(int x, int y) {
        this.x = x;
        this.y = y;
        vonkajsi.zmenPolohu(x - 17, y - 10);
        vnutorny.zmenPolohu(x - 15, y - 8);
        this.zobraz();
    }

    public void zobraz() {
        vonkajsi.zobraz();
        vnutorny.zobraz();
    }

    public void skry() {
        vonkajsi.skry();
        vnutorny.skry();
    }


    public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void pridajHp(float kolko) {
        hp += kolko;
        if (hp > 100) {
            hp = 100;
        }
        vnutorny.zmenStrany(hp, 8);
    }
}
