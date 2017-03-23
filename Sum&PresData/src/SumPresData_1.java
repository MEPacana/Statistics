
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Michael Pacana and Noah Silvio on 3/19/2017.
 */
public class SumPresData_1 extends JFrame {
    private JPanel basePanel = new JPanel();// switching panels
    private JPanel mainPanel = new JPanel();// mainPanel for Switch

    private JLabel title; // mainPanel title
    private JButton ctgButt, nmrlButt, quitButt, getData;// mainPanel buttons
    private CardLayout cl = new CardLayout();//Layout to change screens

    private DataGathering_2 dataGathering = new DataGathering_2();
    Data data;
    private TableData_3 tableData = new TableData_3();

    private SumPresData_1(){
        Container cp = getContentPane();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mainPanel.setLayout(new GridBagLayout());// Grid layout for more control
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel("Summarizing and Presenting Data");// setting up main menu
        title.setFont(new Font("Century Gothic",Font.BOLD,30));
        ctgButt = new JButton("Categorical");
        ctgButt.addActionListener(new myActionListener());
        nmrlButt = new JButton("Numerical");
        nmrlButt.addActionListener(new myActionListener());
        quitButt =new JButton("Quit");
        quitButt.addActionListener(new myActionListener());

        gc.weighty = 1;
        gc.gridy = 0;
        gc.gridx = 0;
        mainPanel.add(title,gc);
        gc.weighty = 0.3;
        gc.gridy = 1;
        mainPanel.add(ctgButt,gc);
        gc.gridy = 2;
        mainPanel.add(nmrlButt,gc);
        gc.gridy = 3;
        mainPanel.add(quitButt,gc);
        gc.weighty = 0.5;
        gc.gridy = 4;
        mainPanel.add(new JLabel(""),gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        getData = new JButton("Show Table");
        getData.addActionListener(new myActionListener());
        dataGathering.add(getData,gc);

        basePanel.setLayout(cl);//to switch between Panels
        basePanel.add(mainPanel,"mainPanel");
        basePanel.add(dataGathering,"dataGathering");
        basePanel.add(tableData,"tableData");

        cl.show(basePanel,"mainPanel");

        setTitle("Summarizing and Presenting Data");
        add(basePanel);
        setVisible(true);
        setSize(640,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == quitButt){
                dispose();
            }else {
                if (e.getSource() == ctgButt) {
                    dataGathering.setNumericDataType(false); // data is not numerical
                    cl.show(basePanel,"dataGathering");

                } else if (e.getSource() == nmrlButt) {
                    dataGathering.setNumericDataType(true); // data is numerical
                    cl.show(basePanel,"dataGathering");
                }
                else if(e.getSource() == getData){
                    if(dataGathering.checkData()){// checks if input follows chosen category
                        System.out.println("From here");
                        data = dataGathering.getData();
                        System.out.println("To here");
                        tableData.updateData(data);
                        cl.show(basePanel,"tableData");
                    }
                }
            }
        }

    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() { new SumPresData_1(); }
        });
    }
}
