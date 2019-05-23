package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import sample.Car.Car;
import sample.Hub.City.City;
import sample.Hub.Crossing.RightPriority;
import sample.Hub.Crossing.Stop;
import sample.Hub.Hub;
import sample.Road.BigRoad;
import sample.Road.MediumRoad;
import sample.Road.Road;
import sample.Road.SmallRoad;

import java.util.Vector;

public class Main extends Application {

    private StackPane rootPane;
    private Pane backPane;
    private Pane frontPane;
    private double t = 0.0;
    private double timeWarp = 0.1; // 100 millisec

    private Vector<Hub> hubs = new Vector<>();
    private Vector<Road> roads = new Vector<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("J Traffic");


        this.rootPane = new StackPane();
        this.rootPane.setPrefSize(1600, 900);

        this.backPane = new Pane();
        this.frontPane = new Pane();

        this.rootPane.getChildren().addAll(backPane, frontPane);

        primaryStage.setScene( new Scene(this.rootPane));
        primaryStage.show();

        City Lille = new City(this.frontPane, 100, 100, "Lille", Color.web("#00a8ff"));
        City Toulon = new City(this.frontPane, 400, 800, "Toulon", Color.web("#e84118"));
        City Nantes = new City(this.frontPane, 700, 400, "Nantes", Color.web("#fbc531"));
        City Brest = new City(this.frontPane, 1500, 400, "Brest", Color.web("#4cd137"));
        City Marseille = new City(this.frontPane, 1800, 200, "Marseille", Color.web("#487eb0"));
        City Rabat = new City(this.frontPane, 1400, 150, "Rabat", Color.web("#e84118"));
        City Nimes = new City(this.frontPane, 1000, 750, "Nîmes", Color.web("#718093"));

        RightPriority RP01 = new RightPriority(this.frontPane, 400, 400, Color.RED);
        Stop Stop01 = new Stop(this.frontPane, 800, 200, Color.RED);
        Stop Stop02 = new Stop(this.frontPane, 1200, 600, Color.RED);
        Stop Stop03 = new Stop(this.frontPane, 1100, 400, Color.RED);

        this.hubs.add(Lille);
        this.hubs.add(Toulon);
        this.hubs.add(Nantes);
        this.hubs.add(Brest);
        this.hubs.add(Marseille);
        this.hubs.add(Rabat);
        this.hubs.add(Nimes);

        this.hubs.add(RP01);
        this.hubs.add(Stop01);
        this.hubs.add(Stop02);
        this.hubs.add(Stop03);

        SmallRoad road01 = new SmallRoad(this.backPane);
        Toulon.addOutRoad(road01);
        Lille.addInRoad(road01);

        SmallRoad road02 = new SmallRoad(this.backPane);
        Nantes.addOutRoad(road02);
        Toulon.addInRoad(road02);

        SmallRoad road03 = new SmallRoad(this.backPane);
        RP01.addOutRoad(road03);
        Lille.addInRoad(road03);

        BigRoad road04 = new BigRoad(this.backPane);
        RP01.addOutRoad(road04);
        Nantes.addInRoad(road04);

        MediumRoad road05 = new MediumRoad(this.backPane);
        RP01.addOutRoad(road05);
        Toulon.addInRoad(road05);

        MediumRoad road06 = new MediumRoad(this.backPane);
        RP01.addOutRoad(road06);
        Stop01.addInRoad(road06);

        SmallRoad road07 = new SmallRoad(this.backPane);
        Nantes.addOutRoad(road07);
        Stop02.addInRoad(road07);

        BigRoad road08 = new BigRoad(this.backPane);
        Lille.addOutRoad(road08);
        Stop01.addInRoad(road08);

        MediumRoad road09 = new MediumRoad(this.backPane);
        Nantes.addOutRoad(road09);
        Stop01.addInRoad(road09);

        SmallRoad road10 = new SmallRoad(this.backPane);
        Stop01.addOutRoad(road10);
        Stop02.addInRoad(road10);

        SmallRoad road11 = new SmallRoad(this.backPane);
        Stop02.addOutRoad(road11);
        Stop03.addInRoad(road11);

        BigRoad road12 = new BigRoad(this.backPane);
        Stop02.addOutRoad(road12);
        Nimes.addInRoad(road12);

        BigRoad road13 = new BigRoad(this.backPane);
        Rabat.addOutRoad(road13);
        Stop03.addInRoad(road13);

        SmallRoad road14 = new SmallRoad(this.backPane);
        Stop03.addOutRoad(road14);
        Stop01.addInRoad(road14);

        MediumRoad road15 = new MediumRoad(this.backPane);
        Nantes.addOutRoad(road15);
        Nimes.addInRoad(road15);

        MediumRoad road16 = new MediumRoad(this.backPane);
        Brest.addOutRoad(road16);
        Rabat.addInRoad(road16);

        SmallRoad road17 = new SmallRoad(this.backPane);
        Brest.addOutRoad(road17);
        Stop02.addInRoad(road17);

        SmallRoad road18 = new SmallRoad(this.backPane);
        Brest.addOutRoad(road18);
        Stop03.addInRoad(road18);

        MediumRoad road19 = new MediumRoad(this.backPane);
        Toulon.addOutRoad(road19);
        Nimes.addInRoad(road19);

        Car myCar01 = new Car(1, 10, 1, 100, 100, 1000, 500, 10, 1, 1, 0, this.frontPane);
        Car myCar02 = new Car(1, 10, 1, 100, 100, 1000, 500, 10, 1, 1, 20, this.frontPane);

        AnimationTimer timer = new AnimationTimer() {

            private double t = 0;
            @Override
            public void handle(long now) {
                t += 0.1;
                myCar01.graphicUpdate(t);
                myCar02.graphicUpdate(t);
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}