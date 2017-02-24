/**
 * Created by MikePacs on 2/21/2017.
 */
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BasicSamplingMethodsApp extends JFrame{

    private JPanel mainPanel;
    JButton sysSampButton, simpRandSampButton, stratSampButton, quit;
    JFrame mainFrame = new JFrame("Statistics Lab 1 ");

    public BasicSamplingMethodsApp(){
        //Main Frame creation
        mainFrame.setVisible(true);
        mainFrame.setSize(640,360);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //JFrame.setDefaultLookAndFeelDecorated(true);

        mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        //using Grid Bag type layout for more control
        mainPanel.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel title = new JLabel("Random Sampling Techniques");
        title.setFont(new Font("Century Gothic",Font.BOLD,20));

        simpRandSampButton = new JButton("Simple Random Samping");
        simpRandSampButton.addActionListener(new myActionListener());
        sysSampButton = new JButton("Systematic Sampling");
        sysSampButton.addActionListener(new myActionListener());
        stratSampButton = new JButton("Stratified Sampling");
        stratSampButton.addActionListener(new myActionListener());
        //weight to adjust spacing and grid for placement
        quit = new JButton("Quit");
        quit.addActionListener(new myActionListener());

        gc.weighty = 1;
        gc.weightx= 1;
        gc.gridx = 0;
        gc.gridy = 0;
        mainPanel.add(title,gc);

        gc.weighty = 0.4;
        gc.gridx = 0;
        gc.gridy = 1;
        mainPanel.add(simpRandSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        mainPanel.add(stratSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        mainPanel.add(sysSampButton,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        mainPanel.add(quit,gc);
    }

    public class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == sysSampButton){
                mainPanel.setVisible(false);
                System.out.println("Systematic Sample Button");
                Stratified StratPanel = new Stratified();

                mainFrame.add(StratPanel);
                //create Stratif
            }
            else if(e.getSource() == stratSampButton){
                mainPanel.setVisible(false);
                System.out.println("Stratified Sample Button");
                Systematic sysPanel = new Systematic();

                mainFrame.add(sysPanel);
            }
            else if(e.getSource() == simpRandSampButton) {
                System.out.println("Simple Random Sample Button");
            }
            else if(e.getSource() == quit){
                mainFrame.dispose();
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
