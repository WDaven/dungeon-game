package scenes;

import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;
import javafx.scene.control.*;

public class MazeScenes {
    private static int bkgdWidth;
    private static int bkgdHeight;
    private static Button exitLeft;
    private static Button exitRight;
    private static Button exitTop;
    private static Button exitBottom;

    private static Image backgroundImage;
    private static BackgroundImage bkgdSettings;
    private static Background bkgd;

    public static Scene start(int i, Stage primaryStage) {
        bkgdWidth = 900;
        bkgdHeight = 600;
        BorderPane root = new BorderPane();
        exitLeft = new Button("Exit Left");
        exitRight = new Button("Exit Right");
        exitTop = new Button("Exit Top");
        exitBottom = new Button("Exit Bottom");
        root = specifyScene(i, root, exitLeft, exitRight, exitTop, exitBottom);
        root.setBackground(bkgd);
        primaryStage.setScene(new Scene(root, bkgdWidth, bkgdHeight));
        return primaryStage.getScene();
    }
    public static BorderPane specifyScene(int i, BorderPane root, Button eL, Button eR, Button eT, Button eB) {
        switch(i) {
            case 1: //+
                root.setTop(eT);
                root.setBottom(eB);
                root.setLeft(eL);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (1).png");
                break;
            case 2://ㅓ
                root.setTop(eT);
                root.setBottom(eB);
                root.setLeft(eL);
                backgroundImage = new Image("/Maze Rooms (2).png");
                break;
            case 3://
                root.setTop(eT);
                root.setLeft(eL);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (3).png");
                break;
            case 4://
                root.setTop(eT);
                root.setBottom(eB);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (4).png");
                break;
            case 5://ㅜ
                root.setBottom(eB);
                root.setLeft(eL);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (5).png");
                break;
            case 6: //
                root.setTop(eT);
                root.setLeft(eL);
                backgroundImage = new Image("/Maze Rooms (6).png");
                break;
            case 7://L
                root.setTop(eT);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (7).png");
                break;
            case 8:
                root.setBottom(eB);;
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (8).png");
                break;
            case 9:
                root.setBottom(eB);
                root.setLeft(eL);
                backgroundImage = new Image("/Maze Rooms (9).png");
                break;
            case 10://|
                root.setTop(eT);
                root.setBottom(eB);
                backgroundImage = new Image("/Maze Rooms (10).png");
                break;
            case 11://-
                root.setLeft(eL);
                root.setRight(eR);
                backgroundImage = new Image("/Maze Rooms (11).png");
                break;
        }
        bkgdSettings = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        bkgd = new Background(bkgdSettings);
        return root;
    }
}
