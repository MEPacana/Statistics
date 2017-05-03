/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UGthrData_3a extends JPanel{
    private JTextField desFld;
    private JTextArea dataAr;
    JLabel desLbl, dataLbl;
    private int ctdSearched;
    private JScrollPane scroll;
    String[] dTypeChoice = {"Integer","Float"};
    Data data;
    public UGthrData_3a(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        desLbl = new JLabel("Please enter a short description");
        dataLbl = new JLabel("Please enter the data");
        desLbl.setFont(new Font("Century Gothic",Font.BOLD,20));
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,20));

        desFld = new JTextField(40);
        dataAr = new JTextArea(8,40);
        scroll = new JScrollPane(dataAr);
        scroll.setSize(10,40);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weightx = gc.weighty = 1;

        gc.gridx = gc.gridy = 0;
        this.add(desLbl,gc);
        gc.gridy++;
        this.add(desFld,gc);
        gc.gridy++;
        this.add(dataLbl,gc);
        gc.gridy++;
        this.add(scroll,gc);
        gc.gridy = 2;
        gc.gridx =1;
        this.setVisible(true);
    }
    public void erase(){
        desFld.setText("");
        dataAr.setText("");
    }

    //gets data stored in info above
    public Data getData(){
        Data data = new Data();
        //TODO check if empty
        data.setShrtDesc(desFld.getText());
        data.setData(dataAr.getText().split("\\n"));
        //TODO no checks yet
        return data;
    }

    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}
