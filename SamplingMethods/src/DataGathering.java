/**
 * Created by MikePacs on 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class DataGathering extends JPanel{
    public DataGathering(Data data){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel(data.name);

        JLabel popSizeLabel = new JLabel("Please input the Data");
        JTextArea dataArea = new JTextArea(10,50);
        JScrollPane scroll = new JScrollPane(dataArea);
        scroll.setSize(10,50);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        gc.weighty = 1;
        gc.gridy = 0;
        add(popSizeLabel,gc);
        gc.weighty = 0.5;
        gc.gridy = 1;
        add(scroll,gc);

        this.setVisible(true);
    }
}
