package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

//    @Test
//    public void testAverageWithOneElementArray() {
//        // setup input data and expected result
//        double[] temperatureSeries = {-1.0};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//        double expResult = -1.0;
//
//        // call tested method
//        double actualResult = seriesAnalysis.average();
//
//        // compare expected result with actual result
//        assertEquals(expResult, actualResult, 0.00001);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAverageWithEmptyArray() {
//        double[] temperatureSeries = {};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//
//        // expect exception here
//        seriesAnalysis.average();
//    }
//
//    @Test
//    public void testAverage() {
//        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//        double expResult = 1.0;
//
//        double actualResult = seriesAnalysis.average();
//
//        assertEquals(expResult, actualResult, 0.00001);
//    }

    @Test
    public void testFindClosestToZero() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        double[] arr = {1, 2, 3};
        TemperatureSeriesAnalysis t = new TemperatureSeriesAnalysis(arr);
        assertEquals("TempSummaryStatistics{avgTemp=2.0, devTemp=1.0, minTemp=1.0, maxTemp=3.0}",
                t.summaryStatistics().toString());
    }
}
