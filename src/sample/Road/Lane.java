package sample.Road;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Lane {

    private Pane root;
    private Line line;

    private double xStart, yStart, xEnd, yEnd;


    public Lane(final Pane root) {
        this.root = root;

        this.line.setStroke(Color.BLACK);
        this.line.setStrokeWidth(1);

        this.root.getChildren().add(this.line);
    }

    public void setStart(double xStart, double yStart){
        this.xStart = xStart;
        this.yStart = yStart;

        this.line.setStartX(xStart);
        this.line.setStartY(yStart);
    }

    public void setEnd(double xEnd, double yEnd){
        this.xEnd = xEnd;
        this.yEnd = yEnd;

        this.line.setEndX(xEnd);
        this.line.setEndY(yEnd);
    }

    public double getXStart() {
        return this.xStart;
    }

    public double getyStart() {
        return this.yStart;
    }

    public  double getXEnd() {
        return this.xEnd;
    }

    public double getyEnd() {
        return this.yEnd;
    }
}
