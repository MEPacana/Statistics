package CTD; /**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 *//*

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CTD.GChoiceData_4c extends JPanel{
    private String classTitle = "Descriptive Statistics";
    JLabel title;
    JPanel titlePanel;

    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;

    private Object[] columns = {"Upper Class Limit", "Lower Class Limit","Frequencies",
        "Class Marks (xi)","(fixi)","(fixi2)"  };
    CTD.Data1 data1;

    public CTD.GChoiceData_4c(){
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

    public void init(CTD.Data1 data1){
        erase();
        this.data1 = data1;
        model.setRowCount(data1.getFrequency().length+1);//TODO SUM NILA
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
    Data1 data1;

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

    public void init(Data1 data12){
        erase();
        this.data1 = data12;
        somenumber = this.data1.getFrequency().length;
        model.setRowCount(0);//TODO SUM NILA
        data1.makeMidpoints();
        this.data1 = data12;
        drawModel(data12);
        System.out.println("Mean : " + data1.gMean());
        System.out.println("Mode : " + data1.gMode());
        System.out.println("Median : " + data1.gMedian());
    }

    public void setTitle(String text){
        title.setText(text);
    }

    public void updateData(Data1 data12){
        this.data1 = data12;
        drawModel(data12);
    }

    public void drawModel(Data1 data12){
        System.out.println(data12.getFrequency().length + " <---eyyyyyy");
        System.out.println(data12.getUpperClassLimits().length + " <---eyyyyyy");
        System.out.println(data12.getLowerClassLimits().length + " <---eyyyyyy");
        System.out.println(data12.getMidpoint().size() + " <---eyyyyyy");

        if(data12.getOpentype() == 1 && data1.getFrequency().length > 1) {
            for (int i = 0; i < data1.getFrequency().length; i++) {
                if(i == 0)
                    model.addRow(new String[] {"<" + this.data1.getUpperClassLimits()[i], "-", this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data1.getUpperClassLimits()[i], this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
            }
        } else if (data1.getOpentype() == 2 && data1.getFrequency().length > 1) {
            for (int i = 0; i < data12.getFrequency().length; i++) {
                if(i == data1.getFrequency().length-1)
                    model.addRow(new String[] {"-" , ">" + this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data1.getUpperClassLimits()[i], this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
            }
        } else if (data1.getOpentype() == 3 && data1.getFrequency().length > 2) {
            for (int i = 0; i < data1.getFrequency().length; i++) {
                System.out.println(data12.getFrequency());
                if(i == data1.getFrequency().length-1)
                    model.addRow(new String[] {"-" , ">" + this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
                if(i == 0)
                    model.addRow(new String[] {"<" + this.data1.getUpperClassLimits()[i], "-", this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
                else
                    model.addRow(new String[] {this.data1.getUpperClassLimits()[i], this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
            }
        } else {
            for (int i = 0; i < data12.getFrequency().length; i++) {
                model.addRow(new String[]{this.data1.getUpperClassLimits()[i], this.data1.getLowerClassLimits()[i], this.data1.getFrequency()[i], this.data1.getMidpoint().elementAt(i).toString(), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i])), String.valueOf(this.data1.getMidpoint().elementAt(i) * Double.valueOf(this.data1.getFrequency()[i]) * this.data1.getMidpoint().elementAt(i))});
            }
        }
        data1.makeFreqTimeMidpt();
        data1.makeFreqTimeMidptSqrr();
        model.addRow(new String[]{"","","","", String.valueOf(data1.getTotalFX()), String.valueOf(data1.getTotalFX2())});
    }

}
