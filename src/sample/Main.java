package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Hub.City.City;


public class Main extends Application {

    private Pane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("J Traffic");

        this.root = new Pane();
        this.root.setPrefSize(1600, 900);
        primaryStage.setScene( new Scene(this.root));
        primaryStage.show();

        City Lille = new City(this.root, 600, 600, "Lille", "test");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
