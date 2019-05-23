package sample.Road;

import javafx.scene.layout.Pane;

public class BigRoad extends Road{

    private int backgroundLineStrokeWidth = 20;

    public BigRoad(final Pane root) {
        super(root);

        this.backgroundLine.setStrokeWidth(this.backgroundLineStrokeWidth);

        Lane lane01 = new Lane(this.root,5);
        Lane lane02 = new Lane(this.root,5);
        Lane lane03 = new Lane(this.root,5);

        Lane lane04 = new Lane(this.root,5);
        Lane lane05 = new Lane(this.root,5);
        Lane lane06 = new Lane(this.root,5);

        this.startToEndLanes.add(lane01);
        this.startToEndLanes.add(lane02);
        this.startToEndLanes.add(lane03);

        this.endToStartLanes.add(lane04);
        this.endToStartLanes.add(lane05);
        this.endToStartLanes.add(lane06);
    }
}
