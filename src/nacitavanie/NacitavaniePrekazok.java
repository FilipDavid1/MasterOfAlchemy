package nacitavanie;

import Mapa.Mapa;
import Prekazky.HernyObjekt;
import Prekazky.Postavy.Postava;
import fri.shapesge.Manazer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NacitavaniePrekazok {
    private Mapa mapa;

    public NacitavaniePrekazok(Mapa mapa, Manazer manazer) {
        this.mapa = mapa;
        List<Map<String, String>> prekazkyData = null;
        try {
            prekazkyData = this.nacitajPrekazky("resources/prekazky.txt");
        } catch (IOException e) {
            e.getMessage();
        }

        if (prekazkyData != null) {
            System.out.println("Pocet prekazok: " + prekazkyData.size());
            for (Map<String, String> prekazkaData : prekazkyData) {
                String typ = prekazkaData.get("typ");
                String meno = prekazkaData.get("meno");
                int pocetObrazkov = Integer.parseInt(prekazkaData.get("pocetObrazkov"));
                String cestaKObrazku = prekazkaData.get("cestaKObrazku");
                int xPrekazka = Integer.parseInt(prekazkaData.get("x"));
                int yPrekazka = Integer.parseInt(prekazkaData.get("y"));

                HernyObjekt prekazka = this.vytvorObjekt(typ, meno, pocetObrazkov, cestaKObrazku, xPrekazka, yPrekazka);

                if (prekazka != null) {
                    System.out.println("Pridavam prekazku: " + prekazka);
                    mapa.pridajPrekazku(prekazka);
                    manazer.spravujObjekt(prekazka);
                }
            }
        }

    }

    public List<Map<String, String>> nacitajPrekazky(String subor) throws IOException {
        List<Map<String, String>> zaznamy = new ArrayList<>();
        BufferedReader citac = new BufferedReader(new FileReader(subor));
        String riadok;

        Map<String, String> aktualnyZaznam = new HashMap<>();
        while ((riadok = citac.readLine()) != null) {
            System.out.println(riadok);
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



    public HernyObjekt vytvorObjekt(String typ, String meno, int pocetObrazkov, String cestaKObrazku, int x, int y) {
        try {
            String plneMenoTriedy;
            if (typ.equals("monstrum")) {
                plneMenoTriedy = "Prekazky.Postavy.Monstra." + meno;
            } else if (typ.equals("NPC")) {
                plneMenoTriedy = "Prekazky.Postavy.NPC" + meno;
            } else {
                plneMenoTriedy = meno;
            }
            System.out.println("Vytvaram objekt: " + plneMenoTriedy);
            Class<?> clazz = Class.forName(plneMenoTriedy);
            Constructor<?> ctor = clazz.getConstructor(int.class, String.class, int.class, int.class, Postava.class);
            return (HernyObjekt) ctor.newInstance(pocetObrazkov, cestaKObrazku, x, y, mapa.getHrac());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
