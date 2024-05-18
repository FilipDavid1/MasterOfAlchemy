package prekazky.postavy.hrac;

import interakcie.Interakcia;
import mapa.Mapa;
import prekazky.postavy.OrientaciaPostavy;
import prekazky.postavy.Postava;
import prekazky.postavy.monstra.IMonstrum;
import prekazky.postavy.monstra.Skeleton;
import veci.elixiry.ElixirJedu;
import veci.elixiry.ElixirMoci;
import veci.elixiry.ElixirOdolnosti;
import veci.elixiry.ElixirOzivenia;
import veci.elixiry.ElixirRegeneracie;
import veci.elixiry.ElixirSkrytia;
import veci.elixiry.ElixirObnovenia;
import fri.shapesge.Kruh;
import fri.shapesge.Manazer;

/**
 * Trieda Hrac reprezentuje hráča v hre.
 */
public class Hrac extends Postava {
    private final Mapa mapa; // Mapa hry
    private final Kruh kruh; // Kruh okolo hráča
    private Inventar inventar; // Inventár hráča
    private Interakcia interakcia; // Interakcia hráča s objektami na mape
    private Postava vybrataPostava; // Vybratá postava na mape
    private int casRegeneracie; // Čas regenerácie hráča

    /**
     * Konštruktor pre triedu Hrac.
     * @param pocetObrazkovIdle Počet obrázkov pre animáciu nečinnosti
     * @param nazov Názov hráča
     * @param x X-súradnica hráča
     * @param y Y-súradnica hráča
     * @param mapa Mapa hry
     * @param manazer Manažér pre správu objektov
     */
    public Hrac(int pocetObrazkovIdle, String nazov, int x, int y, Mapa mapa, Manazer manazer) {
        super(pocetObrazkovIdle, nazov, x, y, 10);
        this.mapa = mapa;
        this.kruh = new Kruh();
        this.inventar = new Inventar();
        this.interakcia = new Interakcia(mapa, this.inventar, this);
        manazer.spravujObjekt(this.interakcia);
        this.vybrataPostava = null;

        // Pridanie elixírov do inventára
        this.inventar.pridajVec(new ElixirObnovenia("ElixirObnovenia"));
        this.inventar.pridajVec(new ElixirMoci("ElixirMoci"));
        this.inventar.pridajVec(new ElixirOdolnosti("ElixirOdolnosti"));
        this.inventar.pridajVec(new ElixirOzivenia("ElixirOzivenia"));
        this.inventar.pridajVec(new ElixirRegeneracie("ElixirRegeneracie"));
        this.inventar.pridajVec(new ElixirSkrytia("ElixirSkrytia"));
        this.inventar.pridajVec(new ElixirJedu("ElixirJedu"));
    }

    /**
     * Metóda chodDole posunie hráča dole.
     */
    public void chodDole() {
        float targetY = super.getY() + 10;
        float newY = lerp(super.getY(), targetY, super.getRychlost());
        if (this.mapa.getY() <= -1840 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Down_");
        super.setOrientacia(OrientaciaPostavy.DOWN);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.setVelY(-5 * ( super.getRychlost()));
        }
    }

    /**
     * Metóda chodHore posunie hráča hore.
     */
    public void chodHore() {
        float targetY = super.getY() - 10;
        float newY = lerp(super.getY(), targetY, super.getRychlost());
        if (this.mapa.getY() >= 0 || super.getY() != 450) {
            super.posunNa(super.getX(), (int)newY);
        }
        this.krok("Walk_Up_");
        super.setOrientacia(OrientaciaPostavy.UP);
        this.hybeSa();
        if (super.getY() == 450) {
            this.mapa.setVelY(5 * ( super.getRychlost()));
        }
    }

    /**
     * Metóda chodVlavo posunie hráča vľavo.
     */
    public void chodVlavo() {
        float targetX = super.getX() - 10;
        float newX = lerp(super.getX(), targetX, super.getRychlost());
        if (this.mapa.getX() >= 0 || super.getX() <= 725) {
            super.posunNa((int)newX, super.getY());
        }
        this.krok("Walk_Left_");
        super.setOrientacia(OrientaciaPostavy.LEFT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.mapa.setVelX(5 * ( super.getRychlost()));
        }
    }

    /**
     * Metóda chodVpravo posunie hráča vpravo.
     */
    public void chodVpravo() {
        float targetX = super.getX() + 10;
        float newX = lerp(super.getX(), targetX, super.getRychlost());
        if (this.mapa.getX() <= -2910 || super.getX() <= 725) {
            super.posunNa((int)newX, super.getY());
        }
        this.krok("Walk_Right_");
        super.setOrientacia(OrientaciaPostavy.RIGHT);
        this.hybeSa();
        if (super.getX() >= 725) {
            this.mapa.setVelX(-5 * ( super.getRychlost()));
        }
    }

    /**
     * Metóda stop zastaví hráča.
     */
    public void stop() {
        this.nehybeSa();
        this.kruh.skry();
        this.inventar.skryIngrediencieSInventara();
    }

    /**
     * Metóda nehybeSa nastaví hráča do stavu nehybe sa.
     */
    public void nehybeSa() {
        super.setHybeSa(false);
    }

    /**
     * Metóda hybeSa nastaví hráča do stavu hybe sa.
     */
    public void hybeSa() {
        super.setHybeSa(true);
    }

    /**
     * Metóda tik sa volá v každom cykle hry.
     * Aktualizuje stav hráča.
     */
    public void tik() {
        if (!super.getHybeSa()) {
            this.idleAnimacia(  super.getCestaKObrazku().replace("Down_0", "") + super.getOrientacia() + "_");
        }

        if (super.getCasOslabenia() > 0 && !super.getJeOtraveny()) {
            super.oslabenie((super.getCasOslabenia() / 1000) - 1);
        }

        if (casRegeneracie > 0) {
            if (casRegeneracie % 1000 == 0) {
                super.pridajHp(5);
            }
            casRegeneracie -= 200;
        }

        if (super.getY() <= 0) {
            super.posunNa(super.getX(), 0);
        }

        if (super.getY() >= 800) {
            super.posunNa(super.getX(), 800);
        }

    }

    /**
     * Metóda getInventar vráti inventár hráča.
     * @return Inventár hráča
     */
    public Inventar getInventar() {
        return this.inventar;
    }

    /**
     * Metóda utocNaMonstra umožní hráčovi útočiť na monštrá.
     */
    public void utocNaMonstra() {
        if (this.vybrataPostava != null) {
            double vzdialenost = Math.sqrt(Math.pow(vybrataPostava.getX() - this.getX(), 2) + Math.pow(vybrataPostava.getY() - this.getY(), 2));
            if (vzdialenost < 200) {
                this.interakcia(this.vybrataPostava);
            }
        }
    }

    /**
     * Metóda vyberPostavu umožní hráčovi vybrať postavu.
     * @param monstum Postava na výber
     */
    public void vyberPostavu(Postava monstum) {
        this.vybrataPostava = monstum;
    }


    /**
     * Metóda interakcia umožní hráčovi interagovať s postavou.
     * @param postava Postava na interakciu
     */
    @Override
    public void interakcia(Postava postava) {
        if (postava instanceof IMonstrum ) {
            if (postava instanceof Skeleton skeleton) {
                if (!skeleton.jeBarieraAktivna()) {
                    postava.uberHp(super.getSila());
                } else {
                    skeleton.znicBarieru();
                }
            } else {
                postava.uberHp(super.getSila());
            }
            this.attackAnimacia(super.getCestaKObrazku().replace("/Idle/Idle_Down_0", "/Attack/Attack_") + super.getOrientacia() + "_", 6 );
        } else {
            postava.interakcia(this);
        }
    }

    /**
     * Metóda lerp vypočíta lineárnu interpoláciu medzi dvoma hodnotami.
     * @param zaciatok Začiatočná hodnota
     * @param koniec Konečná hodnota
     * @param rychlost Rýchlosť interpolácie
     * @return Výsledok lineárnej interpolácie
     */
    private float lerp(float zaciatok, float koniec, float rychlost) {
        return zaciatok + rychlost * (koniec - zaciatok);
    }

    /**
     * Metóda zobrazInventar zobrazí inventár hráča.
     */
    public void zobrazInventar() {
        this.inventar.zobrazIngrediencieVInventari();
    }

    /**
     * Metóda pouziElixir1 umožní hráčovi použiť elixír 1.
     */
    public void pouziElixir1() {
        inventar.pouziElixir(0, this);
    }

    /**
     * Metóda pouziElixir2 umožní hráčovi použiť elixír 2.
     */
    public void pouziElixir2() {
        inventar.pouziElixir(1, this);
    }

    /**
     * Metóda pouziElixir3 umožní hráčovi použiť elixír 3.
     */
    public void pouziElixir3() {
        inventar.pouziElixir(2, this);
    }

    /**
     * Metóda pouziElixir4 umožní hráčovi použiť elixír 4.
     */
    public void pouziElixir4() {
        inventar.pouziElixir(3, this);
    }

    /**
     * Metóda pouziElixir5 umožní hráčovi použiť elixír 5.
     */
    public void pouziElixir5() {
        inventar.pouziElixir(4, this);
    }

    /**
     * Metóda pouziElixir6 umožní hráčovi použiť elixír 6.
     */
    public void pouziElixir6() {
        inventar.pouziElixir(5, this);
    }

    /**
     * Metóda pouziElixir7 umožní hráčovi použiť elixír 7.
     */
    public void pouziElixir7() {
        inventar.pouziElixir(6, this);
    }

    /**
     * Metóda pouziElixir8 umožní hráčovi použiť elixír 8.
     */
    public void pouziElixir8() {
        inventar.pouziElixir(7, this);
    }

    /**
     * Metóda pouziElixir9 umožní hráčovi použiť elixír 9.
     */
    public void pouziElixir9() {
        inventar.pouziElixir(8, this);
    }

    /**
     * Metóda pouziElixir10 umožní hráčovi použiť elixír 10.
     */
    public void pouziElixir10() {
        inventar.pouziElixir(9, this);
    }

    /**
     * Metóda getVybrataPostava vráti vybratú postavu hráčom.
     * @return Vybratá postava
     */
    public Postava getVybrataPostava() {
        return this.vybrataPostava;
    }

    /**
     * Metóda regenerujHp umožní hráčovi regenerovať zdravie.
     * @param sekundy Počet sekúnd pre regeneráciu
     */
    public void regenerujHp(int sekundy) {
        this.casRegeneracie = sekundy * 1000;
    }
}
