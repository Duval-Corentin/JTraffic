package sample.Car;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static java.lang.Math.*;

public class Car {

    //attributes
    private double currentPosX;
    private double currentPosY;
    private double currentSpeed;
    private double speedLimit;

    private double minPosX;
    private double minPosY;
    private double maxPosX;
    private double maxPosY;
    private double direction;
    private double t0;

    private double maxSpeed;
    private double accel; // a voir plus tard
    private double deccel; // a voir plus tard

    private int indice;

    //graphics

    private Pane pane;

    private Circle carDot;
    private Circle hitBox;
    private static GraphicsContext carsPane;


    //constructors


    public Car(double minPosX,
               double minPosY,
               double maxPosX,
               double maxPosY,
               double speedLimit,
               double maxSpeed,
               double t0,
               Pane pane) {
        this.currentPosX = minPosX;
        this.currentPosY = minPosY;
        this.speedLimit = speedLimit;
        this.currentSpeed = 1;
        this.minPosX = minPosX;
        this.minPosY = minPosY;
        this.maxPosX = maxPosX;
        this.maxPosY = maxPosY;
        this.direction = (maxPosY - minPosY) / (maxPosX - minPosX);

        //System.out.println("("+this.minPosX+","+this.minPosY+")to("+this.maxPosX+","+this.maxPosY+")" + "dir : " + this.direction);

        this.maxSpeed = maxSpeed;
        this.accel = 2;
        this.deccel = 2;
        this.t0 = t0;
        this.pane = pane;

        this.carDot = new Circle();
        this.carDot.setFill(Color.BLUE);
        this.carDot.setRadius(5);
        this.carDot.setCache(true);
        this.pane.getChildren().add(this.carDot);
    }

    public void removeCar() {
        this.pane.getChildren().remove(this.carDot);
    }

    //setters

    public void setCurrentPos(double currentPosX, double currentPosY){
        if(this.getAchievedLenght()<this.getPathLenght() && this.currentSpeed != 0){
            this.currentPosX = currentPosX;
            this.currentPosY = currentPosY;
        }
        else{
            this.currentSpeed = 0;
            // this.currentPosX = this.maxPosX;
            // this.currentPosY = this.maxPosY;
        }
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setMinPosX(double minPosX) {
        this.minPosX = minPosX;
    }

    public void setMinPosY(double minPosY) {
        this.minPosY = minPosY;
    }

    public void setMaxPosX(double maxPosX) {
        this.maxPosX = maxPosX;
    }

    public void setMaxPosY(double maxPosY) {
        this.maxPosY = maxPosY;
    }

    public void setCoordinates(double minPosX, double minPosY, double maxPosX, double maxPosY){
        this.minPosX = minPosX;
        this.minPosY = minPosY;
        this.maxPosX = maxPosX;
        this.maxPosY = maxPosY;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setAccel(double accel) {
        this.accel = accel;
    }

    public void setDeccel(double deccel) {
        this.deccel = deccel;
    }

    public void setMotionProperties(double maxSpeed, double speedLimit, double accel, double deccel){
        this.maxSpeed = maxSpeed;
        this.speedLimit = speedLimit;
        this.accel = accel;
        this.deccel = deccel;
    }

    //getters

    public double getCurrentPosX() {
        return this.currentPosX;
    }

    public double getCurrentPosY() {
        return this.currentPosY;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public double getMinPosX() {
        return this.minPosX;
    }

    public double getMinPosY() {
        return this.minPosY;
    }

    public double getMaxPosX() {
        return this.maxPosX;
    }

    public double getMaxPosY() {
        return this.maxPosY;
    }

    public Point2D getPosition(){
        return new Point2D(this.currentPosX,this.currentPosY);
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public double getAccel() {
        return this.accel;
    }

    public double getDeccel() {
        return this.deccel;
    }

    public double getDirection(){
        return this.direction;
    }

    public double getPathLenght(){
        return sqrt(pow((maxPosX-minPosX),2)+pow((maxPosY-minPosY),2));
    }

    public double getAchievedLenght(){
        return sqrt(pow((currentPosX-minPosX),2)+pow((currentPosY-minPosY),2));
    }

    public double getCarProgression(){return this.getAchievedLenght()/this.getPathLenght();}

    //other methods

    public void graphicUpdate(double t){
        draw(t-t0);
    }

    private void draw(double t){
        if(t<0){t=0;}
        carDot.setLayoutX(carPosition(t).getX());
        carDot.setLayoutY(carPosition(t).getY());
    }



    private double speed(double t){

        double accel = 0.01;
        double deccel = 0.0;

        if(this.getCarProgression()<0.90){
            if(this.getCurrentSpeed()+ accel< this.getMaxSpeed()){
                this.setCurrentSpeed(this.getCurrentSpeed()+accel);
            }else{
                this.setCurrentSpeed(this.getMaxSpeed());
            }
        }

        return  this.getCurrentSpeed();
    }

    private Point2D carPosition(double t){
        double timeWarp = 0.001;
        double a = this.getMinPosX();
        double b = this.getMinPosY();
        double c = this.getMaxPosX();
        double d = this.getMaxPosY();

        if(t>0.0) {
           this.setCurrentPos((1.0-t)*a+t*c,(1.0-t)*b+t*d);
        }
        return new Point2D(this.getCurrentPosX(),this.getCurrentPosY());
    }


}
