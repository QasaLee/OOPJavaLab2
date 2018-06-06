package lby.lab05;

import java.io.*;
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
                Image image = new Image(32, 32, tag);
                BufferedReader in = new BufferedReader(new FileReader(file));
                for (int y = 0; y < 32; y++) {
                    String s = new String();
                    s = in.readLine();
                    for (int x = 0; x < 32; x++) {
                        char c = s.charAt(x);
                        int rgb = c == '0' ? 0 : 1;
                        image.setColor(x, y, rgb);
                    }
                }
                images.add(image);
            }
        }
        return images;
    }

}
