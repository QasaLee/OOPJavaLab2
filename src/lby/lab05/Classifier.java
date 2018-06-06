package lby.lab05;

import java.util.ArrayList;

public interface Classifier<T> {
    void setTrainingData(ArrayList<T> trainingData);
    String predict(T object);
}
