package lby.lab05;

import java.util.ArrayList;

public class ImageClassifier extends KNearestClassifier<Image> {

    // MARK: - Constructors
    public ImageClassifier(int k) {
        super(k);
    }
    // Default one
    public ImageClassifier() {
        super(3);
    }

    // MARK: - Implement Methods from Classifier interface
    @Override
    public String predict(Image image) {
        ArrayList<Distance> distances = new ArrayList<>();

        for (Image trainingImage : getTrainingData()) {
            double computedDistance = this.computeDistance(trainingImage.getFeatureVector(), image.getFeatureVector());
            Distance distance = new Distance(trainingImage.getTag(), computedDistance);

            distances.add(distance);
        }

        return null;
    }
}
