package nacitavanie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NacitavaniePrekazok {





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
        citac.close();
        return zaznamy;
    }
}
