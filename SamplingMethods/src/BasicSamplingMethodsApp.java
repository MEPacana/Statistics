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
    JButton sysSampButton, simpRandSampButton, stratSampButton, quit,
            simRandGetInitParam, simRandGetData,Home;
    SimpleRandom simRandPanel = new SimpleRandom("Simple Random Sampling Technique");
    DataGathering simRandDataPanel, sysDataPanel,stratDataPanel;
    DataDisplay simRandDataDisp, sysDataDisp, stratDataDisp;
    CardLayout cl = new CardLayout();

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

        simRandGetInitParam = new JButton("Continue");
        simRandGetInitParam.addActionListener(new myActionListener());
        gc.weighty = 0.3;
        gc.gridy = 5;
        simRandPanel.add(simRandGetInitParam,gc);

        simRandDataPanel = new DataGathering(new Data());//made temp data
        simRandGetData = new JButton("Continue");
        gc.weighty = .3;
        gc.gridy = 10;
        simRandDataPanel.add(simRandGetData,gc);

        simRandDataDisp = new DataDisplay(new Data());
        //simRand
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        sysSampButton = new JButton("Systematic Sampling");
        sysSampButton.addActionListener(new myActionListener());
        stratSampButton = new JButton("Stratified Sampling");
        stratSampButton.addActionListener(new myActionListener());
        quit = new JButton("Quit");
        quit.addActionListener(new myActionListener());

        //weight to adjust spacing and grid for placement
        gc.weighty = 1;
        gc.weightx= 1;
        //placement because of gridlayout
        gc.gridx = gc.gridy = 0;
        mainPanel.add(title,gc);

        gc.weighty = 0.4;
        gc.gridx = 0;
        gc.gridy = 1;
        mainPanel.add(simpRandSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        //mainPanel.add(sysSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        mainPanel.add(quit,gc);

        basePanel.setLayout(cl);
        basePanel.add(mainPanel,"1");
        basePanel.add(simRandPanel,"2");
        basePanel.add(simRandDataPanel,"3");
        basePanel.add(simRandDataDisp,"4");

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
                //TODO Checking if it is number

                if (e.getSource() == simpRandSampButton) {
                   //create new class that extend JPanel
                    cl.show(basePanel,"2");
                }if (e.getSource() == simRandGetInitParam) {
                    //if it is done
                    Data simRandData = simRandPanel.getData();
                    simRandDataPanel = new DataGathering(simRandData);
                    cl.show(basePanel, "3");
                }if (e.getSource() == simRandGetData) {
                    //if it is done
                    Data simRandData = simRandPanel.getData();
                    simRandDataPanel = new DataGathering(simRandData);
                    cl.show(basePanel,"4");
                }

                else if (e.getSource() == sysSampButton) {
                    //create new class that extend JPanel
                    mainPanel.setVisible(false);
                    Stratified StratPanel = new Stratified();

                    add(StratPanel);
                } else if (e.getSource() == stratSampButton) {
                    //create new class that extend JPanel
                    mainPanel.setVisible(false);
                    Systematic sysPanel = new Systematic();

                    add(sysPanel);
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
