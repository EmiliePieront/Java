package ToucheCoule.Advanced;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * La classe Pseudo permet de gérer la liste des pseudos (tous uniques) des joueurs (humain ou bot)
 * Cette classe ne contient que des attributs et des méthodes statiques, elle est 'final' et ne peut donc être héritée
 * Il n'est pas possible de créer une instance de cette classe
 * @STEP          Pas d'incrémentation de la taille du tableau des pseudos
 * @pseudos       tableau qui contient la liste des pseudos
 * @nombrePseudos Nombre de pseudos dans le tableau
 */
public final class Pseudo {
    private static final int STEP = 5;
    private static String[] pseudos = new String[STEP];
    private static int nombrePseudos = 0;

    /**
     * Constructeur privé pour empêcher la création d'instance de la classe Pseudo
     */
    private Pseudo() {}

    /**
     * Cette méthode permet d'ajouter un nouveau pseudo à la liste à condition qu'il ne soit pas déjà utilisé
     * @param  nouveauPseudo Nouveau pseudo que l'on souhaite ajouter à la liste s'il n'existe pas encore
     * @return true si le pseudo a pu être ajouté à la liste
     */
    public static boolean addPseudo(@NotNull String nouveauPseudo) {
        for (var pseudo : pseudos) {
            if (nouveauPseudo.equalsIgnoreCase(pseudo))
                return false;
        }

        if (nombrePseudos == pseudos.length)
            pseudos = Arrays.copyOf(pseudos, nombrePseudos + STEP);

        pseudos[nombrePseudos++] = nouveauPseudo;

        return true;
    }

    /**
     * Cette méthode permet d'ajouter un nouveau pseudo de manière automatique
     * Le nouveau pseudo sera Joueur-x si c'est un joueur humain, sinon ce sera Bot-x
     * @param estUnBot Indique si le joueur est un bot ou non
     * @return Le nouveau pseudo généré et ajouté à la liste
     */
    public static String addPseudo(boolean estUnBot) {
        var prefixe = (!estUnBot ? "Joueur-" : "Bot-");
        String nom;
        var suffixe = 1;

        while (! addPseudo(nom = prefixe + suffixe++));

        return nom;
    }

    /**
     * Cette méthode retourne true si le pseudo passé en paramètre est déjà utilisé
     * @param pseudo pseudo à vérifier
     * @return true si le pseudo est déjà utilisé
     */
    public static boolean pseudoEstUtilise(@NotNull String pseudo) {
        for (var _pseudo : pseudos) {
            if (pseudo.equalsIgnoreCase(_pseudo))
                return true;
        }

        return false;
    }

    /**
     * Cette méthode permzet de changer de pseudo à condition que le nouveau pseudo ne soit pas déjà utilisé
     * @param oldPseudo pseudo à remplacer
     * @param newPseudo nouveau pseudo à utiliser
     * @return true si le remplacement à pu se faire
     */
    public static boolean remplacePseudo(@NotNull String oldPseudo, @NotNull String newPseudo) {
        if (oldPseudo.equalsIgnoreCase(newPseudo))
            return false;

        if (pseudoEstUtilise(newPseudo))
            return false;

        for (int tmp = 0; tmp < nombrePseudos; tmp++) {
            if (pseudos[tmp].equalsIgnoreCase(oldPseudo)) {
                pseudos[tmp] = newPseudo;
                return true;
            }
        }

        return false;
    }

    public static boolean effacePseudo(@NotNull String pseudo) {
        if (pseudoEstUtilise(pseudo)) {
            for (var indice = 0; indice < nombrePseudos; indice++) {
                if (pseudos[indice].equalsIgnoreCase(pseudo)) {
                    System.arraycopy(pseudos, indice + 1, pseudos, indice, nombrePseudos - indice - 1);
                    nombrePseudos--;
                    pseudos[nombrePseudos] = null;
                }
            }
            return true;
        } else return false;
    }
}