package lby.lab05;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageClassifier extends KNearestClassifier<Image> {

    // MARK: - Constructors
    public ImageClassifier(int k) {
        super(k);
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

        // MARK: - Experiment to find optimized K
        distances.removeAll(distances.subList(getK(), distances.size()));
//        distances.removeAll(distances.subList(9, distances.size())); // K == 9
//        distances.removeAll(distances.subList(8, distances.size())); // K == 8
//        distances.removeAll(distances.subList(7, distances.size())); // K == 7
//        distances.removeAll(distances.subList(6, distances.size())); // K == 6
//        distances.removeAll(distances.subList(5, distances.size())); // K == 5
//        distances.removeAll(distances.subList(4, distances.size())); // K == 4
//        distances.removeAll(distances.subList(3, distances.size())); // K == 3

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
