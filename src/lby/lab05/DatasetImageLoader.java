package lby.lab05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetImageLoader {

    File folder = new File("./src/lby/lab05/digits/trainingDigits");
    File[] listOfFiles = folder.listFiles();

    public void loadImages() throws IOException {

        ArrayList<Image> images = new ArrayList<>();

        System.out.println(folder.getName());
        for (File file: listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
