package lby.lab05;

public class Distance implements Comparable<Distance> {
    // MARK: - Field
    private String tag;
    private double distance;

    // Constructor
    public Distance(String tag, double distance) {
        this.tag = tag;
        this.distance = distance;
    }

    // MARK: - Getters
    public String getTag() {
        return tag;
    }

    public double getDistance() {
        return distance;
    }

    // MARK: - Implement compareTo() method
    @Override
    public int compareTo(Distance o) {
        if (distance < o.getDistance()) {
            return -1;
        } else if (distance == o.getDistance()) {
            return 0;
        } else if (distance > o.getDistance()) {
            return 1;
        }
        return 0;
    }
}
