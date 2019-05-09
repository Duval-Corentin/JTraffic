package sample.Hub;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Road.Road;

import java.util.Vector;

public class Hub {

    protected Rectangle rect;

    private double xPos, yPos;

    protected Pane root;

    private Vector<Road> roads = new Vector<>();

    public Hub(final Pane root, final double xPos, final double yPos) {
        this.root = root;
        this.xPos = xPos;
        this.yPos = yPos;

        this.rect = new Rectangle();
    }

    public double getXPos() {
        return this.xPos;
    }

    public double getYPos() {
        return this.yPos;
    }

    public void addInRoad(final Road road) {
        road.setStart(this.getXPos(), this.getYPos());
        this.roads.add(road);
    }

    public void removeRoad(final Road road) {
        this.roads.remove(road);
    }

    public void addOutRoad(final Road road) {
        road.setEnd(this.getXPos(), this.getYPos());
        this.roads.add(road);
    }
}
