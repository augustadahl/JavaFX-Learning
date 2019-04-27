//package Cardriving;
//
//import java.util.ArrayList;
//
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.geometry.Bounds;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.paint.Color;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class intersect extends Application {
//
//    ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Group root = new Group();
//        Scene scene = new Scene(root, 1500, 500, Color.SKYBLUE);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        Car car = new Car(Color.LIGHTCORAL);
//        Car car2 = new Car(Color.RED);
//        car2.setTranslateY(200);
//        root.getChildren().add(car);
//        root.getChildren().add(car2);
//
//        AnimationTimer at = new AnimationTimer() {
//            int dir = 1;
//
//            @Override
//            public void handle(long now) {
//
//                car.setTranslateX(car.getTranslateX() + 8 * dir);
//
//                if (car.getTranslateX() > 1500 - 100 || car.getTranslateX() < 0) {
//                    dir = dir * -1;
//                    car.setRotationAxis(Rotate.Y_AXIS);
//                    car.setRotate(car.getRotate() + 180);
//                }
//
//                car2.setTranslateX(car2.getTranslateX() + 5 * dir);
//
//                if (car2.getTranslateX() > 1500 - 100 || car2.getTranslateX() < 0) {
//                    dir = dir * -1;
//                    car2.setRotationAxis(Rotate.Y_AXIS);
//                    car2.setRotate(car2.getRotate() + 180);
//                }
//
//                if (car.getBoundsInParent().intersects(car2.getBoundsInParent())) {
//
//                    
//
//                }
////            private boolean intersects(Node n1, Node n2) {
////                Bounds b1 = n1.getBoundsInParent();
////                Bounds b2 = n2.getBoundsInParent();
////                double n1minX = b1.getMinX() + n1.getTranslateX();
////                double n1minY = b1.getMinY() + n1.getTranslateY();
////                double n2minX = b2.getMinX() + n2.getTranslateX();
////                double n2minY = b2.getMinY() + n2.getTranslateY();
////
////                if(n1minX)
////                return true;
////
////            }
//
////        };
//
////        scene.setOnKeyPressed(e -> {
////            KeyCode key = e.getCode();
////            if (!keysPressed.contains(key))
////                keysPressed.add(key);
////        });
////
////        scene.setOnKeyReleased(e -> {
////            KeyCode key = e.getCode();
////            if (keysPressed.contains(key))
////                keysPressed.remove(key);
////        });
//
////        at.start();
//
//    }
//public static void main(String[] args) {
//        launch();
//    }
//
//}