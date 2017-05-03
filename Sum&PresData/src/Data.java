/*
*
 * Created by Michael Pacana & Noah Silvio on 3/21/2017.
*/
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Data {
    private String[] rawData;
    private String briefTitle;
    private boolean isNumericDataType; // true = numerical, false = categorical
    private String[][] addtlData;
    private int rowNum;
    //TableValues for Numerical Data
    private Vector<Integer> frequency, cFrequency;
    private Vector<Double> lowerClassLimit, upperClassLimit, trueLowerClassLimit, trueUpperClassLimit, midpoints, classPercentage, cClassPercentage;
    //TableValues for Categorical Data
    private Vector<String> categories;
    private Vector<Integer> categoryCount;
    private Vector<Double>  categoryPercentage;
    private Integer totalFreq;
    private Double totalPercent;

    public Integer getTotalFreq() {
        return totalFreq;
    }

    public Double getTotalPercent() {
        return totalPercent;
    }


    double classWidth;
    double range, numberOfClasses;

    public Data() {
        rawData = new String[]{"0","1"};
        briefTitle = "adasd";
        isNumericDataType = false;
        addtlData = new String[][]{{"0","1"},{"1","0"}};
        rowNum = 2;
    }
    public Data(String[] rawData, String briefTitle, boolean isNumericDataType) {
        //for Numerical Data
        lowerClassLimit = new Vector<>();
        upperClassLimit = new Vector<>();
        frequency =  new Vector<>();
        cFrequency = new Vector<>();
        classPercentage = new Vector<>();
        cClassPercentage = new Vector<>();

        trueLowerClassLimit = new Vector<>();
        trueUpperClassLimit = new Vector<>();
        midpoints = new Vector<>();

        //for Categorical Data
        categories = new Vector<>();
        categoryCount = new Vector<>();
        categoryPercentage = new Vector<>();

        //for both data
        this.rawData = rawData;
        this.briefTitle = briefTitle;
        this.isNumericDataType = isNumericDataType;
        this.totalPercent = new Double(0);
        this.totalFreq = new Integer(0);

        if(isNumericDataType){
            rowNum = 7;
        }else{
            rowNum = 2;
        }
    }

    public Vector<Double> getMidpoints(){
        return midpoints;
    }

    public void processNumericalData(){
        //fundamental values:
        //calculating the values of the three important numbers
        numberOfClasses = Math.ceil(1 + (3.322*Math.log10((double) rawData.length)));
        range = findRange();
        System.out.println(range);
        //System.out.println("Range: " + range);
        classWidth = Math.ceil((double)range/(double)numberOfClasses);

        //finding the values for all the table values & initialising frequency, cFrequency, classPercentage, and cClassPercentage
        Double num = new Double(0.5);
        Double tempVarForClassLimits = findMin();
        for(int i = 0; i < numberOfClasses; i++) {
            lowerClassLimit.addElement(tempVarForClassLimits);
            upperClassLimit.addElement(tempVarForClassLimits + classWidth);
            trueLowerClassLimit.addElement(lowerClassLimit.elementAt(i) - num);
            trueUpperClassLimit.addElement(upperClassLimit.elementAt(i) + num);
            midpoints.addElement((trueLowerClassLimit.elementAt(i) + trueUpperClassLimit.elementAt(i))/2);
            frequency.addElement(0);
            System.out.println("i=" + i + "; " + lowerClassLimit.lastElement());
            tempVarForClassLimits += (classWidth+1);
        }

        //tallying for each class
        for (String aRawData : rawData) {
            for (int j = 0; j < lowerClassLimit.size(); j++) {
                if (Double.parseDouble(aRawData) >= trueLowerClassLimit.elementAt(j) && Double.parseDouble(aRawData) < trueUpperClassLimit.elementAt(j)) {
                    frequency.set(j, frequency.elementAt(j) + 1);
                    break;
                }
            }
        }

        //finding the percentage & cFrequency
        //finding the percentage & cFrequency
        Integer currentCFrequency = 0;
        Double currentCClassPercentage = 0.0;
        for(int i = 0; i < lowerClassLimit.size(); i++) {
            classPercentage.addElement(frequency.elementAt(i).doubleValue()/(double)rawData.length*100);

            currentCFrequency += frequency.elementAt(i);
            cFrequency.addElement(currentCFrequency);

            currentCClassPercentage += classPercentage.elementAt(i);
            cClassPercentage.addElement(currentCClassPercentage);

            totalFreq += frequency.elementAt(i);
            totalPercent += classPercentage.elementAt(i);
        }

        //testing
        for(int i = 0; i < lowerClassLimit.size(); i++ ) {
            //System.out.println(lowerClassLimit.elementAt(i) + "-" + upperClassLimit.elementAt(i) + "  |  " + trueLowerClassLimit.elementAt(i) + "-" + trueUpperClassLimit.elementAt(i) + "  |  " + midpoints.elementAt(i) + "  |  " + frequency.elementAt(i) + "  |  " + cFrequency.elementAt(i) + "  |  " + classPercentage.elementAt(i) + "  |  " + cClassPercentage.elementAt(i)) ;
        }
    }

    public void processCategoricalData(){
        //These vectors are the storage for processed rawData:

        //used for keeping track for the current index in Vector<Integer> categoryCount
        int sampleSize;

        sampleSize = rawData.length;

        Arrays.sort(rawData, String.CASE_INSENSITIVE_ORDER);

        /* adds the rawData elements to categories. similar elements are not added
         * to categories but categoryCount is changed
         */
        for(int i = 0; i < rawData.length; i++){
            //rawData[i] can just be compared with the last element of categories bc rawData is sorted
            if(categories.contains(rawData[i])){
                //add 1 to categoryCount[currentCategoryCountIndex]
                categoryCount.set(categories.indexOf(rawData[i]), categoryCount.elementAt(categories.indexOf(rawData[i])) + 1);
            } else {
                //add a new category to vector
                categories.addElement(rawData[i]);

                //add a new counter for the new category
                categoryCount.addElement(1);
            }
        }

        //this part is for calculating the percentage of each category
        for(int i = 0; i < categoryCount.size(); i++) {
            //this is basically count/total size * 100
            categoryPercentage.addElement(Double.valueOf(categoryCount.elementAt(i).toString())/sampleSize*100);
            totalPercent += Double.valueOf(categoryCount.elementAt(i).toString())/sampleSize*100;
        }
    }

    public boolean getIsNumericDataType(){
        return isNumericDataType;
    }

    public String[][] getAddtlData() {
        return addtlData;
    }

    //TODO This function assumes that the values in rawData[] are all integers. Double is also possible
    public double findMin(){
        double temp, min = Double.parseDouble(rawData[0]);
        for(int i = 0; i < rawData.length; i++) {
            temp = Double.parseDouble(rawData[i]);
            if(min > temp) {
                min = temp;
            }
        }
        return min;
    }

    public double findMax(){
        double temp, max = Double.parseDouble(rawData[0]);
        for(int i = 0; i < rawData.length; i++) {
            temp = Double.parseDouble(rawData[i]);
            if(max < temp) {
                max = temp;
            }
        }
        return max;
    }

    public double findRange(){
        return findMax() - findMin();
    }

    public String[] getRawData() {
        return rawData;
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public String getCategoryItem(int index) {
        return categories.elementAt(index);
    }

    public int getCategoriesLength(){ return categories.size(); }

    public String getCategoryPercentage(int index) { return categoryPercentage.elementAt(index).toString() + " %"; }

    public double getDoubleCategoryPercentage(int index) { return categoryPercentage.elementAt(index); }

    public String getLowerClassLimitItem(int i) { return lowerClassLimit.elementAt(i).toString(); }

    public String getUpperClassLimitItem(int i) { return upperClassLimit.elementAt(i).toString(); }

    public String getTrueLowerClassLimitItem(int i) { return trueLowerClassLimit.elementAt(i).toString(); }

    public String getTrueUpperClassLimitItem(int i) { return trueUpperClassLimit.elementAt(i).toString(); }

    public String getMidpointItem(int i) { return midpoints.elementAt(i).toString(); }

    public String getFrequencyItem(int i) { return frequency.elementAt(i).toString(); }

    public Vector<Integer> getFrequency() { return frequency; }

    public String getCFrequencyItem(int i) { return cFrequency.elementAt(i).toString(); }

    public String getClassPercentageItem(int i) { return classPercentage.elementAt(i).toString(); }

    public String getCClassPercentageItem(int i) { return cClassPercentage.elementAt(i).toString(); }

    public int getClassLength() { return lowerClassLimit.size(); }

    public String[] getData() {
        return rawData;
    }


}