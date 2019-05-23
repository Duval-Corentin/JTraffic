package sample.Hub.Crossing;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TrafficLight extends Crossing {

    public TrafficLight(final Pane root, final Pane carPane, final double xPos, final double yPos, final Color color) {
        super(root, carPane, xPos, yPos, color);
    }

    public void update(double t) {

    }
}