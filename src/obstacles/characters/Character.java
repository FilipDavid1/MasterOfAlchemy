package obstacles.characters;

import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import obstacles.GameObject;
import obstacles.characters.player.Player;

/**
 * Abstraktná trieda Postava, ktorá rozširuje triedu HernyObjekt.
 */
public abstract class Character extends GameObject {
    private int animation;
    private boolean isMoving = false;
    private CharacterOrientation orientation;
    private final HpBar hpBar;
    private float movementSpeed = 0.7f;
    private int weaknessDuration = 0;
    private boolean isAttacking = false;
    private float strength;
    private final float originalStrength;
    private boolean isPoisoned = false;
    private float deductedLives = 0;
    private BlokTextu name;

    /**
     * Konštruktor pre triedu Postava.
     *
     * @param numberOfImages Počet obrázkov pre animáciu.
     * @param pathToImage Cesta k obrázku pre animáciu.
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     * @param strength Sila postavy.
     */
    public Character(int numberOfImages, String pathToImage, int x, int y, int strength) {
        super(numberOfImages, pathToImage, x, y);
        this.orientation = CharacterOrientation.DOWN;
        this.hpBar = new HpBar(x - 20 , y - 15);
        System.out.println(super.getWidth() + "  " + super.getHeight() + "  " + pathToImage + "  " + x + "  " + y);
        this.strength = strength;
        this.originalStrength = strength;
        this.name = new BlokTextu(this.getClass().getSimpleName(), x, y - 20);
        this.name.zmenFont("Courier New", StylFontu.BOLD, 15);
        this.name.zmenFarbu("white");
        this.name.zobraz();
    }

    /**
     * Abstraktná metóda interakcia, ktorá sa volá pri interakcii s postavou.
     * Implementácia tejto metódy závisí od konkrétnej triedy, ktorá túto triedu rozširuje.
     *
     * @param character Postava, s ktorou sa interaguje.
     */
    public abstract void interaction(Character character);

    /**
     * Metóda nastavObrazok, ktorá nastavuje obrázok postavy.
     */
    @Override
    public void setImage() {
        super.setImage(getPathToImage().replace("0", "") + animation + ".png");
        super.changeImagePosition(super.getX(), super.getY());
    }

    /**
     * Metóda krok, ktorá vykonáva animáciu pohybu postavy.
     *
     * @param imgName Názov obrázku pre animáciu.
     */
    public void step(String imgName) {
        animation++;
        if (animation >= super.getNumberOfImages()) {
            animation = 0;
        }
        super.changeImage(super.getPathToImage().replace("Idle/Idle_Down_0", "") + "Walk/" + imgName + animation + ".png");
    }

    /**
     * Metóda idleAnimacia, ktorá vykonáva animáciu nečinnosti postavy.
     *
     * @param imgname Názov obrázku pre animáciu.
     */
    public void idleAnimation(String imgname) {
        animation++;
        if (animation >= super.getNumberOfImages()) {
            animation = 0;
        }
        super.changeImage(  imgname + animation + ".png");

        if (weaknessDuration > 0 && isPoisoned) {
            weaknessDuration = weaknessDuration - 200;
        } else {
            this.isPoisoned = false;
        }

        if (this.isPoisoned) {
            this.hpBar.reduceHp(deductedLives);
        }
    }

    /**
     * Metóda posunNa, ktorá posúva postavu na danú pozíciu.
     *
     * @param x X-ová pozícia na mape.
     * @param y Y-ová pozícia na mape.
     */
    public void moveTo(int x, int y) {
        super.setX(x, super.getImage(), hpBar, super.getData());
        super.setY(y, super.getImage(), hpBar, super.getData());
        if (!(this instanceof Player)) {
            this.name.zmenPolohu(x - 20, y - 20);
        } else {
            this.name.zmenPolohu(x, y - 20);
        }
    }

    /**
     * Metóda skry, ktorá skrýva postavu.
     */
    public void hideImage() {
        super.hideImage();
        this.hpBar.hideHpBar();
        this.name.skry();
    }

    /**
     * Metóda zobraz, ktorá zobrazuje postavu.
     */
    public void show() {
        super.showImage();
        this.hpBar.show();
    }

    /**
     * Metóda setHybeSa, ktorá nastavuje, či sa postava hýbe.
     *
     * @param moving Boolean hodnota, či sa postava hýbe.
     */
    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    /**
     * Metóda getHybeSa, ktorá vráti, či sa postava hýbe.
     *
     * @return boolean Hodnota, či sa postava hýbe.
     */
    public boolean getMoving() {
        return isMoving;
    }

    /**
     * Metóda setOrientacia, ktorá nastavuje orientáciu postavy.
     *
     * @param orientation Orientácia postavy.
     */
    public void setOrientation(CharacterOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Metóda getOrientacia, ktorá vráti orientáciu postavy.
     *
     * @return String Orientácia postavy.
     */
    protected String getOrientation() {
        return orientation.toString();
    }

    /**
     * Metóda uberHp, ktorá odoberá zdravie postave.
     *
     * @param kolko Počet bodov zdravia, ktoré sa majú odobrať.
     */
    public void uberHp(float kolko) {
        this.hpBar.reduceHp(kolko);
        if (this.hpBar.getHp() <= 0) {
            this.hideImage();
        }
    }

    /**
     * Metóda pridajHp, ktorá pridáva zdravie postave.
     *
     * @param howMuch Počet bodov zdravia, ktoré sa majú pridať.
     */
    public void addHp(float howMuch) {
        this.hpBar.addHp(howMuch);
        this.show();
    }

    /**
     * Metóda jeMrtvy, ktorá vráti, či je postava mŕtva.
     *
     * @return boolean Hodnota, či je postava mŕtva.
     */
    public boolean isDead() {
        return this.hpBar.getHp() <= 0;
    }

    /**
     * Metóda attackAnimacia, ktorá vykonáva animáciu útoku postavy.
     *
     * @param imgname Názov obrázku pre animáciu.
     * @param i Počet obrázkov pre animáciu.
     */
    protected void attackAnimation(String imgname, int i) {
        animation++;
        if (animation >= i) {
            animation = 0;
        }
        super.changeImage(  imgname + animation + ".png");

        if (weaknessDuration > 0) {
            weaknessDuration = weaknessDuration - 200;
        } else {
            this.strength = originalStrength;
            this.isPoisoned = false;
        }

        if (this.isPoisoned) {
            this.hpBar.reduceHp(0.5f);
        }
    }

    /**
     * Metóda getSpeed, ktorá vráti rýchlosť postavy.
     *
     * @return float Rýchlosť postavy.
     */
    public float getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Metóda oslabenie, ktorá nastavuje čas oslabenia postavy.
     * Ak je čas oslabenia nulový, rýchlosť postavy je nastavená na 0.7f, inak je nastavená na 0.3f.
     *
     * @param seconds Čas oslabenia v sekundách.
     */
    public void weakness(int seconds) {
        this.weaknessDuration = seconds;

        if (this.weaknessDuration == 0) {
            this.movementSpeed = 0.7f;
        } else {
            this.movementSpeed = 0.3f;
        }
    }

    /**
     * Metóda getCasOslabenia, ktorá vráti čas oslabenia postavy v milisekundách.
     *
     * @return int Čas oslabenia v milisekundách.
     */
    public int getWeaknessDuration() {
        return weaknessDuration * 1000;
    }

    /**
     * Metóda setUtoci, ktorá nastavuje, či postava útočí.
     *
     * @param attacking Boolean hodnota, či postava útočí.
     */
    public void setAttacking(boolean attacking) {
        this.isAttacking = attacking;
    }

    /**
     * Metóda getUtoci, ktorá vráti, či postava útočí.
     *
     * @return boolean Hodnota, či postava útočí.
     */
    public boolean getAttacking() {
        return isAttacking;
    }

    /**
     * Metóda getHp, ktorá vráti aktuálne zdravie postavy.
     *
     * @return float Aktuálne zdravie postavy.
     */
    public float getHp() {
        return hpBar.getHp();
    }

    /**
     * Metóda getSila, ktorá vráti silu postavy.
     *
     * @return float Sila postavy.
     */
    public float getStrength() {
        return strength;
    }

    /**
     * Metóda setSila, ktorá nastavuje silu postavy.
     *
     * @param strength Sila postavy.
     */
    public void setStrength(float strength) {
        this.strength = strength;
    }

    /**
     * Metóda setSila, ktorá nastavuje silu postavy a čas oslabenia.
     *
     * @param sila Sila postavy.
     * @param cas Čas oslabenia v sekundách.
     */
    public void setStrength(float sila, int cas) {
        this.strength = sila;
        this.weaknessDuration = cas * 1000;
    }

    /**
     * Metóda otrav, ktorá nastavuje čas oslabenia, nastavuje postavu ako otrávenú a nastavuje ubrané životy na 0.5f.
     *
     * @param cas Čas oslabenia v sekundách.
     */
    public void poison(int cas) {
        this.weaknessDuration = cas * 1000;
        this.isPoisoned = true;
        this.deductedLives = 0.5f;
    }

    /**
     * Metóda otrav, ktorá nastavuje čas oslabenia, nastavuje postavu ako otrávenú a nastavuje ubrané životy.
     *
     * @param cas Čas oslabenia v sekundách.
     * @param zivoty Počet ubraných životov.
     */
    public void poison(int cas, int zivoty) {
        this.weaknessDuration = cas * 1000;
        this.isPoisoned = true;
        this.deductedLives = zivoty;
    }

    /**
     * Metóda getJeOtraveny, ktorá vráti, či je postava otrávená.
     *
     * @return boolean Hodnota, či je postava otrávená.
     */
    protected boolean getIsPoisoned() {
        return isPoisoned;
    }

    /**
     * Metóda setMeno, ktorá nastavuje meno postavy a mení polohu mena.
     *
     * @param s Meno postavy.
     * @param x X-ová pozícia mena na mape.
     * @param y Y-ová pozícia mena na mape.
     */
    public void setMeno(String s, int x, int y) {
        this.name.zmenPolohu(x, y);
        this.name.zmenText(s);
    }
}

