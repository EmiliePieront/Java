package ToucheCoule.Exercices;

public class TV_1950 {
    private String marque;
    private String modele;
    protected int volume;
    private float diagonale;
    private int  nombreDeChaine;
    private int chaineChourante;
    private int luminosite;
    private int contraste;
    private boolean estAllumee;
    private boolean estBranchee;

    public TV_1950(String marque, String modele, float diagonale, int nombreDeChaine) {
        this.marque = marque;
        this.modele = modele;
        this.diagonale = diagonale;
        this.nombreDeChaine = nombreDeChaine;
        estAllumee = false;
        estBranchee = false;
        chaineChourante = 1;
    }
    public void volumeUp(){
        if (volume < 100)
            volume++;
    }
    public void volumeDown(){
        if (volume<0)
            volume--;
    }
    public void luminositeUp(){
        if(luminosite<100)
            luminosite++;
    }
    public void luminositeDown(){
        if (luminosite>0)
            luminosite--;
    }
    public void contrasteUp(){
        if(contraste<100)
            contraste++;
    }
    public void contrasteDown(){
        if (contraste>0)
            contraste--;
    }
    public void pushOnButton(){
        estAllumee = !estAllumee;
    }
    public void plug(){
        estBranchee = true;
    }
    public void unpluged(){
        estBranchee = false;
    }
    public void channelUp(){
        chaineChourante++;
        if (chaineChourante > nombreDeChaine)
            chaineChourante = 1;
    }
    public void channelDown(){
        chaineChourante--;
        if(chaineChourante == 0)
            chaineChourante = nombreDeChaine;
    }
    @Override
    public String toString() {
        return "TV_1950{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", volume=" + volume +
                ", diagonale=" + diagonale +
                ", nombreDeChaine=" + nombreDeChaine +
                ", chaineChourante=" + chaineChourante +
                ", luminosite=" + luminosite +
                ", contraste=" + contraste +
                ", estAllumee=" + estAllumee +
                ", estBranchee=" + estBranchee +
                ", elle fonctionne=" + (estBranchee & estAllumee ? "OUI" : "NON") +
                '}';

    }
    private void maMethodePrivate() {
        System.out.println("Je suis private dans TV1950");
    }
}
