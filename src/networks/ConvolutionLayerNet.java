package networks;

import java.util.List;

public class ConvolutionLayerNet extends MultilayerNet {

    public ConvolutionLayerNet(NeuralNetwork prevNetwork) throws IllegalArgumentException {
        super(prevNetwork, prevNetwork.getOutputNodes().size());
        List<Node> prevNodes = prevNetwork.getOutputNodes();
        int i = 0;
        for(Node node : getOutputNodes()) {
            linesToPrev.add(new Line(prevNodes.get(i), node));
            i++;
        }
    }
}
