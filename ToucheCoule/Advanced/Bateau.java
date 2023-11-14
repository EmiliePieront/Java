package ToucheCoule.Advanced;

public class Bateau {
    private final int taille;
    private final String nom;
    private ETAT_BATEAU etatBateau = ETAT_BATEAU.INTACTE;
    private int nombreDeVie;

    public Bateau(int taille, String nom) {
        this.taille = taille;
        this.nom = nom;
        nombreDeVie = taille;

    }
}
