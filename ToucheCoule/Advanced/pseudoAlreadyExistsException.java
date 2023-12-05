package ToucheCoule.Advanced;

public class pseudoAlreadyExistsException extends Exception{

    //Créer une sous classe -> Au lieu de redéfinir toute une classe on met que ce qui est différent ou en plus.
    //La sous classe hérite implicitement de tout ce que possède la classe.
    public pseudoAlreadyExistsException(String message) {
        super(message);
        //Le super va appeler le constructeur définit dans la classe exception et lui envoie le paramètre message


    }
}
