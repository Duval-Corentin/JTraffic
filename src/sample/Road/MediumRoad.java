package sample.Road;

import javafx.scene.layout.Pane;

public class MediumRoad extends Road{

    private int backgroundLineStrokeWidth = 15;

    public MediumRoad(final Pane root) {
        super(root);

        this.backgroundLine.setStrokeWidth(this.backgroundLineStrokeWidth);

        Lane lane01 = new Lane(this.root,7);
        Lane lane02 = new Lane(this.root,7);

        Lane lane03 = new Lane(this.root,7);
        Lane lane04 = new Lane(this.root,7);

        this.startToEndLanes.add(lane01);
        this.startToEndLanes.add(lane02);

        this.endToStartLanes.add(lane03);
        this.endToStartLanes.add(lane04);

    }
}
