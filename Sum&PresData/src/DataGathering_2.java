import javax.swing.*;
import java.awt.*;
/**
 * Created by  Michael Pacana and Noah Silvio on 3/20/2017.
 */

public class DataGathering_2 extends JPanel{
    private JTextField briefTitleTxtField;//setting up elements
    private JTextArea dataTxtArea;
    private JScrollPane dataScroll;
    private JLabel briefTitleLabel, dataLabel;
    private boolean isNumericDataType;

    public DataGathering_2(){
        this.setLayout(new GridBagLayout());//GridBagLayout for more control
        GridBagConstraints gc = new GridBagConstraints();

        briefTitleLabel = new JLabel("Please enter a brief title for your data");// setting up contents
        dataLabel = new JLabel("Please enter the data");
        briefTitleTxtField = new JTextField(50);
        dataTxtArea = new JTextArea(5,50 );
        dataScroll = new JScrollPane(dataTxtArea);
        dataScroll.setSize(5,50);
        dataScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weighty = 1;//adding contents to panel
        gc.gridy = 0;
        this.add(briefTitleLabel,gc);
        gc.weighty = 1;
        gc.gridy = 1;
        this.add(briefTitleTxtField,gc);
        gc.weighty = 1;
        gc.gridy = 2;
        this.add(dataLabel,gc);
        gc.weighty = 0.1;
        gc.gridy = 3;
        this.add(dataScroll,gc);
        gc.weighty = 1;
        this.add(new JTextArea(""),gc);

        this.setVisible(true);
    }

    public void setNumericDataType(boolean isNumericDataType){
        this.isNumericDataType = isNumericDataType;
    }

    public boolean isNumericDataType(){
        return isNumericDataType;
    }
    public Data getData(){

        String briefTitleStr = briefTitleTxtField.getText(); // storing input to temp
        String dataStrArr[] = dataTxtArea.getText().split("\\n");
        Data data = new Data(dataStrArr, briefTitleStr,isNumericDataType);
        if(isNumericDataType()){
            data.processNumericalData();
        }else{
            data.processCategoricalData();
        }
        return data;
    }
    public void erase(){
        dataTxtArea.setText("");
        briefTitleTxtField.setText("");
    }

    public boolean checkData(){
        String briefTitleStr = briefTitleTxtField.getText(); // storing input to temp
        String dataStrArr[] = dataTxtArea.getText().split("\\n");

        if(briefTitleStr.length() == 0 || dataTxtArea.getText().equals("")){ //if title or data is empty
            JOptionPane.showMessageDialog(this,
                    "Input is empty",
                    "Input error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for(int i = 0; i < dataStrArr.length ; i++){
            if(isNumericDataType()){
                if(!isNumeric(dataStrArr[i])){ // checks if it is all numbers
                    JOptionPane.showMessageDialog(this,
                            "You have selected numerical data type",
                            "Wrong Data Type",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }else{
                if(isNotAllLetters(dataStrArr[i])){ // checks if it is all letters
                    JOptionPane.showMessageDialog(this,
                            "You have selected categorical data type",
                            "Wrong Data Type",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isNotAllLetters(String str) {
        if(str.length() == 0){
            return true;
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                if (!(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' || str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                    return true;
            }
        }
        return false;
    }
}