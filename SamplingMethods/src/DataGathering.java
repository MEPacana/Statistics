/**
 * Created by Michael Pacana & Noah Silvioon 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
public class DataGathering extends JPanel{
    private JTextArea dataArea;
    private int type;//1 - Simple Random 2 - Systematic Sampling 3- Stratified
    private JLabel title;
    private JScrollPane scroll;
    private JLabel popSizeLabel;
    public DataGathering(int type){
        this.type = type;
        this.setLayout(new GridBagLayout());


        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel();
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        if(type == 1){
            title.setText("Simple Random Sampling");
        }else if(type ==2){
            title.setText("Systematic Sampling");
        }else{
            title.setText("Stratified Sampling");
        }
        title.setFont(new Font("Century Gothic",Font.BOLD,30));
        popSizeLabel = new JLabel("Please input the data. Please seperate it by line.");

        dataArea = new JTextArea(10,40);
        scroll = new JScrollPane(dataArea);
        scroll.setSize(10,40);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(title,gc);

        gc.weighty = 0.3;
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(popSizeLabel,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(scroll,gc);

        this.setVisible(true);
    }
    public Boolean check(Data data){
        //TODO waht if empty
        Boolean noError= true;
        String[] dataStrArr = dataArea.getText().split("\\n");
        if(dataStrArr.length < data.getPopSize() ||dataStrArr.length > data.getPopSize()){
            JOptionPane.showMessageDialog(this,
                    "Population size needed is "+data.getPopSize(),
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (int i = 0; i < dataStrArr.length; i++) {
            if(isNotAllLetters(dataStrArr[i])){
                if(data.getDataType() == 1){
                    JOptionPane.showMessageDialog(this,
                            "Please input letters only please",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }

        for(int i = 0, dataType =data.getDataType() ; i < dataStrArr.length; i++ ){
            if(dataType == 1 && isNumeric(dataStrArr[i]) || dataType == 0 && !(isNumeric(dataStrArr[i]))){
                if(dataType == 0){
                    JOptionPane.showMessageDialog(this,
                            "You have chosen numbers as your data type",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                else{
                    JOptionPane.showMessageDialog(this,
                            "You have chosen characters as your data type",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

        }
        return noError;
    }
    public Data getData(Data data){
        //TODO waht if empty
        String[] dataStrArr = dataArea.getText().split("\\n");
        for( int i = 0; i < dataStrArr.length;i++)
        data.setData(dataStrArr);
        return data;
    }

    public void clear (){
        dataArea.setText("");
    }
    private static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static boolean isNotAllLetters(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' || str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))
                return true;
        }
        return false;
    }
}