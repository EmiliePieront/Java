package ToucheCoule.NewProject;

import java.time.LocalDate;

public class PersonneDomiciliee extends Personne{
    private Adresse adresse;
    public PersonneDomiciliee(String nom, String prenom, LocalDate dob, Adresse adresse) throws parameterIsBlankOrNullException {
        super(nom, prenom, dob); //Appelle le constructeur parent
        this.adresse = adresse;

    }
    public  PersonneDomiciliee(String nom, String prenom, LocalDate dob, String rue, String numero, String localite, String cp) throws parameterIsBlankOrNullException {
        super(nom, prenom, dob);
        adresse = new Adresse(rue, numero, localite, cp);

    }
}
