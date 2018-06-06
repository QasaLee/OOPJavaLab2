package lby.lab05;

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
        return null;
    }
}
