package sample.Hub.Crossing;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Road.Lane;

public class RightPriority extends Crossing {

    public RightPriority(final Pane root, final Pane carPane, final double xPos, final double yPos, final Color color) {
        super(root, carPane, xPos, yPos, color);
    }

    public void update(double t) {
        for(Lane line : this.outRoads) {
            System.out.println(line);
            if(line.getCars().size() > 0) {
                if(line.getCars().getFirst().getCarProgression() > 0.99) {
                    line.getCars().pop().removeCar();
                    if(this.inRoads.size() > 0) {
                        System.out.println("test");
                        this.inRoads.get( (int) Math.random() * this.outRoads.size()).addCar(t, 12, this.carPane);

                    }

                }
            }
        }

        for(Lane line : this.inRoads) {
            line.update(t);
        }
    }
}
