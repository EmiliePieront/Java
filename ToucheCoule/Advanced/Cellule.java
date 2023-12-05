package ToucheCoule.Advanced;


/**
 * La classe Cellule représente une case d'une grille
 */
public class Cellule {
    private final int x, y;
    private Bateau bateau = null;
    private boolean estVisee;
    private final TYPE_GRILLE typeGrille;

    /**
     * Construction d'une cellule à partir de ses coordonnées et du type de grille à laquelle il appartient
     * @param x             Coordonnée en x de la cellule dans la grille
     * @param y             Coordonnée en y de la cellule dans la grille
     * @param typeGrille    Type de grille à laquelle la cellule appartient (ATTAQUE, DEFENSE)
     */
    public Cellule(int x, int y, TYPE_GRILLE typeGrille) {
        this.x = x;
        this.y = y;
        this.typeGrille = typeGrille;
    }
}
