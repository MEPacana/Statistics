package CTD; /**
 * Created by Michael Pacana and Noah Sivlio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;

public class MainPanel_2 extends JPanel{
    private String classTitle = "Descriptive Statistics";
    JLabel title;
    JPanel titlePanel;
    public MainPanel_2(){
        //setting up main Panel
        clearData();
        titlePanel = new JPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel(classTitle);
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        gc.gridx = 0;
        gc.gridy = 0;
        titlePanel.add(title,gc);
        gc.weighty = gc.weightx = 1;
        gc.gridy = 0;
        this.add(titlePanel,gc);
        this.add(titlePanel,gc);
        setVisible(true);
    }

    public void clearData(){

    }

    public void setTitle(String text){
        title.setText(text);
    }
}
