package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOver {
    private static BorderPane background;
    private static Label gameOver;
    private static Button restart;
    private static VBox goBox;
    public static Scene start(Stage primaryStage) {
        background = new BorderPane();
        gameOver = new Label("Game Over. Please try again...");
        gameOver.setStyle("-fx-text-fill:red; -fx-font-weight:bold");
        gameOver.setFont(new Font("verdana",20));
        restart = new Button("Start Over");
        goBox = new VBox();
        goBox.getChildren().add(gameOver);
        goBox.setAlignment(Pos.CENTER);
        background.setTop(goBox);
        background.setCenter(restart);
        restart.setOnAction(e -> {
            primaryStage.setScene(InitializeConfigScreen.initConfigScreen(primaryStage));
        });
        return new Scene(background,400,500);
    }
}
