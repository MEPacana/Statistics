/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CTD_1 extends JFrame{
    private JPanel switchPanel = new JPanel();
    private MainPanel_2 mainPanel = new MainPanel_2();

    //main menu panels
    private UGthrData_3a uDataPanel = new UGthrData_3a();
    private UDispData_3b uDispPanel = new UDispData_3b();
    private UChoiceData_3c uChoicePanel = new UChoiceData_3c();
    private UResults_3d uResultsPanel = new UResults_3d();
    private JPanel tempPanel = new JPanel();
    private JPanel ResultsRedoPanel = new JPanel();
    private JPanel gEditContinue = new JPanel();

    private GGthrData_4a gGthrPanel = new GGthrData_4a();
    private GDispData_4b gDispPanel = new GDispData_4b();
    private GChoiceData_4c gChoicePanel = new GChoiceData_4c();
    private GResults_4d gResultsPanel = new GResults_4d();

    private JButton ungrpdB, grpdB,
            udispB,
            uCont, uEdit,
            uMeanB, uMedianB, uModeB, quitB, allB,
            inpIntpn, execRun;

    private JButton gDisp,
        gDone, gEdit, gContinue;


    private CardLayout cl = new CardLayout();
    String[] cmboStr = {"same data","new set"};
    JComboBox balik = new JComboBox(cmboStr);
    Data data;

    public CTD_1(){
        //setting up Panel to switch screens
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = gc.weighty = 0.5;
        switchPanel.setLayout(cl);

        //initialize main menu buttons

        ungrpdB = new JButton("Ungrouped Data");
        ungrpdB.addActionListener(new myActionListener());
        grpdB = new JButton("Grouped Data");
        grpdB.addActionListener(new myActionListener());
        quitB = new JButton("Quit");
        quitB.addActionListener(new myActionListener());

        gc.gridy = 1;
        mainPanel.add(ungrpdB,gc);
        gc.gridy = 2;
        mainPanel.add(grpdB,gc);
        gc.gridy = 3;
        mainPanel.add(quitB,gc);

        uMeanB = new JButton("Mean");
        uMeanB.addActionListener(new myActionListener());
        uMedianB = new JButton("Median");
        uMedianB.addActionListener(new myActionListener());
        uModeB = new JButton("Mode");
        uModeB.addActionListener(new myActionListener());
        allB = new JButton("All Measures");
        allB.addActionListener(new myActionListener());


        //adding onto main menu
        tempPanel.setLayout(new GridBagLayout());
        uChoicePanel.setLayout(new GridBagLayout());
        gc.weightx = 1;
        gc.weighty = 5;
        gc.gridx =0;
        gc.gridy = 1;
        tempPanel.add(uMeanB,gc);
        gc.gridx =1;
        gc.gridy = 1;
        tempPanel.add(uMedianB,gc);
        gc.gridx = 2;
        gc.gridy = 1;
        tempPanel.add(uModeB,gc);
        gc.gridx = 1;
        gc.gridy = 2;
        tempPanel.add(new JLabel(" "),gc);
        gc.gridy = 3;
        tempPanel.add(allB,gc);
        gc.gridx = 0;
        gc.gridy = 1;
        uChoicePanel.add(tempPanel,gc);

        uCont = new JButton("Continue");
        uCont.addActionListener(new myActionListener());
        uEdit = new JButton("Edit");
        uEdit.addActionListener(new myActionListener());


        gc.gridx = 0;
        gc.gridy = 3;
        uDispPanel.add(uCont,gc);
        gc.gridy = 4;
        uDispPanel.add(uEdit,gc);

        gc.gridy =1;
        gc.gridx =0;
        //uDataPanel.add(uChoicePanel,gc);
        //initialize gather data button
        udispB = new JButton("Display");
        udispB.addActionListener(new myActionListener());
        gc.gridy = 4;
        gc.gridx = 0;
        uDataPanel.add(udispB,gc);

        ResultsRedoPanel.setLayout(new GridBagLayout());
        inpIntpn = new JButton("Input Interpretation");
        inpIntpn.addActionListener(new myActionListener());
        gc.gridx = 0;
        ResultsRedoPanel.add(inpIntpn,gc);
        execRun = new JButton("Exectute another run");
        execRun.addActionListener(new myActionListener());
        gc.gridx = 1;
        ResultsRedoPanel.add(execRun,gc);
        gc.gridx = 2;
        ResultsRedoPanel.add(balik,gc);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.weighty = 1;
        uResultsPanel.add(ResultsRedoPanel,gc);


        gDisp = new JButton("Display");
        gDisp.addActionListener(new myActionListener());
        gc.gridx = 0;
        gc.gridy = 5;
        gGthrPanel.add(gDisp,gc);


        //addding class panels to card layout
        switchPanel.add(mainPanel,"mainPanel_cl");
        switchPanel.add(uDataPanel,"uDataPanel_cl");
        switchPanel.add(uDispPanel,"uDispPanel_cl");
        switchPanel.add(uChoicePanel,"uChoicePanel_cl");
        switchPanel.add(uResultsPanel,"uResultsPanel_cl");

        switchPanel.add(gGthrPanel,"gGthrPanel_cl");
        switchPanel.add(gDispPanel,"gDispPanel_cl");
        
        gDone = new JButton("Done");
        gDone.addActionListener(new myActionListener());

        gEdit = new JButton("Edit");
        gEdit.addActionListener(new myActionListener());

        gContinue = new JButton("Continue");
        gContinue.addActionListener(new myActionListener());

        gc.gridx = 0;
        gc.gridy = 3;
        gDispPanel.add(gDone,gc);

        gc.gridy = gc.gridx = 0;
        gEditContinue.add(gEdit,gc);
        gc.gridx = 1;
        gEditContinue.add(gContinue,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gDispPanel.add(gEditContinue,gc);

        gEditContinue.setVisible(false);

        cl.show(switchPanel, "mainPanel_cl");
        this.add(switchPanel);
        this.setTitle("Descriptive Statistics");
        this.setVisible(true);
        this.setSize(640,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void redraw(){
        this.redraw();
    }
    public class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == quitB){
                dispose();
            }
            else
                if( e.getSource() == ungrpdB){
                cl.show(switchPanel, "uDataPanel_cl");
            }else if(e.getSource() == udispB) {
                data = uDataPanel.getData();
                uDispPanel.init(data);
                cl.show(switchPanel, "uDispPanel_cl");
            }else if( e.getSource() == uCont){
                    cl.show(switchPanel, "uChoicePanel_cl");
            }else if(e.getSource() == uEdit){
                cl.show(switchPanel, "uDataPanel_cl");
            }
            else if(e.getSource() == uMeanB ||e.getSource() == uMedianB ||
                        e.getSource() == uModeB ||e.getSource() == allB) {
                cl.show(switchPanel, "uResultsPanel_cl");

                if (e.getSource() == uMeanB) {
                    uDataPanel.setCTDSearched(1);
                } else if (e.getSource() == uMedianB) {
                    uDataPanel.setCTDSearched(2);
                } else if (e.getSource() == uModeB) {
                    uDataPanel.setCTDSearched(3);
                } else if (e.getSource() == allB) {
                    uDataPanel.setCTDSearched(4);
                }
            }else if(e.getSource() == inpIntpn){
                uResultsPanel.addTextArea();
            }else if(e.getSource() == execRun) {
                    System.out.println("nisud");
                if (balik.getSelectedIndex() == 0) {
                    cl.show(switchPanel, "uChoicePanel_cl");
                } else {
                    cl.show(switchPanel, "gGthrPanel_cl");
                }
            }else if(e.getSource() == grpdB){
                cl.show(switchPanel,"gGthrPanel_cl");
            }else if(e.getSource() == gDisp){
                data = gGthrPanel.getData();
                gDispPanel.init(data);
                cl.show(switchPanel,"gDispPanel_cl");
            }else if(e.getSource() == gDone){
                gEditContinue.setVisible(true);
                gDone.setVisible(false);
                gDispPanel.doneIsPressed();
            }else if(e.getSource() == gEdit){
                    gEditContinue.setVisible(false);
                    gDone.setVisible(true);
                    gDispPanel.editIsPressed();
            } else if(e.getSource() == gEdit){
                    gEditContinue.setVisible(false);
                    gDone.setVisible(true);
                    gDispPanel.editIsPressed();
            } else if(e.getSource() == gContinue){
                    data = gDispPanel.getData();
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){ new CTD_1();}
        });
    }
}