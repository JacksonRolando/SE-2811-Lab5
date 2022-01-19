package networks;

import javafx.scene.canvas.Canvas;

import java.util.List;

public class FullyConnectedNet extends MultilayerNet{

    public FullyConnectedNet(NeuralNetwork prevNetwork, int numNodes) {
        super(prevNetwork, numNodes);
        List<Node> prevNodes = prevNetwork.getOutputNodes();

        for(Node thisNode : getOutputNodes()) {
            for(Node prevNode : prevNodes) {
                linesToPrev.add(new Line(prevNode, thisNode));
            }
        }
    }
}
