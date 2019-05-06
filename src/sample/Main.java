package sample;

import Car.Car;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Hub.City.City;

import java.util.Vector;


public class Main extends Application {

    private Pane root;
    private double t = 0.0;
    private double timeWarp = 0.1; // 100 millisec

    private Vector<City> citys = new Vector<>();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("J Traffic");


        this.root = new Pane();
        this.root.setPrefSize(1600, 900);
        primaryStage.setScene( new Scene(this.root));
        primaryStage.show();

        this.citys.add(new City(this.root, 200, 200, "ville 01", Color.MEDIUMPURPLE));
        this.citys.add(new City(this.root, 400, 400, "ville 02", Color.MAGENTA));
        this.citys.add(new City(this.root, 700, 400, "ville 03", Color.BEIGE));

        Car papaMobile = new Car(0,15,4, this.citys.get(0).getXPos() ,this.citys.get(0).getYPos(),this.citys.get(1).getXPos(),this.citys.get(1).getYPos(),
                50,2,3,5,this.root);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t+=timeWarp;
                papaMobile.graphicUpdate(t);
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
