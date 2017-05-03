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

    public UResults_3d(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        dataLbl = new JLabel("");
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,20));

        solution = new JTextArea(6,40);
        ans = new JTextArea(4,40);
        scroll = new JScrollPane(solution);
        scroll.setSize(10,40);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weightx = gc.weighty = 1;

        gc.gridx = gc.gridy = 0;
        this.add(dataLbl,gc);
        gc.gridy++;
        this.add(ans,gc);
        gc.gridy++;
        this.add(scroll,gc);

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

    //gets data stored in info above
    public void init(Data data){
        erase();
        this.data = data;
        dataLbl.setText(data.getShrtDesc());
        ans.setText(data.getAns());
        for(int i = 0; i < data.getSolution().length;i++){
            solution.append(data.getSolution()[i]);
        }
    }
}
