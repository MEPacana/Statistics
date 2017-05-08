/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UResults_3d extends JPanel{
    private JTextArea ans, solution, interpretation;
    JLabel dataLbl;
    JScrollPane scroll;
    Data data;

    JPanel temp = new JPanel();
    public UResults_3d(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        dataLbl = new JLabel("");
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,20));

        solution = new JTextArea(6,25);
        ans = new JTextArea(4,25);
        scroll = new JScrollPane(solution);
        scroll.setSize(10,25);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weightx = gc.weighty = 1;

        temp.setLayout(new GridBagLayout());

        gc.gridx = gc.gridy = 0;
        this.add(dataLbl,gc);
        //gc.gridy++;
        gc.gridx = gc.gridy = 0;
        temp.add(ans,gc);
        //gc.gridx++;
        gc.gridx = 1;
        temp.add(scroll,gc);
        gc.gridy = 1;
        gc.gridx= 0;
        this.add(temp,gc);

        this.add(temp,gc);
        gc.gridx = 0;
        gc.gridy = 5;
        interpretation = new JTextArea(4,40);
        this.add(interpretation,gc);
        interpretation.setVisible(false);

        this.setVisible(true);
    }

    public void erase(){
        dataLbl.setText("");
        ans.setText("");
        solution.setText("");
    }

    public void addTextArea(){
        System.out.println("nisud diri");
        interpretation.setVisible(true);
    }
    public void removeTextArea(){
        interpretation.setVisible(false);
    }

    //gets data stored in info above
    public void init(Data data){
        erase();
        this.data = data;
        dataLbl.setText(data.getShrtDesc());
        ans.setText(data.getAns());
        for(int i = 0; i < data.getSolution().length;i++){
            solution.append(data.getSolution()[i]+ "\n");
        }
    }
}
