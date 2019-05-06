package sample.Hub;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Hub {

    protected Rectangle rect;

    protected double xPos, yPos;

    protected Pane root;

    public Hub(final Pane root, final double xPos, final double yPos) {
        this.root = root;
        this.xPos = xPos;
        this.yPos = yPos;

        this.rect = new Rectangle();
    }
}
