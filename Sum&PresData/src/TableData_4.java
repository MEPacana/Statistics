import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * Created by Michael Pacana & Noah Silvio on 3/22/2017.
 */
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
}