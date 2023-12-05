package ToucheCoule.Advanced;

/**
 * La classe Bateau représente un bateau qui sera placé sur la grille de jeu
 * @taille      Représente la taille du bateau
 * @nom         Réprésente le nom du bateau
 * @etatBateau  Représente l'état du bateau : INTACTE, TOUCHE, COULE
 * @nombreDeVie Représente le nombre de coups restants avant que le bateau ne soit coulé
 */
public class Bateau {
    private final int taille;
    private final String nom;
    private ETAT_BATEAU etatBateau = ETAT_BATEAU.INTACTE;
    private int nombreDeVie;

    /**
     * Construcion d'un bateau à l'aide de sa taille et d'un nom
     * @param taille Taille du bateau et nombre de vies du bateau au départ
     * @param nom    Nom du bateau
     */
    public Bateau(int taille, String nom) {
        this.taille = nombreDeVie = taille;
        this.nom = nom;
    }
}
