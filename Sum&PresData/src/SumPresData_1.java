
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
    private JPanel tableCollapsePanel = new JPanel();
    private JPanel tableHomePanel = new JPanel();
    private JLabel title; // mainPanel title
    private JButton ctgButt, nmrlButt, quitButt,
            getTableInfo,getTableInfo2, getRawTableInfo,
            collapseOpt, showGraphOpt, homeButt;// mainPanel buttons
    private CardLayout cl = new CardLayout();//Layout to change screens
    private ChartDisplay_05 chartDisplay = new ChartDisplay_05();

    private DataGathering_2 dataGathering = new DataGathering_2();
    Data data;
    private TableData_4 tableData = new TableData_4();
    private TableDataRaw_3 tableDataRaw = new TableDataRaw_3();

    private SumPresData_1(){
        Container cp = getContentPane();

        //Setting up main-panel
        mainPanel.setLayout(new GridBagLayout());// Grid layout for more control
        GridBagConstraints gc = new GridBagConstraints();

        title = new JLabel("Summarizing and Presenting Data");// setting up Main Menu
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

        collapseOpt = new JButton("Collapse");//setting up options for TableData_4
        collapseOpt.addActionListener(new myActionListener());
        showGraphOpt = new JButton("Show Graph");
        showGraphOpt.addActionListener(new myActionListener());
        gc.gridx = 1;
        tableCollapsePanel.add(showGraphOpt, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        tableData.add(tableCollapsePanel,gc);

        homeButt = new JButton("Home");
        homeButt.addActionListener(new myActionListener());
        tableHomePanel = new JPanel();
        gc.gridx = gc.gridy = 0;
        getTableInfo2 = new JButton("Show Table");
        getTableInfo2.addActionListener(new myActionListener());
        tableHomePanel.add(getTableInfo2, gc);
        gc.gridx = 1;
        tableHomePanel.add(homeButt,gc);
        gc.gridx = 0;
        gc.gridy = 1;
        chartDisplay.add(tableHomePanel,gc);

        getRawTableInfo = new JButton("Show Raw Data");//setting up options for TableData_3
        getRawTableInfo.addActionListener(new myActionListener());
        gc.gridx = 0;
        gc.gridy = 4;
        dataGathering.add(getRawTableInfo,gc);

        gc.gridy = 2;//setting up  TableData_3
        getTableInfo = new JButton("Show Table");
        getTableInfo.addActionListener(new myActionListener());
        tableDataRaw.add(getTableInfo,gc);

        //setting up  cardLayout to switch between panels
        basePanel.setLayout(cl);
        basePanel.add(mainPanel,"mainPanel");
        basePanel.add(dataGathering,"dataGathering");
        basePanel.add(tableDataRaw,"tableDataRaw");
        basePanel.add(tableData,"tableData");
        basePanel.add(chartDisplay, "chartDisplay");

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
                else if(e.getSource() == getTableInfo || e.getSource() == getTableInfo2){
                    if(dataGathering.checkData()){// checks if input follows chosen category
                        if(e.getSource() == getTableInfo) {
                            data = dataGathering.getData();
                            tableData.updateData(data);
                            GridBagConstraints gc = new GridBagConstraints();
                            if(data.getIsNumericDataType()) {
                                gc.gridy = gc.gridx = 0;
                                tableCollapsePanel.add(collapseOpt, gc);
                            }
                        }
                            cl.show(basePanel,"tableData");
                    }
                }
                else if(e.getSource() == collapseOpt){
                  /*  tableData.collapse();
                    cl.show(basePanel,)*/
                  //TODO Noah Collapse
                }
                else if(e.getSource() == showGraphOpt ){
                    Object[] options = {"Yes", //show options whether to show Graph or not
                            "No"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                            "Would you like the Graph to be shown?",
                            "Graph",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,null);
                    if(n == 0){
                        chartDisplay.getData(data);
                        cl.show(basePanel,"chartDisplay");
                    }else{
                        cl.show(basePanel,"mainPanel");
                    }
                }
                else if(e.getSource() == homeButt){
                    dataGathering.erase();
                    tableDataRaw.erase();
                    tableData.erase();
                    cl.show(basePanel,"mainPanel");
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
