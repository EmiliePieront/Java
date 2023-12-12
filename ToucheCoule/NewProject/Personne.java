package ToucheCoule.NewProject;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private LocalDate dob; //date of birth

    public Personne(@NotNull String nom, @NotNull String prenom, @NotNull LocalDate dob) throws parameterIsBlankOrNullException {
        if (nom.isBlank()) {
            throw new parameterIsBlankOrNullException("Le nom doit contenir des caractères.");
        }
        if (prenom.isBlank()) {
            throw new parameterIsBlankOrNullException("Le Prénom doit contenir des caractères.");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.dob = dob;
    }
    public void setNom(@NotNull String nouveauNom){
        this.nom = nouveauNom;
    }

}
