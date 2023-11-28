package ToucheCoule.Advanced;
//import static ToucheCoule.Advanced.Pseudo.*; Si on ne veut pas chaque fois stipuler d'où vient la méthode.
import org.jetbrains.annotations.NotNull;

public class Joueur {
    private final String nom;
    private final String prenom;
    private String pseudo;
    private Statistique statistique;
    private final Boolean estUnBot;
    private Grille grillesAttaque, grilleDefense;

    /**
     * Création d'un joueur humain à partir de son nom et de son prénom
     * @param nom Nom du joueur (non null)
     * @param prenom Prénom du joueur (non null)
     *
     */
    Joueur(@NotNull String nom, @NotNull String prenom) {
        this(nom, prenom, false);

    }

    /**
     * Création d'un joueur (bot ou humain)
     * @param nom Nom du joueur (non null)
     * @param prenom Prénom du joueur (non null)
     * @param estUnBot True si c'est un bot
     */
    Joueur(@NotNull String nom,@NotNull String prenom, boolean estUnBot){
        this.estUnBot = estUnBot;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = Pseudo.addPseudo(estUnBot);
    }

    /***
     * Création d'un bot
     * @param pseudo pseudo du bot
     */
    Joueur(@NotNull String pseudo){
        estUnBot = true;
        nom = prenom = null;
        if (Pseudo.addPseudo(pseudo)){
            this.pseudo = pseudo;
        } else {
            throw new IllegalArgumentException("Il existe déjà un joueur avec le pseudo "+pseudo+". Le joueur n'est pas créé");
        }
//        this(pseudo, pseudo, true);
//        this.pseudo = pseudo;
    }
    Joueur (){
        estUnBot = true;
        nom = prenom = null;
        pseudo = Pseudo.addPseudo(estUnBot);
    }

    /***
     * Cette méthode permet d'attribuer un nouveau pseudo à un joueur.
     * @param nouveauPseudo Nouveau pseudo pour le joueur.
     * @return true si le nouveau pseudo est accepté, sinon false.
     */
    boolean setPseudo(@NotNull String nouveauPseudo){
        if (nouveauPseudo.equals(pseudo)){
            System.out.println("Vous utilisez déjà ce pseudo : "+nouveauPseudo);
            return false;
        }
        if (Pseudo.pseudoEstUtilise(nouveauPseudo)){
            System.out.println("Ce pseudo est déjà utilisé : "+nouveauPseudo);
            return false;
        }
        Pseudo.remplacePseudo(pseudo, nouveauPseudo);
        pseudo = nouveauPseudo;
        return true;
    }
    String getPseudo(){
        return pseudo;
    }
}
