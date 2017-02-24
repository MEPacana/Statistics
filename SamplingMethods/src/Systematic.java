/**
 * Created by MikePacs on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Systematic extends JPanel{
    public Systematic(){
        this.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel("Systematic Sampling Techniques");

        this.add(title);
        this.setVisible(true);
    }
}
