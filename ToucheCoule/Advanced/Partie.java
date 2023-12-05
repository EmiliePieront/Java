package ToucheCoule.Advanced;

/**
 * La classe Partie représente une partie (en cours ou jouée)
 */
public class Partie {
    private final Joueur[] joueurs;
    private Joueur joueurActif;
    private final NIVEAU_PARTIE niveauPartie;
    private final int idPartie;

    public Partie(Joueur[] joueurs, NIVEAU_PARTIE niveauPartie, int idPartie) {
        this.joueurs = joueurs;
        this.niveauPartie = niveauPartie;
        this.idPartie = idPartie;
    }
}

