/**
 * Created by Michael Pacana & Noah Silvio on 2/21/2017
 */
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BasicSamplingMethodsApp extends JFrame{
    private JLabel finalTitle = new JLabel("Mini-Statistical Package (Mini-SP)");
    private JLabel finalbriefDescription = new JLabel("Description");
    private JLabel finalInstructions = new JLabel("Press Any Key to Continue");
    private JLabel finalName1 = new JLabel("Michael Ervin B. Pacana");
    private JLabel finalName2 = new JLabel("Noah Dominic Silvio");

    private JPanel mainPanelSM = new JPanel();
    private JPanel finalFirstPanelSM = new JPanel();
    private JPanel switchPanel = new JPanel();
    private JButton sysSampButton, simpRandSampButton, stratSampButton, quit,
            simRandGetInitParam, simRandGetData,home1,
            sysGetInitParam, sysGetData,home2,
            stratGetInitParam, stratGetData,home3;
    private InitData simRandPanel,sysPanel,stratPanel;
    private DataGathering simRandDataPanel,sysDataPanel,stratDataPanel;
    private DataDisplay simRandDataDispPanel, sysDataDispPanel, stratDataDispPanel;
    private CardLayout cl = new CardLayout();
    private Data2 data2;
    public BasicSamplingMethodsApp(){
        //Instead of initializing frame, we extend frame and use this. We use container c to adjust Pane
        //using Grid Bag type layout for more control
        mainPanelSM.setLayout( new GridBagLayout());
        finalFirstPanelSM.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //adding components
        JLabel title = new JLabel("Random Sampling Techniques");
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

/////////////////////////////////////// S I M P L E      R A N D O M ////////////////////////////////////////////////////////////////////////////
        //initializing the simple random panel with its components
        simpRandSampButton = new JButton("Simple Random Samping");
        simpRandSampButton.addActionListener(new myActionListener());

        simRandPanel = new InitData(1);
        simRandGetInitParam = new JButton("Continue to Data2");
        simRandGetInitParam.addActionListener(new myActionListener());
        gc.weighty = 0.3;
        gc.gridy = 5;
        simRandPanel.add(simRandGetInitParam,gc);

        simRandDataPanel = new DataGathering(1);
        simRandGetData = new JButton(" Continue to Display");
        simRandGetData.addActionListener(new myActionListener());
        gc.weighty = .3;
        gc.gridy = 10;
        simRandDataPanel.add(simRandGetData,gc);

        simRandDataDispPanel = new DataDisplay(1);
        home1 = new JButton("Sampling Techniques: Another Run");
        home1.addActionListener(new myActionListener());
        simRandDataDispPanel.add(home1,gc);
////////////////////////////////////////////////// S Y S T E M A T I C///////////////////////////////////////////////////////////////////////////////////
        //initializing the systematic panel with its components
        sysSampButton = new JButton("Systematic Sampling");
        sysSampButton.addActionListener(new myActionListener());

        sysPanel = new InitData(2);
        sysGetInitParam = new JButton("Continue to Data2");
        sysGetInitParam.addActionListener(new myActionListener());
        gc.weighty = 0.3;
        gc.gridy = 5;
        sysPanel.add(sysGetInitParam,gc);

        sysDataPanel = new DataGathering(2);
        sysGetData = new JButton(" Continue to Display");
        sysGetData.addActionListener(new myActionListener());
        gc.weighty = .3;
        gc.gridy = 10;
        sysDataPanel.add(sysGetData,gc);

        sysDataDispPanel = new DataDisplay(2);
        home2 = new JButton("Home");
        home2.addActionListener(new myActionListener());
        sysDataDispPanel.add(home2,gc);
/////////////////////////////////////////////////// S T R A T I F I E D /////////////////////////////////////////////////////////////////////////////////////////////
        //initializing the stratified panel with its components
        stratSampButton = new JButton("Stratified Sampling");
        stratSampButton.addActionListener(new myActionListener());

        stratPanel = new InitData(3);
        stratGetInitParam = new JButton("Continue to Data2");
        stratGetInitParam.addActionListener(new myActionListener());
        gc.weighty = 0.3;
        gc.gridy = 5;
        stratPanel.add(stratGetInitParam,gc);

        stratDataPanel = new DataGathering(3);
        stratGetData = new JButton(" Continue to Display");
        stratGetData.addActionListener(new myActionListener());
        gc.weighty = .3;
        gc.gridy = 10;
        stratDataPanel.add(stratGetData,gc);

        stratDataDispPanel = new DataDisplay(3);
        home3 = new JButton("Home");
        home3.addActionListener(new myActionListener());
        stratDataDispPanel.add(home3,gc);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        quit = new JButton("Quit");
        quit.addActionListener(new myActionListener());

        //weight to adjust spacing and grid for placement
        gc.weighty = 0.5;
        gc.weightx= 1;
        //placement because of gridlayout
        gc.gridx = gc.gridy = 0;
        mainPanelSM.add(title,gc);

        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 1;
        mainPanelSM.add(simpRandSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        mainPanelSM.add(sysSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        mainPanelSM.add(stratSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 5;
        mainPanelSM.add(quit,gc);

        switchPanel.setLayout(cl);
        switchPanel.add(mainPanelSM,"mainpanel");
        switchPanel.add(simRandPanel,"simRandPanel");
        switchPanel.add(simRandDataPanel,"simRandDataPanel");
        switchPanel.add(simRandDataDispPanel,"simRandDataDispPanel");

        switchPanel.add(sysPanel,"sysPanel");
        switchPanel.add(sysDataPanel,"sysDataPanel");
        switchPanel.add(sysDataDispPanel,"sysDataDispPanel");

        switchPanel.add(stratPanel,"stratPanel");
        switchPanel.add(stratDataPanel,"stratDataPanel");
        switchPanel.add(stratDataDispPanel,"stratDataDispPanel");

        cl.show(switchPanel,"1");
        add(switchPanel);
        setTitle("CMSC 105 Lab 1");
        setVisible(true);
        setSize(640,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //handling events
    public class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == quit){
                //quit program
                dispose();
            }
            else {
                if (e.getSource() == simpRandSampButton) {
                   //create new class that extend JPanel
                    cl.show(switchPanel,"simRandPanel");
                }else if (e.getSource() == simRandGetInitParam && simRandPanel.check()) {
                        data2 = simRandPanel.getData();
                        cl.show(switchPanel, "simRandDataPanel");
                }else if (e.getSource() == simRandGetData && simRandDataPanel.check(data2)) {
                    data2 = simRandDataPanel.getData(data2);
                    data2.process();
                    simRandDataDispPanel.display(data2);
                    cl.show(switchPanel,"simRandDataDispPanel");
                } else if (e.getSource() == home1) {
                    data2.clear();
                    simRandPanel.clear();
                    simRandPanel.clear();
                    simRandDataPanel.clear();
                    simRandDataDispPanel.clear();
                    cl.show(switchPanel,"mainpanel");
                }
                ///////////////////////////////////////////////////////////////////
                if (e.getSource() == sysSampButton) {
                    //create new class that extend JPanel
                    cl.show(switchPanel,"sysPanel");
                }else if (e.getSource() == sysGetInitParam && sysPanel.check()) {
                    data2 = sysPanel.getData();
                    cl.show(switchPanel, "sysDataPanel");
                }else if (e.getSource() == sysGetData && sysDataPanel.check(data2)) {
                    data2 = sysDataPanel.getData(data2);
                    data2.process();
                    sysDataDispPanel.display(data2);
                    cl.show(switchPanel,"sysDataDispPanel");
                }else if (e.getSource() == home2) {
                    cl.show(switchPanel,"mainpanel");
                    data2.clear();
                    sysPanel.clear();
                    sysPanel.clear();
                    sysDataPanel.clear();
                    sysDataDispPanel.clear();
                }////////////////////////////////////////////////////////
                if (e.getSource() == stratSampButton) {
                    //create new class that extend JPanel
                    cl.show(switchPanel,"stratPanel");
                }else if (e.getSource() == stratGetInitParam && stratPanel.check()) {
                    data2 = stratPanel.getData();
                    data2 = stratPanel.getData();
                    cl.show(switchPanel, "stratDataPanel");
                }else if (e.getSource() == stratGetData && stratDataPanel.check(data2)) {
                    data2 = stratDataPanel.getData(data2);
                    data2.process();
                    stratDataDispPanel.display(data2);
                    cl.show(switchPanel,"stratDataDispPanel");
                }else if (e.getSource() == home3) {
                    cl.show(switchPanel,"mainpanel");
                    data2.clear();
                    stratPanel.clear();
                    stratPanel.clear();
                    stratDataPanel.clear();
                    stratDataDispPanel.clear();
                }
            }
        }
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BasicSamplingMethodsApp();
            }
        });
    }
}
