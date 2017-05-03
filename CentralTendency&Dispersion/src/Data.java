import java.util.Vector;

/**
 * Created by Michael Ervin Pacana and Noah Silvio on 4/26/2017.
 */
public class Data {
    String shrtDesc;
    String[] data;
    boolean unsigned;
    int ctdChoice;

    public String getShrtDesc() {
        return shrtDesc;
    }

    public void setShrtDesc(String shrtDesc) {
        this.shrtDesc = shrtDesc;
    }

    public String[] getData() {
        return data;
    }

    public String[] getSolution() {
        String[] solution = new String[]{"solution","solution"};
        return solution;
    }
    public String getAns() {
        return "answer";
    }


    public void setData(String[] data) {
        this.data = data;
    }
}
