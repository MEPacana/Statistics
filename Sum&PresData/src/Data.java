/**
 * Created by Michael Pacana & Noah Silvio on 3/21/2017.
 */
import java.util.List;
public class Data {
    private String[] data;
    private String briefTitle;
    private boolean isNumericDataType; // true = numerical, false = categorical
    private String[][] addtlData;
    private int rowNum;
    public Data() {
        data = new String[]{"0","1"};
        briefTitle = "adasd";
        isNumericDataType = false;
        addtlData = new String[][]{{"0","1"},{"1","0"}};
        rowNum = 2;
    }
    public Data(String[] data, String briefTitle,boolean isNumericDataType) {
        this.data = data;
        this.briefTitle = briefTitle;
        this.isNumericDataType = isNumericDataType;
        if(isNumericDataType){
            processNumericalData();
            rowNum = 7;
        }else{
            processCategoricalData();
            rowNum = 2;
        }
    }
    public int getRow(){
        return rowNum;
    }
    public void processNumericalData(){//TODO Noah edit this
        int numOfClasses,range,classWidth;
        double tempDouble;
        tempDouble = 1 + (3.322 * Math.log10(data.length));/*
        System.out.println(Math.log10(data.length));
        System.out.println((Math.log10(data.length)*3.322));*/
        if(tempDouble%1 !=0){tempDouble++;}
        numOfClasses =(int)(tempDouble);
        range = findRange();

        classWidth = Math.round(range / numOfClasses);/*
        System.out.println("class size is"+numOfClasses);*/
        addtlData = new String[data.length][6];

        for(int i =0 ; i <data.length; i++){
            addtlData[i][0] = "1 - 20";
            addtlData[i][1] = "0.5 - 19.5";
            addtlData[i][2] = "1%";//I think ang 3rd kay ang actual data
            addtlData[i][3] = "1";
            addtlData[i][4] = "1%";
            addtlData[i][5] = "1%";
        }
    }

    public void processCategoricalData(){//TODO Noah edit this
        addtlData = new String[data.length][1];
        for(int i =0 ; i <data.length; i++){
            addtlData[i][0] = "20%";
        }
    }
    public boolean getIsNumericDataType(){
        return isNumericDataType;
    }

    public String[][] getAddtlData() {
        return addtlData;
    }

    public int findRange(){
        int min, max,temp;
        min = max = Integer.parseInt(data[0]);
        for(int i = 0 ; i < data.length;i++){
            if((temp = Integer.parseInt(data[i]))< min){
                min = temp;
            }else if((temp = Integer.parseInt(data[i]))> max){
                max = temp;
            }
        }
        return max - min;
    }
    public void setAddtlData(String[][] addtlData) {
        this.addtlData = addtlData;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle;
    }
}