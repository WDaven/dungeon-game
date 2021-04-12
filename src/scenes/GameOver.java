package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static generators.Maze.getPlayer;

public class GameOver {
    private static BorderPane background;
    private static Label gameOver;
    private static Button restart;
    public static Scene start(Stage primaryStage) {
        background = new BorderPane();
        gameOver = new Label("Game Over. Please try again...");
        gameOver.setAlignment(Pos.TOP_CENTER);
        restart = new Button("Start Over.");
        restart.setAlignment(Pos.CENTER);
        background.setTop(gameOver);
        background.setCenter(restart);
        restart.setOnAction(e -> {
            Inventory.setNumDaggers(0);
            Inventory.setNumSwords(0);
            Inventory.setNumGSwords(0);
            Inventory.setNumAPotion(0);
            Inventory.setNumHPotion(0);
            Inventory.setNumCrystals(0);
            primaryStage.setScene(InitializeConfigScreen.initConfigScreen(primaryStage));
        });
        getPlayer().setPlayerHealth(100);
        getPlayer().setPlayerDamage(0);
        getPlayer().setCurrAttackNumber(0);
        return new Scene(background, 400, 500);
    }
}
