package networks;

import javafx.scene.canvas.Canvas;

public class Node {
    private final double DEFAULT_RADIUS = 10;

    private double locationX;
    private double locationY;
    private double radius = DEFAULT_RADIUS;

    public Node(double locationX, double locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public Node(double locationX, double locationY, double radius) {
        this(locationX, locationY);
        this.radius = radius;
    }

    public void draw(Canvas destination) {
        destination.getGraphicsContext2D().strokeOval(locationX-DEFAULT_RADIUS,locationY - DEFAULT_RADIUS,
                2*DEFAULT_RADIUS,2*DEFAULT_RADIUS);
    }

    public double getX() {
        return locationX;
    }

    public double getY() {
        return locationY;
    }

    public double getRadius() {
        return radius;
    }
}
