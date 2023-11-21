package ToucheCoule.Advanced;

public class Bateau {
    private final int taille;
    private final String nom;
    private ETAT_BATEAU etatBateau = ETAT_BATEAU.INTACTE;
    private int nombreDeVie;

    /***
     *
     * @param taille taille du bateau
     * @param nom nom du bateau
     */
    public Bateau(int taille, String nom) {
        this.taille = nombreDeVie = taille;
        this.nom = nom;

    }
}
