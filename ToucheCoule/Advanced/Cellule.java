package ToucheCoule.Advanced;

public class Cellule {
    private final int x,y;
    private Bateau bateau = null;
    private boolean estVisee;
    private final TYPE_GRILLE typeGrille;

    /***
     * Construction d'une cellule à partir de ses coordonnées et du type de grille à laquelle il appartient
     * @param x         Coordonnées en x de la cellule dans la grille
     * @param y         Coordonnées en y de la cellule dans la grille
     * @param typeGrille Type de grille, défense ou attaque.
     */
    public Cellule(int x, int y, TYPE_GRILLE typeGrille) {
        this.x = x;
        this.y = y;
        this.typeGrille = typeGrille;
    }
}
