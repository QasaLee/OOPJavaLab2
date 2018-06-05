package lby.lab05;

import java.io.File;
import java.io.IOException;

public class DatasetImageLoader {
    File folder = new File("/Users/m78");
    File[] listOfFiles = folder.listFiles();

    public void loadImages() throws IOException {
        System.out.println(folder.getName());
        for (File file: listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
