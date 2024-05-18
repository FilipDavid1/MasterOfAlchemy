package nacitavanie;

import mapa.Mapa;
import prekazky.HernyObjekt;
import prekazky.postavy.Postava;
import fri.shapesge.Manazer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trieda NacitavaniePrekazok slúži na načítanie prekážok z textového súboru.
 */
public class NacitavaniePrekazok {
    private Mapa mapa;

    /**
     * Konštruktor pre triedu NacitavaniePrekazok.
     * @param mapa Mapa hry
     * @param manazer Manažér pre správu objektov
     */
    public NacitavaniePrekazok(Mapa mapa, Manazer manazer) {
        this.mapa = mapa;
        List<Map<String, String>> prekazkyData = null;
        try {
            prekazkyData = this.nacitajPrekazky("resources/prekazky.txt");
        } catch (IOException e) {
            e.getMessage();
        }

        if (prekazkyData != null) {
            for (Map<String, String> prekazkaData : prekazkyData) {
                String typ = prekazkaData.get("typ");
                String meno = prekazkaData.get("meno");
                int pocetObrazkov = Integer.parseInt(prekazkaData.get("pocetObrazkov"));
                String cestaKObrazku = prekazkaData.get("cestaKObrazku");
                int xPrekazka = Integer.parseInt(prekazkaData.get("x"));
                int yPrekazka = Integer.parseInt(prekazkaData.get("y"));

                HernyObjekt prekazka = this.vytvorObjekt(typ, meno, pocetObrazkov, cestaKObrazku, xPrekazka, yPrekazka);

                if (prekazka != null) {
                    mapa.pridajPrekazku(prekazka);
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
    public List<Map<String, String>> nacitajPrekazky(String subor) throws IOException {
        List<Map<String, String>> zaznamy = new ArrayList<>();
        BufferedReader citac = new BufferedReader(new FileReader(subor));
        String riadok;

        Map<String, String> aktualnyZaznam = new HashMap<>();
        while ((riadok = citac.readLine()) != null) {
            if (riadok.isEmpty()) {
                zaznamy.add(aktualnyZaznam);
                aktualnyZaznam = new HashMap<>();
            } else {
                String[] casti = riadok.split(": ");
                if (casti.length == 2) {
                    aktualnyZaznam.put(casti[0], casti[1]);
                }
            }
        }
        // Pridanie posledného záznamu
        if (!aktualnyZaznam.isEmpty()) {
            zaznamy.add(aktualnyZaznam);
        }
        citac.close();
        return zaznamy;
    }

    /**
     * Metóda vytvorObjekt vytvorí herný objekt na základe dát z textového súboru.
     * @param typ Typ objektu
     * @param meno Meno objektu
     * @param pocetObrazkov Počet obrázkov objektu
     * @param cestaKObrazku Cesta k obrázku objektu
     * @param x X-súradnica objektu
     * @param y Y-súradnica objektu
     * @return Vytvorený herný objekt
     */
    public HernyObjekt vytvorObjekt(String typ, String meno, int pocetObrazkov, String cestaKObrazku, int x, int y) {
        try {
            String plneMenoTriedy;
            if (typ.equals("monstrum")) {
                plneMenoTriedy = "prekazky.postavy.monstra." + meno;
            } else if (typ.equals("npc")) {
                plneMenoTriedy = "prekazky.postavy.npc." + meno;
            } else {
                plneMenoTriedy = meno;
            }
            Class<?> clazz = Class.forName(plneMenoTriedy);
            Constructor<?> ctor = clazz.getConstructor(int.class, String.class, int.class, int.class, Postava.class);
            return (HernyObjekt)ctor.newInstance(pocetObrazkov, cestaKObrazku, x, y, mapa.getHrac());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
