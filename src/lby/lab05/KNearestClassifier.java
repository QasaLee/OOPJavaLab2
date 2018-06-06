package lby.lab05;

import java.util.ArrayList;

public abstract class KNearestClassifier<T> implements Classifier<T> {
    // MARK: - Field
    private ArrayList<T> trainingData;
    private int k; // k-nn

    // MARK: - Constructor
    public KNearestClassifier(int k) {
        this.k = k;
    }

    // MARK: - Getter
    public ArrayList<T> getTrainingData() {
        return trainingData;
    }

    public int getK() {
        return k;
    }

    // MARK: - Implement methods form Classifier interface
    @Override
    public void setTrainingData(ArrayList<T> trainingData) {
        this.trainingData = trainingData;
    }

    // MARK: - Helper Methods
    protected double computeDistance(int[] featureVectorA, int[] featureVectorB) {
        double total = 0;
        int vectorLength = featureVectorA.length; //both vectors are the same length (32^2)

        for (int i = 0; i < vectorLength; i++) {
            total += Math.pow(featureVectorA[i] - featureVectorB[i], 2);
        }

        //fun fact - we are computing the distance between two points in a 784 dimensional space.
        //Try to visualise that :)
        return Math.sqrt(total);
    }

}
