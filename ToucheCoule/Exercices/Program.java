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

        System.out.println("-------------------------------------");
        var tv1950GMuted = new TV_1950_Mute("Philips", "T-1001", 14, 4);
        System.out.println(tv1950GMuted);
        tv1950GMuted.plug();
        tv1950GMuted.pushOnButton();
        for (int x = 0; x < 15; x++)
            tv1950GMuted.volumeUp();
        System.out.println(tv1950GMuted);

        tv1950GMuted.pushMute();
        System.out.println(tv1950GMuted);

        tv1950GMuted.pushMute();
        System.out.println(tv1950GMuted);

        System.out.println("-------------------------------------");

        var tv1957 = new TV_1957();
        System.out.println(tv1957);

        System.out.println("-------------------------------------");
        TV_1950 tv1950_2 = new TV_1950_Mute("Philips", "T1", 214,4);
        tv1950_2.channelUp();
        System.out.println(tv1950_2);

        TV_1950[] tvs = {tv1950, tv1950GMuted, tv1957};
        for (var maTv : tvs){
            System.out.println(maTv);
            maTv.luminositeUp();
            System.out.println(maTv);
        }


    }
}
