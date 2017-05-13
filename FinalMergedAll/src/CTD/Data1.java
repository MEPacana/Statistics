package CTD;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Michael Ervin Pacana and Noah Silvio on 4/26/2017.
 */
public class Data1 {

    private String shrtDesc;
    private String[] data;
    private Double[] dData;
    private boolean isFloat;
    private int ctdChoice;
    private boolean isUngrouped;

    //for Grouped
    private String[] upperClassLimits;
    private String[] lowerClassLimits;
    private Vector<Double> frequency = new Vector<>();
    private Vector<Double> midpoints = new Vector<>();
    private Vector<Double> freqTimesMidpt = new Vector<>();
    private Vector<Double> freqTimesMidptSqr = new Vector<>();
    boolean isOpenEnded;
    int opentype;

    public int getOpentype() {
        return opentype;
    }

    public void setOpentype(int opentype) {
        this.opentype = opentype;
    }

    private int classIntervals;

    public void erase() {
        String[] eraseData = {""};
        shrtDesc = "";
        isFloat = isUngrouped = false;
        data = upperClassLimits = lowerClassLimits = eraseData;
        classIntervals = ctdChoice = 0;
        //idk how to initialize double
    }

    public int getClassIntervals() {
        return classIntervals;
    }

    public void setClassIntervals(int classIntervals) {
        this.classIntervals = classIntervals;
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
        if(isUngrouped && ctdChoice ==0){
            return ugetSDVar();
        }else if(isUngrouped && ctdChoice ==1) {
            return ugetMedian();
        }else if(isUngrouped && ctdChoice ==2){
            return ugetModeType();
        }else if(isUngrouped && ctdChoice ==3){
            return ugetEverything();
        }else if(!isUngrouped && ctdChoice ==0){
            String[] sdvar = new String[1];
            if(opentype == 1 || opentype == 2 || opentype == 3)
                sdvar[0] = "SD and Variance cannot be calculated.";
            else
                sdvar[0] = "SD: "+gSD()+" Variance: "+gVariance();
            return sdvar;
        }else if(!isUngrouped && ctdChoice ==1) {
            String[] med = new String[1];
            med[0] = "-------------";
            return med;
        }else if(!isUngrouped && ctdChoice ==2){
            String[] md = new String[1];
            if(gMode().size() == 0){
                md[0] = "NO MODE";
            }else if(gMode().size() == 1){
                md[0] = "UNIMODAL";
            }else if(gMode().size() == 2){
                md[0] = "BIMODAL";
            }else if(gMode().size() == 3){
                md[0] = "MULTIMODAL";
            }
            return md;
        }else if(!isUngrouped && ctdChoice ==3){
            String[] everything = new String[3];

            if(opentype == 1 || opentype == 2 || opentype == 3)
                everything[0] = "SD and Variance cannot be calculated.";
            else
                everything[0] = "SD: "+gSD()+" Variance: "+gVariance();
            everything[1] = "--------------------";
            if(gMode().size() == 0){
                everything[2] = "NO MODE";
            }else if(gMode().size() == 1){
                everything[2] = "UNIMODAL";
            }else if(gMode().size() == 2){
                everything[2] = "BIMODAL";
            }else if(gMode().size() == 3){
                everything[2] = "MULTIMODAL";
            }
            return everything;
        }
        return solution;
    }

    public String[] ugetEverything(){
        String[] solution = new String[4];
        Double var = getVariance();
        Double sd = Math.sqrt(var);
        solution[0] = "Variance:" + var + " SD: "+sd;
        Double[] srtdData = sort(dData);
        Double range = srtdData[0] - srtdData[srtdData.length-1];
        String sorted = "";

        for(int i = 0; i <srtdData.length;i++){
            if(isFloat()){
                sorted = sorted + " " + srtdData[i];
            }else{
                sorted = sorted + " " + srtdData[i].intValue();
            }
        }

        solution[1] = sorted;
        solution[2] = "RANGE: "+String.valueOf(range);

        boolean srtd = true;
        Double temp;
        while (srtd) {
            srtd = false;
            for (int i = 0; i < dData.length - 1; i++)
                if (dData[i] > dData[i + 1]) {
                    temp = dData[i];
                    dData[i] = dData[i + 1];
                    dData[i + 1] = temp;
                    srtd = true;
                }
        }
        int count,max;
        count = 1;
        max = 0;
        Double tempMode = dData[0];
        for(int i = 0; i+1 < dData.length ; i++){
            //System.out.println(dData[i+1]+" compared with "+dData[i]);
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                //System.out.println(count+" compared with "+max);
                count = 1;
            }
            if(count > max){
                tempMode =dData[i];
                max =count;
            }
        }
        Vector<Double> modecollect = new Vector<Double>();
        modecollect.add(tempMode);
        count = 1;
        for(int i = 0; i+1 < dData.length ; i++){
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                count = 1;
            }
            if(count == max){
                if(!modecollect.contains(dData[i])) {
                    modecollect.add(dData[i]);
                }
            }
        }
        if(max ==1 ){
            solution[3] ="NO MODE";
        }
        else if(modecollect.size() == 1){
            solution[3] = "UNIMODAL";
        }else if(modecollect.size() == 2){
            solution[3] = "BIMODAL";
        }
        else if(modecollect.size() >= 3){
            solution[3] = "MULTIMODAL";
        }

        return solution;
    }

    public String[] ugetSDVar(){
        Double var = getVariance();
        Double sd = Math.sqrt(var);
        String[] solution = new String[1];
        solution[0] = "Variance:" + var + " SD: "+sd;
        return solution;
    }

    public String[] ugetMedian(){
        String[] solution = new String[2];
        Double[] srtdData = sort(dData);
        Double range = srtdData[0] - srtdData[srtdData.length-1];
        String sorted = "";

        for(int i = 0; i <srtdData.length;i++){
            if(isFloat()){
                sorted = sorted + " " + srtdData[i];
            }else{
                sorted = sorted + " " + srtdData[i].intValue();
            }
        }

        solution[0] = sorted;
        solution[1] = "RANGE: "+String.valueOf(range);
        return solution;
    }

    public Double[] sort(Double[] num){
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        Double temp;   //holding variable

        while ( flag )
        {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < num.length -1;  j++ )
            {
                if ( num[ j ] < num[j+1] )   // change to > for ascending sort
                {
                    temp = num[ j ];                //swap elements
                    num[ j ] = num[ j+1 ];
                    num[ j+1 ] = temp;
                    flag = true;              //shows a swap occurred
                }
            }
        }
        return num;
    }
    public Vector<Double> getMidpoint() { return midpoints; }
    public Double getVariance(){
        double mean = uMean();
        double temp = 0;
        for(double a :dData)
            temp += (a-mean)*(a-mean);
        return temp/dData.length;
    }

    public String getAns() {
        if(isUngrouped && ctdChoice ==0){
            return "The MEAN is "+String.valueOf(uMean());
        }else if(isUngrouped && ctdChoice ==1) {
            return uMedian();
        }else if(isUngrouped && ctdChoice ==2){
            return uMode();
        }
        else if(isUngrouped && ctdChoice ==3){

            return "The MEAN is "+String.valueOf(uMean());
        }else if(!isUngrouped && ctdChoice ==0){
            if(opentype == 1 || opentype == 2 || opentype == 3)
                return "MEAN cannot be calculated because it is open-ended.";
            else
                return "The MEAN is "+String.valueOf(uMean()) + "\n"
                        + uMedian() +"\n" + uMode();
        }else if(!isUngrouped && ctdChoice ==1) {
            return "The MEDIAN is "+String.valueOf(gMedian());
        }else if(!isUngrouped && ctdChoice ==2){
            return "The MODE is "+String.valueOf(gMode());
        }
        else if(!isUngrouped && ctdChoice ==3){
            if(opentype == 1 || opentype == 2 || opentype == 3)
                return "The MEAN cannot be calculated" + "\n"
                        + "The MEDIAN: "+String.valueOf(gMedian()) +"\n"
                        + "The MODE: "+String.valueOf(gMode());
            else
                return "The MEAN: "+String.valueOf(gMean()) + "\n"
                        + "The MEDIAN: "+String.valueOf(gMedian()) +"\n"
                        + "The MODE: "+String.valueOf(gMode());

        }
        return "answer";
    }
    public Double uMean(){
        double sum = 0;
        for (int i = 0; i < dData.length; i++) {
            sum += dData[i];
        }
        double ans =  sum / dData.length;
        return ans;
    }
    public String uMedian(){
        Double ans;
        int middle = dData.length/2;
        if (dData.length%2 == 1) {
            if(isFloat()) {
                ans = dData[middle];
            }else{
                return "The MEDIAN is "+String.valueOf(dData[middle].intValue());
            }
        } else {
            ans = (dData[middle-1] + dData[middle]) / 2.0;
        }
        return "The MEDIAN is "+String.valueOf(ans);
    }
    public String uMode() {
        boolean sorted = true;
        Double temp;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < dData.length - 1; i++)
                if (dData[i] > dData[i + 1]) {
                    temp = dData[i];
                    dData[i] = dData[i + 1];
                    dData[i + 1] = temp;
                    sorted = true;
                }
        }
        int count,max;
        count = 1;
        max = 0;
        Double tempMode = dData[0];
        for(int i = 0; i+1 < dData.length ; i++){
            //System.out.println(dData[i+1]+" compared with "+dData[i]);
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                //System.out.println(count+" compared with "+max);
                count = 1;
            }
            if(count > max){
                tempMode =dData[i];
                max =count;
            }
        }
        Vector<Double> modecollect = new Vector<Double>();
        modecollect.add(tempMode);
        count = 1;
        for(int i = 0; i+1 < dData.length ; i++){
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                count = 1;
            }
            if(count == max){
                if(!modecollect.contains(dData[i])) {
                    modecollect.add(dData[i]);
                }
            }
        }
        String modes = "MODE: ";
        if(max == 1){
            modes = modes + "----------";
        }else {
            for (int i = 0; i < modecollect.size(); i++) {
                if(isFloat()) {
                    modes = modes + " " + modecollect.get(i);
                }else{
                    modes = modes + " " + modecollect.get(i).intValue();
                }
            }
        }
        return modes;
    }

    public String[] ugetModeType() {
        boolean sorted = true;
        Double temp;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < dData.length - 1; i++)
                if (dData[i] > dData[i + 1]) {
                    temp = dData[i];
                    dData[i] = dData[i + 1];
                    dData[i + 1] = temp;
                    sorted = true;
                }
        }
        int count,max;
        count = 1;
        max = 0;
        Double tempMode = dData[0];
        for(int i = 0; i+1 < dData.length ; i++){
            //System.out.println(dData[i+1]+" compared with "+dData[i]);
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                //System.out.println(count+" compared with "+max);
                count = 1;
            }
            if(count > max){
                tempMode =dData[i];
                max =count;
            }
        }
        Vector<Double> modecollect = new Vector<Double>();
        modecollect.add(tempMode);
        count = 1;
        for(int i = 0; i+1 < dData.length ; i++){
            if(dData[i+1].equals(dData[i])){
                count++;
            }else{
                count = 1;
            }
            if(count == max){
                if(!modecollect.contains(dData[i])) {
                    modecollect.add(dData[i]);
                }
            }
        }
        String[] modes = {""};
        if(max ==1 ){
            modes[0] ="NO MODE";
        }
        else if(modecollect.size() == 1){
            modes[0] = "UNIMODAL";
        }else if(modecollect.size() == 2){
            modes[0] = "BIMODAL";
        }
        else if(modecollect.size() >= 3){
            modes[0] = "MULTIMODAL";
        }
        return modes;
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
    public String uVariance (){
        double numerator = 0;

        for(int i = 0 ; i < dData.length; i++) {
            numerator += Double.valueOf(dData[i]) - Double.valueOf(uMean());
        }

        numerator *= numerator;

        return String.valueOf(numerator/(dData.length-1));
    }

    public String uSD() {
        return String.valueOf(Math.sqrt(Double.valueOf(uVariance())));
    }

    public double gMean () {
        double mean = (double)0;
        makeFreqTimeMidpt();

        mean = total(freqTimesMidpt)/total(frequency);
        System.out.println(mean);
        return mean;
    }

    //this returns a vector of index of the modal classes
    public Vector<Integer> gMode () {
        Vector<Integer> modes = new Vector<>();
        modes.add(0);
        Double modalValue = frequency.elementAt(modes.elementAt(0));

        if(frequency.size() > 0) {
            for (int i = 1; i < frequency.size(); i++) {
                System.out.println("currFreq" + frequency.elementAt(i) + "   modal Value" + modalValue);
                if (frequency.elementAt(i).equals(modalValue)) {
                    System.out.println("==");
                    modes.add(i);
                } else if (frequency.elementAt(i) > modalValue) {
                    System.out.println(">");
                    modes.clear();
                    modalValue = frequency.elementAt(i);
                    modes.add(i);
                }
            }
        }

        return modes;
    }

    public String gMedian() {
        return "Median not computed.";
    }

    public double gVariance(){
        makeFreqTimeMidptSqrr();
        double variance;

        Double sumFXm2 = total(freqTimesMidptSqr);
        Double sumFXm = total(freqTimesMidpt);
        Double totalFreq = total(frequency);

        variance = totalFreq*sumFXm2 - sumFXm*sumFXm;
        variance = variance/(totalFreq*(totalFreq - 1));
        return variance;
    }

    public double gSD(){
        double sd = Math.sqrt(gVariance());
        return sd;
    }

    public void makeMidpoints () {
        midpoints.clear();
        for(int i = 0; i < upperClassLimits.length; i++) {
            midpoints.add((Double.valueOf(upperClassLimits[i]) + Double.valueOf(lowerClassLimits[i]))/2);
        }
    }


    public void makeFreqTimeMidpt() {
        freqTimesMidpt.clear();
        for(int i = 0; i < frequency.size(); i++) {
            freqTimesMidpt.add(frequency.elementAt(i) * midpoints.elementAt(i));
        }
    }

    public void makeFreqTimeMidptSqrr() {
        freqTimesMidptSqr.clear();
        for(int i = 0; i < frequency.size(); i++) {
            freqTimesMidptSqr.add(frequency.elementAt(i) * midpoints.elementAt(i) * midpoints.elementAt(i));
        }
    }

    public Double total(Vector<Double> someNumbers) {
        Double sum = Double.valueOf(0);

        for(int i = 0; i< someNumbers.size(); i++) {
            sum = sum + someNumbers.elementAt(i);
        }

        return sum;
    }

    public String[] getFrequency() {
        String[] freqStr = new String[frequency.size()];
        for(int i = 0; i < frequency.size(); i++) {
            freqStr[i] = String.valueOf(frequency.elementAt(i));
        }
        return freqStr;
    }

    public void setFrequency(String[] frequencyStr) {
        Vector<String> temp = new Vector<>(Arrays.asList(frequencyStr));
        for(int i = 0 ; i < temp.size(); i++) {
            try{
                frequency.set(i, Double.valueOf(temp.elementAt(i)));
            } catch (Exception e) {
                frequency.add(Double.valueOf(temp.elementAt(i)));
            }
        }
    }

    public double getTotalFX() { return total(freqTimesMidpt); }

    public double getTotalFX2() { return total(freqTimesMidptSqr); }


}
