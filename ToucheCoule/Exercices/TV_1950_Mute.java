package ToucheCoule.Exercices;

public class TV_1950_Mute extends TV_1950 {
    private boolean isMuted = false;
    private int savedVolume;

    public TV_1950_Mute(String marque, String modele, float diagonale, int nombreDeChaine) {
        super(marque, modele, diagonale, nombreDeChaine);
    }

    public void pushMute(){
        if(isMuted){
            volume = savedVolume;
        } else {
            savedVolume = volume;
            volume = 0;
        }
        isMuted = !isMuted;
    }
    public String toString(){
        return super.toString() +
                "Muted:" + isMuted;
    }
    public void maMethodePrivate() {

    }
}
