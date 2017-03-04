/**
 * Created by MikePacs on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class InitData extends JPanel{
    JButton getInitDataButton;
    Integer popSize, sampleSize;
    JTextField popSizeTextField, sampleSizeTextField;
    JComboBox dataTypeCombo;
    int type;// 1 - Simple Random 2 - Systematic Sampling 3 - Stratified
    public InitData(int type){
        this.type = type;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel();
        if(type == 1){
            title.setText("Simple Random Sampling");
        }else if(type == 2){
            title.setText("Systematic Sampling");
        }else{
            title.setText("Stratified Sampling");
        }
        title.setFont(new Font("Century Gothic",Font.BOLD,30));
        JLabel popSizeLabel = new JLabel("Please input population size");
        popSizeTextField = new JTextField("",20);

        JLabel sampleSizeLabel = new JLabel("Please input sample size");
        sampleSizeTextField = new JTextField("",20);

        String[] dataChoices = {"Integers", "Characters"};
        dataTypeCombo = new JComboBox(dataChoices);
        dataTypeCombo.setSelectedIndex(1);


        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(title,gc);

        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(popSizeLabel,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(popSizeTextField,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(sampleSizeLabel,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        this.add(sampleSizeTextField,gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(dataTypeCombo,gc);

        this.setVisible(true);
    }
    public Boolean check(){
        Boolean noError= true;
        String popSize = popSizeTextField.getText();
        String sampleSize = sampleSizeTextField.getText();
        if(popSize.length() == 0 ){
            JOptionPane.showMessageDialog(this,
                    "No Input",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!(isNumeric(popSize)&& isNumeric(sampleSize))){
            JOptionPane.showMessageDialog(this,
                    "Input must be valid number",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Integer.parseInt(popSize) <= Integer.parseInt(sampleSize)){
            JOptionPane.showMessageDialog(this,
                    "Sample size must be lesser than Population size",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        System.out.println(Integer.parseInt(popSize) + " " +Integer.parseInt(popSize));
        return noError;
    }
    public Data getData(){
        //TODO waht if empty
        System.out.println(Integer.parseInt(popSizeTextField.getText()) +
                " " + Integer.parseInt(sampleSizeTextField.getText()) + " " + dataTypeCombo.getSelectedIndex());
        int popsize = Integer.parseInt(popSizeTextField.getText());
        int  dataType = dataTypeCombo.getSelectedIndex();
        int sampleSize;
        if(sampleSizeTextField.getText().length() == 0){
            sampleSize = (int)(popsize * .20);
        }else{
            sampleSize = Integer.parseInt(sampleSizeTextField.getText());
        }
        Data initParam = new Data(type, popsize,sampleSize ,dataType);
        return initParam;
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}