/*
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
*/
/**
 * Created by Michael Pacana & Noah Silvio on 3/22/2017.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * Created by Michael Pacana & Noah Silvio on 3/22/2017.
 */
public class TableData_4 extends JPanel {
    JTable table = new JTable();// setting up contents
    DefaultTableModel model = new DefaultTableModel();
    Data data;
    JLabel title;
    public TableData_4(){

        this.setLayout(new GridBagLayout());//GridBagLayout for more control
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel("123");//creating contents
        table.setModel(model);//setting up table
        table.setPreferredScrollableViewportSize(new Dimension(515,125));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table); // for table to be scrollable

        gc.weighty = 1;//adding items to
        gc.gridy = 0;
        add(title,gc);
        gc.gridy = 1;
        add(scrollPane, gc);
        setVisible(true);
    }
    public void erase(){
        model.setRowCount(0);
    }
    public void updateData(Data data){
        this.data = data;
        Object[] columnNames;
        Object[][] tableData = new Object[data.getRawData().length][];

        for(int i = 0; i < data.getRawData().length; i++){
            if(data.getIsNumericDataType())
                tableData[i] = new Object[7];
            else
                tableData[i] = new Object[2];
        }

        title.setText(data.getBriefTitle());
        title.setFont(new Font("Arial",Font.BOLD,30));
        if(data.getIsNumericDataType()){
            columnNames = new Object[]{"CL","TRUE CL","MIDPOINTS","FREQ","%","CF","C%"};
            for(int i = 0; i < data.getClassLength(); i++) {
                tableData[i][0] = data.getLowerClassLimitItem(i) + " - " + data.getUpperClassLimitItem(i);
                tableData[i][1] = data.getTrueLowerClassLimitItem(i) + " - " + data.getTrueUpperClassLimitItem(i);
                tableData[i][2] = data.getMidpointItem(i);
                tableData[i][3] = data.getFrequencyItem(i);
                tableData[i][4] = data.getClassPercentageItem(i) + "%";
                tableData[i][5] = data.getCFrequencyItem(i);
                tableData[i][6] = data.getCClassPercentageItem(i) + "%";
            }
        }else{
            columnNames = new Object[]{"VALUE LABELS(sorted)","PERCENTAGE(based on 'n'*)"};
            for(int i = 0; i < data.getCategoriesLength(); i++) {
                tableData[i][0] = data.getCategoryItem(i);
                tableData[i][1] = data.getCategoryPercentage(i);
            }
        }
        erase();
        model.setColumnIdentifiers(columnNames);
        if(data.getIsNumericDataType()) {
            for (int i = 0; i < data.getClassLength(); i++) {
                model.addRow(tableData[i]);
            }
            model.addRow(new String[] {"","", "", data.getTotalFreq().toString(), data.getTotalPercent().toString() + " %", "", "", ""});
        } else {
            for (int i = 0; i < data.getCategoriesLength(); i++) {
                model.addRow(tableData[i]);
            }
            model.addRow(new String[] {"", data.getTotalPercent().toString() + " %"});
        }
    }
    public void collapse(Data data, int choice){
        erase();
        Object[] columnNames = new Object[]{"CL","TRUE CL","MIDPOINTS","FREQ","%","CF","C%"};
        Object[][] tableData = new Object[data.getRawData().length][];

        title.setText(data.getBriefTitle());
        title.setFont(new Font("Arial",Font.BOLD,30));

        for(int i = 0; i < data.getRawData().length; i++){
            tableData[i] = new Object[7];
        }

        for(int i = 0; i < data.getClassLength(); i++) {
            tableData[i][0] = data.getLowerClassLimitItem(i) + " - " + data.getUpperClassLimitItem(i);
            tableData[i][1] = data.getTrueLowerClassLimitItem(i) + " - " + data.getTrueUpperClassLimitItem(i);
            tableData[i][2] = data.getMidpointItem(i);
            tableData[i][3] = data.getFrequencyItem(i);
            tableData[i][4] = data.getClassPercentageItem(i) + "%";
            tableData[i][5] = data.getCFrequencyItem(i);
            tableData[i][6] = data.getCClassPercentageItem(i) + "%";
        }

        for (int i = 0; i < data.getCategoriesLength(); i++) {
            model.addRow(tableData[i]);
        }

        if (choice == 2 || choice == 1) {
            tableData[0][0] = " < " + data.getUpperClassLimitItem(0);
            tableData[0][1] = " < " + data.getTrueUpperClassLimitItem(0);
            tableData[0][2] = " -- ";
        }
        if(choice == 3 || choice == 1) {
            tableData[data.getClassLength() - 1][0] = " > " + data.getLowerClassLimitItem(data.getClassLength() - 1);
            tableData[data.getClassLength() - 1][1] = " > " + data.getTrueLowerClassLimitItem(data.getClassLength() -1);
            tableData[data.getClassLength() - 1][2] = " -- ";
        }

        model.setColumnIdentifiers(columnNames);


        for (int i = 0; i < data.getClassLength(); i++) {
            model.addRow(tableData[i]);
        }

        model.addRow(new String[] {"","", "", data.getTotalFreq().toString(), data.getTotalPercent().toString() + " %", "", "", ""});
    }

}