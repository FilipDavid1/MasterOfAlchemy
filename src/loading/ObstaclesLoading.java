package loading;

import map.Map;
import obstacles.GameObject;
import obstacles.characters.Character;
import fri.shapesge.Manazer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Trieda NacitavaniePrekazok slúži na načítanie prekážok z textového súboru.
 */
public class ObstaclesLoading {
    private Map map;

    /**
     * Konštruktor pre triedu NacitavaniePrekazok.
     * @param map Mapa hry
     * @param manazer Manažér pre správu objektov
     */
    public ObstaclesLoading(Map map, Manazer manazer) {
        this.map = map;
        List<java.util.Map<String, String>> obstaclesData = null;
        try {
            obstaclesData = this.loadObstacles("resources/prekazky.txt");
        } catch (IOException e) {
            e.getMessage();
        }

        if (obstaclesData != null) {
            for (java.util.Map<String, String> obstacleData : obstaclesData) {
                String typ = obstacleData.get("typ");
                String meno = obstacleData.get("meno");
                int numberOfImages = Integer.parseInt(obstacleData.get("numberOfImages"));
                String pathToImage = obstacleData.get("pathToImage");
                int x = Integer.parseInt(obstacleData.get("x"));
                int y = Integer.parseInt(obstacleData.get("y"));

                GameObject prekazka = this.vytvorObjekt(typ, meno, numberOfImages, pathToImage, x, y);

                if (prekazka != null) {
                    map.addObstacle(prekazka);
                    manazer.spravujObjekt(prekazka);
                }
            }
        }
    }

    /**
     * Metóda nacitajPrekazky načíta prekážky z textového súboru.
     * @param subor Cesta k textovému súboru
     * @return Zoznam prekážok
     * @throws IOException Chyba pri čítaní súboru
     */
    public List<java.util.Map<String, String>> loadObstacles(String subor) throws IOException {
        List<java.util.Map<String, String>> records = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(subor));
        String row;

        java.util.Map<String, String> actualRecord = new HashMap<>();
        while ((row = bufferedReader.readLine()) != null) {
            if (row.isEmpty()) {
                records.add(actualRecord);
                actualRecord = new HashMap<>();
            } else {
                String[] parts = row.split(": ");
                if (parts.length == 2) {
                    actualRecord.put(parts[0], parts[1]);
                }
            }
        }
        // Pridanie posledného záznamu
        if (!actualRecord.isEmpty()) {
            records.add(actualRecord);
        }
        bufferedReader.close();
        return records;
    }

    /**
     * Metóda vytvorObjekt vytvorí herný objekt na základe dát z textového súboru.
     * @param type Typ objektu
     * @param name Meno objektu
     * @param numberOfImages Počet obrázkov objektu
     * @param pathToImage Cesta k obrázku objektu
     * @param x X-súradnica objektu
     * @param y Y-súradnica objektu
     * @return Vytvorený herný objekt
     */
    public GameObject vytvorObjekt(String type, String name, int numberOfImages, String pathToImage, int x, int y) {
        try {
            String classFullName;
            if (type.equals("monstrum")) {
                classFullName = "obstacles.characters.monsters." + name;
            } else if (type.equals("npc")) {
                classFullName = "obstacles.characters.npcs." + name;
            } else {
                classFullName = name;
            }
            Class<?> clazz = Class.forName(classFullName);
            Constructor<?> ctor = clazz.getConstructor(int.class, String.class, int.class, int.class, Character.class);
            return (GameObject)ctor.newInstance(numberOfImages, pathToImage, x, y, map.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
