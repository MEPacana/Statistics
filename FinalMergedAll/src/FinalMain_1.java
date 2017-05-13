/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import CTD.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalMain_1 extends JFrame{

    private JPanel finalmainPanel = new JPanel();
    private JButton finalCTD, finalSM, finalSPD;
    private JLabel finaltitle = new JLabel("FINAL MP");
    ////////////////////////////////////////////////// Central Tendency & Dispersion ////////////////////////////////////////////////
    private JPanel switchPanel = new JPanel();
    private MainPanel_2 mainPanel = new MainPanel_2();

    //main menu panels
    private UGthrData_3a uDataPanel = new UGthrData_3a();
    private UDispData_3b uDispPanel = new UDispData_3b();
    private UChoiceData_3c uChoicePanel = new UChoiceData_3c();
    private UResults_3d uResultsPanel = new UResults_3d();
    private JPanel tempPanel = new JPanel();
    private JPanel ResultsRedoPanel = new JPanel();
    private JPanel gResultsRedoPanel = new JPanel();
    private JPanel gEditContinue = new JPanel();

    private JPanel gMeanMedianModeAll = new JPanel();

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
        gDone, gEdit, gContinue,
            gMeanB, gMedianB, gModeB, gAllB,
            gInpIntpn, gExecRun;
    String[] cmboStr = {"same data1","new set"};
    private CardLayout cl = new CardLayout();
    JComboBox balik = new JComboBox(cmboStr);
    JComboBox gBalik = new JComboBox(cmboStr);
    Data1 data1 = new Data1();
/////////////////////////////////////////////////////// Sampling Methods ////////////////////////////////////////////////////////////////////

/*
    private JPanel mainPanelSM = new JPanel();
    private JPanel basePanel = new JPanel();
    private JButton sysSampButton, simpRandSampButton, stratSampButton, quit,
            simRandGetInitParam, simRandGetData,home1,
            sysGetInitParam, sysGetData,home2,
            stratGetInitParam, stratGetData,home3;
    private InitData simRandPanel,sysPanel,stratPanel;
    private DataGathering simRandDataPanel,sysDataPanel,stratDataPanel;
    private DataDisplay simRandDataDispPanel, sysDataDispPanel, stratDataDispPanel;

    private Data2 data2;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

    public FinalMain_1(){
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = gc.weighty = 0.5;
        finalmainPanel.setLayout(new GridBagLayout());
        finalCTD = new JButton("Central Tendency and Dispersion");
        finalCTD.addActionListener(new myActionListener());

        finalSM = new JButton("Sampling Methods");
        finalSM.addActionListener(new myActionListener());

        finalSPD = new JButton("Summary and Presentation of Data");
        finalSPD.addActionListener(new myActionListener());
        gc.gridx = 0;
        gc.gridy =0;
        finalmainPanel.add(finaltitle,gc);
        gc.gridy++;
        finalmainPanel.add(finalCTD,gc);
        gc.gridy++;
        finalmainPanel.add(finalSM,gc);
        gc.gridy++;
        finalmainPanel.add(finalSPD,gc);
        finalmainPanel.setVisible(true);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //setting up Panel to switch screens

        switchPanel.setLayout(cl);

        //initialize main menu buttons

        ungrpdB = new JButton("Ungrouped CTD.Data1");
        ungrpdB.addActionListener(new myActionListener());
        grpdB = new JButton("Grouped CTD.Data1");
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
        //initialize gather data1 button
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


        gMeanB = new JButton("Mean");
        gMeanB.addActionListener(new myActionListener());
        gMedianB = new JButton("Median");
        gMedianB.addActionListener(new myActionListener());
        gModeB = new JButton("Mode");
        gModeB.addActionListener(new myActionListener());
        gAllB = new JButton("All Measures");
        gAllB.addActionListener(new myActionListener());

        gMeanMedianModeAll.setLayout(new GridBagLayout());
        gc.gridx = gc.gridy = 0;
        gMeanMedianModeAll.add(gMeanB,gc);
        gc.gridx = 1;
        gMeanMedianModeAll.add(gMedianB,gc);
        gc.gridx = 2;
        gMeanMedianModeAll.add(gModeB,gc);
        gc.gridx =3;
        gMeanMedianModeAll.add(gAllB,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gChoicePanel.add(gMeanMedianModeAll,gc);

        gInpIntpn = new JButton("Input Interpretation");
        gInpIntpn.addActionListener(new myActionListener());
        gc.gridx = 0;
        gResultsRedoPanel.add(gInpIntpn,gc);
        gExecRun = new JButton("Exectute another run");
        gExecRun.addActionListener(new myActionListener());
        gc.gridx = 1;
        gResultsRedoPanel.add(gExecRun,gc);
        gc.gridx = 2;
        gResultsRedoPanel.add(gBalik,gc);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.weighty = 1;
        gResultsPanel.add(gResultsRedoPanel,gc);

        switchPanel.add(finalmainPanel,"finalmainPanel_fl");
        switchPanel.add(mainPanel,"mainPanel_cl");
        switchPanel.add(uDataPanel,"uDataPanel_cl");
        switchPanel.add(uDispPanel,"uDispPanel_cl");
        switchPanel.add(uChoicePanel,"uChoicePanel_cl");
        switchPanel.add(uResultsPanel,"uResultsPanel_cl");

        switchPanel.add(gGthrPanel,"gGthrPanel_cl");
        switchPanel.add(gDispPanel,"gDispPanel_cl");
        switchPanel.add(gChoicePanel,"gChoicePanel_cl");
        switchPanel.add(gResultsPanel, "gResultsPanel_cl");

        cl.show(switchPanel, "finalmainPanel_cl");
        this.add(switchPanel);
        this.setTitle("Descriptive Statistics");
        this.setVisible(true);
        this.setSize(640,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void redraw(){
        this.redraw();
    }

    public class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == finalCTD){
                System.out.println("nisud");
                cl.show(switchPanel, "mainPanel_cl");
            }else if(e.getSource() == finalSM){

            }else if(e.getSource() == finalSPD){

            }
            else if(e.getSource() == quitB){
                dispose();
            }
            else if( e.getSource() == ungrpdB){
                data1.setUngrouped(true);
                cl.show(switchPanel, "uDataPanel_cl");
            }else if(e.getSource() == udispB) {
                if(uDataPanel.checkData()) {
                    data1 = uDataPanel.init(data1);
                    uDispPanel.init(data1);
                    cl.show(switchPanel, "uDispPanel_cl");
                }
            }else if( e.getSource() == uCont){
                    cl.show(switchPanel, "uChoicePanel_cl");
            }else if(e.getSource() == uEdit){
                cl.show(switchPanel, "uDataPanel_cl");
            }else if(e.getSource() == uMeanB ||e.getSource() == uMedianB ||
                        e.getSource() == uModeB ||e.getSource() == allB) {
                if (e.getSource() == uMeanB) {
                    data1.setCtdChoice(0);
                } else if (e.getSource() == uMedianB) {
                    data1.setCtdChoice(1);
                } else if (e.getSource() == uModeB) {
                    data1.setCtdChoice(2);
                } else if (e.getSource() == allB) {
                    data1.setCtdChoice(3);
                }
                uResultsPanel.init(data1);
                cl.show(switchPanel, "uResultsPanel_cl");
            }else if(e.getSource() == inpIntpn){
                uResultsPanel.addTextArea();
            }else if(e.getSource() == execRun) {
                    System.out.println("nisud");
                if (balik.getSelectedIndex() == 0) {
                    cl.show(switchPanel, "uChoicePanel_cl");
                } else {
                    cl.show(switchPanel, "mainPanel_cl");
                    uDataPanel.erase();
                    uDispPanel.erase();
                }
            }else if(e.getSource() == grpdB){
                cl.show(switchPanel,"gGthrPanel_cl");
            }else if(e.getSource() == gDisp){
                if(gGthrPanel.checkData()) {
                    data1 = gGthrPanel.getData1();
                    gDispPanel.init(data1);
                    cl.show(switchPanel, "gDispPanel_cl");
                }
            }else if(e.getSource() == gDone){
                gEditContinue.setVisible(true);
                gDone.setVisible(false);
                gDispPanel.doneIsPressed();
            }else if(e.getSource() == gEdit){
                    gEditContinue.setVisible(false);
                    gDone.setVisible(true);
                    gDispPanel.editIsPressed();
            }else if(e.getSource() == gEdit){
                    gEditContinue.setVisible(false);
                    gDone.setVisible(true);
                    gDispPanel.editIsPressed();
            }else if(e.getSource() == gContinue){
                try {
                    data1 = gDispPanel.getData1();
                }catch(Exception d){
                    d.printStackTrace();
                }
                    gChoicePanel.init(data1);
                    cl.show(switchPanel, "gChoicePanel_cl");
            }else if(e.getSource() == gMeanB ||e.getSource() == gMedianB ||
                        e.getSource() == gModeB ||e.getSource() == gAllB) {
                    if (e.getSource() == gMeanB) {
                        data1.setCtdChoice(0);
                    } else if (e.getSource() == gMedianB) {
                        data1.setCtdChoice(1);
                    } else if (e.getSource() == gModeB) {
                        data1.setCtdChoice(2);
                    } else if (e.getSource() == gAllB) {
                        data1.setCtdChoice(3);
                    }
                gResultsPanel.init(data1);
                cl.show(switchPanel, "gResultsPanel_cl");
            }else if(e.getSource() == inpIntpn){
                    uResultsPanel.addTextArea();
            }else if(e.getSource() == execRun){
                if (gBalik.getSelectedIndex() == 0) {
                    cl.show(switchPanel, "uChoicePanel_cl");
                } else {
                    cl.show(switchPanel, "mainPanel_cl");
                }
                uResultsPanel.removeTextArea();
            }else if(e.getSource() == gInpIntpn){
                gResultsPanel.addTextArea();
            }else if(e.getSource() == gExecRun){
                if (gBalik.getSelectedIndex() == 0) {
                    cl.show(switchPanel, "gChoicePanel_cl");
                } else {
                    cl.show(switchPanel, "mainPanel_cl");
                }
                gResultsPanel.removeTextArea();
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){ new FinalMain_1();}
        });
    }
}
