/**
 * Created by MikePacs on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class SimpleRandom extends JPanel{
    JButton getInitDataButton;
    Integer popSize, sampleSize;
    JTextField popSizeTextField, sampleSizeTextField;
    JComboBox dataTypeCombo;
    String label;
    public SimpleRandom(String label){
        this.label = label;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel(label);

        JLabel popSizeLabel = new JLabel("Please input population size");
        popSizeTextField = new JTextField("",20);

        JLabel sampleSizeLabel = new JLabel("Please input sample size");
        sampleSizeTextField = new JTextField("",20);

        String[] dataChoices = {"Integers", "Characters"};
        dataTypeCombo = new JComboBox(dataChoices);
        dataTypeCombo.setSelectedIndex(1);


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
    public Data getData(){
        System.out.println();
        //TODO waht if empty

        Data initParam = new Data("potato", Integer.parseInt(popSizeTextField.getText()), Integer.parseInt(sampleSizeTextField.getText()), dataTypeCombo.getSelectedIndex());
        return initParam;
    }
}