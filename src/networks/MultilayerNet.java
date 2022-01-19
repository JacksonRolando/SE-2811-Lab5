package networks;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public abstract class MultilayerNet implements NeuralNetwork {
    private NeuralNetwork prevNetwork;
    private List<Node> layerNodes = new ArrayList<>();
    protected List<Line> linesToPrev = new ArrayList<>();
    private double centerY;
    private double locX;

    public MultilayerNet(NeuralNetwork prevNetwork, int numNodes) {
        this.prevNetwork = prevNetwork;

        double[] prevCenter = prevNetwork.getCenterCoord();
        this.locX = prevCenter[0] + DEFAULT_INTER_LAYER_DISTANCE;
        this.centerY = prevCenter[1];

        double topY = centerY - (((numNodes - 1) * DEFAULT_INTER_CENTER_DISTANCE) / 2);
        for (int i = 0; i < numNodes; i++) {
            layerNodes.add(new Node(locX, topY + i * DEFAULT_INTER_CENTER_DISTANCE));
        }
    }

    @Override
    public double[] getCenterCoord() {
        return new double[] {locX, centerY};
    }

    @Override
    public List<Node> getOutputNodes() {
        return layerNodes;
    }

    @Override
    public void draw(Canvas destination) {
        getOutputNodes().forEach(node -> node.draw(destination));
        linesToPrev.forEach(line -> line.draw(destination));
        prevNetwork.draw(destination);
    }
}
