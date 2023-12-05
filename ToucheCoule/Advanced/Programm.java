package ToucheCoule.Advanced;
public class Programm {
    public static void main(String[] args) {
        var grille = new Grille(7, TYPE_GRILLE.ATTAQUE);
        Joueur joueur1 = new Joueur("Geoffroy", "Malherbe");
        Joueur joueur2 = new Joueur("Alain", "Ryan", false);
        Joueur bot1 = null;
        try {
            bot1 = new Joueur("Bot-2");
        } catch (pseudoAlreadyExistsException e) {
            System.out.println("Message de l'exception : " + e.getMessage());
            bot1 = new Joueur();
        }

        Joueur bot2 = new Joueur();

        System.out.println("Pseudo joueur1 : " + joueur1.getPseudo());
        System.out.println("Pseudo joueur2 : " + joueur2.getPseudo());
        System.out.println("Pseudo bot1    : " + bot1.getPseudo());
        System.out.println("Pseudo bot2    : " + bot2.getPseudo());

        System.out.println();
        System.out.println("Le pseudo joueur-1 est déjà utilisé ? : " + Pseudo.pseudoEstUtilise("joueur-1"));
        System.out.println("Le pseudo bot-14 est déjà utilisé ?   : " + Pseudo.pseudoEstUtilise("Bot-14"));

        System.out.println();
        var pseudo = joueur1.getPseudo();
        System.out.printf("Changement du pseudo de joueur1. Ancien pseudo = %s; Nouveau pseudo = %s\n", pseudo, "Appel");
        joueur1.setPseudo("Appel");
        System.out.println("Pseudo joueur1 : " + joueur1.getPseudo());

        pseudo = joueur2.getPseudo();
        System.out.printf("Changement du pseudo de joueur2. Ancien pseudo = %s; Nouveau pseudo = %s\n", pseudo, "Joueur-1");
        joueur2.setPseudo("Joueur-1");
        System.out.println("Pseudo joueur2 : " + joueur2.getPseudo());

        System.out.println();
        Joueur bot3 = null;

        try {
            bot3 = new Joueur("Bot-2");
            System.out.println("coucou");
        }
        catch (pseudoAlreadyExistsException e) {
            // Affiche le message de l'exception et la pile d'appel aux méthodes
            // e.printStackTrace();

            // Affiche juste le message lié à l'exception
            System.out.println("Message de l'exception : " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Une exception a été levée. Vérifiez votre code informatique");
        }
        finally {
            System.out.println("Code dans le finally");
        }

        System.out.println("Bot3 = " + bot3);

        var pseudoBot2 = bot2.getPseudo();
        bot2 = null;
        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Pseudo Bot2 : " + Pseudo.pseudoEstUtilise(pseudoBot2));
    }
}