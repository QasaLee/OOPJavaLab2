package lby.lab05;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetImageLoader {

    // MARK: - DataInputStream
    private DataInputStream datasetInputStream;

    File folder = new File("./src/lby/lab05/digits/trainingDigits");
    File[] listOfFiles = folder.listFiles();

    public ArrayList<Image> loadImages() throws IOException {

        ArrayList<Image> images = new ArrayList<>();

        System.out.println(folder.getName()); // DEBUG

        for (File file: listOfFiles) {
            if (file.isFile()) {
                // Get Tag
                String tag = file.getName().substring(0, 1);
                System.out.println(tag); // DEBUG
                Image image = new Image(32, 32, tag);

                // DEBUG
                FileReader fr =
                        new FileReader(file);

                int i;
                while ((i=fr.read()) != -1)
                    System.out.print((char) i);
                //

                for (int y = 0; y < 32; y++) {
                    for (int x = 0; x < 32; x++) {
                        int rgb = fr.read();
                        image.setColor(x, y, rgb);
                    }
                }
                images.add(image);
            }
        }

        return images;
    }

}
