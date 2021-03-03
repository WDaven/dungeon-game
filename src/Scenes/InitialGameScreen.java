package Scenes;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;
import javafx.scene.control.*;

import static Scenes.InitializeConfigScreen.getGameDifficulty;
import static javafx.application.Application.launch;

public class InitialGameScreen {
    private static int bkgdWidth = 947;
    private static int bkgdHeight = 599;
    private static Button exitLeft;
    private static Button exitRight;
    private static Button exitTop;
    private static Button exitBottom;
    private static Label money;
    private static Label exitNotif;

    public static Label getMoney() {
        return money;
    }

    public static void setMoney(Label money) {
        InitialGameScreen.money = money;
    }

    public static Scene start(Stage primaryStage) {
        // constants + panes
        HBox hBox = new HBox(370);
        VBox vBox = new VBox(bkgdHeight - 100);
        Pane pane = new Pane();
        Pane centerText = new Pane();

        // Money label etc.
        money = new Label("Money:");
        money.setStyle("-fx-stroke:black; -fx-stroke-Width: 1; -fx-font: 30 arial");
        money.setAlignment(Pos.TOP_LEFT);
        pane.getChildren().add(money);
        int difficulty = getGameDifficulty();
        if (difficulty == 0) {
            money.setText("$2000");
        }
        if (difficulty == 1) {
            money.setText("$1000");
        }
        if (difficulty == 2) {
            money.setText("$100");
        }

        // exit label
        exitNotif = new Label("Pick an exit");
        exitNotif.setAlignment(Pos.CENTER);

        // background image
        Image imageBkgd = new Image("/backgroundnored.png");
        BackgroundImage bkgdSettings = new BackgroundImage(imageBkgd, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(bkgdSettings);

        // exit buttons
        exitLeft = new Button("Exit Left");
        exitRight = new Button("Exit Right");
        hBox.getChildren().addAll(exitLeft, exitNotif, exitRight);
        hBox.setAlignment(Pos.CENTER_LEFT);
        exitTop = new Button("Exit Top");
        exitBottom = new Button("Exit Bottom");
        vBox.getChildren().addAll(exitTop, exitBottom);
        vBox.setAlignment(Pos.TOP_CENTER);

        // final panes and showing scene
        StackPane  root = new StackPane();
        root.setBackground(background);
        primaryStage.setTitle("Initial Game Screen");
        primaryStage.setScene(new Scene(root, bkgdWidth, bkgdHeight));
        root.getChildren().addAll(hBox, vBox, pane, centerText);
        
        //primaryStage.show();
        return primaryStage.getScene();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
