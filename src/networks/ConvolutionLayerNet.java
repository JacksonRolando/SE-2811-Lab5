package networks;

import javafx.scene.canvas.Canvas;

import java.util.List;

public class ConvolutionLayerNet extends MultilayerNet {

    public ConvolutionLayerNet(NeuralNetwork prevNetwork, int numNodes) {
        super(prevNetwork, numNodes);
        //TODO: connect them bitches to the previous
    }

    @Override
    public void draw(Canvas destination) {

    }

    @Override
    public List<Node> getOutputNodes() {
        return null;
    }
}
