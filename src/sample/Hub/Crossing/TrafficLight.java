package sample.Hub.Crossing;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TrafficLight extends Crossing {

    public TrafficLight(final Pane root, final double xPos, final double yPos, final Color color) {
        super(root, xPos, yPos, color);
    }
}