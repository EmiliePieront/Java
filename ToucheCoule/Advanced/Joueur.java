package ToucheCoule.Advanced;

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
    }


    Joueur(@NotNull String pseudo){
        this(pseudo, pseudo, true);
        this.pseudo = pseudo;
    }
    void setPseudo(String pseudo){

    }
}
