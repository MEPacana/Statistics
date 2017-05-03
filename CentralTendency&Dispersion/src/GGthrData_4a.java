/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GGthrData_4a extends JPanel{
    private JTextField desFld,numIntFld;
    JLabel desLbl, dataLbl;
    private int ctdSearched;
    String[] dTypeChoice = {"Integer","Float"};
    private JComboBox dataType;
    Data data;

    JPanel temp = new JPanel();
    String[]  sIntervals = {"Close-Ended","Open-Ended"};
    private JComboBox cIntervals;

    public GGthrData_4a(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        desLbl = new JLabel("Please enter a short description");
        dataLbl = new JLabel("Number of Class Intervals:");
        desLbl.setFont(new Font("Century Gothic",Font.BOLD,20));
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,15));

        desFld = new JTextField(40);
        numIntFld = new JTextField(20);

        temp.setLayout(new GridBagLayout());
        gc.gridx = gc.gridy = 0;
        temp.add(dataLbl,gc);
        gc.gridx = 1;
        temp.add(numIntFld,gc);
        gc.weightx = gc.weighty = 1;

        gc.gridx = gc.gridy = 0;
        this.add(desLbl,gc);

        gc.gridy++;
        this.add(desFld,gc);

        gc.gridy++;
        this.add(temp,gc);

        cIntervals = new JComboBox(sIntervals);
        dataType = new JComboBox(dTypeChoice);

        gc.gridy++;
        this.add(dataType,gc);

        gc.gridy++;
        this.add(cIntervals,gc);
        this.setVisible(true);
    }
    public void erase(){
        desFld.setText("");
    }

    //gets data stored in info above
    public Data getData(){
        Data data = new Data();
        data.setShrtDesc(desFld.getText());
        if(dataType.getSelectedIndex() == 1){
            data.setFloat(false);
        }else{
            data.setFloat(true);
        }if(cIntervals.getSelectedIndex() == 1){
            data.setOpenEnded(false);
        }else{
            data.setOpenEnded(true);
        }
        data.setClassIntervals(Integer.parseInt(numIntFld.getText()));
        return data;
    }
    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}
