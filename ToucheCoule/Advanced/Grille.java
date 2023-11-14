package ToucheCoule.Advanced;

/**
 * La classe Grille représente une grille (carrée) de jeu composée de cellules
 * @MINIMUM         Représente le nombre de lignes/colonnes minimum pour la grille
 * @nombreLignes    Représente le nombre de lignes/colonnes de la grille
 * @cellules        Représente la liste des cellules qui composent la grille
 * @typeGrille      Représente le type de grille : ATTAQUE, DEFENSE
 */
public class Grille {
    private static final int MINIMUM = 8;
    private final int nombreLignes;
    private final Cellule[] cellules;
    private final TYPE_GRILLE typeGrille;
}