package ToucheCoule.Advanced;
//import static ToucheCoule.Advanced.Pseudo.*; Si on ne veut pas chaque fois stipuler d'où vient la méthode.
import org.jetbrains.annotations.NotNull;

import static ToucheCoule.Advanced.Pseudo.*;

/**
 * La classe Joueur représente un joueur
 * @nom             Représente le nom du joueur
 * @prenom          Représente le prénom du joueur
 * @pseudo          Représente le pseudo du joueur
 * @statistiques    Représente les statistiques de jeu du joueur
 * @estUnBot        Indique si le joueur est un bot
 */
public class Joueur {
    private final String nom;
    private final String prenom;
    private String pseudo;
    private Statistique statistiques;
    private final Boolean estUnBot;
    private Grille grilleAttaque, grilleDefense;

    /**
     * Création d'un Joueur humain à partir d'un nom et d'un prénom
     * @param nom       Nom du joueur
     * @param prenom    Prénom du joueur
     */
    Joueur(@NotNull String nom, @NotNull String prenom) {
        this(nom, prenom, false);
    }

    /**
     * Création d'un Joueur (humain ou bot) à partir d'un nom et d'un prénom
     * @param nom       Nom du joueur
     * @param prenom    Prénom du joueur
     * @param estUnBot  true = est un bot / false = joueur humain
     */
    Joueur(@NotNull String nom, @NotNull String prenom, boolean estUnBot) {
        this.nom = nom;
        this.prenom = prenom;
        this.estUnBot = estUnBot;
        this.pseudo = Pseudo.addPseudo(estUnBot);
    }

    /**
     * Création d'un joueur bot à partir d'un pseudo.
     * Si le pseudo existe déjà, le bot n'est pas créé
     * @param pseudo Pseudo du bot
     * @exception IllegalArgumentException Si le pseudo demandé est déjà utilisé
     */
    Joueur (String pseudo) throws pseudoAlreadyExistsException {
        estUnBot = true;
        nom = prenom = null;
        if (addPseudo(pseudo))
            this.pseudo = pseudo;
        else
            throw new pseudoAlreadyExistsException(String.format("Il existe déjà un joueur avec le pseudo %s.", pseudo));
    }

    /**
     * Création d'un bot. Le pseudo sera généré automatiquement.
     */
    Joueur () {
        estUnBot = true;
        nom = prenom = null;
        pseudo = addPseudo(estUnBot);
    }

    /**
     * Cette méthode permet d'attribuer un (nouveu) pseudo à un joueur
     * @param nouveauPseudo Nouveau pseudo pour le joueur
     * @return true si le nouveau pseudo est accepté sinon false
     */
    boolean setPseudo(@NotNull String nouveauPseudo) {
        if (nouveauPseudo.equals(pseudo)) {
            System.out.println("Vous utilisez déjà ce pseudo : " + pseudo);
            return false;
        }

        if (pseudoEstUtilise(nouveauPseudo)) {
            System.out.println("Ce pseudo est déjà utilisé : " + nouveauPseudo);
            return false;
        }

        remplacePseudo(pseudo, nouveauPseudo);
        pseudo = nouveauPseudo;

        return true;
    }

    /**
     * Cette méthode retourne le pseudo actuel de l'utilisateur (bot ou humain)
     * @return Le pseudo actuel du joueur
     */
    String getPseudo() {
        return pseudo;
    }

    /**
     * Cette méthode permet de savoir si le joueur est un bot
     * @return true si le joueur est un bot
     */
    boolean estUnBot() {
        return estUnBot;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Pseudo.effacePseudo(pseudo);
    }
}