/**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 *//*

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GChoiceData_4c extends JPanel{
    private String classTitle = "Descriptive Statistics";
    JLabel title;
    JPanel titlePanel;

    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;

    private Object[] columns = {"Upper Class Limit", "Lower Class Limit","Frequencies",
        "Class Marks (xi)","(fixi)","(fixi2)"  };
    Data data;

    public GChoiceData_4c(){
        //setting up main Panel
        titlePanel = new JPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel(classTitle);
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        model.setRowCount(10);
        model.setColumnIdentifiers(columns);
        table.setPreferredScrollableViewportSize(new Dimension(515,125));
        table.setModel(model);
        scroll = new JScrollPane(table);

        gc.gridx = 0;
        gc.gridy = 0;
        titlePanel.add(title,gc);

        gc.weighty = gc.weightx = 1;
        gc.gridy = 0;
        this.add(titlePanel,gc);
        gc.gridy = 1;

        this.add(scroll,gc);
        setVisible(true);
        //todo summation
    }

    public void erase(){

    }

    public void init(Data data){
        erase();
        this.data = data;
        model.setRowCount(data.getFrequency().length+1);//TODO SUM NILA
    }

    public void setTitle(String text){
        title.setText(text);
    }
}
*/
/**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GChoiceData_4c extends JPanel{
    private String classTitle = "Descriptive Statistics";
    JLabel title;
    JPanel titlePanel = new JPanel();;

    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();

    int somenumber;
    JScrollPane scroll;

    private Object[] columns = {"Upper Class Limit", "Lower Class Limit","Frequencies",
            "Class Marks (xi)","(fixi)","(fixi2)"  };
    Data data;

    public GChoiceData_4c(){
        //setting up main Panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel(classTitle);
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        model.setRowCount(1);
        model.setColumnIdentifiers(columns);
        table.setPreferredScrollableViewportSize(new Dimension(515,125));

        table.setModel(model);
        scroll = new JScrollPane(table);

        gc.gridx = 0;
        gc.gridy = 0;
        titlePanel.add(title,gc);

        gc.weighty = gc.weightx = 1;
        gc.gridy = 0;
        this.add(titlePanel,gc);
        gc.gridy = 1;

        this.add(scroll,gc);
        setVisible(true);

        //todo summation
    }

    public void erase(){

    }

    public void init(Data data2){
        erase();
        this.data = data2;
        somenumber = this.data.getFrequency().length;
        model.setRowCount(0);//TODO SUM NILA
        data.makeMidpoints();
        this.data = data2;
        drawModel(data2);
        System.out.println("Mean : " + data.gMean());
        System.out.println("Mode : " + data.gMode());
        System.out.println("Median : " + data.gMedian());
    }

    public void setTitle(String text){
        title.setText(text);
    }

    public void updateData(Data data2){
        this.data = data2;
        drawModel(data2);
    }

    public void drawModel(Data data2){
        System.out.println(data2.getFrequency().length + " <---eyyyyyy");
        System.out.println(data2.getUpperClassLimits().length + " <---eyyyyyy");
        System.out.println(data2.getLowerClassLimits().length + " <---eyyyyyy");
        System.out.println(data2.getMidpoint().size() + " <---eyyyyyy");

        if(data2.getOpentype() == 1 && data.getFrequency().length > 1) {
            for (int i = 0; i < data.getFrequency().length; i++) {
                if(i == 0)
                    model.addRow(new String[] {"<" + this.data.getUpperClassLimits()[i], "-", this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data.getUpperClassLimits()[i], this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
            }
        } else if (data.getOpentype() == 2 && data.getFrequency().length > 1) {
            for (int i = 0; i < data2.getFrequency().length; i++) {
                if(i == data.getFrequency().length-1)
                    model.addRow(new String[] {"-" , ">" + this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data.getUpperClassLimits()[i], this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
            }
        } else if (data.getOpentype() == 3 && data.getFrequency().length > 2) {
            for (int i = 0; i < data.getFrequency().length; i++) {
                System.out.println(data2.getFrequency());
                if(i == data.getFrequency().length-1)
                    model.addRow(new String[] {"-" , ">" + this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
                if(i == 0)
                    model.addRow(new String[] {"<" + this.data.getUpperClassLimits()[i], "-", this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data.getUpperClassLimits()[i], this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
            }
        } else {
            for (int i = 0; i < data2.getFrequency().length; i++) {
                model.addRow(new String[]{this.data.getUpperClassLimits()[i], this.data.getLowerClassLimits()[i], this.data.getFrequency()[i], this.data.getMidpoint().elementAt(i).toString(), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i])), String.valueOf(this.data.getMidpoint().elementAt(i) * Double.valueOf(this.data.getFrequency()[i]) * this.data.getMidpoint().elementAt(i))});
            }
        }
        data.makeFreqTimeMidpt();
        data.makeFreqTimeMidptSqrr();
        model.addRow(new String[]{"","","","", String.valueOf(data.getTotalFX()), String.valueOf(data.getTotalFX2())});
    }

}
