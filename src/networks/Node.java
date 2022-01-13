package networks;

public class Node {
    private double locationX;
    private double locationY;

    public Node(double locationX, double locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public double getX() {
        return locationX;
    }

    public double getY() {
        return locationY;
    }
}
