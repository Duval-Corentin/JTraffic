package Car;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
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

    private Circle carDot;
    private Circle hitBox;
    private static GraphicsContext carsPane;


    //constructors


    public Car(int i,
               double speedLimit,
               double currentSpeed,
               Integer minPosX,
               Integer minPosY,
               Integer maxPosX,
               Integer maxPosY,
               double maxSpeed,
               double accel,
               double deccel,
               double t0,
               Pane pane) {
        this.currentPosX = minPosX;
        this.currentPosY = minPosY;
        this.speedLimit = speedLimit;
        this.currentSpeed = currentSpeed;
        this.minPosX = minPosX;
        this.minPosY = minPosY;
        this.maxPosX = maxPosX;
        this.maxPosY = maxPosY;
        this.direction = ((double)maxPosY-(double)minPosY)/((double)maxPosX-(double)minPosX);
        this.indice = i;

        //System.out.println(this.direction);

        this.maxSpeed = maxSpeed;
        this.accel = accel;
        this.deccel = deccel;
        this.t0 = t0;

        this.hitBox = new Circle();
        this.hitBox.setFill(Color.WHITE);
        this.hitBox.setRadius(1);
        this.hitBox.setCache(true);
        pane.getChildren().add(this.hitBox);

        this.carDot = new Circle();
        this.carDot.setFill(Color.BLUE);
        this.carDot.setRadius(5);
        this.carDot.setCache(true);
        pane.getChildren().add(this.carDot);
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

        hitBox.setLayoutX(carPosition(t).getX());
        hitBox.setLayoutY(carPosition(t).getY());
    }


    private double smoother(double t){

        double deccelTime = 50.0;
        double result = (0.5)*( tanh((t/5.0)-3.0)+1.0 );
        //System.out.println(t + " :: " + result);
        return result;
    }


    private Point2D carPosition(double t){
        double u = this.getMinPosX();
        double v = this.getMinPosY();
        double coeff = this.getDirection();
        double carSpeed = this.getMaxSpeed();

        double speedLimit = this.getSpeedLimit();
        if(speedLimit<carSpeed) carSpeed = speedLimit;

        this.setCurrentPos(signum(this.maxPosX-this.minPosX) * currentSpeed * t*smoother(t) + u,
                signum(this.maxPosY-this.minPosY)* currentSpeed * coeff * t * smoother(t) + v);



        return new Point2D(this.getCurrentPosX(),this.getCurrentPosY());//.multiply(20);
    }


}
