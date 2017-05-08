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
    JComboBox dataType;
    Data data;
    public UGthrData_3a(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        desLbl = new JLabel("Please enter a short description");
        dataLbl = new JLabel("Please enter the data");
        desLbl.setFont(new Font("Century Gothic",Font.BOLD,20));
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,20));
        dataType = new JComboBox(dTypeChoice);
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
        gc.gridx++;
        this.add(dataType,gc);
        gc.gridx=0;
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
    public Data init(Data data){
        this.data = data;
        data.setShrtDesc(desFld.getText());
        data.setData(dataAr.getText().split("\\n"));

        if(dataType.getSelectedIndex() == 0) {
            data.setFloat(false);
        } else{
            data.setFloat(true);
        }

        return data;
    }
    public boolean checkData(){
        Data data = new Data();
        if(desFld.getText().length() == 0){
            System.out.println("Cannot be blank");
            return false;
        }
        data.setShrtDesc(desFld.getText());
        String[] tempData = dataAr.getText().split("\\n");
        try {
            for (int i = 0; i < tempData.length; i++) {
                if(tempData[i].length() == 0){
                    return false;
                }
                if(dataType.getSelectedIndex() == 1) {
                    Double.valueOf(tempData[i]);
                }else{
                    Integer.valueOf(tempData[i]);
                }
            }
            return true;
        }catch(NumberFormatException e){
            System.out.println("must be a double or int");
        }
        return false;
    }
    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}
