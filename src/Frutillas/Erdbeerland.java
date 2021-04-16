package Frutillas;

import java.util.Arrays;

public class Erdbeerland {
    final int GRÜN = 1;
    final int REIF = 2;
    final int VERDORBEN = 3;
    final static int BECHER_GRÖSZE = 10;
    final static int BECHER_VORHANDEN = 100;

    public static void main(String[] args) {
        final double[] GEWICHTE = Erdbeeren.WEIGHTS;
        final int[] KLASSIFIZIERUNG = Erdbeeren.CLASSIFICATION;

        System.out.println(istVerdorben(KLASSIFIZIERUNG, 0));
        System.out.println(istGrün(KLASSIFIZIERUNG, 0));
        System.out.println(anzahlReifeBeeren(KLASSIFIZIERUNG));
        System.out.println(nimmReifeBeeren(KLASSIFIZIERUNG, 16));
        System.out.println(mittleresGewicht(GEWICHTE));
        System.out.println(mittleresGewichtReif(GEWICHTE, KLASSIFIZIERUNG));
        System.out.println(Arrays.toString(fülleBecher(KLASSIFIZIERUNG, 1)));
        System.out.println(Arrays.toString(fülleBecher(KLASSIFIZIERUNG, 2)));
        System.out.println(becherNettoGewicht(GEWICHTE, fülleBecher(KLASSIFIZIERUNG, 0)));

    }

    public static boolean istVerdorben(int[] beerenKlassifiziert, int index) {
        if (beerenKlassifiziert[index] == 3){
            return true;
        }
        return false;
    }

    public static boolean istGrün(int[] beerenKlassifiziert, int index) {
        if (beerenKlassifiziert[index] == 1){
            return true;
        }
        return false;
    }

    public static int anzahlReifeBeeren(int[] beerenKlassifiziert) {
        int counter = 0;
        for (int i = 0; i < beerenKlassifiziert.length; i++) {
            if (beerenKlassifiziert[i]==2)
            counter++;

        }
        return counter;
    }

    public static int nimmReifeBeeren(int[] beerenKlassifiziert, int index) {
        //count how many ripe follow
        int counter = 0;
        if (beerenKlassifiziert[index] == 2){

            for (int i = index; i < beerenKlassifiziert.length; i++) {
                if (beerenKlassifiziert[index] ==2){
                    counter++;
                    index++;
                }else {
                    break;
                }
            }
        }
        return counter;
    }

    public static double mittleresGewicht(double[] gewichte) {
        double sum = 0;
        for (int i = 0; i < gewichte.length; i++) {
            sum = sum + gewichte[i];

        }
        return sum/gewichte.length; // Platzhalter
    }

    public static double mittleresGewichtReif(double[] gewichte, int[] beerenKlassifiziert) {
        double sum=0;
        int counterRipes = 0;
        for (int i = 0; i < beerenKlassifiziert.length; i++) {
            if(beerenKlassifiziert[i] == 2){
                sum = sum + gewichte[i];
                counterRipes++;
            }
        }
        return sum/counterRipes; // Platzhalter
    }

    public static int[] fülleBecher(int[] beerenKlassifiziert, int index) {
        int[] numberRipes = new int[10];
        int counter = 0;

        for (int i = index; i < beerenKlassifiziert.length; i++) {

            if (beerenKlassifiziert[index] == 2 && counter<10){
                numberRipes[counter] = index;
                counter++;
            }
            index++;
        }

        return numberRipes;
    }

    public static double becherNettoGewicht(double[] gewichte, int[] becherFüllung) {
        double sumCup = 0;
        for (int i = 0; i < becherFüllung.length; i++) {
            sumCup = sumCup + gewichte[becherFüllung[i]];

        }
        return sumCup;
    }
}
