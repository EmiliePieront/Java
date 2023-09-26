package ToucheCoule;

import java.util.Arrays;

public class Programme {
    public static void main(String[] args) {
        System.out.println("Hello world !");

        //Declaration of J1_points
        var J1_Points = 0;
        var J2_Points = J1_Points; //Not the same pointer.
        J1_Points += 2;
        System.out.println(J1_Points+" "+J2_Points);
        //Declaration of a Constant
        final var MAX_POINTS = 5 + 4 + 3 + 2 + 2;
        //Creation of a table for the battle grid
        var attackGrid = new char[100]; //Creation and initialisation of a table
        int[] integerTab = {1,2,3,4,5,6,7};
        //creation of a characters table
        var boatsGrid = new char[100];
        //show an element of the table
        System.out.println("args = " + attackGrid[0]);
        //filling attack grid with "."

        for (int i = 0, y = 0; i < attackGrid.length ; i++, y++){
            //U can do this way
            attackGrid[i] = '.';
        }
        //Or This way, to fill the grid.
        Arrays.fill(boatsGrid, '.');


        //Display of the attackGrid by columns
        System.out.println("Attack grid");
        displayGrid(attackGrid);


        /*
        var a = 0;
        var b = 0;
        a = b++;
        System.out.println(a+" et "+b);
        a = 0; b = 0;
        a = ++b;
        System.out.println(a+" et "+b);
        System.out.println("args = " + attackGrid[0]);
        System.out.println(Arrays.toString(boatsGrid));
        */
        System.out.println("Boats grid");
        displayGrid(boatsGrid);
    }

    /**
     * display a grid with header
     * @param table is the table to display
     */
    static void displayGrid (char[] table){
        //Display of the BoatsGrid by columns
        System.out.print("\t");
        for (char lettre = 'A'; lettre < 'A'+10; System.out.print(lettre+" "), lettre++);
        System.out.println();
        for (var i=0; i < table.length; i++){
            if(i%10 == 0){
//                if(i < 90) System.out.print(" ");
//                System.out.print(i/10+1);
                System.out.printf(" %2d ", i/10+1);
            }
            System.out.print(table[i]+" ");
            if(i%10 ==9){
                System.out.println();
            }
        }
    }
}
