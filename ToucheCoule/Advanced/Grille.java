package ToucheCoule.Advanced;

import java.util.Arrays;

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

    /***
     * Construction d'une grille (ATTAQUE ou DEFENSE) composée de (nombreLigne X nombreLigne) cellules
     * @param nombreLignes Nombre de case par ligne et par colonne
     * @param typeGrille Défini le type de grille : ATTAQUE, DEFENSE.
     */
    public Grille(int nombreLignes, TYPE_GRILLE typeGrille) {
        if(nombreLignes < MINIMUM) {
            System.out.printf("Le nombre de ligne doit être supérieur ou égal à 8.\n " +
                    "Vous avez mis comme valeur \n"+
                    "la valeur minimale (8) a été appliquée par défaut.\n", nombreLignes);
            nombreLignes = MINIMUM;
        }
        this.nombreLignes = nombreLignes;
        this.typeGrille = typeGrille;
        cellules = new Cellule[nombreLignes*nombreLignes];

        for(int x = 0; x < cellules.length; x++){
            cellules[x] = new Cellule(x % nombreLignes, x/nombreLignes ,typeGrille);
        }
    }
}