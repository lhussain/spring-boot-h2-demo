package io.techrank.demo.algo;

import java.util.ArrayList;
import java.util.List;

public class AlgoForAbdullah {

    private static final int PERCENT_MULT = 100;

    private List<Long> doPercentageCalculation(double ref,  double[] tokyo, double[] london) {

        List<Long> percentages = new ArrayList<>();

        for (int i = 0; i < tokyo.length; i++) {
            double tokyoAsPercent = (tokyo[i] / ref) * PERCENT_MULT;
            double londonAsPercent = (london[i] /ref) * PERCENT_MULT;
            double diffAsPercent;

            if (tokyoAsPercent > londonAsPercent) {
                diffAsPercent = tokyoAsPercent - londonAsPercent;
            } else {
                diffAsPercent = londonAsPercent - tokyoAsPercent;
            }

            percentages.add(Math.round(diffAsPercent));
        }

        return percentages;
    }

    public static void main(String[] args) {
        double reference = 30;
        double[] tokyo =  {7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6};
        double[] london =  {3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8};

        AlgoForAbdullah afa = new AlgoForAbdullah();

        List<Long> percentages = afa.doPercentageCalculation(reference, tokyo, london);

        percentages.forEach(percent -> System.out.println(percent));
    }
}
