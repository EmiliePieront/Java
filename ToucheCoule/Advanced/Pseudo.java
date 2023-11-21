package ToucheCoule.Advanced;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Pseudo {
    private final static int STEP = 5;
    private static String[] pseudos = new String[10];
    private static int nommbrePseudo = 0;
    private Pseudo() {}
    public static boolean addPseudo (@NotNull String pseudo){
        for(var alias : pseudos){
            if(pseudo.equalsIgnoreCase(alias)){
                return false;
            }
        }
        if (nommbrePseudo == pseudos.length) {
            pseudos = Arrays.copyOf(pseudos, nommbrePseudo+STEP);
        }
        pseudos[nommbrePseudo] = pseudo;
        nommbrePseudo++;
        return true;
    }
}
