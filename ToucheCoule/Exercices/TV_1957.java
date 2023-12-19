package ToucheCoule.Exercices;

public class TV_1957 extends TV_1950_Mute {
    public TV_1957 (){
        super("Philips", "T1010", 14, 10);
    }
    @Override //Pour que le système vérifie si oui ou non c'est une nouvelle compilation
    public String toString(){
        return super.toString() +
                "\n La couleur est arrivée !!";
    }
}
