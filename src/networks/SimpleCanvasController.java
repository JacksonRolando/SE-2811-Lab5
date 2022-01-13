/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Decorators
 * Author: Dr. Yoder and _______
 * Date:
 */
package networks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * The controller for the main window.
 *
 * Also manages the networks.
 */
public class SimpleCanvasController {
    @FXML
    private ToggleGroup network;
    @FXML

    private Canvas canvas;

    private Map<String, ConcreteNetwork> displayable_networks = new HashMap<>();

    /** TODO: PLEASE PLEASE find a new home for RADIUS! It doesn't belong as a responsibility of the
     * controller! You might also want to make it variable. */
    private static final double RADIUS = 40;

    @FXML
    private void showNetwork(ActionEvent actionEvent) {
        ToggleButton source = (ToggleButton)actionEvent.getSource();
        String id = source.getId();
        System.out.println("id = " + id);
        // Clear Canvas: https://stackoverflow.com/q/27203671/1048186
        GraphicsContext context = canvas.getGraphicsContext2D();
        System.out.println("canvas.getWidth() = " + canvas.getWidth());
        System.out.println("canvas.getHeight() = " + canvas.getHeight());
        context.setLineWidth(3);
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if(!displayable_networks.containsKey(id)) {
            System.out.println("Warning: Unknown network id:"+id);
        } else {
            System.out.println("DEBUG: Drawing network: "+id);
            ConcreteNetwork network = displayable_networks.get(id);

            //TODO: Delete this example code
            drawNode(canvas, 100,100);
            drawNode(canvas, 300,400);
            drawEdge(canvas, 100, 100, 300, 400);
            //ENDTODO

            network.draw(canvas);
        }
    }

    @FXML
    private void initialize() {
        displayable_networks.put("alexLike", createAlexNet());
        displayable_networks.put("inceptionLike", createInception());
    }

    /**
     * As client code, use the decorator classes to construct the inception-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private ConcreteNetwork createInception() {
        return null; // TODO return the network
    }

    /**
     * As client code, use the decorator classes to construct the AlexNet-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private ConcreteNetwork createAlexNet() {
        return null; // TODO return the network
    }


    /**
     * Draw a node centered on the given location.
     * @param canvas canvas on which to draw this.
     * @param x center of the node
     * @param y center of the node
     */
    /** TODO: PLEASE PLEASE find a new home for drawNode. It doesn't belong as a responsibility of the
     *  controller! The name and parameters probably need updating as well.
     */
    public static void drawNode(Canvas canvas, int x, int y){
        canvas.getGraphicsContext2D().strokeOval(x-RADIUS,y-RADIUS,2*RADIUS,2*RADIUS);
    }

    /**
     * Draw an edge between two nodes.
     *
     * @param canvas
     * @param x1 center of first node
     * @param y1
     * @param x2 center of second node
     * @param y2
     */
    /** TODO: PLEASE PLEASE find a new home for drawEdge. It doesn't belong as a responsibility of the
     *  controller! The name and parameters probably need updating as well.
     *  Drawing arrows on the edges is not a requirement.
     */
    public static void drawEdge(Canvas canvas, double x1, double y1, double x2, double y2) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        Point2D p1 = new Point2D(x1, y1);
        Point2D p2 = new Point2D(x2, y2);
        Point2D direction = p2.subtract(p1).normalize();
        Point2D radius = direction.multiply(RADIUS);
        Point2D start = p1.add(radius);
        Point2D end = p2.subtract(radius);
        context.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
