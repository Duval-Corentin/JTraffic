package sample.Hub;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Road.Lane;
import sample.Road.Road;

import java.util.Vector;

public abstract class Hub {

    protected Rectangle rect;

    private double xPos, yPos;

    protected Pane root, carPane;


    protected Vector<Lane> inRoads = new Vector<>();
    protected Vector<Lane> outRoads = new Vector<>();

    public Hub(final Pane root, final Pane carPane, final double xPos, final double yPos) {
        this.root = root;
        this.carPane = carPane;
        this.xPos = xPos;
        this.yPos = yPos;

        this.rect = new Rectangle();
    }

    public abstract void update(double t);

    public double getXPos() {
        return this.xPos;
    }

    public double getYPos() {
        return this.yPos;
    }

    public void addInRoad(final Lane road) {
        road.setStart(this.getXPos(), this.getYPos());
        this.inRoads.add(road);
    }

    public void removeRoad(final Lane road) {
        this.inRoads.remove(road);
        this.outRoads.remove(road);
    }

    public void addOutRoad(final Lane road) {
        road.setEnd(this.getXPos(), this.getYPos());
        this.outRoads.add(road);
    }
}
