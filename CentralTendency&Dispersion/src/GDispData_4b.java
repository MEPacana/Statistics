/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Scanner;

public class GDispData_4b extends JPanel{
    private JTextArea dataAr;
    JLabel desLbl, dataLbl;
    private int ctdSearched;

    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;
    private Data data;
    private Object[] columns = {"Upper Class Limit", "Lower Class Limit","Frequencies"};
    public GDispData_4b(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        desLbl = new JLabel("sdfasdsasfda");
        dataLbl = new JLabel("Please input the Data");
        desLbl.setFont(new Font("Century Gothic",Font.BOLD,30));
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,15));

        dataAr = new JTextArea(10,40);
        model.setRowCount(10);
        model.setColumnIdentifiers(columns);
        table.setPreferredScrollableViewportSize(new Dimension(515,125));
        table.setModel(model);
        scroll = new JScrollPane(table);

        gc.weightx = gc.weighty = 1;

        gc.gridx = gc.gridy = 0;
        this.add(desLbl,gc);
        gc.gridy++;
        this.add(dataLbl,gc);
        gc.gridy++;
        this.add(scroll,gc);

        desLbl.setVisible(false);
        this.setVisible(true);
    }

    public void erase(){
        dataAr.setText("");
        dataLbl.setText("");
    }

    public void init(Data data){
        erase();
        this.data = data;
        desLbl.setText(data.getShrtDesc());
        dataLbl.setText(data.getShrtDesc());
        model.setRowCount(data.getClassIntervals());
    }

    public void doneIsPressed(){
        table.setEnabled(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        desLbl.setVisible(true);
    }

    public void editIsPressed(){
        table.setEnabled(true);
        table.setFocusable(true);
        table.setRowSelectionAllowed(true);
        desLbl.setVisible(false);
    }

    public Data getData(){
        String[] tempUCL = new  String[table.getRowCount()];
        String[] tempLCL = new  String[table.getRowCount()];
        String[] freq = new  String[table.getRowCount()];
        for(int i = 0 ; i < table.getRowCount(); i++){
            tempUCL[i] = (String) table.getValueAt(i,0);
            tempLCL[i] = (String) table.getValueAt(i,1);
            freq[i] = (String) table.getValueAt(i,2);
        }
        for(int i = 0 ; i < table.getRowCount(); i++){
            System.out.println(tempUCL[i]+ " "+tempLCL[i]+ " "+ freq[i]);
        }
        data.setLowerClassLimits(tempLCL);
        data.setUpperClassLimits(tempUCL);
        data.setFrequency(freq);
        return data;
    }
    public void setTableSize(int column, int rows){
        model.setColumnCount(column);
        model.setRowCount(rows);
    }
    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}

