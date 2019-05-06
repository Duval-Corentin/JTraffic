package sample.Hub.City;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sample.Hub.Hub;
import javafx.scene.shape.*;


public class City extends Hub {

    private static double width = 100;
    private static double height = 50;
    private static double fontSize = 15;
    private static double arcWidth = 15;

    private Text nameText;

    public City(final Pane root, final double xPos, final double yPos, final String name, final Color color) {

        super(root, xPos, yPos);

        this.rect.setX(xPos - width/2);
        this.rect.setY(yPos - height/2);
        this.rect.setWidth(width);
        this.rect.setHeight(height);
        this.rect.setArcWidth(arcWidth);
        this.rect.setArcHeight(arcWidth);
        this.rect.setFill(color);

        this.nameText = new Text();
        this.nameText.setFont(Font.font("Verdana", FontWeight.BOLD, fontSize));
        this.nameText.setText(name);
        this.nameText.setX(xPos - width/2);
        this.nameText.setY(yPos + fontSize/2);
        this.nameText.setTextAlignment(TextAlignment.CENTER);
        this.nameText.setWrappingWidth(width);


        this.root.getChildren().add(this.rect);
        this.root.getChildren().add(this.nameText);

    }
}
