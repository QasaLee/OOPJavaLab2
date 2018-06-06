package lby.lab05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class KnnNumber {
    public static void main(String[] args) throws IOException {
        ArrayList<Image> trainingImages = new ArrayList<>();
        ArrayList<Image> testingImages = new ArrayList<>();

        // MARK: - Load Files
        try {
            System.out.println("Loading training data...");
            DatasetImageLoader trainingImageLoader = new DatasetImageLoader("./src/lby/lab05/digits/trainingDigits");
            trainingImages = trainingImageLoader.loadImages();

            System.out.println("Loading testing data...");
            DatasetImageLoader testingImageLoader = new DatasetImageLoader("./src/lby/lab05/digits/testDigits");
            testingImages = testingImageLoader.loadImages();

        } catch (FileNotFoundException e) {
            System.out.println("The specified file doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // MARK: - Classifier
        ImageClassifier imageClassifier = new ImageClassifier(3); // Let's try with 3
        imageClassifier.setTrainingData(trainingImages);

        // MARK: - Test
        int errors = 0;
        int i = 1;

        for (Image testingImage : testingImages) {
            String predictedDigit = imageClassifier.predict(testingImage);

            System.out.print("(" + i + " out of " + testingImages.size() + ") Predicted " + predictedDigit + ", was " + testingImage.getTag());

            if (!testingImage.getTag().equals(predictedDigit)) {
                errors++;
                System.out.print(", so it was an Error!");
            }

            System.out.println();
            i++;
        }

        System.out.println("Accuracy: " + (1 - (double) errors / testingImages.size()) * 100 + "%");

    }
}
