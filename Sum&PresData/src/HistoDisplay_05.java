import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.Histogram;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Histogram Overlapped
 *
 * Demonstrates the following:
 * <ul>
 * <li>Histogram
 * <li>Bar Chart styles - overlapped, bar width
 * */
public class HistoDisplay_05 implements ExampleChart<CategoryChart> {

    public static void main(String[] args) {
        ExampleChart<CategoryChart> exampleChart = new HistoDisplay_05();
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<CategoryChart>(chart).displayChart();
    }

    @Override
    public CategoryChart getChart() {
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Mean").yAxisTitle("Count").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setAvailableSpaceFill(.96);
        chart.getStyler().setOverlapped(true);

        // Series
        Histogram histogram1 = new Histogram(getGaussianData(10000), 20, -20, 20);
        chart.addSeries("histogram 1", histogram1.getxAxisData(), histogram1.getyAxisData());
        return chart;
    }

    private List<Double> getGaussianData(int count) {

        List<Double> data = new ArrayList<Double>(count);
        Random r = new Random();
        double k;
        System.out.println("The count is "+ count);
        for (int i = 0; i < count; i++) {
            data.add(k = r.nextGaussian());
            //System.out.println(k);
        }
        System.out.println("out");
        return data;
    }
}