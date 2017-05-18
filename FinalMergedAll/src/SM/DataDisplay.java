package SM; /**
 * Created by Michael Pacana & Noah Silvioon 2/23/2017.
 */
import javax.swing.*;
import java.awt.*;

public class DataDisplay extends JPanel {
    private JTextArea dataArea;
    private int type;
    public DataDisplay(int type){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel();
        if(type == 1){
            title.setText("RANDOM SAMPLE");
        }else if(type ==2){
            title.setText("RANDOM SAMPLE (Systematic Sampling)");
        }else{
            title.setText("RANDOM SAMPLE (Stratified Sampling)");
        }
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        dataArea = new JTextArea(10,50);
        dataArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(dataArea);
        scroll.setSize(10,50);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weighty = 1;
        gc.gridy = 0;
        add(title,gc);
        gc.weighty = 0.5;
        gc.gridy = 1;
        add(scroll,gc);

        this.setVisible(true);
    }
    public void clear(){
        dataArea.setText("");
    }
    public void display(Data2 data2){
        if(data2.getSamplingType() == 3){
            int temp = 1;
            String currentStrata="";
            dataArea.append(data2.displayAll() + "\n\n");
            for (int i = 0, strataNum = 1; i < data2.alfred + temp; i++) {
                System.out.println("Th i is "+i+" "+ data2.getSample(i));
                if( i == 0 ){
                    dataArea.append("Strata 1\n");
                    strataNum++;
                    currentStrata = data2.getSample(i);
                }
                else if(currentStrata.compareTo(data2.getSample(i))!=0 ){
                    dataArea.append("Strata "+strataNum+"\n");
                    currentStrata = data2.getSample(i);
                    strataNum++;
                }
                dataArea.append("Index " + (i + 1) + ": " + data2.getSample(i) + "\n");
            }
        }
        else {
            for (int i = 0; i < data2.getSampleSize(); i++)
                dataArea.append("Index " + (i + 1) + ": " + data2.getSample(i) + "\n");
        }
    }
}

