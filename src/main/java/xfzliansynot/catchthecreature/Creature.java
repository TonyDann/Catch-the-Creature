package xfzliansynot.catchthecreature;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Creature extends ImageView {

    public static double size = 100;
    public static int catches = 0;
    public static int misses = 0;
    public Creature() {
        super();
        setFitWidth(size);
        setFitHeight(size);

        setOnMouseClicked(clicked);
    }

    public Creature(Image img) {
        super(img);
        setFitWidth(size);
        setFitHeight(size);

        setOnMouseClicked(clicked);
    }

    public Creature(Image img, double x, double y) {
        super(img);
        setFitWidth(size);
        setFitHeight(size);

        setOnMouseClicked(clicked);
    }

    EventHandler <MouseEvent> clicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouse) {
            Main.spawnCreature();
            //Main.count = 0;
            catches++;
            Main.catchesLbl.setText("Catches:\t" + catches);
        }
    };
}
