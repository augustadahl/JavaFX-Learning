
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
// importerar alla olika extensions vi kommer att beh�va

public class tac extends Application {

	//lite olika variabler som lagrar information om spelets nuvarande l�ge.
    private boolean playable = true;
    private boolean turnX = true;
    private Tile[][] board = new Tile[3][3];
    private List<Combo> combos = new ArrayList<>();

    private Pane root = new Pane();

    private Parent createContent() {
        root.setPrefSize(600, 600); 
        // H�r g�r vi layouten
        
        //h�r skapas alla rutor och placeras ut p� r�tt plats
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        //h�r skapas dem olika vinnande dragen, dvs. lodr�t v�gr�t och diagonal
        // horizontal
        for (int y = 0; y < 3; y++) {
            combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
        }

        // diagonals
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));

        return root;
    }

    //h�r skapas f�nstret.
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    //h�r kollar man om n�gon spelare har f�tt 3 i rad enligt dem drag som skapades tidigare. Om det st�mmer s� avslutas spelet.
    private void checkState() {
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false;
                playWinAnimation(combo);
                break;
            }
        }
    }

    //om man vinner s� skapas h�r en linje som dras genom de vinnande rutorna
    private void playWinAnimation(Combo combo) {
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());

        root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));
        timeline.play();
    }

    //h�r l�ggs en ruta in i ett vinnande drag.
    private class Combo {
        private Tile[] tiles;
        public Combo(Tile... tiles) {
            this.tiles = tiles;
        }

        //returnerar rutans v�rde om den inte �r tom.
        public boolean isComplete() {
            if (tiles[0].getValue().isEmpty())
                return false;

            return tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());
        }
    }

    //Skapar en ruta och ger den utseende samt funktion.
    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile() {
        	//skapar en svart ram
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            //�ndrar storleken p� texten
            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            //om spelet fortfarande �r ig�ng s� s�tter den X vid v�nsterklick och O vid h�gerklick med hj�lp av metoden nedan.
            setOnMouseClicked(event -> {
                if (!playable)
                    return;

                if (event.getButton() == MouseButton.PRIMARY) {
                    if (!turnX)
                        return;

                    drawX();
                    turnX = false;
                    checkState();
                }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    if (turnX)
                        return;

                    drawO();
                    turnX = true;
                    checkState();
                }
            });
        }

        //�ndrar positionen i X led
        public double getCenterX() {
            return getTranslateX() + 100;
        }

        //�ndrar positionen i Y led
        public double getCenterY() {
            return getTranslateY() + 100;
        }

        //kollar vad rutan har f�r text (O, X eller tom)
        public String getValue() {
            return text.getText();
        }

        //byter ut texten till X
        private void drawX() {
           text.setText("X");
        }

        //Byter ut texten till O
        private void drawO() {
            text.setText("O");
        }
    } 
    
    public static void main(String[] args) {
        launch(args);
    }
}
