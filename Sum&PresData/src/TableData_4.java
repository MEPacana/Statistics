/*
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
*/
/**
 * Created by Michael Pacana & Noah Silvio on 3/22/2017.
 *//*

public class TableData_4 extends JPanel {
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    Object[] columnNames;
    Object[][] tableData;
    Data data;
    JLabel title;
    public TableData_4(){
        this.setLayout(new GridBagLayout());
        table.setModel(model);

        GridBagConstraints gc = new GridBagConstraints();
        title = new JLabel("123");
        table.setPreferredScrollableViewportSize(new Dimension(515,125));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        gc.weighty = 1;
        gc.gridy = 0;
        add(title,gc);
        gc.gridy = 1;
        add(scrollPane, gc);
        setVisible(true);
    }

    public void updateData(Data data){
        this.data = data;
        tableData = new Object[data.getData().length][data.getRow()];
        table.setModel(model);
        title.setText(data.getBriefTitle());
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        if(data.getIsNumericDataType()){
            columnNames = new Object[]{"CL","TRUE CL","MIDPOINTS","FREQ","%","CF","C%"};
            for(int i = 0; i < data.getData().length;i++) {
                tableData[i][0] = data.getAddtlData()[i][0];
                tableData[i][1] = data.getAddtlData()[i][1];
                tableData[i][2] = data.getAddtlData()[i][2];
                tableData[i][3] = data.getData()[i];
                tableData[i][4] = data.getAddtlData()[i][3];
                tableData[i][5] = data.getAddtlData()[i][4];
                tableData[i][6] = data.getAddtlData()[i][5];
            }
        }else{
            columnNames = new Object[]{"VALUE LABELS(sorted)","PERCENTAGE(based on 'n'*)"};
            for(int i = 0; i < data.getData().length;i++) {
                tableData[i][0]  = data.getData()[i];
                tableData[i][1] = data.getAddtlData()[i][0];
            }
        }
        model.setColumnIdentifiers(columnNames);
        for(int i = 0;i <data.getData().length;i++) {
            model.addRow(tableData[i]);
        }
    }

}*/
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

        model.setColumnIdentifiers(columnNames);

        if(!data.getIsNumericDataType()) {
            for (int i = 0; i < data.getCategoriesLength(); i++) {
                model.addRow(tableData[i]);
            }
        } else {
            for (int i = 0; i < data.getClassLength(); i++) {
                model.addRow(tableData[i]);
            }
        }
    }
}