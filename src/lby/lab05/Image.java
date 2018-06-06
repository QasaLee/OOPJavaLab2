package lby.lab05;

public class Image {
    private int width;
    private int height;
    private int pixels[][];
    private String tag; // Indicates which number it is!
    // Constructor
    public Image(int width, int height, String tag) {
        this.width = width;
        this.height = height;
        this.tag = tag;
        pixels = new int[width][height];
    }
    // Getters and Setters
    public void setColor(int x, int y, int RGB) {
        pixels[y][x] = RGB;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getTag() {
        return tag;
    }
    // MARK: - Get Feature Vector
    public int[] getFeatureVector() {
        int[] featureVector = new int[width * height];
        int i = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                featureVector[i] = pixels[x][y];
                i++;
            }
        }
        return featureVector;
    }
}
