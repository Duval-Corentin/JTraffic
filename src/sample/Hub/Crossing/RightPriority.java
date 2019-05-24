package sample.Hub.Crossing;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Road.Lane;

public class RightPriority extends Crossing {

    public RightPriority(final Pane root, final Pane carPane, final double xPos, final double yPos, final Color color) {
        super(root, carPane, xPos, yPos, color);
    }

    public void update(double t) {
        for (Lane line : this.outRoads) {
            if (line.getCars().size() > 0) {
                if (line.getCars().getFirst().getCarProgression() > 0.95) {


                    if (this.inRoads.size() > 0) {

                        Lane randLane = this.inRoads.get( (int) (Math.random() * this.inRoads.size() ) );

                        if (randLane.getLastEnteredCarProgression() > 0.15){
                            line.getCars().pop().removeCar();
                            randLane.addCar(t, 12, this.carPane);
                        }


                    }

                }
            }
        }

        for(Lane line : this.inRoads) {
            line.update(t);
        }
    }
}
