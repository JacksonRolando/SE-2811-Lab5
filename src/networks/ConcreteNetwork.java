package networks;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Either implement this class or replace it by a different class (depending on your design).
 */
public class ConcreteNetwork implements NeuralNetwork {

    private ArrayList<Node> layerNodes;

    @Override
    public void draw(Canvas destination) {

    }

    @Override
    public List<Node> getOutputNodes() {
        return layerNodes;
    }
}
