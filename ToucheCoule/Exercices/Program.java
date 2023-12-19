package ToucheCoule.Exercices;

public class Program {
    public static void main(String[] args){
        var tv1950 = new TV_1950("Philips", "T-1000", 14, 6);
        System.out.println(tv1950);
        var infoTV = tv1950.toString();
        System.out.println(infoTV);

        tv1950.plug();
        tv1950.pushOnButton();
        for (int x = 0; x < 15; x++)
            tv1950.volumeUp();
        for (int x = 0; x < 50; x++)
            tv1950.contrasteUp();
        for (int x = 0; x < 70; x++)
            tv1950.luminositeUp();
        System.out.println(tv1950);
    }
}
