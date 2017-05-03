/**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 */
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
