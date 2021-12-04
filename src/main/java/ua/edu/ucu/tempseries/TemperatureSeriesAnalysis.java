package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
//        this.temperatureSeries = new double[temperatureSeries.length];
//        for (int i = 0; i < temperatureSeries.length; i++) {
//            this.temperatureSeries[i] = temperatureSeries[i];
//        }
    }

    public double average() {
        double sum = 0;
        for (double temp : this.temperatureSeries) {
            sum += temp;
        }
        return sum / temperatureSeries.length;
    }

    public double deviation() {
        double tmpAverage = average();
        double sum = 0;
        for (double temp : this.temperatureSeries) {
            sum += Math.pow((temp - tmpAverage), 2);
        }
        return Math.pow(sum / (temperatureSeries.length - 1), 0.5);
    }

    public double min() {
        return findTempClosestToValue(-1000);
    }

    public double max() {
        return findTempClosestToValue(1000);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Zero length of temps array");
        }
        double diff = Double.POSITIVE_INFINITY;
        double nearest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < temperatureSeries.length; i++) {
            double cur_diff = Math.abs(temperatureSeries[i] - tempValue);
            if (cur_diff < diff || (cur_diff == diff && temperatureSeries[i] > 0 && nearest < 0)) {
                diff = cur_diff;
                nearest = temperatureSeries[i];
            }
        }
        return nearest;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        return 0;
    }

    @Override
    public String toString() {
        return "TemperatureSeriesAnalysis{" +
                "temperatureSeries=" + Arrays.toString(temperatureSeries) +
                '}';
    }
}
