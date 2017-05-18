/**
 * Created by Michael Pacana and Noah Silvio on 4/26/2017.
 */
import CTD.*;
import SM.Data2;
import SM.DataDisplay;
import SM.DataGathering;
import SM.InitData;
import SPD.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class FinalMain_1 extends JFrame{

    private JPanel finalmainPanel = new JPanel();
    private JPanel finaldescPanel = new JPanel();
    private JButton finalCTD, finalSM, finalSPD;
    private JLabel finaltitle = new JLabel("FINAL MP");
    private JButton miniSPcontinue;
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
    String[] cmboStr = {"CTD: Same Data","CTD: New Set","HOME"};
    private CardLayout cl = new CardLayout();
    JComboBox balik = new JComboBox(cmboStr);
    JComboBox gBalik = new JComboBox(cmboStr);
    Data1 data1 = new Data1();
/////////////////////////////////////////////////////// Sampling Methods ////////////////////////////////////////////////////////////////////
    private JPanel mainPanelSM = new JPanel();
    private JButton sysSampButton, simpRandSampButton, stratSampButton, quit,
            simRandGetInitParam, simRandGetData,home1,fhome1,
            sysGetInitParam, sysGetData,home2,fhome2,
            stratGetInitParam, stratGetData,home3, fhome3;
    private InitData simRandPanel,sysPanel,stratPanel;
    private DataGathering simRandDataPanel,sysDataPanel,stratDataPanel;
    private DataDisplay simRandDataDispPanel, sysDataDispPanel, stratDataDispPanel;
    private Data2 data2;
/////////////////////////////////////////////////////// Summarizing and Presenting Data ///////////////////////////////////////////////////
    private JPanel s3MainPanel = new JPanel();// s3MainPanel for Switch
    private JPanel tableCollapsePanel = new JPanel();
    private JPanel tableHomePanel = new JPanel();
    private JLabel title; // s3MainPanel title
    private JButton ctgButt, nmrlButt, quitButt,
            getTableInfo,getTableInfo2, getRawTableInfo,
            collapseOpt, collapseOpt2, collapseOpt3, showGraphOpt, homeButt;// s3MainPanel buttons
    private ChartDisplay_05 chartDisplay = new ChartDisplay_05();

    private DataGathering_2 dataGathering = new DataGathering_2();
    Data3 data;
    private TableData_4 tableData = new TableData_4();
    private TableDataRaw_3 tableDataRaw = new TableDataRaw_3();

    ImageIcon icon = createImageIcon("res/sP.png",
            "a pretty but meaningless splat");

    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    ImageIcon imageIcon = new ImageIcon("res/sP.png"); // load the image to a imageIcon
    Image image = imageIcon.getImage(); // transform it
    Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
    JButton SPDhome, SPDhome2;

    public ImageIcon scaleImage(ImageIcon the_icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    JButton finalquitB;

    public FinalMain_1(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = gc.weighty = 0.5;
        finalmainPanel.setLayout(new GridBagLayout());
        finaldescPanel.setLayout(new GridBagLayout());
        finalmainPanel.setBackground(Color.cyan);
        finaldescPanel.setBackground(Color.cyan);
        JPanel combin = new JPanel();

        icon = scaleImage(icon,300,300);
        JLabel titleMiniSP = new JLabel(icon);
        titleMiniSP.setSize(new Dimension(1,1));

        JLabel titleMiniSP2 = new JLabel(icon);
        JLabel descMiniSP = new JLabel(" Mini-SP is a software implementation of basic statistical techniques and methods. ");
        descMiniSP.setForeground(Color.darkGray);
        descMiniSP.setForeground(Color.darkGray);
        descMiniSP.setFont(new Font("Century Gothic",Font.BOLD,18));

        JLabel descMiniSP2 = new JLabel(       "Central Tendency & Dispersion  ~  Sampling Methods  ~  " +
                "Summarizing & Presenting Data.");
        descMiniSP2.setForeground(Color.darkGray);
        descMiniSP2.setFont(new Font("Century Gothic",Font.BOLD,11));

        JLabel progMiniSP = new JLabel("Michael Ervin Pacana . Noah Dominic Silvio");
        progMiniSP.setForeground(Color.darkGray);
        progMiniSP.setFont(new Font("Century Gothic",Font.BOLD,8));
        miniSPcontinue = new JButton("Continue");
        miniSPcontinue.addActionListener(new myActionListener());

        gc.gridx = gc.gridy = 0;
        finaldescPanel.add(titleMiniSP,gc);
        gc.weighty = 5;
        finaldescPanel.add(new JLabel(""),gc);
        gc.weighty = 0.01;
        gc.gridy++;
        finaldescPanel.add(descMiniSP,gc);
        gc.weighty = 0.1;
        gc.gridy++;
        finaldescPanel.add(descMiniSP2,gc);
        gc.weighty = 1;
        gc.gridy++;
        finaldescPanel.add(progMiniSP,gc);
        gc.weighty = 3;
        gc.gridy++;
        finaldescPanel.add(miniSPcontinue,gc);
        gc.gridy++;
        finaldescPanel.add(progMiniSP,gc);

        finalCTD = new JButton("Central Tendency and Dispersion");
        finalCTD.addActionListener(new myActionListener());

        finalSM = new JButton("Sampling Methods");
        finalSM.addActionListener(new myActionListener());

        finalSPD = new JButton("Summary and Presentation of Data");
        finalSPD.addActionListener(new myActionListener());
        gc.gridx = 0;
        gc.gridy =0;
        finalmainPanel.add(titleMiniSP2,gc);
        gc.gridy++;
        finalmainPanel.add(finalCTD,gc);
        gc.gridy++;
        finalmainPanel.add(finalSM,gc);
        gc.gridy++;
        finalmainPanel.add(finalSPD,gc);
        finalquitB = new JButton("Quit");
        finalquitB.addActionListener(new myActionListener());
        gc.gridy++;
        finalmainPanel.add(finalquitB,gc);

        finalmainPanel.setVisible(true);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //setting up Panel to switch screens

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
///////////////////////////////////////////////////Sampling Methods///////////////////////////////////////////////////////////////////////////////////
        //Instead of initializing frame, we extend frame and use this. We use container c to adjust Pane
        //using Grid Bag type layout for more control
        mainPanelSM.setLayout( new GridBagLayout());
        //adding components
        JLabel title = new JLabel("Random Sampling Techniques");
        title.setFont(new Font("Century Gothic",Font.BOLD,30));

        //initializing the simple random panel with its components
        simpRandSampButton = new JButton("Simple Random Samping");
        simpRandSampButton.addActionListener(new myActionListener());

        simRandPanel = new InitData(1);
        simRandGetInitParam = new JButton("Continue to SM.Data2");
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
        home1 = new JButton("ST: Run Again");
        home1.addActionListener(new myActionListener());
        simRandDataDispPanel.add(home1,gc);
        fhome1 = new JButton("Home");
        fhome1.addActionListener(new myActionListener());
        gc.gridy++;
        simRandDataDispPanel.add(fhome1,gc);
////////////////////////////////////////////////// S Y S T E M A T I C///////////////////////////////////////////////////////////////////////////////////
        //initializing the systematic panel with its components
        sysSampButton = new JButton("Systematic Sampling");
        sysSampButton.addActionListener(new myActionListener());

        sysPanel = new InitData(2);
        sysGetInitParam = new JButton("Continue to SM.Data2");
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
        home2 = new JButton("ST: Run Again");
        home2.addActionListener(new myActionListener());
        sysDataDispPanel.add(home2,gc);
        fhome2 = new JButton("Home");
        fhome2.addActionListener(new myActionListener());
        gc.gridy++;
        sysDataDispPanel.add(fhome2,gc);
/////////////////////////////////////////////////// S T R A T I F I E D /////////////////////////////////////////////////////////////////////////////////////////////
        //initializing the stratified panel with its components
        stratSampButton = new JButton("Stratified Sampling");
        stratSampButton.addActionListener(new myActionListener());

        stratPanel = new InitData(3);
        stratGetInitParam = new JButton("Continue to SM.Data2");
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
        home3 = new JButton("ST: Run Again");
        home3.addActionListener(new myActionListener());
        stratDataDispPanel.add(home3,gc);
        fhome3 = new JButton("Home");
        fhome3.addActionListener(new myActionListener());
        gc.gridy++;
        stratDataDispPanel.add(fhome3,gc);
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
////////////////////////////////////////////Presenting Data//////////////////////////////////////////////////////


        Container cp = getContentPane();

        //Setting up main-panel
        s3MainPanel.setLayout(new GridBagLayout());// Grid layout for more control

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
        s3MainPanel.add(title,gc);
        gc.weighty = 0.3;
        gc.gridy = 1;
        s3MainPanel.add(ctgButt,gc);
        gc.gridy = 2;
        s3MainPanel.add(nmrlButt,gc);
        gc.gridy = 3;
        s3MainPanel.add(quitButt,gc);
        gc.weighty = 0.5;
        gc.gridy = 4;
        s3MainPanel.add(new JLabel(""),gc);

        collapseOpt = new JButton("Collapse 1st and last classes");//setting up options for SPD.SPD.TableData_4
        collapseOpt.addActionListener(new myActionListener());
        collapseOpt2 = new JButton("Collapse 1st class");
        collapseOpt2.addActionListener(new myActionListener());
        collapseOpt3 = new JButton("Collapse last class");
        collapseOpt3.addActionListener(new myActionListener());

        showGraphOpt = new JButton("Show Graph");
        showGraphOpt.addActionListener(new myActionListener());
        gc.gridx = 0;
        tableCollapsePanel.add(showGraphOpt, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        tableData.add(tableCollapsePanel,gc);

        homeButt = new JButton("SPD: Run Again");
        homeButt.addActionListener(new myActionListener());
        tableHomePanel = new JPanel();
        gc.gridx = gc.gridy = 0;
        getTableInfo2 = new JButton("Show Table");
        getTableInfo2.addActionListener(new myActionListener());
        tableHomePanel.add(getTableInfo2, gc);
        gc.gridx = 1;
        tableHomePanel.add(homeButt,gc);
        SPDhome = new JButton("Home");
        SPDhome.addActionListener(new myActionListener());
        gc.gridx++;
        tableHomePanel.add(SPDhome,gc);
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
        switchPanel.setLayout(cl);
        switchPanel.add(s3MainPanel,"s3MainPanel");
        switchPanel.add(finaldescPanel,"descPanelFinal");
        switchPanel.add(finalmainPanel,"finalmainPanel_fl");

        switchPanel.add(dataGathering,"dataGathering");
        switchPanel.add(tableDataRaw,"tableDataRaw");
        switchPanel.add(tableData,"tableData");
        switchPanel.add(chartDisplay, "chartDisplay");

        cl.show(switchPanel, "descPanelFinal");
        this.add(switchPanel);
        this.setTitle("Descriptive Statistics");
        this.setVisible(true);
        this.setSize(768,432);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void redraw(){
        this.redraw();
    }

    public class myActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == finalquitB){
                dispose();
            }else if(e.getSource() == finalCTD){
                cl.show(switchPanel, "mainPanel_cl");
            }else if(e.getSource() == finalSM){
                cl.show(switchPanel, "mainpanel");
            }else if(e.getSource() == finalSPD){
                cl.show(switchPanel, "s3MainPanel");
            }else if(e.getSource() == miniSPcontinue){
                cl.show(switchPanel, "finalmainPanel_fl");
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
                } else if(balik.getSelectedIndex() == 1){
                    cl.show(switchPanel, "mainPanel_cl");
                    uDataPanel.erase();
                    uDispPanel.erase();
                }else{
                    cl.show(switchPanel, "finalmainPanel_fl");
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
                } else if(gBalik.getSelectedIndex() == 1){
                    cl.show(switchPanel, "mainPanel_cl");
                } else{
                    cl.show(switchPanel, "finalmainPanel_fl");
                }
                gResultsPanel.removeTextArea();
            } else if(e.getSource() == quit){
                //quit program
                dispose();
            }
            else {
                if (e.getSource() == simpRandSampButton) {
                    //create new class that extend JPanel
                    cl.show(switchPanel, "simRandPanel");
                } else if (e.getSource() == simRandGetInitParam && simRandPanel.check()) {
                    data2 = simRandPanel.getData();
                    cl.show(switchPanel, "simRandDataPanel");
                } else if (e.getSource() == simRandGetData && simRandDataPanel.check(data2)) {
                    data2 = simRandDataPanel.getData(data2);
                    data2.process();
                    simRandDataDispPanel.display(data2);
                    cl.show(switchPanel, "simRandDataDispPanel");
                } else if (e.getSource() == home1) {
                    data2.clear();
                    simRandPanel.clear();
                    simRandPanel.clear();
                    simRandDataPanel.clear();
                    simRandDataDispPanel.clear();
                    cl.show(switchPanel, "mainpanel");
                }else if (e.getSource() == fhome1) {
                    data2.clear();
                    simRandPanel.clear();
                    simRandPanel.clear();
                    simRandDataPanel.clear();
                    simRandDataDispPanel.clear();
                    cl.show(switchPanel, "finalmainPanel_fl");
                }
                ///////////////////////////////////////////////////////////////////
                if (e.getSource() == sysSampButton) {
                    //create new class that extend JPanel
                    cl.show(switchPanel, "sysPanel");
                } else if (e.getSource() == sysGetInitParam && sysPanel.check()) {
                    data2 = sysPanel.getData();
                    cl.show(switchPanel, "sysDataPanel");
                } else if (e.getSource() == sysGetData && sysDataPanel.check(data2)) {
                    data2 = sysDataPanel.getData(data2);
                    data2.process();
                    sysDataDispPanel.display(data2);
                    cl.show(switchPanel, "sysDataDispPanel");
                } else if (e.getSource() == home2) {
                    cl.show(switchPanel, "mainpanel");
                    data2.clear();
                    sysPanel.clear();
                    sysPanel.clear();
                    sysDataPanel.clear();
                    sysDataDispPanel.clear();
                } else if (e.getSource() == fhome2) {
                    data2.clear();
                    sysPanel.clear();
                    sysPanel.clear();
                    sysDataPanel.clear();
                    sysDataDispPanel.clear();
                    cl.show(switchPanel, "finalmainPanel_fl");
                }////////////////////////////////////////////////////////
                if (e.getSource() == stratSampButton) {
                    //create new class that extend JPanel
                    cl.show(switchPanel, "stratPanel");
                } else if (e.getSource() == stratGetInitParam && stratPanel.check()) {
                    data2 = stratPanel.getData();
                    data2 = stratPanel.getData();
                    cl.show(switchPanel, "stratDataPanel");
                } else if (e.getSource() == stratGetData && stratDataPanel.check(data2)) {
                    data2 = stratDataPanel.getData(data2);
                    data2.process();
                    stratDataDispPanel.display(data2);
                    cl.show(switchPanel, "stratDataDispPanel");
                } else if (e.getSource() == home3) {
                    cl.show(switchPanel, "mainpanel");
                    data2.clear();
                    stratPanel.clear();
                    stratPanel.clear();
                    stratDataPanel.clear();
                    stratDataDispPanel.clear();
                } else if (e.getSource() == fhome3) {
                    data2.clear();
                    stratPanel.clear();
                    stratPanel.clear();
                    stratDataPanel.clear();
                    stratDataDispPanel.clear();
                    cl.show(switchPanel, "finalmainPanel_fl");
                }else if(e.getSource() == quitButt){
                    dispose();
                }else {
                    if (e.getSource() == ctgButt) {
                        dataGathering.setNumericDataType(false); // data is not numerical
                        cl.show(switchPanel, "dataGathering");

                    } else if (e.getSource() == nmrlButt) {
                        dataGathering.setNumericDataType(true); // data is numerical
                        cl.show(switchPanel, "dataGathering");
                    } else if (e.getSource() == getRawTableInfo) {
                        if (dataGathering.checkData()) {// checks if input follows chosen category
                            data = dataGathering.getData();
                            System.out.println("it got new data");
                            for (int i = 0; i < data.getCategoriesLength(); i++) {
                                System.out.println(data.getData()[i]);
                            }
                            System.out.println("title is" + data.getBriefTitle());
                            tableDataRaw.updateData(data);
                            cl.show(switchPanel, "tableDataRaw");
                        }
                    } else if (e.getSource() == getTableInfo || e.getSource() == getTableInfo2) {
                        if (dataGathering.checkData()) {// checks if input follows chosen category
                            if (e.getSource() == getTableInfo) {
                                data = dataGathering.getData();
                                tableData.updateData(data);
                                GridBagConstraints gc = new GridBagConstraints();
                                if (data.getIsNumericDataType()) {
                                    gc.gridy = gc.gridx = 0;
                                    tableCollapsePanel.add(collapseOpt, gc);
                                    tableCollapsePanel.add(collapseOpt2, gc);
                                    tableCollapsePanel.add(collapseOpt3, gc);
                                }
                            }
                            cl.show(switchPanel, "tableData");
                        }
                    } else if (e.getSource() == collapseOpt) {
                        tableData.collapse(data, 1);
                    } else if (e.getSource() == collapseOpt2) {
                  /*  tableData.collapse();
                    cl.show(switchPanel,)*/
                        tableData.collapse(data, 2);
                    } else if (e.getSource() == collapseOpt3) {
                  /*  tableData.collapse();
                    cl.show(switchPanel,)*/
                        tableData.collapse(data, 3);
                    } else if (e.getSource() == showGraphOpt) {
                        Object[] options = {"Yes", //show options whether to show Graph or not
                                "No"};
                        int n = JOptionPane.showOptionDialog(new JFrame(),
                                "Would you like the Graph to be shown?",
                                "Graph",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options, null);
                        if (n == 0) {
                            chartDisplay.getData(data);
                            chartDisplay.setNiBack(true);
                            cl.show(switchPanel, "chartDisplay");
                        } else {
                            dataGathering.erase();
                            tableDataRaw.erase();
                            tableData.erase();
                            chartDisplay.erase();
                            cl.show(switchPanel, "s3MainPanel");
                        }
                    } else if (e.getSource() == homeButt) {
                        dataGathering.erase();
                        tableDataRaw.erase();
                        tableData.erase();
                        chartDisplay.erase();
                        cl.show(switchPanel, "s3MainPanel");
                    } else if (e.getSource() == SPDhome) {
                        dataGathering.erase();
                        tableDataRaw.erase();
                        tableData.erase();
                        chartDisplay.erase();
                        cl.show(switchPanel, "finalmainPanel_fl");
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){ new FinalMain_1();}
        });
    }
}
