import java.util.*;

/**
 * Created by Michael Ervin Pacana and Noah Silvio on 4/26/2017.
 */
public class Data {

    private String shrtDesc;
    private String[] data;
    private Double[] dData;
    private boolean isFloat;
    private int ctdChoice;
    private boolean isUngrouped;

    //for Grouped
    private String[] upperClassLimits;
    private String[] lowerClassLimits;
    private String[] frequency;
    boolean isOpenEnded;
    private int classIntervals;

    public void erase() {
        String[] eraseData = {""};
        shrtDesc = "";
        isFloat = isUngrouped = false;
        data = upperClassLimits = lowerClassLimits = frequency = eraseData;
        classIntervals = ctdChoice = 0;
        //idk how to initialize double
    }

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
        if(isUngrouped && ctdChoice ==1){

        }else if(isUngrouped && ctdChoice ==2) {

        }else if(isUngrouped && ctdChoice ==3){

        }
        return solution;
    }

    public String getAns() {
        if(isUngrouped && ctdChoice ==0){
            return uMean();
        }else if(isUngrouped && ctdChoice ==1) {
            return uMedian();
        }else if(isUngrouped && ctdChoice ==2){
            return uMode();
        }
        else if(isUngrouped && ctdChoice ==2){
            return uMode();
        }
        return "answer";
    }
    public String uMean(){
        double sum = 0;
        for (int i = 0; i < dData.length; i++) {
            sum += dData[i];
        }
        double ans =  sum / dData.length;

        return "The MEAN is "+String.valueOf(ans);
    }
    public String uMedian(){
        Double ans;
        int middle = dData.length/2;
        if (dData.length%2 == 1) {
            ans = dData[middle];
        } else {
            ans = (dData[middle-1] + dData[middle]) / 2.0;
        }
        return "The MEDIAN is "+String.valueOf(ans);
    }

    public String uMode() {
        final List<Integer> modes = new ArrayList<Integer>();
        final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        int max = -1;

        for (final double n : dData) {
            int count = 0;

            if (countMap.containsKey(n)) {
                count = countMap.get(n) + 1;
            } else {
                count = 1;
            }

            countMap.put((int) n, count);

            if (count > max) {
                max = count;
            }
        }

        for (final Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
            if (tuple.getValue() == max) {
                modes.add(tuple.getKey());
            }
        }
        if(modes.size() == 0){
            return "There is no mode";
        }else if(modes.size() == 1){
            return "The data is unimodal";
        }else if(modes.size() == 2){
            return "The data is bimodal";
        } else{
            System.out.println();
            return "The data is multimodal";
        }
    }
    public boolean isOpenEnded() {
        return isOpenEnded;
    }
    public void setOpenEnded(boolean isOpenEnded) {
        this.isOpenEnded = isOpenEnded;
    }

    public void setData(String[] data) {
        this.data = data;
        dData = new Double[data.length];
        for(int i = 0 ; i < data.length; i++){
            dData[i] = Double.valueOf(data[i]);
        }
    }
}
