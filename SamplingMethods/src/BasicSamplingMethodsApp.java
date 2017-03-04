/**
 * Created by MikePacs on 2/21/2017.
 */
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BasicSamplingMethodsApp extends JFrame{

    private JPanel mainPanel = new JPanel();
    private JPanel basePanel = new JPanel();
    private JButton sysSampButton, simpRandSampButton, stratSampButton, quit,
            simRandGetInitParam, simRandGetData,home1,
            sysGetInitParam, sysGetData,home2,
            stratGetInitParam, stratGetData,home3;
    private InitData simRandPanel,sysPanel,stratPanel;
    private DataGathering simRandDataPanel,sysDataPanel,stratDataPanel;
    private DataDisplay simRandDataDispPanel, sysDataDispPanel, stratDataDispPanel;
    private CardLayout cl = new CardLayout();
    private Data data;
    public BasicSamplingMethodsApp(){
        //Instead of initializing frame, we extend frame and use this. We use container c to adjust Pane
        Container cp = getContentPane();

        //using Grid Bag type layout for more control
        mainPanel.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //adding components
        JLabel title = new JLabel("Random Sampling Techniques");
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

/////////////////////////////////////// S I M P L E      R A N D O M ////////////////////////////////////////////////////////////////////////////

        simpRandSampButton = new JButton("Simple Random Samping");
        simpRandSampButton.addActionListener(new myActionListener());

        simRandPanel = new InitData(1);
        simRandGetInitParam = new JButton("Continue to Data");
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
        home1 = new JButton("Home");
        home1.addActionListener(new myActionListener());
        simRandDataDispPanel.add(home1,gc);
////////////////////////////////////////////////// S Y S T E M A T I C///////////////////////////////////////////////////////////////////////////////////

        sysSampButton = new JButton("Systematic Sampling");
        sysSampButton.addActionListener(new myActionListener());

        sysPanel = new InitData(2);
        sysGetInitParam = new JButton("Continue to Data");
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
        
        stratSampButton = new JButton("Stratified Sampling");
        stratSampButton.addActionListener(new myActionListener());
        
        stratPanel = new InitData(3);
        stratGetInitParam = new JButton("Continue to Data");
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
        mainPanel.add(title,gc);

        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 1;
        mainPanel.add(simpRandSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        mainPanel.add(sysSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        mainPanel.add(stratSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 5;
        mainPanel.add(quit,gc);

        basePanel.setLayout(cl);
        basePanel.add(mainPanel,"mainpanel");
        basePanel.add(simRandPanel,"simRandPanel");
        basePanel.add(simRandDataPanel,"simRandDataPanel");
        basePanel.add(simRandDataDispPanel,"simRandDataDispPanel");

        basePanel.add(sysPanel,"sysPanel");
        basePanel.add(sysDataPanel,"sysDataPanel");
        basePanel.add(sysDataDispPanel,"sysDataDispPanel");
        

        cl.show(basePanel,"1");
        add(basePanel);
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
                    cl.show(basePanel,"simRandPanel");
                }else if (e.getSource() == simRandGetInitParam && simRandPanel.check()) {
                        data = simRandPanel.getData();
                        cl.show(basePanel, "simRandDataPanel");
                }else if (e.getSource() == simRandGetData && simRandDataPanel.check(data)) {
                    data = simRandDataPanel.getData(data);
                    data = data.process();
                    simRandDataDispPanel.display(data);
                    cl.show(basePanel,"simRandDataDispPanel");
                } else if (e.getSource() == home1) {
                  cl.show(basePanel,"mainpanel");
                }
                ///////////////////////////////////////////////////////////////////
                if (e.getSource() == sysSampButton) {
                    //create new class that extend JPanel
                    cl.show(basePanel,"sysPanel");
                }else if (e.getSource() == sysGetInitParam && sysPanel.check()) {
                    data = sysPanel.getData();
                    cl.show(basePanel, "sysDataPanel");
                }else if (e.getSource() == sysGetData && sysDataPanel.check(data)) {
                    data = sysDataPanel.getData(data);
                    data = data.process();
                    sysDataDispPanel.display(data);
                    cl.show(basePanel,"sysDataDispPanel");
                }else if (e.getSource() == home3) {
                    cl.show(basePanel,"mainpanel");
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
