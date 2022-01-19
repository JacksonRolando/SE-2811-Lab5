package networks;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Line {
    private final double ARROW_LENGTH = 5;
    private Node start;
    private Node end;

    public Line(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public void draw(Canvas destination) {
        GraphicsContext context = destination.getGraphicsContext2D();
        Point2D p1 = new Point2D(start.getX(), start.getY());
        Point2D p2 = new Point2D(end.getX(), end.getY());

        Point2D direction = p2.subtract(p1).normalize();
        Point2D startRad = direction.multiply(start.getRadius());
        Point2D endRad = direction.multiply(end.getRadius());

        Point2D lineStart = p1.add(startRad);
        Point2D lineEnd = p2.subtract(endRad);

        context.strokeLine(lineStart.getX(), lineStart.getY(), lineEnd.getX(), lineEnd.getY());

        Point2D arrowEnd1 = new Point2D((lineEnd.getX() - 7 * direction.getX()) + 4 * direction.getY(), (lineEnd.getY() - 7 * direction.getY()) + 4 * -1 * direction.getX());
        Point2D arrowEnd2 = new Point2D((lineEnd.getX() - 7 * direction.getX()) - 4 * direction.getY(), (lineEnd.getY() - 7 * direction.getY()) - 4 * -1 * direction.getX());

        context.strokeLine(arrowEnd1.getX(), arrowEnd1.getY(), lineEnd.getX(), lineEnd.getY());
        context.strokeLine(arrowEnd2.getX(), arrowEnd2.getY(), lineEnd.getX(), lineEnd.getY());
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }
}
