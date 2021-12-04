package ua.edu.ucu.tempseries;

public class Main {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3};
        TemperatureSeriesAnalysis t = new TemperatureSeriesAnalysis(arr);
        arr[0] = 45;
        System.out.println(t);
        System.out.println(t.summaryStatistics().toString());

    }

}
