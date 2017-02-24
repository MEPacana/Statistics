import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by MikePacs on 2/23/2017.
 */
public class Stratified extends JPanel{
    public Stratified(){
       //JFrame.setDefaultLookAndFeelDecorated(true);
        //using Grid Bag type layout for more control
        this.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel("Stratified Sampling Techniques");

        this.add(title);
        this.setVisible(true);
    }
}
