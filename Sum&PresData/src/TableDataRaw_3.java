import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * Created by Michael Pacana and Noah Silvio on 3/24/2017.
 */

public class TableDataRaw_3 extends JPanel{
    JTable table = new JTable(); // setting up panel contents
    DefaultTableModel model = new DefaultTableModel();
    Object[][] tableData;
    Data data;
    JLabel title;
    int tableHeight;
    public TableDataRaw_3(){
        this.setLayout(new GridBagLayout());// GridBagLayout for more control
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
    public void erase(){
        table = new JTable();
        model = new DefaultTableModel();
    }
    public void updateData(Data data){
        this.data = data;
        double temp =(double)(data.getData().length)/4;
        System.out.println("temp is "+temp);
        tableHeight = (int)(roundUp(temp));
        System.out.println(data.getData().length+"table height"+tableHeight);
        tableData = new Object[tableHeight][4];
        table.setModel(model);
        System.out.println("inside "+data.getBriefTitle());
        title.setText("Raw Data: "+data.getBriefTitle());
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        for(int i = 0,inc= 0,j=0 ; i < data.getData().length;i++, j++) {
            if(j == 4) {
                j = 0;
                ++inc;
            }
            System.out.println(inc+" "+j+" "+i+" ");
            tableData[inc][j]  = data.getData()[i];
        }
        model.setColumnIdentifiers(new Object[]{"","","",""});
        for(int i = 0;i <tableHeight;i++) {
            model.addRow(tableData[i]);
        }
    }
    public double roundUp(double number){
        System.out.println("the number i "+ number);
        if(number%1 != 0 ){
            number++;
        }
        return number;
    }
}
