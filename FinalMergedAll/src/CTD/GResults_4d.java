package CTD; /**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 *//*

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class CTD.GResults_4d extends JPanel{
    private JTextArea ans, solution, interpretation;
    JLabel dataLbl;
    JScrollPane scroll;
    CTD.Data1 data1;

    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();

    public CTD.GResults_4d (){
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

    public void init(CTD.Data1 data1){
        erase();
        this.data1 = data1;
        dataLbl.setText(data1.getShrtDesc());
        ans.setText(data1.getAns());
        for(int i = 0; i < data1.getSolution().length;i++){
            solution.append(data1.getSolution()[i]);
        }
    }
}
*/
/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;

public class GResults_4d extends JPanel{
    private JTextArea ans, solution, interpretation;
    JLabel dataLbl;
    JScrollPane scroll;
    Data1 data1;

    JPanel temp = new JPanel();
    public GResults_4d(){
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

    //gets data1 stored in info above
    public void init(Data1 data1){
        erase();
        this.data1 = data1;
        dataLbl.setText(data1.getShrtDesc());
        ans.setText(data1.getAns());
        for(int i = 0; i < data1.getSolution().length; i++){
            solution.append(data1.getSolution()[i]+ "\n");
        }
    }
}
