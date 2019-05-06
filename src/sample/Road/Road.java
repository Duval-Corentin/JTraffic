package sample.Road;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Road {

    private Line line;
    private Pane root;

    public Road() {

    }

    public Road(final Pane root) {

        this.line = new Line();
        this.root = root;

        this.root.getChildren().add(line);
    }

    public void setStart(double xStart, double yStart){
        this.line.setStartX(xStart);
        this.line.setStartY(yStart);
    }

    public void setEnd(double xEnd, double yEnd){
        this.line.setEndX(xEnd);
        this.line.setEndY(yEnd);
    }
}
