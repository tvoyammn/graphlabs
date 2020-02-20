import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene (root, 400, 250);

        scene.setFill(Color.rgb(255, 215, 0));

        Polygon bigPol = new Polygon(20, 40, 150, 125, 20, 210, 55, 125);
        bigPol.setFill(Color.BLUE);
        root.getChildren().add(bigPol);

        Circle circle = new Circle(95,125,25);
        circle.setFill(Color.RED);
        root.getChildren().add(circle);

        Polygon smallPol = new Polygon(310, 125, 370, 80, 345, 125, 370, 170);
        smallPol.setFill(Color.BLUE);
        root.getChildren().add(smallPol);

        Line line1 = new Line(85, 115, 330, 115);
        Line line2 = new Line(85, 119, 330, 119);
        Line line3 = new Line(85, 123, 330, 123);
        Line line4 = new Line(85, 127, 330, 127);
        Line line5 = new Line(85, 131, 330, 131);
        Line line6 = new Line(85, 135, 330, 135);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);
        root.getChildren().add(line5);
        root.getChildren().add(line6);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
