package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import sample.Hub.City.City;
import sample.Car.Car;
import sample.Hub.Crossing.Crossing;
import sample.Hub.Crossing.RightPriority;
import sample.Hub.Crossing.Stop;
import sample.Road.Road;


import java.util.Vector;


public class Main extends Application {

    private StackPane rootPane;
    private Pane backPane;
    private Pane frontPane;
    private double t = 0.0;
    private double timeWarp = 0.1; // 100 millisec

    private Vector<City> citys = new Vector<>();
    private Vector<Crossing> crossings = new Vector<>();
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

        this.citys.add(Lille);
        this.citys.add(Toulon);
        this.citys.add(Nantes);
        this.citys.add(Brest);
        this.citys.add(Marseille);
        this.citys.add(Rabat);
        this.citys.add(Nimes);

        RightPriority RP01 = new RightPriority(this.frontPane, 400, 400, Color.RED);
        Stop Stop01 = new Stop(this.frontPane, 800, 200, Color.RED);
        Stop Stop02 = new Stop(this.frontPane, 1200, 600, Color.RED);
        Stop Stop03 = new Stop(this.frontPane, 1100, 400, Color.RED);

        this.crossings.add(RP01);
        this.crossings.add(Stop01);
        this.crossings.add(Stop02);
        this.crossings.add(Stop03);

        Road roads01 = new Road(this.backPane);
        Toulon.addOutRoad(roads01);
        Lille.addInRoad(roads01);

        Road roads02 = new Road(this.backPane);
        Nantes.addOutRoad(roads02);
        Toulon.addInRoad(roads02);

        Road roads03 = new Road(this.backPane);
        RP01.addOutRoad(roads03);
        Lille.addInRoad(roads03);

        Road roads04 = new Road(this.backPane);
        RP01.addOutRoad(roads04);
        Nantes.addInRoad(roads04);

        Road roads05 = new Road(this.backPane);
        RP01.addOutRoad(roads05);
        Toulon.addInRoad(roads05);

        Road roads06 = new Road(this.backPane);
        RP01.addOutRoad(roads06);
        Stop01.addInRoad(roads06);

        Road roads07 = new Road(this.backPane);
        Nantes.addOutRoad(roads07);
        Stop02.addInRoad(roads07);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
