package CTD; /**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;

public class UChoiceData_3c extends JPanel{
    private JLabel title;
    private JPanel titlePanel;
    public UChoiceData_3c(){
        //setting up main Panel
        titlePanel = new JPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel("Descriptive Statistics");
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        gc.gridx = 0;
        gc.gridy = 0;
        titlePanel.add(title,gc);
        gc.weighty = gc.weightx = 1;
        gc.gridy = 0;
        this.add(titlePanel,gc);

        setVisible(true);
    }

    public void erase(){

    }

    public void init(Data1 data1){
        title.setText(data1.getShrtDesc());
    }
}
