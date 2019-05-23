package sample.Road;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.Car.Car;

import java.util.LinkedList;

public class Lane {


    //graphic attributes
    private Pane root;
    private Line line;

    //attributes relative to cars
    private LinkedList<Car> garage;
    private static final double stackingThreshold = 15.0; //give the allowed distance between two cars.


    //lane attributes
    private double xStart, yStart, xEnd, yEnd;
    private static double laneSpeedLimit = 8;


    public Lane(final Pane root) {
        this.root = root;

        this.line = new Line();

        this.line.setStroke(Color.BLACK);
        this.line.setStrokeWidth(1);

        this.root.getChildren().add(this.line);

        //car stuff
        this.garage = new LinkedList<>();
    }

    public void setStart(double xStart, double yStart){
        this.xStart = xStart;
        this.yStart = yStart;

        this.line.setStartX(xStart);
        this.line.setStartY(yStart);
    }

    public void setEnd(double xEnd, double yEnd){
        this.xEnd = xEnd;
        this.yEnd = yEnd;

        this.line.setEndX(xEnd);
        this.line.setEndY(yEnd);
    }

    public LinkedList<Car> getCars() {
        return this.garage;
    }

    public double getStackingThreshold() {
        return this.stackingThreshold;
    }

    public double getXStart() {
        return this.xStart;
    }

    public double getyStart() {
        return this.yStart;
    }

    public  double getXEnd() {
        return this.xEnd;
    }

    public double getyEnd() {
        return this.yEnd;
    }

    //methods relative to cars

    public void addCar(double t, double carSpeed, Pane pane){

        this.garage.add(new Car(this.xStart, this.yStart, this.xEnd, this.yEnd, this.laneSpeedLimit, carSpeed, t, pane));
    }

    public void update(double t){

        for(int i = 0; i<garage.size(); i++) {
            if(i + 1 < garage.size()){
                Point2D c0 = garage.get(i).getPosition();
                Point2D c1 = garage.get(i+1).getPosition();
                double dist = c0.distance(c1);

                if(dist<stackingThreshold && dist>0.0){
                    garage.get(i+1).setCurrentSpeed(garage.get(i).getCurrentSpeed());
                }



            }
            garage.get(i).graphicUpdate(t);
        }
    }

    public int getCarAmount(){return garage.size();}

    public void clearArrivedCars() {
        for(Car car : this.garage) {
            if(car.getAchievedLenght() >= car.getPathLenght() - 1) {
                car.removeCar();
            }
        }
    }
}
