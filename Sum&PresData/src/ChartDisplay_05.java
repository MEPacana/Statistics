import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michael Pacana & Noah Silvio on 3/27/2017.
 */

public class ChartDisplay_05 extends JPanel {
    private Data data = new Data();
    private JLabel title;
    JPanel pnlChart;
    PieChart dataPieChart;
    CategoryChart dataCategoryChart;
    int dataPieChartlength,dataCategoryChartLength;
    private boolean hasProcessed = false;
    public ChartDisplay_05(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel(data.getBriefTitle());

        this.validate();
        setVisible(true);
    }
    public void getData(Data data){
        if(!hasProcessed) {
         hasProcessed = true;
            if (data.getIsNumericDataType()) {
                getNumericData(data);
            } else {
                getCategoricalData(data);
            }
        }

    }
    public void getNumericData( Data data){

        dataCategoryChart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
        JPanel pnlChart = new XChartPanel(dataCategoryChart);
        pnlChart.setSize(100,100);
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = gc.gridy = 0;
        this.add(pnlChart,gc);
        // Customize Chart
        dataCategoryChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        dataCategoryChart.getStyler().setHasAnnotations(true);

        // Series
        dataCategoryChart.addSeries(data.getBriefTitle(), data.getMidpoints(), data.getFrequency());
    }

    private java.util.List<Double> getGaussianData(Data data) {

        java.util.List<Double> listData = new ArrayList<Double>(data.getRawData().length);
        for (int i = 0; i < data.getRawData().length; i++) {

            listData.add(Double.parseDouble(data.getRawData()[i]));
        }
        System.out.println("out");
        return listData;
    }
    public void erase(){
        if(!data.getIsNumericDataType()) {
            for (int i = 0; i < dataPieChartlength; i++) {
                dataPieChart.removeSeries(data.getCategoryItem(i));
            }
        }else{

        }
    }
    public void getCategoricalData(Data data){
        this.data = data;
        dataPieChartlength = data.getCategoriesLength();
        System.out.println("Nisulod sa get Categorical");
        dataPieChart = new PieChartBuilder().width(800).height(600).title(data.getBriefTitle()).build();
        Random rand = new Random();

        JPanel pnlChart = new XChartPanel(dataPieChart);
        pnlChart.setSize(100,100);
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = gc.gridy = 0;
        this.add(pnlChart,gc);

        Color[] sliceColors = new Color[data.getCategoriesLength()];
        for (int i = 0; i < data.getCategoriesLength(); i++) {
            float r = (float) (rand.nextFloat() / 2f + 0.5);
            float g = (float) (rand.nextFloat() / 2f + 0.5);

            float b = (float) (rand.nextFloat() / 2f + 0.5);

            sliceColors[i] = new Color(r, g, b);
            sliceColors[i].brighter();
        }
        dataPieChart.getStyler().setSeriesColors(sliceColors);

        // Series
        for (int i = 0; i < data.getCategoriesLength(); i++) {
            dataPieChart.addSeries(data.getCategoryItem(i), data.getDoubleCategoryPercentage(i));
        }
    }
}