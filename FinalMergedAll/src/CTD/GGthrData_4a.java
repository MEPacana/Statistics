package CTD; /**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;

public class GGthrData_4a extends JPanel{
    private JTextField desFld,numIntFld;
    private JLabel desLbl, dataLbl;
    private int ctdSearched;
    private String[] dTypeChoice = {"Integer","Float"};
    private JComboBox dataType;
    Data1 data1;

    JPanel temp = new JPanel();
    String[]  sIntervals = {"Close-Ended","Open-Ended First Class Only", "Open-Ended Last Class Only","Open-Ended Both"};
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

        dataType = new JComboBox(dTypeChoice);
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
    public boolean checkData(){
        if(desFld.getText().length() == 0 || numIntFld.getText().length() == 0){
            System.out.println("CANNOT BE EMPTY");
            return false;
        }
        try{
            Integer.parseInt(numIntFld.getText());
        }catch(NumberFormatException e){
            System.out.println("MUST BE A NUMBER");
            return false;
        }
        return true;
    }
    //gets data1 stored in info above
    public Data1 getData1(){
        Data1 data1 = new Data1();
        data1.setShrtDesc(desFld.getText());
        if (dataType.getSelectedIndex() == 1) {
            data1.setFloat(false);
        } else {
            data1.setFloat(true);
        }

        data1.setOpentype(cIntervals.getSelectedIndex());
        data1.setClassIntervals(Integer.parseInt(numIntFld.getText()));
        return data1;
    }
    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}
