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

    private Bateau[] bateaux = {
            new Bateau(5, "Porte-Avion"),
            new Bateau(4, "Destroyer"),
            new Bateau(3, "Sous-Marin"),
            new Bateau(3, "Croiseur"),
            new Bateau(2, "Torpilleur")
    };

    /**
     * Construction d'une grille (ATTAQUE ou DEFENSE) composées de (nombreLignes x nombreLignes) cellules
     * @param nombreLignes  Nombre de cases par ligne et par colonne
     * @param typeGrille    Défini le type de grille : ATTAQUE, DEFENSE
     */
    public Grille(int nombreLignes, TYPE_GRILLE typeGrille) {
        if (nombreLignes < MINIMUM) {
            System.out.printf("Le nombre de ligne doit être >= 8.\n" +
                    "Vous avez mis %d comme valeur.\n" +
                    "La valeur minimale (8) a été appliquée par défaut.\n", nombreLignes);
            nombreLignes = MINIMUM;
        }

        this.nombreLignes = nombreLignes;
        this.typeGrille = typeGrille;
        cellules = new Cellule[nombreLignes * nombreLignes];

        for(int x = 0; x < cellules.length; x++) {
            cellules[x] = new Cellule(x % nombreLignes, x / nombreLignes, typeGrille);
        }
    }
}