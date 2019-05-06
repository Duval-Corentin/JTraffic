package sample.Hub.City;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Hub.Hub;
import javafx.scene.shape.*;


public class City extends Hub {

    private static int width = 200;
    private static int height = 100;

    private Rectangle rect;

    private Pane root;

    public City(final Pane root, final int xPos, final int yPos, final String name, final String color) {

        this.root = root;

        rect = new Rectangle();
        rect.setX(xPos);
        rect.setY(yPos);
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.RED);

        this.root.getChildren().add(this.rect);
    }
}
