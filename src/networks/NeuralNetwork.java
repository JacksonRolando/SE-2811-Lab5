package networks;

import javafx.scene.canvas.Canvas;

import java.util.List;

public interface NeuralNetwork {

    final double DEFAULT_INTER_CENTER_DISTANCE = 30;
    final double DEFAULT_INTER_LAYER_DISTANCE = 60;

    public void draw(Canvas destination);
    public List<Node> getOutputNodes();

    default double[] getCenterCoord() {
        List<Node> outNodes = getOutputNodes();
        double[] retCoord = new double[2];
        retCoord[0] = outNodes.get(0).getX();
        retCoord[1] = ( outNodes.get(outNodes.size() - 1).getY() + outNodes.get(0).getY() ) / 2;
        return retCoord;
    };
}
