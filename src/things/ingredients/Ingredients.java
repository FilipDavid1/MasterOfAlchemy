package things.ingredients;

/**
 * Enum Ingrediencie reprezentuje rôzne typy ingrediencií, ktoré sa môžu použiť v hre.
 */
public enum Ingredients {
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
    playerh,
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
    public String getName() {
        return this.name();
    }

    /**
     * Vygeneruje náhodnú ingredienciu.
     *
     * @return Názov náhodnej ingrediencie.
     */
    public static String getRandomIngredienciu() {
        Ingredients[] ingredients = Ingredients.values();
        return ingredients[ (int)(Math.random() * (ingredients.length - 1))].getName();
    }

}
