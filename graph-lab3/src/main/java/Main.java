import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        {
            MoveTo start = new MoveTo(200, 200);
            HLineTo hLineTo = new HLineTo(300);
            VLineTo vLineTo1 = new VLineTo(250);
            // Top part
            ArcTo bottom = new ArcTo(100, 70, 0, 200, 250, false, true);
            VLineTo vLineTo2 = new VLineTo(200);
            Path drum = new Path();
            drum.setStrokeWidth(1);
            drum.setStroke(Color.BLACK);
            drum.setFill(new LinearGradient(0, 0,
                    1, 0, true, CycleMethod.NO_CYCLE,
                    new Stop(0, Color.RED),
                    new Stop(0.75, Color.WHITE),
                    new Stop(1, Color.RED)));
            drum.getElements().add(start);
            drum.getElements().add(hLineTo);
            drum.getElements().add(vLineTo1);
            drum.getElements().add(bottom);
            drum.getElements().add(vLineTo2);
            root.getChildren().add(drum);
        }

        {
            Ellipse e1 = new Ellipse(233, 187, 5, 5);
            e1.setStrokeWidth(1);
            e1.setStroke(Color.BLACK);
            e1.setFill(Color.BROWN);

            Ellipse e2 = new Ellipse(266, 187, 5, 5);
            e2.setStrokeWidth(1);
            e2.setStroke(Color.BLACK);
            e2.setFill(Color.BROWN);
            root.getChildren().add(e1);
            root.getChildren().add(e2);
        }

        {
            Path p = new Path();
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.BROWN);
            p.getElements().add(new MoveTo(200, 200));
            p.getElements().add(new LineTo(203, 250));
            p.getElements().add(new ArcTo(3, 3, 0, 197, 250, false, true));
            p.getElements().add(new LineTo(200, 200));
            root.getChildren().add(p);
        }

        {
            Path p = new Path();
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.BROWN);
            p.getElements().add(new MoveTo(233, 213));
            p.getElements().add(new LineTo(236, 258));
            p.getElements().add(new ArcTo(3, 3, 0, 230, 258, false, true));
            p.getElements().add(new LineTo(233, 213));
            root.getChildren().add(p);
        }

        {
            Path p = new Path();
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.BROWN);
            p.getElements().add(new MoveTo(266, 213));
            p.getElements().add(new LineTo(269, 258));
            p.getElements().add(new ArcTo(3, 3, 0, 263, 258, false, true));
            p.getElements().add(new LineTo(266, 213));
            root.getChildren().add(p);
        }

        {
            Path p = new Path();
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.BROWN);
            p.getElements().add(new MoveTo(300, 200));
            p.getElements().add(new LineTo(303, 250));
            p.getElements().add(new ArcTo(3, 3, 0, 297, 250, false, true));
            p.getElements().add(new LineTo(300, 200));
            root.getChildren().add(p);
        }

        {
            Ellipse ellipse = new Ellipse(250, 200, 50, 15);
            ellipse.setStrokeWidth(1);
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.YELLOW);
            root.getChildren().add(ellipse);
        }

        {
            Ellipse e1 = new Ellipse(200, 200, 5, 5);
            e1.setStrokeWidth(1);
            e1.setStroke(Color.BLACK);
            e1.setFill(Color.BROWN);

            Ellipse e2 = new Ellipse(233, 213, 5, 5);
            e2.setStrokeWidth(1);
            e2.setStroke(Color.BLACK);
            e2.setFill(Color.BROWN);

            Ellipse e3 = new Ellipse(266, 213, 5, 5);
            e3.setStrokeWidth(1);
            e3.setStroke(Color.BLACK);
            e3.setFill(Color.BROWN);

            Ellipse e4 = new Ellipse(300, 200, 5, 5);
            e4.setStrokeWidth(1);
            e4.setStroke(Color.BLACK);
            e4.setFill(Color.BROWN);
            root.getChildren().add(e1);
            root.getChildren().add(e2);
            root.getChildren().add(e3);
            root.getChildren().add(e4);
        }

        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(200, 130),
                    new LineTo(250, 150),
                    new ArcTo(10, 10, 0, 248, 155, true, true),
                    new LineTo(200, 135),
                    new ArcTo(2, 2, 30, 200, 130, false, true)
            );
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.ORANGE);
            root.getChildren().add(p);
        }

        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(310, 150),
                    new LineTo(260, 190),
                    new ArcTo(10, 10, 0, 265, 195, true, false),
                    new LineTo(310, 155),
                    new ArcTo(2, 2, 0, 310, 150, false, false)
            );
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.ORANGE);
            root.getChildren().add(p);
        }

        {
            Path stripe = new Path();
            int xoff = 200;
            int yoff = 200;
            stripe.getElements().addAll(
                    // inner
                    new MoveTo(xoff, yoff),
                    new CubicCurveTo(-30 + xoff, 30 + yoff, -5 + xoff, 39 + yoff, -30 + xoff, 70 + yoff),
                    new CubicCurveTo(-40 + xoff, 80 + yoff, -20 + xoff, 122 + yoff, 10 + xoff, 100 + yoff),
                    new QuadCurveTo(50 + xoff, 50 + yoff, 90 + xoff, 97 + yoff),
                    new CubicCurveTo(-10 + 100 + xoff, 100 + yoff, 40 + 100 + xoff, 130 + yoff, 123 + xoff, 70 + yoff),
                    new CubicCurveTo(-10 + 100 + xoff, 30 + yoff, 30 + 100 + xoff, 10 + yoff, 100 + xoff, yoff),
                    new CubicCurveTo(130 + xoff, yoff, 110 + xoff, 11 + yoff, 115 + xoff, 45 + yoff),
                    new CubicCurveTo(143 + xoff, 70 + yoff, 40 + 100 + xoff, 130 + yoff, -5 + 100 + xoff, 110 + yoff),
                    new CubicCurveTo(80 + xoff, 90 + yoff, 50 + xoff, 50 + yoff, 5 + xoff, 110 + yoff),
                    new CubicCurveTo(-40 + xoff, 130 + yoff, -43 + xoff, 70 + yoff, -30 + xoff, 53 + yoff),
                    new CubicCurveTo(-20 + xoff, 45 + yoff, -20 + xoff, 5 + yoff, xoff, yoff)
            );
            stripe.setStrokeWidth(1);
            stripe.setStroke(Color.BLACK);
            stripe.setFill(new LinearGradient(0, 0,
                    0.25, 0, true, CycleMethod.REPEAT,
                    new Stop(0, Color.BLUE),
                    new Stop(0.75, Color.SKYBLUE),
                    new Stop(1, Color.BLUE)));
            root.getChildren().add(stripe);
        }

        // Animation
        int cycleCount = 2;
        int time = 2000;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), root);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time), root);
        translateTransition.setFromX(150);
        translateTransition.setToX(0);
        translateTransition.setCycleCount(cycleCount + 1);
        translateTransition.setAutoReverse(true);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(time), root);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(150);
        translateTransition2.setCycleCount(cycleCount + 1);
        translateTransition2.setAutoReverse(true);

        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time), root);
        scaleTransition2.setToX(0.1);
        scaleTransition2.setToY(0.1);
        scaleTransition2.setCycleCount(cycleCount);
        scaleTransition2.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().

                addAll(
                        rotateTransition,
                        scaleTransition,
                        scaleTransition2,
                        translateTransition
                );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
        // End of animation
        primaryStage.setTitle("Lab 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}