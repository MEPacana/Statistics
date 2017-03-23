import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * Created by Michael Pacana & Noah Silvio on 3/22/2017.
 */
public class TableData_3 extends JPanel {
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    Data data;
    JLabel title;
    public TableData_3(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        title = new JLabel("123");
        table.setModel(model);
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
        Object[] columnNames;
        Object[][] tableData;
        title.setText(data.getBriefTitle());
        title.setFont(new Font("Century Gothic",Font.BOLD,30));
        if(data.getIsNumericDataType()){
            columnNames = new Object[]{"CL","TRUE CL","MIDPOINTS","FREQ","%","CF","C%"};
            for(int i = 0; i < data.getData().length;i++) {
                model.addRow(new Object[]{data.getAddtlData()[0][i],data.getAddtlData()[1][i],
                        data.getAddtlData()[2][i], data.getData(), data.getAddtlData()[3][i],
                        data.getAddtlData()[4][i],data.getAddtlData()[5][i]});
            }
        }else{
            columnNames = new Object[]{"VALUE LABELS(sorted)","PERCENTAGE(based on 'n'*)"};
            for(int i = 0; i < data.getData().length;i++) {
                Object[] temp = {data.getData()[i],data.getAddtlData()[0][i]};
                model.addRow(temp);
            }
        }
        model.setColumnIdentifiers(columnNames);
    }
}