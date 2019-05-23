package sample.Road;

import javafx.scene.layout.Pane;

public class SmallRoad extends Road {

    private int backgroundLineStrokeWidth = 10;

    public SmallRoad(final Pane root) {
        super(root);

        this.backgroundLine.setStrokeWidth(this.backgroundLineStrokeWidth);

        Lane lane01 = new Lane(this.root);

        Lane lane02 = new Lane(this.root);

        this.startToEndLanes.add(lane01);
        this.endToStartLanes.add(lane02);
    }
}
