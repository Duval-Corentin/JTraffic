package sample.Road;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import java.util.Vector;

public class Road {

    private static final Color roadColor = Color.rgb(213, 213, 213);;

    private Vector<Lane> startToEndLane;
    private Vector<Lane> endToStartLane;

    private Pane root;

    private Line line;

    public Road() {
        
    }

    public Road(final Pane root) {

        this.line = new Line();
        this.root = root;

        this.line.setStrokeWidth(20);

        this.line.setStroke(this.roadColor);
        this.line.setStrokeLineCap(StrokeLineCap.BUTT);
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
