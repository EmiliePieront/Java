package ToucheCoule.Advanced;


public class Programm {
    public static void main(String[] args) {
        var grille = new Grille(7, TYPE_GRILLE.ATTAQUE);
        Joueur joueur1 = new Joueur("Geoffrey", "Malherbe");
        Joueur joueur2 = new Joueur("Alain","Ryan", true);
        Joueur bot1 = new Joueur("Bot-2");
        Joueur bot2 = new Joueur();

        System.out.println("Pseudo joueur1 : "+ joueur1.getPseudo());
        System.out.println("Pseudo joueur2 : "+ joueur2.getPseudo());
        System.out.println("Pseudo de Bot1 : "+ bot1.getPseudo());
        System.out.println("Pseudo de Bot2 : "+ bot2.getPseudo());

        System.out.println();
        System.out.println("Le pseudo joueur-1 est déjà utilisé? : * "+Pseudo.pseudoEstUtilise("joueur-1"));
        System.out.println("Le pseudo bot-14 est déjà utilisé? : * "+Pseudo.pseudoEstUtilise("Bot-14"));

        System.out.println();
        var pseudo = joueur1.getPseudo();
        System.out.printf("Changement du pseudo de joueur1. Ancien pseudo = %s; Nouveau pseudo = %s\n", pseudo, "Angel" );
        joueur1.setPseudo("Angel");
        System.out.println("Pseudo joueur1 : "+joueur1.getPseudo());

        pseudo = joueur2.getPseudo();
        System.out.printf("Changement du pseudo de joueur2. Ancien pseudo = %s; Nouveau pseudo = %s\n", pseudo, "Joueur-1" );
        joueur1.setPseudo("Joueur-1");
        System.out.println("Pseudo joueur2 : "+joueur2.getPseudo());

        Joueur bot3 = null;
        try {
            bot3 = new Joueur("Bot-02");

        } catch (ArithmeticException | IllegalArgumentException e ){
            e.printStackTrace();
            System.out.println("Le Bot bot-2 existe déjà");
        } catch (ExceptionInInitializerError e){
            System.out.println("Le Bot bot-2 existe déjà");
        }
        finally {
            System.out.println("Code dans le finally");
        }
        System.out.println("Bot3 = "+bot3);
    }
}
