package Veci.Ingrediencie;

public enum Ingrediencie {
    AmadamovyList,
    Ametist,
    Ashwagandha,
    Ayahuasca,
    Balvany,
    Bufotenin,
    Cernice,
    CervenyList,
    Dimethyltryptamin,
    DurmanObycajny,
    Fazula,
    Fencyklidin,
    Gastany,
    HavajskaRuza,
    Hrach,
    Ibogain,
    JavorovyList,
    Koren,
    Lekno,
    LieskovyOrech,
    Lisohlavky,
    List,
    Lopuch,
    Mrkva,
    MuskatovyOrech,
    Obilie,
    PeyotiKaktus,
    Plevel,
    Psilocybin,
    Rohace,
    Salvia,
    Semienka,
    Sipky,
    Slivka,
    SojoveBoby,
    StromovaHuba,
    Tekvica,
    TrojListok,
    Zihlava,
    ZmutovanaJahoda;

    public String getNazov() {
        return this.name();
    }

    public static Ingrediencia getRandomIngredienciu(int x, int y) {
        String nazov = Ingrediencie.values()[(int) (Math.random() * Ingrediencie.values().length)].getNazov();

        //vytvor instanciu nazvu
        try {
            return (Ingrediencia) Class.forName("Veci.Ingrediencie." + nazov).getConstructor(int.class, int.class).newInstance(x, y);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
