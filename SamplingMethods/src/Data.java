/**
 * Created by Michael Pacana & Noah Silvio on 2/23/2017.
 */
import java.util.Random;
import java.util.Arrays;
import java.util.Vector;
public class Data {
    private int sampleSize, popSize, dataType, samplingType, SIMPLE_RANDOM = 1, SYSTEMATIC_RANDOM = 2, STRATIFIED = 3;
    private String[] population, samples;
    public int alfred;
    private Vector<String> strataPopulation = new Vector <>();
    private Vector<Vector<String> > strataList = new Vector<>();

    public Data (int samplingType,  int popSize,  int sampleSize, int dataType) {
        this.samplingType =  samplingType;
        this.dataType = dataType;
        this.popSize = popSize;
        this.sampleSize = sampleSize;

        if(samplingType != 3)
            samples = new String[sampleSize];
        else
            samples = new String[popSize+1];
        System.out.println(samplingType);
    }
    public int getSamplingType(){
        return samplingType;
    }
    public void process () {
        Random rand = new Random();
        if(samplingType == SIMPLE_RANDOM) {
            for(int i = 0; i < sampleSize; i++) {
                int randomNumber = rand.nextInt(popSize);
                System.out.println("random number is "+ randomNumber);

                samples[i] = new String(population[randomNumber]);
                System.out.println("samples is "+samples[i]+" with index "+i+"\n");

            }
            //TODO send the samples somewhere
        } else if (samplingType == SYSTEMATIC_RANDOM) {
            int divisions = popSize/sampleSize;
            int randomNumber = rand.nextInt(divisions);
            for(int i = 0; i < sampleSize; i++) {
                samples[i] = new String(population[randomNumber]);
                randomNumber += divisions;
            }
            //TODO send the sample
        } else if (samplingType == STRATIFIED) {
            Arrays.sort(population);


            int strataIndex = -1;
            String currentStrata = "";

            for (int i = 0; i < popSize; i++) {

                if(population[i].compareTo(currentStrata) != 0) {
                    currentStrata = population[i];
                    //declare new strataPopulation for new Strata
                    strataPopulation = new Vector<>();
                    strataPopulation.addElement(population[i]);

                    //add newly declared strata to strataList
                    strataList.addElement(strataPopulation);
                    strataIndex++;

                    //strataPopulation
                } else {
                    strataList.elementAt(strataIndex).addElement(population[i]);
                }
            }

            for(int i = 0; i <strataList.size(); i++) {
                for(int j = 0; j < strataList.elementAt(i).size(); j++) {
                    System.out.println("STRATA " + i + " ELEMENT: " + strataList.elementAt(i).elementAt(j));
                }
            }

            int k = 0;

            for(int i = 0; i < strataList.size(); i++) {
                //this is assuming sampleSize is a value from 1 - 99 bc it's a percentage
                double alfred = (((double)(sampleSize*strataList.elementAt(i).size()))/100);
                System.out.println("pota"+alfred);
                int temp =1;
                if(alfred %1 ==0){
                    temp =0;
                }
                int a = (int)(alfred +temp);
                System.out.println(a + "final alfred");
                System.out.println(a + " <-a");
                for(int j = 0; j < a; j++, k++) {//TODO
                    int randomNumber = rand.nextInt(strataList.elementAt(i).size());
                    samples[k] = new String(strataList.elementAt(i).elementAt(randomNumber));
                }
            }
            int j;
            for (j = 0; samples[j]!=null; j++){
                System.out.println("index " + j + ": " + samples[j]);
            }
            alfred = j- 1;
        } else {
            System.out.println("This isn't supposed to happen. WTF.");
        }
    }

    public int getStrataNum(){
        return strataList.size();
    }
    public void clear(){
        sampleSize = popSize = dataType = samplingType = 0;
        population = samples = new String[1];
    }

    public String getSample (int i) {
        return samples[i];
    }

    public void setData (String[] population) {
        this.population = population;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public int getPopSize() { return popSize; }

    public int getDataType() {
        return dataType;
    }

    public String displayAll() {
        String a = "";
        for(int i = 0; i < strataList.size(); i++) {
            a = a + "STRATA " + (i+1) + "\n";
            for(int j = 0; j < strataList.elementAt(i).size(); j++) {
                a = a + "INDEX " + (j+1) + ": " + strataList.elementAt(i).elementAt(j) + "\n";
            }
            a = a + "\n";
        }

        return a;
    }
}