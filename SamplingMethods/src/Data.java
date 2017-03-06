/**
 * Created by Mikepacs on 3/1/2017.
 */
public class Data {
    private int popSize, sampleSize, dataType;
    private String[] data;
    int samplingType;
    public Data() {
        samplingType = 0;
        popSize = 1;
        sampleSize = 1;
        dataType = 1 ;
    }

    public Data(int samplingType, int popSize, int sampleSize, int dataType) {
        this.samplingType = samplingType;
        this.popSize = popSize;
        this.sampleSize = sampleSize;
        this.dataType = dataType;
    }

    public String getData(int i){
        return data[i];
    }
    public int getSamplingtype() {
        return samplingType;
    }

    public void setSamplingType(int samplingType) {
        this.samplingType = samplingType;
    }

    public int getPopSize() {
        return popSize;
    }

    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public Data process(){
        return this;
    }
}
