package networks;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class SimpleNetwork implements NeuralNetwork {

    private ArrayList<Node> layerNodes = new ArrayList<>();
    double xLocation;
    double yLocation;

    public SimpleNetwork(int numNodes, double xLocation, double yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        for (int i = 0; i < numNodes; i++) {
            layerNodes.add(new Node(xLocation, yLocation + i * DEFAULT_INTER_CENTER_DISTANCE));
        }
    }

    @Override
    public void draw(Canvas destination) {
        layerNodes.forEach(node -> node.draw(destination));
    }

    @Override
    public List<Node> getOutputNodes() {
        return layerNodes;
    }
}
