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

    protected Line backgroundLine;
    protected Pane root;


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
        this.backgroundLine.setStartX(xStart);
        this.backgroundLine.setStartY(yStart);

        for(Lane lane : this.startToEndLanes){
            lane.setStart(xStart + 3, yStart + 3);
        }

        for(Lane lane : this.endToStartLanes){
            lane.setEnd(xStart + 3, yStart + 3);
        }
    }

    public void setEnd(double xEnd, double yEnd){
        this.backgroundLine.setEndX(xEnd);
        this.backgroundLine.setEndY(yEnd);

        for(Lane lane : this.startToEndLanes) {
            lane.setEnd(xEnd + 3, yEnd + 3);
        }

        for(Lane lane : this.endToStartLanes){
            lane.setStart(xEnd - 3, yEnd + 3);
        }
    }
}
