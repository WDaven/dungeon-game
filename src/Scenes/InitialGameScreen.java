package Scenes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;
import javafx.scene.control.*;

import static Scenes.initializeConfigScreen.getGameDifficulty;
import static javafx.application.Application.launch;

public class InitialGameScreen {

    public static Scene start(Stage primaryStage) {
        // constants + panes
        int bkgdWidth = 947;
        int bkgdHeight = 599;
        HBox hBox = new HBox(bkgdWidth-150);
        VBox vBox = new VBox(bkgdHeight-100);
        Pane pane = new Pane();

        // Money label etc.
        Label money = new Label("Money:");
        money.setStyle("-fx-stroke:black; -fx-stroke-Width: 1; -fx-font: 30 arial");
        money.setAlignment(Pos.TOP_LEFT);
        pane.getChildren().add(money);
        int difficulty = getGameDifficulty();
        if (difficulty == 0) {
            money.setText("$100");
        }
        if (difficulty == 1) {
            money.setText("$1000");
        }
        if (difficulty == 2) {
            money.setText("$2000");
        }


        // background image
        Image imageBkgd = new Image("/backgroundnored.png");
        BackgroundImage bkgdSettings = new BackgroundImage(imageBkgd, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(bkgdSettings);

        // exit buttons
        Button exitLeft = new Button("Exit Left");
        Button exitRight = new Button("Exit Right");
        hBox.getChildren().addAll(exitLeft,exitRight);
        hBox.setAlignment(Pos.CENTER_LEFT);
        Button exitTop = new Button("Exit Top");
        Button exitBottom = new Button("Exit Bottom");
        vBox.getChildren().addAll(exitTop,exitBottom);
        vBox.setAlignment(Pos.TOP_CENTER);

        // final panes and showing scene
        StackPane  root = new StackPane();
        root.setBackground(background);
        primaryStage.setTitle("Initial Game Screen");
        primaryStage.setScene(new Scene(root, bkgdWidth, bkgdHeight));
        root.getChildren().addAll(hBox,vBox,pane);
        //primaryStage.show();
        return primaryStage.getScene();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
