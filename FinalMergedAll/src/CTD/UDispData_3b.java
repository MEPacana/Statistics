package CTD; /**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;

public class UDispData_3b extends JPanel{
    private JTextArea dataAr;
    JLabel desLbl, dataLbl;
    private int ctdSearched;
    private JScrollPane scroll;

    Data1 data1;

    public UDispData_3b(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        desLbl = new JLabel();
        dataLbl = new JLabel("CTD.Data1");
        desLbl.setFont(new Font("Century Gothic",Font.BOLD,30));
        dataLbl.setFont(new Font("Century Gothic",Font.BOLD,30));

        dataAr = new JTextArea(10,40);
        scroll = new JScrollPane(dataAr);
        scroll.setSize(10,40);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gc.weightx = gc.weighty = 1;

        gc.gridx = gc.gridy = 0;
        this.add(desLbl,gc);
        gc.gridy++;
        this.add(dataLbl,gc);
        gc.gridy++;
        this.add(scroll,gc);
        dataAr.setEditable(false);
        this.setVisible(true);
    }

    public void erase(){
        dataAr.setText("");
        dataLbl.setText("");
    }
    public void init(Data1 data1){
        erase();
        this.data1 = data1;
        dataLbl.setText(data1.getShrtDesc());
        dataAr.append("DATA:\n");
        for(int i = 0; i < data1.getData().length; i++){
            if(data1.getData() == null){
                System.out.println("nothing");
            }else {
                if(data1.isFloat()){
                    dataAr.append((i + 1) + ":     " +  data1.getData()[i] + "\n");
                }else {
                    dataAr.append((i + 1) + ":     " + data1.getData()[i] + "\n");
                }
            }
        }
    }

    // to know what to search 1- Mean 2- Median 3- Mode
    public void setCTDSearched(int i){ ctdSearched = i; }
}

