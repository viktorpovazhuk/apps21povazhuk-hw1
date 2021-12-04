package ua.edu.ucu.tempseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        addTemps(temperatureSeries);
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
        int lessValuesCount = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                lessValuesCount += 1;
            }
        }
        double[] lessValues = new double[lessValuesCount];
        if (lessValuesCount > 0) {
            for (int i = 0; i < lessValuesCount; i++) {
                for (int j = 0; j < temperatureSeries.length; j++) {
                    if (temperatureSeries[i] < tempValue) {
                        lessValues[i] = temperatureSeries[j];
                    }
                }
            }
        }
        return lessValues;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int greaterValuesCount = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > tempValue) {
                greaterValuesCount += 1;
            }
        }
        double[] greaterValues = new double[greaterValuesCount];
        if (greaterValuesCount > 0) {
            for (int i = 0; i < greaterValuesCount; i++) {
                for (int j = 0; j < temperatureSeries.length; j++) {
                    if (temperatureSeries[i] > tempValue) {
                        greaterValues[i] = temperatureSeries[j];
                    }
                }
            }
        }
        return greaterValues;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < -273) {
                throw new InputMismatchException();
            }
        }
        if (temperatureSeries == null) {
            temperatureSeries = new double[0];
        }
        double[] newTemps = new double[temps.length + temperatureSeries.length];
        System.arraycopy(temperatureSeries, 0, newTemps, 0, temperatureSeries.length);
        System.arraycopy(temps, 0, newTemps, temperatureSeries.length, temps.length);
        temperatureSeries = newTemps;
        return temperatureSeries.length;
    }

    @Override
    public String toString() {
        return "TemperatureSeriesAnalysis{" +
                "temperatureSeries=" + Arrays.toString(temperatureSeries) +
                '}';
    }
}
