package networks;

import javafx.scene.canvas.Canvas;

import java.util.List;

public interface NeuralNetwork {
    public void draw(Canvas destination);
    public List<Node> getOutputNodes();
}
