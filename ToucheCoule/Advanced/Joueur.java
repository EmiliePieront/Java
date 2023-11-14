package ToucheCoule.Advanced;

public class Joueur {
    private final String nom;
    private final String prenom;
    private String pseudo;
    private Statistique statistique;
    private final Boolean estUnBot;
    private Grille grillesAttaque, grilleDefense;
    Joueur(String nom, String prenom) {
        this(nom, prenom, false);

    }
    Joueur(String nom, String prenom, boolean estUnBot){
        this.estUnBot = estUnBot;
        this.nom = nom;
        this.prenom = prenom;
    }
    Joueur(String pseudo){
        estUnBot = true;
        nom = prenom = null;
        this.pseudo = pseudo;
    }
    void setPseudo(String pseudo){

    }
}
