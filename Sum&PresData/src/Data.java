/**
 * Created by Michael Pacana & Noah Silvio on 3/21/2017.
 */
import java.util.List;
public class Data {
    private String[] data;
    private String briefTitle;
    private boolean isNumericDataType; // true = numerical, false = categorical
    private String[][] addtlData;
    public Data() {
        data = new String[]{"0","1"};
        briefTitle = "adasd";
        isNumericDataType = false;
        addtlData = new String[][]{{"0","1"},{"1","0"}};
    }

    public Data(String[] data, String briefTitle,boolean isNumericDataType) {
        this.data = data;
        this.briefTitle = briefTitle;
        this.isNumericDataType = isNumericDataType;
        if(isNumericDataType){
            processNumericalData();
        }else{
            processCategoricalData();
        }
    }
    public void processNumericalData(){//TODO Noah edit this
        addtlData = new String[6][data.length];
        for(int i =0 ; i <data.length; i++){
            addtlData[0][i] = "1 - 20";
            addtlData[1][i] = "0.5 - 19.5";
            addtlData[2][i] = "1%";//I think ang 3rd kay ang actual data
            addtlData[3][i] = "1";
            addtlData[4][i] = "1%";
            addtlData[5][i] = "1%";
        }
        for(int i =0 ; i <data.length; i++){
            System.out.println("potato"+addtlData[0][i]+"\n");
        }
        System.out.println("info length"+addtlData.length);
    }
    public void processCategoricalData(){//TODO Noah edit this
        addtlData = new String[1][data.length];
        for(int i =0 ; i <data.length; i++){
            addtlData[0][i] = "20%";
        }
        for(int i =0 ; i <data.length; i++){
            System.out.println("potato"+addtlData[0][i]+"\n");
        }
        System.out.println("info length"+addtlData.length);
    }
    public boolean getIsNumericDataType(){
        return isNumericDataType;
    }

    public String[][] getAddtlData() {
        return addtlData;
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