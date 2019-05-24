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
            //System.out.println(line);
            if (line.getCars().size() > 0) {
                if (line.getCars().getFirst().getCarProgression() > 0.99) {


                    if (this.inRoads.size() > 0) {
                        int randLane = (int) Math.random() * this.outRoads.size();

                        if (this.inRoads.get(randLane).getLastEnteredCarProgression() > 0.05) {
                            line.getCars().pop().removeCar();
                            this.inRoads.get(randLane).addCar(t, 12, this.carPane);
                        }


                    }

                }
            }
        }
    }
}
