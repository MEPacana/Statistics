
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Created by Michael Pacana and Noah Silvio on 3/19/2017.
 */
public class SumPresData_1 extends JFrame {
    private JPanel basePanel = new JPanel();// switching panels
    private JPanel mainPanel = new JPanel();// mainPanel for Switch

    private JLabel title; // mainPanel title
    private JButton ctgButt, nmrlButt, quitButt,
            getTableInfo, getRawTableInfo,
            collapseOpt, showGraphOpt;// mainPanel buttons
    public CardLayout cl = new CardLayout();//Layout to change screens

    private DataGathering_2 dataGathering = new DataGathering_2();
    Data data;
    private TableData_4 tableData = new TableData_4();
    private TableDataRaw_3 tableDataRaw = new TableDataRaw_3();
    private JPanel tableDataPanel = new JPanel();
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

        collapseOpt = new JButton("Collapse");
        collapseOpt.addActionListener(new myActionListener());
        showGraphOpt = new JButton("Next");
        showGraphOpt.addActionListener(new myActionListener());
        gc.gridy = gc.gridx= 0;
        tableDataPanel.add(collapseOpt,gc);
        gc.gridx = 1;
        tableDataPanel.add(showGraphOpt,gc);
        gc.gridx = 0;
        gc.gridy = 4;
        tableData.add(tableDataPanel,gc);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        getRawTableInfo = new JButton("Show Raw Data");
        getRawTableInfo.addActionListener(new myActionListener());
        dataGathering.add(getRawTableInfo,gc);

        gc.gridy = 2;
        getTableInfo = new JButton("Show Table");
        getTableInfo.addActionListener(new myActionListener());
        tableDataRaw.add(getTableInfo,gc);

        basePanel.setLayout(cl);//to switch between Panels
        basePanel.add(mainPanel,"mainPanel");
        basePanel.add(dataGathering,"dataGathering");
        basePanel.add(tableDataRaw,"tableDataRaw");
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
                else if(e.getSource() == getRawTableInfo){
                    if(dataGathering.checkData()){// checks if input follows chosen category
                        data = dataGathering.getData();
                        System.out.println("title is"+ data.getBriefTitle());
                        tableDataRaw.updateData(data);
                        cl.show(basePanel,"tableDataRaw");
                    }
                }
                else if(e.getSource() == getTableInfo){
                    if(dataGathering.checkData()){// checks if input follows chosen category
                        data = dataGathering.getData();
                        tableData.updateData(data);
                        cl.show(basePanel,"tableData");
                    }
                }
                else if(e.getSource() == collapseOpt){
                    //TODO Noah Collapse this shit
                }
                else if(e.getSource() == showGraphOpt){
                    Object[] options = {"Yes",
                            "No"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                            "Would you like the Graph to be shown?",
                            "Graph",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,null);
                    if(n == 0){
                        //Todo histogram
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
