package world;

import fri.shapesge.Manazer;
import map.Map;
import loading.ObstaclesLoading;
import obstacles.characters.player.Player;

public class World {
    public static void main(String[] args) {
        Manazer manazer = new Manazer();
        Map map = new Map(manazer);

        Player player = new Player(4, "resources/Obrazky/player/Idle/Idle_Down_0", 725, 450, map, manazer);
        manazer.spravujObjekt(player);
        map.setPlayer(player);
        ObstaclesLoading obstaclesLoading = new ObstaclesLoading(map, manazer);
    }
}
