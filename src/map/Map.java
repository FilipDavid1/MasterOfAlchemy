package map;

import obstacles.GameObject;
import obstacles.characters.Character;
import obstacles.characters.monsters.IMonstrum;
import obstacles.characters.monsters.StrelecMonstrum;
import obstacles.characters.npcs.Alchemist;
import things.ingredients.Ingredient;
import things.ingredients.Ingredients;
import fri.shapesge.Manazer;
import fri.shapesge.Obrazok;

import java.util.ArrayList;
import java.util.List;

/**
 * Trieda Mapa reprezentuje hernú mapu.
 */
public class Map {
    private final Obrazok mapaObr; // Obrázok mapy

    private int x;
    private int y;
    private ArrayList<GameObject> gameObjects;
    private ArrayList<Ingredient> ingredients;
    private Character player;
    private final Manazer manazer;
    private double velX;
    private double velY;

    /**
     * Konštruktor pre triedu Mapa.
     * @param manazer Manažér pre správu objektov
     */
    public Map(Manazer manazer) {
        this.mapaObr = new Obrazok("resources/Obrazky/map/map.png");
        this.mapaObr.zmenPolohu(0, 0);
        this.mapaObr.zobraz();
        this.x = 0;
        this.y = 0;
        this.gameObjects = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.manazer = manazer;
        manazer.spravujObjekt(this);
    }

    /**
     * Metóda setVelX nastaví rýchlosť pohybu mapy v osi X.
     * @param velX Rýchlosť pohybu
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }

    /**
     * Metóda setVelY nastaví rýchlosť pohybu mapy v osi Y.
     * @param velY Rýchlosť pohybu
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Metóda stopX zastaví pohyb mapy v osi X.
     */
    public void stopX() {
        this.setVelX(0);
    }

    /**
     * Metóda stopY zastaví pohyb mapy v osi Y.
     */
    public void stopY() {
        this.setVelY(0);
    }

    /**
     * Metóda mapTik sa volá v každom cykle hry.
     * Aktualizuje polohu mapy a objektov na mape.
     */
    public void mapTik() {
        this.deleteDeadObstacles();
        int stareX = this.x;
        int stareY = this.y;

        this.x += this.velX;
        this.y += this.velY;

        if (this.y >= 0) {
            this.y = 0;
        } else if (this.y <= -1840) {
            this.y = -1840;
        }

        if (this.x >= 0) {
            this.x = 0;
        } else if (this.x <= -2910) {
            this.x = -2910;
        }

        int noveX = this.x;
        int noveY = this.y;
        this.mapaObr.zmenPolohu(this.x, this.y);

        this.moveGameObjets(noveX - stareX, noveY - stareY);
    }

    /**
     * Metóda attack sa volá, keď hráč útočí.
     * Kontroluje interakciu medzi hráčom a postavami na mape.
     */
    public void attack() {
        this.characterInteractions();
    }

    /**
     * Metóda interakciaPostav kontroluje interakciu medzi hráčom a postavami na mape.
     */
    private void characterInteractions() {
        for (GameObject obstacle : this.gameObjects) {
            if (obstacle instanceof Character character) {
                double distance = Math.sqrt(Math.pow(character.getX() - player.getX(), 2) + Math.pow(character.getY() - player.getY(), 2));
                if (distance < 200 && !(character instanceof Alchemist)) {
                    character.interaction(this.player);
                    character.setAttacking(true);
                } else {
                    character.setAttacking(false);
                }
            }
        }
    }

    /**
     * Metóda getX vráti X-súradnicu mapy.
     * @return X-súradnica mapy
     */
    public int getX() {
        return x;
    }

    /**
     * Metóda getY vráti Y-súradnicu mapy.
     * @return Y-súradnica mapy
     */
    public int getY() {
        return y;
    }

    /**
     * Metóda pridajPrekazku pridá prekážku na mapu.
     * @param prekazka Prekážka na pridanie
     */
    public void addObstacle(GameObject prekazka) {
        this.gameObjects.add(prekazka);
        prekazka.setX(prekazka.getX() + this.x);
        prekazka.setY(prekazka.getY() + this.y);
        if (prekazka instanceof Character character) {
            if (character instanceof IMonstrum) {
                character.setMeno("Monstrum: " + character.getClass().getSimpleName(), character.getX() - 20, character.getY() - 20);
            }
        }
    }

    /**
     * Metóda pridajPrekazky pridá zoznam prekážok na mapu.
     * @param obstacles Zoznam prekážok na pridanie
     */
    public void addObstacles(List<GameObject> obstacles) {
        for (GameObject obstacle : obstacles) {
            this.addObstacle(obstacle);
        }
    }

    /**
     * Metóda pridajIngredienciu pridá ingredienciu na mapu.
     * @param ingredient Ingrediencia na pridanie
     */
    private void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    /**
     * Metóda posunHerneObjekty posunie herné objekty na mape.
     * @param x Posun v osi X
     * @param y Posun v osi Y
     */
    public void moveGameObjets(int x, int y) {
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject instanceof Character) {
                Character character = (Character)gameObject;
                character.moveTo(character.getX() + x, character.getY() + y);
            } else {
                gameObject.setX(gameObject.getX() + x);
                gameObject.setY(gameObject.getY() + y);
            }

        }

        for (Ingredient ingredient : this.ingredients) {
            ingredient.setX(ingredient.getX() + x, ingredient.getImage(), ingredient.getBlockOfText());
            ingredient.setY(ingredient.getY() + y, ingredient.getImage(), ingredient.getBlockOfText());
        }
    }

    /**
     * Metóda vymazMrtvePrekazky vymaže mŕtve prekážky z mapy.
     */
    private void deleteDeadObstacles() {
        ArrayList<GameObject> deadObstacles = new ArrayList<>();
        for (GameObject obstacle : this.gameObjects) {
            if (obstacle instanceof Character character) {
                if (character.isDead()) {
                    if (character instanceof StrelecMonstrum strelec) {
                        strelec.zmazStrely();
                    }
                    character.hideImage();
                    deadObstacles.add(obstacle);
                    //manazer prestane spravovat objekt
                    manazer.prestanSpravovatObjekt(character);
                    Ingredient ingredient = new Ingredient(Ingredients.getRandomIngredienciu(), character.getX(), character.getY());
                    this.addIngredient(ingredient);
                }
            }
        }

        this.gameObjects.removeAll(deadObstacles);
    }

    /**
     * Metóda getPrekazky vráti zoznam prekážok na mape.
     * @return Zoznam prekážok na mape
     */
    public ArrayList<GameObject> getGameObjects() {
        return new ArrayList<>(this.gameObjects);
    }

    /**
     * Metóda vymazIngredienciu vymaže ingredienciu z mapy.
     * @param ingredient Ingrediencia na vymazanie
     */
    public void deleteIngredient(Ingredient ingredient) {
        ingredient.skry();
        this.ingredients.remove(ingredient);
    }

    /**
     * Metóda getIngrediencie vráti zoznam ingrediencií na mape.
     * @return Zoznam ingrediencií na mape
     */
    public ArrayList<Ingredient> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    /**
     * Metóda setplayer nastaví hráča na mape.
     * @param player Hráč na nastavenie
     */
    public void setPlayer(Character player) {
        this.player = player;
    }

    /**
     * Metóda getplayer vráti hráča na mape.
     * @return Hráč na mape
     */
    public Character getPlayer() {
        Character player1 = this.player;
        return player1;
    }

}
