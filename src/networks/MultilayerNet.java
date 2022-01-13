package networks;

import java.util.ArrayList;

public abstract class MultilayerNet implements NeuralNetwork {
    private NeuralNetwork prevNetwork;
    private ArrayList<Node> layerNodes;
    private ArrayList<Line> linesToPrev;

    public MultilayerNet(NeuralNetwork prevNetwork, int numNodes) {
        //TODO: make this generate Nodes
        this.prevNetwork = prevNetwork;
    }
}
