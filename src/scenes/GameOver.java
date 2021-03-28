package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static generators.Maze.getPlayer;

public class GameOver {
    private static Pane background;
    private static Label gameOver;
    private static Button restart;
    public static Scene start(Stage primaryStage) {
        background = new Pane();
        gameOver = new Label("Game Over. Please try again...");
        gameOver.setAlignment(Pos.TOP_CENTER);
        restart = new Button("Start Over.");
        restart.setAlignment(Pos.CENTER);
        background.getChildren().addAll(gameOver, restart);
        restart.setOnAction(e -> {
            primaryStage.setScene(InitializeConfigScreen.initConfigScreen(primaryStage));
        });
        getPlayer().setPlayerHealth(100);
        return new Scene(background, 400, 500);
    }
}