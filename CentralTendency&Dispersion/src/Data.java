import java.util.Vector;

/**
 * Created by Michael Ervin Pacana and Noah Silvio on 4/26/2017.
 */
public class Data {
    private String shrtDesc;
    private String[] data;
    private boolean unsigned;
    private boolean isFloat;
    private int ctdChoice;
    private boolean isUngrouped;
    //for Grouped
    private String[] upperClassLimits;
    private String[] lowerClassLimits;
    private String[] frequency;
    boolean isOpenEnded;
    private int classIntervals;

    public int getClassIntervals() {
        return classIntervals;
    }

    public void setClassIntervals(int classIntervals) {
        this.classIntervals = classIntervals;
    }

    public String[] getFrequency() {
        return frequency;
    }

    public void setFrequency(String[] frequency) {
        this.frequency = frequency;
    }


    public boolean isUnsigned() {
        return unsigned;
    }

    public void setUnsigned(boolean unsigned) {
        this.unsigned = unsigned;
    }

    public boolean isFloat() {
        return isFloat;
    }

    public int getCtdChoice() {
        return ctdChoice;
    }

    public void setCtdChoice(int ctdChoice) {
        this.ctdChoice = ctdChoice;
    }

    public boolean isUngrouped() {
        return isUngrouped;
    }

    public void setUngrouped(boolean ungrouped) {
        isUngrouped = ungrouped;
    }

    public String[] getUpperClassLimits() {
        return upperClassLimits;
    }

    public void setUpperClassLimits(String[] upperClassLimits) {
        this.upperClassLimits = upperClassLimits;
    }

    public String[] getLowerClassLimits() {
        return lowerClassLimits;
    }

    public void setLowerClassLimits(String[] lowerClassLimits) {
        this.lowerClassLimits = lowerClassLimits;
    }

    public String getShrtDesc() {
        return shrtDesc;
    }

    public void setShrtDesc(String shrtDesc) {
        this.shrtDesc = shrtDesc;
    }

    public String[] getData() {
        return data;
    }
    public void setFloat(boolean isFloat){
        this.isFloat = isFloat;
    }
    public boolean getFloat(){
        return isFloat;
    }

    public String[] getSolution() {
        String[] solution = new String[]{"solution","solution"};
        if(unsigned && ctdChoice ==1){

        }else if(unsigned && ctdChoice ==2) {

        }else if(unsigned && ctdChoice ==3){

        }
        return solution;
    }

    public String getAns() {
        if(unsigned && ctdChoice ==1){

        }else if(unsigned && ctdChoice ==2) {

        }else if(unsigned && ctdChoice ==3){

        }
        return "answer";
    }
    public boolean isOpenEnded() {
        return isOpenEnded;
    }
    public void setOpenEnded(boolean isOpenEnded) {
        this.isOpenEnded = isOpenEnded;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
