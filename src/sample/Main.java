package sample;

import Car.Car;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Hub.City.City;


public class Main extends Application {

    private Pane root;
    private double t = 0.0;
    private double timeWarp = 0.1; // 100 millisec

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("J Traffic");


        this.root = new Pane();
        this.root.setPrefSize(1600, 900);
        primaryStage.setScene( new Scene(this.root));
        primaryStage.show();

        Car papaMobile = new Car(0,15,4,10,10,1580,880,
                50,2,3,5,this.root);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t+=timeWarp;
                papaMobile.graphicUpdate(t);
            }
        };
        timer.start();

        City Lille = new City(this.root, 600, 600, "Lille", "boite");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
