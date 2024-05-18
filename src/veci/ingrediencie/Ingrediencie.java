package veci.ingrediencie;

/**
 * Enum Ingrediencie reprezentuje rôzne typy ingrediencií, ktoré sa môžu použiť v hre.
 */
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

    /**
     * Získa názov ingrediencie.
     *
     * @return Názov ingrediencie.
     */
    public String getNazov() {
        return this.name();
    }

    /**
     * Vygeneruje náhodnú ingredienciu.
     *
     * @return Názov náhodnej ingrediencie.
     */
    public static String getRandomIngredienciu() {
        Ingrediencie[] ingrediencie = Ingrediencie.values();
        return ingrediencie[ (int)(Math.random() * (ingrediencie.length - 1))].getNazov();
    }

}
