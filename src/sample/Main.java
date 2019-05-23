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
import sample.Road.*;

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

        Lane road01 = new Lane(this.backPane);
        Toulon.addOutRoad(road01);
        Lille.addInRoad(road01);

        Lane road02 = new Lane(this.backPane);
        Nantes.addOutRoad(road02);
        Toulon.addInRoad(road02);

        Lane road03 = new Lane(this.backPane);
        RP01.addOutRoad(road03);
        Lille.addInRoad(road03);

        Lane road04 = new Lane(this.backPane);
        RP01.addOutRoad(road04);
        Nantes.addInRoad(road04);

        Lane road05 = new Lane(this.backPane);
        RP01.addOutRoad(road05);
        Toulon.addInRoad(road05);

        Lane road06 = new Lane(this.backPane);
        RP01.addOutRoad(road06);
        Stop01.addInRoad(road06);

        Lane road07 = new Lane(this.backPane);
        Nantes.addOutRoad(road07);
        Stop02.addInRoad(road07);

        Lane road08 = new Lane(this.backPane);
        Lille.addOutRoad(road08);
        Stop01.addInRoad(road08);

        Lane road09 = new Lane(this.backPane);
        Nantes.addOutRoad(road09);
        Stop01.addInRoad(road09);

        Lane road10 = new Lane(this.backPane);
        Stop01.addOutRoad(road10);
        Stop02.addInRoad(road10);

        Lane road11 = new Lane(this.backPane);
        Stop02.addOutRoad(road11);
        Stop03.addInRoad(road11);

        Lane road12 = new Lane(this.backPane);
        Stop02.addOutRoad(road12);
        Nimes.addInRoad(road12);

        Lane road13 = new Lane(this.backPane);
        Rabat.addOutRoad(road13);
        Stop03.addInRoad(road13);

        Lane road14 = new Lane(this.backPane);
        Stop03.addOutRoad(road14);
        Stop01.addInRoad(road14);

        Lane road15 = new Lane(this.backPane);
        Nantes.addOutRoad(road15);
        Nimes.addInRoad(road15);

        Lane road16 = new Lane(this.backPane);
        Brest.addOutRoad(road16);
        Rabat.addInRoad(road16);

        Lane road17 = new Lane(this.backPane);
        Brest.addOutRoad(road17);
        Stop02.addInRoad(road17);

        Lane road18 = new Lane(this.backPane);
        Brest.addOutRoad(road18);
        Stop03.addInRoad(road18);

        Lane road19 = new Lane(this.backPane);
        Toulon.addOutRoad(road19);
        Nimes.addInRoad(road19);

        for(int i = 0; i<20; i++){
            road06.addCar((double)i*0.1,12.0,this.frontPane);
        }
        for(int i = 0; i<20; i++){
            road01.addCar((double)i*0.1,12.0,this.frontPane);
        }
        for(int i = 0; i<20; i++){
            road07.addCar((double)i*0.1,12.0,this.frontPane);
        }

        road13.addCar(0.0,12.0,this.frontPane);
        road16.addCar(0.0,12.0,this.frontPane);

        //Car toast  = new Car(1000.0,750.0,800.0,400.0,1.0,5.0,0.0,this.frontPane);


        AnimationTimer timer = new AnimationTimer() {

            private double t = 0;
            @Override
            public void handle(long now) {
                t += 0.001;
                road16.update(t);
                road13.update(t);
                road06.update(t);
                road07.update(t);
                road01.update(t);
                //toast.graphicUpdate(t);
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}