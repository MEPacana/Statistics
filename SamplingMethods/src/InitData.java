/**
 * Created by Michael Pacana & Noah Silvio on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
public class InitData extends JPanel{
    private JTextField popSizeTextField, sampleSizeTextField;
    private JComboBox dataTypeCombo;
    int type;// 1 - Simple Random 2 - Systematic Sampling 3 - Stratified
    public InitData(int type){
        this.type = type;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //setting title

        JLabel title = new JLabel();
        if(type == 1){
            title.setText("Simple Random Sampling");
        }else if(type == 2){
            title.setText("Systematic Sampling");
        }else{
            title.setText("Stratified Sampling");
        }
        //setting font
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        JLabel popSizeLabel = new JLabel("Please input population size");
        popSizeTextField = new JTextField("",20);
        JLabel sampleSizeLabel = new JLabel();

        if(type !=3 ) {
            sampleSizeLabel.setText("Please input sample size");
        }else {
            sampleSizeLabel.setText("Please input sample size percentage from each strata");
        }
        sampleSizeTextField = new JTextField("",20);

        String[] dataChoices = {"Integers", "Characters"};
        dataTypeCombo = new JComboBox(dataChoices);
        dataTypeCombo.setSelectedIndex(1);

        //setting layout
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
        //error input trapping
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
        else if(Integer.parseInt(popSize) == 0 || Integer.parseInt(popSize) == 1){
            JOptionPane.showMessageDialog(this,
                    "Population must be more than 1",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(sampleSize.length() == 0 ){
            return true;
        }
        else if(type ==3 && Integer.parseInt(sampleSize) >= 100 || Integer.parseInt(sampleSize) <= 0){
            JOptionPane.showMessageDialog(this,
                    "That is not a valid percentage",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if((Integer.parseInt(popSize) <= Integer.parseInt(sampleSize)) && type!=3){
            JOptionPane.showMessageDialog(this,
                    "Sample size must be lesser than Population size",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if((type == 2 && Integer.parseInt(sampleSize) <= 1) ||Integer.parseInt(popSize) == 0 ){
            JOptionPane.showMessageDialog(this,
                    "Input is too low",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        System.out.println(Integer.parseInt(popSize) + " " +Integer.parseInt(popSize));
        return noError;
    }
    public Data getData(){
        //TODO waht if empty
        System.out.println(popSizeTextField.getText() +
                " " + sampleSizeTextField.getText() + " " + dataTypeCombo.getSelectedIndex());
        int popsize = Integer.parseInt(popSizeTextField.getText());
        int  dataType = dataTypeCombo.getSelectedIndex();
        int sampleSize;
        if(sampleSizeTextField.getText().length() == 0){
            double dPopsize = popsize, percentage = .20,dSampleSize;
            dSampleSize = dPopsize * percentage + (((dPopsize * percentage)% 1 == 0) ? 0 : 1);
            sampleSize = (int) dSampleSize;
        }else{
            sampleSize = Integer.parseInt(sampleSizeTextField.getText());
        }
        System.out.println("Sample size is "+ sampleSize);
        Data initParam = new Data(type, popsize,sampleSize ,dataType);
        return initParam;
    }
    public void clear(){
        sampleSizeTextField.setText("");
        popSizeTextField.setText("");
    }
    private static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}