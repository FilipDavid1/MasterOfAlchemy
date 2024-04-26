package veci.ingrediencie;

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

    public static String getRandomIngredienciu() {
        Ingrediencie[] ingrediencie = Ingrediencie.values();
        return ingrediencie[ (int)(Math.random() * (ingrediencie.length - 1))].getNazov();
    }

}
