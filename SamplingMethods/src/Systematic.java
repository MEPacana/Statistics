/**
 * Created by MikePacs on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Systematic extends JPanel{
    JButton getInitDataButton;
    String popSize, sampleSize;
    JTextField popSizeTextField, sampleSizeTextField;
    public Systematic(){
        this.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel("Simple Random Techniques");

        JLabel popSizeLabel = new JLabel("Please input population size");
        popSizeTextField = new JTextField("",20);

        JLabel sampleSizeLabel = new JLabel("Please input sample size");
        sampleSizeTextField = new JTextField("",20);

        getInitDataButton = new JButton("Continue");
        getInitDataButton.addActionListener(new myActionListener());

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

        gc.gridx = 0;
        gc.gridy = 5;
        this.add(getInitDataButton,gc);

        this.setVisible(true);
    }
    public class myActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == getInitDataButton){
                //TODO ERROR CHECK IF EMPTY IF LESS THAN 0 and more pop size and add default
                popSize = popSizeTextField.getText();
                sampleSize = sampleSizeTextField.getText();
                System.out.println("Population size is"+ popSize+" Sample size is "+sampleSize);
            }
        }
    }
}