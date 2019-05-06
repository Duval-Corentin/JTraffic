package sample.Hub.Crossing;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import sample.Hub.Hub;

public abstract class Crossing extends Hub {

    private static double width = 20;
    private static double height = 20;
    private static double arcWidth = 5;

    public Crossing(final Pane root, final double xPos, final double yPos, final Color color) {

        super(root, xPos, yPos);

        this.rect.setX(xPos - width/2);
        this.rect.setY(yPos - height/2);
        this.rect.setWidth(width);
        this.rect.setHeight(height);
        this.rect.setArcWidth(arcWidth);
        this.rect.setArcHeight(arcWidth);
        this.rect.setFill(color);

        this.root.getChildren().add(this.rect);
    }
}
