package SPD;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Michael Pacana & Noah Silvio on 3/27/2017.
 */

public class ChartDisplay_05 extends JPanel {
    private Data3 data = new Data3();
    private JLabel title;
    JPanel pnlChart;
    PieChart dataPieChart;
    CategoryChart dataCategoryChart;
    int dataPieChartlength,dataCategoryChartLength;
    private boolean hasProcessed = false;
    boolean niBack = false;
    public boolean categoryfirst = true, histofirst = true;

    public ChartDisplay_05(){
        System.out.println("Nisulod diri 1");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel(data.getBriefTitle());

        this.validate();
        setVisible(true);
    }
    public void getData(Data3 data){
         if (data.getIsNumericDataType()) {
                getNumericData(data);
         } else {
             getCategoricalData(data);
         }
    }

    public void getNumericData( Data3 data) {
        this.data=data;
        System.out.println("Nisulod diri NumericData");
        if (histofirst){
            System.out.println("Nisulod diri HistoFirst");
            histofirst = false;
            System.out.println("NIbalike diri 3");
            dataCategoryChart = new CategoryChartBuilder().width(800).height(600).title(data.getBriefTitle()).xAxisTitle("Score").yAxisTitle("Number").build();
            pnlChart = new XChartPanel(dataCategoryChart);
            pnlChart.setSize(100, 100);
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = gc.gridy = 0;
            this.add(pnlChart, gc);
            // Customize Chart
            dataCategoryChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
            dataCategoryChart.getStyler().setHasAnnotations(true);
            dataCategoryChart.getStyler().setAvailableSpaceFill(1);
            // Series
            dataCategoryChart.addSeries(data.getBriefTitle(), data.getMidpoints(), data.getFrequency());
        }
    }

    public void erase(){

        niBack = false;
        System.out.println("NA FALSE BALIK YASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSss");
        if(!data.getIsNumericDataType()) {
            for (int i = 0; i < dataPieChartlength; i++) {
                dataPieChart.removeSeries(data.getCategoryItem(i));
            }
        }else{
            this.remove(pnlChart);
        }
    }

    public void setNiBack(boolean erase){
        this.niBack = erase;
    }

    public void addData(Data3 data){
        System.out.println("Nisulod add data");
        if(!data.getIsNumericDataType()) {
            this.data = data;
            niBack = true;
            dataPieChart.setTitle(data.getBriefTitle());
            dataPieChartlength = data.getCategoriesLength();
            Random rand = new Random();
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
        }else{
            this.data = data;
            System.out.println("Nisulod add data histo");
            dataCategoryChart.setTitle(data.getBriefTitle());
            dataCategoryChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
            dataCategoryChart.getStyler().setHasAnnotations(true);
            dataCategoryChart.getStyler().setAvailableSpaceFill(1);
            // Series
            dataCategoryChart.addSeries(data.getBriefTitle(), data.getMidpoints(), data.getFrequency());
        }
    }

    public void getCategoricalData(Data3 data) {
        if (categoryfirst) {
            categoryfirst = false;
            this.data = data;
            dataPieChartlength = data.getCategoriesLength();
            dataPieChart = new PieChartBuilder().width(800).height(600).title(data.getBriefTitle()).build();
            Random rand = new Random();

            JPanel pnlChart = new XChartPanel(dataPieChart);
            pnlChart.setSize(100, 100);
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = gc.gridy = 0;
            this.add(pnlChart, gc);

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
                System.out.println(data.getCategoryItem(i));
            }
            for (int i = 0; i < data.getCategoriesLength(); i++) {
                dataPieChart.addSeries(data.getCategoryItem(i), data.getDoubleCategoryPercentage(i));
            }
        }else{
            if(!niBack) {
                niBack = true;
                System.out.println("NISULOD SA ELSE");
                addData(data);
            }
        }
    }
}
