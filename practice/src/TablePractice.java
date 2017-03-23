import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 3/22/2017.
 */
public class TablePractice extends JFrame{
    JTable table;
    public TablePractice(){
        setLayout(new FlowLayout());
        String[] coloumnNames = {"Name","Age","School"};

        Object[][] data={{"Sarah", "13", "University of the Philippines"},
                {"Mark","14","University of San Carlos"},
                {"Macy","17","University of San Jose Recolettos"},
                {"Trisha","14","Cebu Institute of Technology"},};

        table = new JTable (data,coloumnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    public static void main(String args[]){
        TablePractice gui = new TablePractice();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600,200);
        gui.setVisible(true);
        gui.setTitle("Table Practice" );
    }
}
