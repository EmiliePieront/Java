//package ToucheCoule;
//
//import java.util.Arrays;
//
//public class Programme {
//    //Definition des grilles
//    static final int GRILLE_ATTAQUES = 0;
//    static final int GRILLE_BATEAUX = 1;
//    //définition des caractères de remplissage
//    static final char VAGUE = '~' ;
//    static final char BATEAU = 'O';
//    static final char TOUCHE = 'X';
//    static final char RATE = '*';
//
//    public static void main(String[] args) {
//        //System.out.println("Hello world !");
//
//        //Declaration of J1_points
//        var J1_Points = 0;
//        var J2_Points = J1_Points; //Not the same pointer.
//
//
//
//
//
////        //Declaration of a Constant
////        //final var MAX_POINTS = 5 + 4 + 3 + 2 + 2;
////        //Creation of a table for the battle grid
////        var attackGridPlayer1= new char[100]; //Creation and initialisation of a table
////        var attackGridPlayer2= new char[100]; //Creation and initialisation of a table
////        //int[] integerTab = {1,2,3,4,5,6,7};
////        //creation of a characters table
////        var boatsGridPlayer1 = new char[100];
////        var boatsGridPlayer2 = new char[100];
////        //show an element of the table
////        //System.out.println("args = " + attackGrid[0]);
//
//        //creation des tableaux  attaques et bateaux par joueur
//        var grillesJoueur1 = new char[2][100];
//        var grillesJoueur2 = new char[2][100];
//
//
//
//        //constant of boats and their size
//        final int CARRIER;
//        final int BATTLESHIP;
//        final int DESTROYER;
//        final int SUBMARINE;
//        final int PATROL;
//
//        //tab with boats' values
//        final var BOATS = new int[] {CARRIER = 5, BATTLESHIP = 4, DESTROYER = 3, SUBMARINE = 3, PATROL = 2};
//
//        final var MAX_POINTS = computeSum(BOATS);
//
//
////        for (int i = 0, y = 0; i < attackGridPlayer1.length ; i++, y++){
////            //U can do this way
////            attackGridPlayer1[i] = '.';
////            attackGridPlayer2[i] = '.';
////        }
////        //Or This way, to fill the grid.
////        Arrays.fill(boatsGridPlayer1, '.');
////        Arrays.fill(boatsGridPlayer2, '.');
//        fillGrid(grillesJoueur1, VAGUE);
//        fillGrid(grillesJoueur2, VAGUE);
//
////        //Display of the attackGrid by columns
////        System.out.println("Attack grid");
////        System.out.println("Player 1:");
////        displayGrid(attackGridPlayer1);
////        System.out.println("Player 2:");
////        displayGrid(attackGridPlayer2);
//
//
//        /*
//        var a = 0;
//        var b = 0;
//        a = b++;
//        System.out.println(a+" et "+b);
//        a = 0; b = 0;
//        a = ++b;
//        System.out.println(a+" et "+b);
//        System.out.println("args = " + attackGrid[0]);
//        System.out.println(Arrays.toString(boatsGrid));
//        */
//
////        System.out.println("Boats grid");
////        displayGrid(boatsGrid);
//
////        //battleships placement
//        System.out.println("\nPlacement des bateaux... ");
//        for (var bateau: BOATS) {
//            setBoats(grillesJoueur1[GRILLE_BATEAUX], bateau);
//            setBoats(grillesJoueur2[GRILLE_BATEAUX], bateau);
//        }
//        System.out.println("\n Grille des bateaux");
//        displayGrids(grillesJoueur1, grillesJoueur2);
////        System.out.println("Player 1:");
////        displayGrid(boatsGridPlayer1);
////        System.out.println("Player 2:");
////        displayGrid(boatsGridPlayer2);
//
//
//    }
//
//    /**
//     * Remplissage des grilles attaques et bateaux des joueurs
//     * @param grillesJoueur les grilles d'un joueur
//     * @param remplissage caractère de remplissage
//     */
//    static void fillGrid(char[][] grillesJoueur, char remplissage) {
//        for (var grille: grillesJoueur) {
//            //affichage de la taille de la grille -> grilleJoueur1[2][100] => grille[100]
//            Arrays.fill(grille, remplissage);
//        }
//    }
//    /**
//     * This function allow to place the boats on the grid.
//     * Boats are not allowed to cross themselves
//     * @param tableau the grid with boats on
//     * @param tailleBateau size of the boat to place
//     */
//    static void setBoats(char[] tableau, int tailleBateau) {
//        boolean isBoatSet;
//        do {
//            var cell = -1;
//
//    //        do {
//    //            cell = (int)(Math.random()*tableau.length);
//    //        } while(tableau[cell] != '.');
//            while (tableau[cell= (int)(Math.random() * tableau.length)] != VAGUE);
//            //var direction = (int)(Math.random() * 4);
//            var direction = DIRECTION.values()[(int)(Math.random() * 4)];
//            System.out.printf("Cell : %2d | Taille : %1d | Direction : %s%n", cell, tailleBateau, direction);
//            isBoatSet = false;
//            switch (direction) {
//                case UP :
//                    if(cell >= (tailleBateau -1 ) * 10 ) {
//                        isBoatSet = isBoatSet(tableau, tailleBateau, cell - (tailleBateau -1) * 10, cell, 10);
//                    }
//                    break;
//                case LEFT:
//                    if (cell > 9 && (cell - tailleBateau + 1 ) % 10 < cell % 10 ){
//                        isBoatSet = isBoatSet(tableau, tailleBateau, cell - tailleBateau +1, cell, 1);
//                    }
//                    break;
//                case RIGHT:
//                    if (cell < 90 && (cell + tailleBateau - 1 ) % 10 > cell % 10 ){
//                        isBoatSet = isBoatSet(tableau, tailleBateau, cell, cell + tailleBateau -1, 1);
//                    }
//                    break;
//                case BOTTOM:
//                    if(cell < 100 - (tailleBateau -1) * 10 ) {
//                        isBoatSet = isBoatSet(tableau, tailleBateau, cell, cell + (tailleBateau -1) * 10, 10);
//                    }
//                    break;
//            }
//        } while( !isBoatSet );
//    }
//
//    /**
//     * Check if boat could be placed in the grid and if it is present in the grid
//     * @param tableau grid to fill  with boats
//     * @param tailleBateau size of the boat
//     * @param start starting case of the boat
//     * @param end ending case of the boat
//     * @param step step for the calc of the following case
//     * @return true is the boat could be placed
//     */
//    static boolean isBoatSet(char[] tableau, int tailleBateau, int start, int end, int step) {
//        //check if all the cases are available
//        for (var cell = start; cell <= end; cell += step){
//            if (tableau[cell] != VAGUE) {
//                return false;
//            }
//        }
//        // Place the boat on the grid
//        for (var cell = start; cell <= end; cell += step){
//            tableau[cell] = (char)('0' + tailleBateau);
//        }
//        return true;
//    }
//
//
//    /**
//     * Give the sum of the different values in the tab
//     * @param boats the table who contains values
//     * @return values sum in the table
//     */
//    static int computeSum(int[] boats) {
//        var retour = 0 ;
//        //foreach example:
//        for (var valeur : boats)
//            retour += valeur;
//        return retour;
//    }
//
//    /**
//     * display a grid with header
//     * @param table is the table to display
//     */
//    static void displayGrid (char[] table){
//        //Display of the BoatsGrid by columns
//        System.out.print("\t");
//        for (char lettre = 'A'; lettre < 'A'+10; System.out.print(lettre+" "), lettre++);
//        System.out.println();
//        for (var i=0; i < table.length; i++){
//            if(i%10 == 0){
////                if(i < 90) System.out.print(" ");
////                System.out.print(i/10+1);
//                System.out.printf(" %2d ", i/10+1);
//            }
//            System.out.print(table[i]+" ");
//            if(i%10 ==9){
//                System.out.println();
//            }
//        }
//    }
//
//    /**
//     * Affichage des grilles des deux joueurs
//     * @param grillesJoueur1 grilles du premier joueur
//     * @param grillesJoueur2 grilles du second joueur
//     */
//    static void displayGrids(char [][] grillesJoueur1, char [][] grillesJoueur2){
//        System.out.println("\t\t  Joueur1\t\t\t\t  Joueur2");
//        for (var i = 0; i < 2; i++) {
//            System.out.print("\t");
//            for (char lettre = 'A'; lettre < 'A' + 10; System.out.print(lettre++ + " "));
//        }
//        System.out.println();
//        for (int i = 0, taille = grillesJoueur1.length; i < taille; i++) {
//            if (i % 10 == 0) System.out.printf(" %2d ", i / 10 + 1);
//            System.out.print(grillesJoueur1[i] + " ");
//            if (i % 10 == 9) {
//                for (var j = 0; j < 10; j++) {
//                    if (j == 0) System.out.printf(" %2d ", i / 10 + j + 1);
//                    System.out.print(grillesJoueur2[i - 9 + j] + " ");
//                }
//                System.out.println();
//            }
//        }
//        System.out.println();
//    }
//}
