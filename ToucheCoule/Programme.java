package ToucheCoule;

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

    }
}
