import javax.swing.*;
import java.awt.*;

public class DataDisplay extends JPanel {
    JTextArea dataArea;
    int type;
    public DataDisplay(int type){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel();
        if(type == 1){
            title.setText("Simple Random Sampling Technique Samples");
        }else if(type ==2){
            title.setText("Systematic Sampling Technique Samples");
        }else{
            title.setText("Stratified Sampling Technique Samples");
        }
        title.setFont(new Font("Century Gothic",Font.BOLD,30));
        JLabel popSizeLabel = new JLabel("Please input population size");

        dataArea = new JTextArea(10,50);
        dataArea.setEditable(false);
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
    public void display(Data data){
        for(int i=0;i<data.getSampleSize();i++)
            dataArea.append("Index "+i+": "+data.getData(i)+"\n");
    }
}

