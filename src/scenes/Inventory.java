package scenes;

import javafx.geometry.Pos;
import generators.Maze;
import generators.Maze.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Inventory {
    private static BorderPane background;
    private static Button back;
    public static Scene start(Stage primaryStage, Maze maze, Node curr) {
        back = new Button("Return to Game");
        background = new BorderPane();
        background.setCenter(back);
        maze.setCurr(curr);
        back.setOnAction( e -> {
            primaryStage.setScene(InitialGameScreen.start(primaryStage, maze));
        });
        return new Scene(background, 400, 500);
    }
}
