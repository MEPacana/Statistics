/**
 * Created by Michael Pacana and Noah Silvio on 3/26/2017.
 */

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

import java.awt.*;

/**
 * Pie Chart Custom Color Palette
 *
 * Demonstrates the following:
 * <ul>
 * <li>Pie Chart
 * <li>ChartBuilderPie
 * <li>Custom series palette
 */
public class PieChartDisplay_05 implements ExampleChart<PieChart> {

    public PieChart getChart() {

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        chart.addSeries("Gold", 24.12);
        chart.addSeries("Silver", 21);
        chart.addSeries("Platinum", 39);
        chart.addSeries("Copper", 17);
        chart.addSeries("Zinc", 40);

        return chart;
    }

    public void displayPieChart() {

        ExampleChart<PieChart> exampleChart = new PieChartDisplay_05();
        PieChart chart = exampleChart.getChart();
        new SwingWrapper<PieChart>(chart).displayChart();
    }
}
