package xfzliansynot.catchthecreature;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    private static Creature creature;
    private static final double stageWidth = 800, stageHeight = 600;
    private static Group canvas;
    private static VBox widgets;
    public static int count = 0;
    static int respawnRate = 3;
    public static Label catchesLbl, missesLbl;

    static Timer timer = new Timer();
    public static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("" + count);

            if (count == respawnRate) {
                Creature.misses++;
                missesLbl.setText("Misses:\t" + Creature.misses);
                spawnCreature();
            }
            count++;

        }
    };
    @Override
    public void start(Stage stage) throws IOException {
        catchesLbl = new Label("Catches:\t0");
        missesLbl = new Label("Misses:\t0");

        widgets = new VBox(catchesLbl, missesLbl);

        FileInputStream f = new FileInputStream("src/main/java/xfzliansynot/catchthecreature/creatures/oldMan.png");
        Image img = new Image(f);
        creature = new Creature(img);

        canvas = new Group(creature);

        VBox root = new VBox(widgets, canvas);

        Scene scene = new Scene(root);

        timer.scheduleAtFixedRate(task, 0, 1000);

        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void spawnCreature() {
        count = 0;
        double x = Math.random() * stageWidth - Creature.size;
        double y = Math.random() * (stageHeight - widgets.getMaxWidth()) - Creature.size;

        if (x < Creature.size) {
            x += Creature.size;
        } else if (x + Creature.size > stageWidth) {
            x -= Creature.size;
        }

        if (y < Creature.size) {
            y += Creature.size;
        } else if (y + Creature.size > stageHeight) {
            y -= Creature.size;
        }

        //canvas.getChildren().remove(creature);
        canvas.setTranslateX(/*creature.getTranslateX()*/ x);
        canvas.setTranslateY(/*creature.getTranslateY()*/ y);
        //canvas.getChildren().addAll(creature);

        System.out.println("spawned");


    }


}
