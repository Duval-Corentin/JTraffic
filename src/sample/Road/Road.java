package sample.Road;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import java.util.Vector;

public class Road {


    private static final Color roadColor = Color.rgb(213, 213, 213);;

    protected Vector<Lane> startToEndLanes = new Vector<>();
    protected Vector<Lane> endToStartLanes = new Vector<>();

    protected double xStart, yStart, xEnd, yEnd;

    protected Line backgroundLine;
    protected Pane root;

    private double orientation;

    public Road() {
        
    }

    public Road(final Pane root) {

        this.root = root;

        this.backgroundLine = new Line();
        this.backgroundLine.setStroke(Color.LIGHTGRAY);
        this.backgroundLine.setStrokeLineCap(StrokeLineCap.BUTT);

        this.root.getChildren().add(backgroundLine);
    }

    public void setStart(double xStart, double yStart){
        this.xStart = xStart;
        this.yStart = yStart;

        this.backgroundLine.setStartX(xStart);
        this.backgroundLine.setStartY(yStart);

        this.updateOrientation();

        for(Lane lane : this.startToEndLanes){
            lane.setStart(xStart + Math.sin(this.orientation) * 5, yStart + Math.cos(this.orientation) * 5);
        }

        for(Lane lane : this.endToStartLanes){
            lane.setEnd(xStart - Math.sin(this.orientation) * 5, yStart - Math.cos(this.orientation) * 5);
        }
    }

    public void setEnd(double xEnd, double yEnd){
        this.xEnd = xEnd;
        this.yEnd = yEnd;

        this.backgroundLine.setEndX(xEnd);
        this.backgroundLine.setEndY(yEnd);

        this.updateOrientation();

        for(Lane lane : this.startToEndLanes) {
            lane.setEnd(xEnd + Math.sin(this.orientation) * 5, yEnd + Math.cos(this.orientation) * 5);
        }

        for(Lane lane : this.endToStartLanes){
            lane.setStart(xEnd-  Math.sin(this.orientation) * 5, - Math.cos(this.orientation) * 5);
        }
    }

    private void updateOrientation() {
        this.orientation = Math.atan( (this.yEnd - this.yStart) / (this.xEnd - this.xStart));
    }
}
