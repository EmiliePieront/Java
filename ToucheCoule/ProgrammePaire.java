package ToucheCoule;
//Fct touche et touche2 faites en paire avec Jonathan

import java.util.Arrays;

public class ProgrammePaire {
    // Définition des grilles
    static final int GRILLE_ATTAQUES = 0;
    static final int GRILLE_BATEAUX = 1;
    // Remplissage des grilles
    static final char VAGUE = '≋';
    static final char BATEAU = '▆';
    static final char RATE = '•';
    static final char TOUCHE = 'X';

    /**
     * Point de démarrage du programme
     *
     * @param args Arguments reçus depuis la ligne de commande
     */
    public static void main(String[] args) {
        System.out.println("Premier programme en Java : touché-coulé !");
        System.out.println();
        System.out.println("Initialisation du jeu... \n");

        // Déclaration et initialisation de J1_Points (nombre de points du joueur 1)
        int J1_Points = 0;
        /*
            Idem pour J2_Points
            Nombre de points du joueur 2
         */
        int J2_Points = J1_Points; // J2_Points est initialisé à la même valeur que J1_Points

        // Déclaration des types de bateau et leur taille
        final var CARRIER = 5;
        final int BATTLESHIP = 4;
        final int DESTROYER = 3;
        final int SUBMARINE = 3;
        final int PATROL = 2;

        final var BOATS = new int[]{CARRIER, BATTLESHIP, DESTROYER, SUBMARINE, PATROL};
        // BOATS[0] += 7;

        // Déclaration d'une constante
        // final var MAX_POINTS = CARRIER + BATTLESHIP + DESTROYER + SUBMARINE + PATROL;
        final var MAX_POINTS = computeSum(BOATS);

        // Création d'un tableau de caractères pour la grille d'attaque et bateaux de chaque joueur
        var grillesJoueur1 = new char[2][100];
        var grillesJoueur2 = new char[2][100];

        // Remplissage des grilles de chaque joueur avec des '.'
        fillGrid(grillesJoueur1, VAGUE);
        fillGrid(grillesJoueur2, VAGUE);

        // Placement des bateaux
        System.out.println("\nPlacement des bateaux des joueurs ...");
        for (var bateau : BOATS) {
            setBoats(grillesJoueur1[GRILLE_BATEAUX], bateau);
            setBoats(grillesJoueur2[GRILLE_BATEAUX], bateau);
        }

        // Impression des grilles d'attaques et de Bateaux des deux joueurs
        displayGrids(grillesJoueur1, grillesJoueur2);

        // Lancement du combat

        var joueurActuel = (int) (Math.random() * 2);
        int tour = 0;
        do {
            tour++;
            if (joueurActuel == 0) {
                J1_Points = touche2(grillesJoueur1[GRILLE_ATTAQUES], grillesJoueur2[GRILLE_BATEAUX], J1_Points);
                joueurActuel = 1;
            } else {
                J2_Points = touche2(grillesJoueur2[GRILLE_ATTAQUES], grillesJoueur1[GRILLE_BATEAUX], J2_Points);
                joueurActuel = 0;
            }
        }
        while (J1_Points < MAX_POINTS && J2_Points < MAX_POINTS);

        if (J1_Points >= MAX_POINTS)
            System.out.printf("\nBravo joueur 1: la partie s'est terminée en %d tours\n", tour / 2);
        if (J2_Points >= MAX_POINTS)
            System.out.printf("\nBravo joueur 2 : la partie s'est terminée en %d tours\n", tour / 2);

        // Impression du résultat final

        displayGrids(grillesJoueur1, grillesJoueur2);
    }

    /**
     *
     */
    static int touche(char[] grillesAttaque, char[] grillesBateaux, int joueurpoint) {
        var cell = -1;
        if (grillesBateaux[cell = (int) (Math.random() * grillesBateaux.length)] == BATEAU) {
            grillesAttaque[cell] = TOUCHE;
            grillesBateaux[cell] = TOUCHE;
            joueurpoint++;
        } else {
            grillesAttaque[cell] = RATE;
            grillesBateaux[cell] = RATE;
        }
        return joueurpoint;
    }

    static int touche2(char[] grillesAttaque, char[] grillesBateaux, int joueurpoint) {
        var cell = -1;
        while (grillesBateaux[cell = (int) (Math.random() * grillesBateaux.length)] != BATEAU && grillesBateaux[cell] != VAGUE)
            ;
        if (grillesBateaux[cell] == BATEAU) {
            grillesAttaque[cell] = TOUCHE;
            grillesBateaux[cell] = TOUCHE;
            joueurpoint++;
        } else {
            grillesAttaque[cell] = RATE;
            grillesBateaux[cell] = RATE;
        }
        return joueurpoint;

    }

    /**
     * Remplissage des grilles Attaques et Bateaux d'un joueur
     *
     * @param grillesJoueur Les grilles d'un joueur
     * @param remplissage   caractère de remplissage
     */
    static void fillGrid(char[][] grillesJoueur, char remplissage) {
        for (char[] grille : grillesJoueur)
            Arrays.fill(grille, remplissage);
    }

    /**
     * Cette fonction permet de placer les bateaux sur la grille.
     * Les bateaux ne peuvent pas se croiser
     *
     * @param tableau La grille sur laquelle on va placer le bateau
     * @param taille  Taille du bateau à placer
     */
    static void setBoats(char[] tableau, int taille) {
        boolean isBoatSet;
        do {
            var cell = -1;
            while (tableau[cell = (int) (Math.random() * tableau.length)] != VAGUE) ;
            //var direction = (int) (Math.random() * 4);
            var direction = DIRECTION.values()[(int) (Math.random() * 4)];
            System.out.printf("Cell : %2d | Taille : %1d | Direction : %s%n", cell, taille, direction);
            isBoatSet = false;
            switch (direction) {
                case UP -> {
                    if (cell >= (taille - 1) * 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell - (taille - 1) * 10, cell, 10);
                    }
                }
                case LEFT -> {
                    if (cell > 9 && (cell - taille + 1) % 10 < cell % 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell - taille + 1, cell, 1);
                    }
                }
                case RIGHT -> {
                    if (cell < 90 && (cell + taille - 1) % 10 > cell % 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell, cell + taille - 1, 1);
                    }
                }
                case BOTTOM -> {
                    if (cell < 100 - (taille - 1) * 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell, cell + (taille - 1) * 10, 10);
                    }
                }
            }
        } while (!isBoatSet);
    }

    /**
     * Cette fonction vérifie que le bateau peut être placé comme souhaité et si c'est le cas, le bateau est encodé dans la grille
     *
     * @param tableau La grille sur laquelle on va placer le bateau
     * @param taille  Nombre de cases pour le bateau
     * @param start   Case de départ pour le placement du bateau
     * @param end     Case d'arrivée pour le placement sdu bateau
     * @param step    Pas pour le calcul de la prochaine case
     * @return True si le bateau a pu être placé comme demandé
     */
    static boolean isBoatSet(char[] tableau, int taille, int start, int end, int step) {
        // On vérifie que toutes les cases nécessaires pour mettre le bateau soient disponibles
        for (var cell = start; cell <= end; cell += step) {
            if (tableau[cell] != VAGUE)
                return false;
        }
        // On place le bateau dans le tableau
        for (var cell = start; cell <= end; cell += step) {
            tableau[cell] = (char) (BATEAU);
        }
        return true;
    }

    /**
     * Calcule la somme des valeurs dans le tableau
     *
     * @param tableau Le tableau qui contient les valeurs
     * @return La somme des valeurs dans le tableau
     */
    static int computeSum(int[] tableau) {
        var retour = 0;
        // for-each
        for (var valeur : tableau)
            retour += valeur;
        return retour;
    }

    // byte, short, char, int, long, float, double, boolean
    // Byte, Short, Character, Integer, Long, Float, Double, Boolean

    /**
     * Affichage des grilles des 2 joueurs
     *
     * @param grillesJoueur1 Grilles du 1er joueur
     * @param grillesJoueur2 Grilles du 2nd joueur
     */
    static void displayGrids(char[][] grillesJoueur1, char[][] grillesJoueur2) {
        System.out.println("\t\t  Grilles d'attaques des 2 joueurs\n");
        displayBaseGrids(grillesJoueur1[GRILLE_ATTAQUES], grillesJoueur2[GRILLE_ATTAQUES]);
        System.out.println("\t\t Grilles des bateaux des 2 joueurs\n");
        displayBaseGrids(grillesJoueur1[GRILLE_BATEAUX], grillesJoueur2[GRILLE_BATEAUX]);
    }

    /**
     * Affichages des grilles des 2 joueurs
     *
     * @param grillesJoueur1
     * @param grillesJoueur2
     */
    static void displayBaseGrids(char[] grillesJoueur1, char[] grillesJoueur2) {
        System.out.println("\t\t\u001B[31m Joueur 1 \t\t\t\t\u001B[32m Joueur 2");
        for (var i = 1; i <= 2; i++) {
            System.out.printf("\t\u001B[3%dm", i);
            for (char lettre = 'A'; lettre < 'A' + 10; System.out.print(lettre + " "), lettre++) ;
        }
        System.out.print("\u001B[0m");
        System.out.println();
        for (int i = 0, taille = grillesJoueur1.length; i < taille; i++) {
            if (i % 10 == 0) System.out.printf(" %2d ", i / 10 + 1);
            System.out.print("\u001B[34m");
            System.out.print(grillesJoueur1[i] + " ");
            if (i % 10 == 9) {
                System.out.print("\u001B[0m");
                for (var j = 0; j < 10; j++) {
                    if (j % 10 == 0) System.out.printf(" %2d ", i / 10 + 1);
                    System.out.print("\u001B[34m");
                    System.out.print(grillesJoueur2[i - 9 + j] + " ");
                }
                System.out.print("\u001B[0m");
                System.out.println();
            }
        }

    }
}