package ToucheCoule.NewProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Personne personne1 = null;
        try {
            Scanner in = new Scanner(System.in);

            System.out.print("Entrez le nom    : ");
            String nom = in.nextLine();

            System.out.print("\nEntrez le prénom    : ");
            String prenom = in.nextLine();

            System.out.print("\nEntrez votre date de naissance    :");
            String dob = in.nextLine();

            personne1 = new Personne(nom, prenom, LocalDate.parse(dob));


            personne1.setNom("Nouveau nom");
            PersonneDomiciliee pd = new PersonneDomiciliee("Nom", "Prenom", LocalDate.parse("2008-12-12"), new Adresse("Rue", "18", "Namur", "5000"));
            pd.setNom("Nouveau Nom");



        } catch (parameterIsBlankOrNullException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e){
            System.out.print("C'est NULL\n");
        }
        System.out.println(personne1);
    }
}
