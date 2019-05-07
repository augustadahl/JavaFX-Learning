package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class transparent_arc extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
    Arc arc = new Arc(0, 0, 100, 100, 0, 90);
    arc.setFill(Color.TRANSPARENT);
    arc.setStroke(Color.BLACK);
    arc.setType(ArcType.ROUND);

    HBox box = new HBox(arc);
 
    Scene scene = new Scene(box);
    stage.setScene(scene);
    stage.setTitle("Test");
    stage.show();
  }
}