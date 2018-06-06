package lby.lab05;

import java.util.ArrayList;
import java.util.HashMap;

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

        distances.sort(null); // A null value indicates that the elements' natural ordering should be used

        // TODO: - Need to figure out
        distances.removeAll(distances.subList(getK(), distances.size()));

        HashMap<String, Integer> tagCount = new HashMap<>();

        for (Distance distance : distances) {
            tagCount.putIfAbsent(distance.getTag(), 0);
            tagCount.put(distance.getTag(), tagCount.get(distance.getTag()) + 1);
        }

        return getMostCommonTag(tagCount);
    }

    // MARK: - Helper Method
    private String getMostCommonTag(HashMap<String, Integer> map) {
        Integer maxValue = 0;

        for (String tag : map.keySet()) {
            if (map.get(tag) > maxValue) {
                maxValue = map.get(tag);
            }
        }

        for (String tag : map.keySet()) {
            if (map.get(tag).equals(maxValue)) {
                return tag;
            }
        }

        return null;
    }
}
