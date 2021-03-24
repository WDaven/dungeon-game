package scenes;

import generators.Maze;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import generators.Maze.*;


import static generators.Maze.getPlayer;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static scenes.InitializeConfigScreen.getGameDifficulty;
import static javafx.application.Application.launch;

public class InitialGameScreen {
    private static int bkgdWidth = 947;
    private static int bkgdHeight = 540;
    private static Button exitLeft;
    private static Button exitRight;
    private static Button exitTop;
    private static Button exitBottom;
    private static Button attackMonster;
    private static Label money;
    private static Label exitNotif;
    private static Maze maze;
    private static Node curr;
    private static BorderPane root;

    public static Node getCurr() {
        return curr;
    }

    public static Label getMoney() {
        return money;
    }

    public static void setMoney(Label money) {
        scenes.InitialGameScreen.money = money;
    }

    public static Scene start(Stage primaryStage) {

        // generating new maze here
        maze = new Maze();

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

        // exit buttons
        root = new BorderPane();
        exitLeft = new Button("Exit Left");
        exitRight = new Button("Exit Right");
        exitTop = new Button("Exit Top");
        exitBottom = new Button("Exit Bottom");
        attackMonster = new Button("Attack!");
        //setting start room page
        curr = Maze.getCurr();

        HBox holdR = new HBox();
        holdR.getChildren().add(exitRight);
        holdR.setAlignment(Pos.CENTER);
        holdR.setSpacing(10);
        root.setRight(holdR);

        HBox holdL = new HBox();
        holdL.getChildren().add(exitLeft);
        holdL.setAlignment(Pos.CENTER);
        holdL.setSpacing(10);
        root.setLeft(holdL);

        HBox holdT = new HBox();
        holdT.getChildren().add(exitTop);
        holdT.setAlignment(Pos.CENTER);
        holdT.setSpacing(10);
        root.setTop(holdT);

        HBox holdB = new HBox();
        holdB.getChildren().add(exitBottom);
        holdB.setAlignment(Pos.CENTER);
        holdB.setSpacing(10);
        root.setBottom(holdB);

        HBox holdM = new HBox();
        holdM.getChildren().add(attackMonster);
        holdM.setAlignment(Pos.CENTER);
        holdM.setSpacing(10);
        root.setCenter(holdM);



        Image imageBkgd = curr.getImageBkgd();
        BackgroundImage bkgdSettings = new BackgroundImage(imageBkgd, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(bkgdSettings);
        root.setBackground(background);

        setExitLeftAction();
        setExitRightAction();
        setExitTopAction();
        setExitBottomAction();
        setAttackMonsterAction();

        // final panes and showing scene
        primaryStage.setTitle("DungeonCrawler");
        primaryStage.setScene(new Scene(root, bkgdWidth, bkgdHeight));
        root.getChildren().addAll(hBox, vBox, pane, centerText);
        return primaryStage.getScene();
    }
    public static void setAttackMonsterAction() {
        attackMonster.setOnAction(e -> {
            int playerHealth = getPlayer().getPlayer_Health();
            int monsterDamage = curr.getMonster().getMonsterDamage();
            int playerDamge= getPlayer().getPlayer_Damage();
            int monsterHealth = curr.getMonster().getMonsterHealth();
            if(curr.getMonster() instanceof MonsterBlue) {
                System.out.println("BlueMonster");
            }
            getPlayer().setPlayer_Health(playerHealth - monsterDamage);
            curr.getMonster().setMonsterHealth(monsterHealth - playerDamge);
            if (curr.getMonster().getMonsterHealth() <= 0) {
                curr.getMonster().setMonsterIsDead(true);
            }
            if (curr.getMonster().getMonsterIsDead()) {
                System.out.println("MonsterIsDead");
                attackMonster.setVisible(false);
            }
        });
    }
    public static void setExitLeftAction() {
        exitLeft.setOnAction(e -> {
            if (curr.getRoomNum() == 14 || curr.getRoomNum() == 18) {
                if (curr.getLeft() == null) {
                    Alert alertExit = new Alert(Alert.AlertType.WARNING,
                            ("Please Choose another Exit"));
                    alertExit.show();
                }
            }
            if (curr.getLeft() != null && (curr.getMonster().getMonsterIsDead() ||
                    (!curr.getMonster().getMonsterIsDead() && curr.getLeft().getIsVisted()))) {
                curr.setIsVisted(true);
                curr = curr.getLeft();
                Image imgBkgd = curr.getImageBkgd();
                BackgroundImage bkgdSet = new BackgroundImage(imgBkgd, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bkgd = new Background(bkgdSet);
                root.setBackground(bkgd);
                //button visibility
                exitTop.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 4
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 7
                        || curr.getRoomIdentifier() == 10);
                exitRight.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 3
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 7 || curr.getRoomIdentifier() == 8
                        || curr.getRoomIdentifier() == 11);
                exitBottom.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 8 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 10);
                exitLeft.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 11);
                attackMonster.setVisible(!(curr.getMonster().monsterIsDead));
            }
        });
    }

    public static void setExitRightAction() {
        exitRight.setOnAction(e -> {
            if (curr.getRoomNum() == 14 || curr.getRoomNum() == 18) {
                if (curr.getRight() == null) {
                    Alert alertExit = new Alert(Alert.AlertType.WARNING,
                            ("Please Choose another Exit"));
                    alertExit.show();
                }
            }
            if (curr.getRight() != null && (curr.getMonster().getMonsterIsDead() ||
                    (!curr.getMonster().getMonsterIsDead() && curr.getRight().getIsVisted()))) {
                curr.setIsVisted(true);
                curr = curr.getRight();
                Image imgBkgd = curr.getImageBkgd();
                BackgroundImage bkgdSet = new BackgroundImage(imgBkgd, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bkgd = new Background(bkgdSet);
                root.setBackground(bkgd);
                //button visibility
                exitTop.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 4
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 7
                        || curr.getRoomIdentifier() == 10);
                exitRight.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 3
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 7 || curr.getRoomIdentifier() == 8
                        || curr.getRoomIdentifier() == 11);
                exitBottom.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 8 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 10);
                exitLeft.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 11);
                if(!(curr.getMonster().monsterIsDead)) {
                    attackMonster.setVisible(true);
                } else {
                    attackMonster.setVisible(false);
                }
            }
        });
    }

    public static void setExitTopAction() {
        exitTop.setOnAction(e -> {
            if (curr.getRoomNum() == 14) {
                if (curr.getTop() == null) {
                    Alert alertExit = new Alert(Alert.AlertType.WARNING,
                            ("Please Choose another Exit"));
                    alertExit.show();
                }
            }
            if (curr.getTop() != null && (curr.getMonster().getMonsterIsDead() ||
                    (!curr.getMonster().getMonsterIsDead() && curr.getTop().getIsVisted()))) {
                curr.setIsVisted(true);
                curr = curr.getTop();
                Image imgBkgd = curr.getImageBkgd();
                BackgroundImage bkgdSet = new BackgroundImage(imgBkgd, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bkgd = new Background(bkgdSet);
                root.setBackground(bkgd);
                //button visibility
                exitTop.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 4
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 7
                        || curr.getRoomIdentifier() == 10);
                exitRight.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 3
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 7 || curr.getRoomIdentifier() == 8
                        || curr.getRoomIdentifier() == 11);
                exitBottom.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 8 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 10);
                exitLeft.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 11);
                if(!(curr.getMonster().monsterIsDead)) {
                    attackMonster.setVisible(true);
                } else {
                    attackMonster.setVisible(false);
                }

            }
        });
    }

    public static void setExitBottomAction() {
        exitBottom.setOnAction(e -> {
            if (curr.getRoomNum() == 18) {
                if (curr.getBottom() == null) {
                    Alert alertExit = new Alert(Alert.AlertType.WARNING,
                            ("Please Choose another Exit"));
                    alertExit.show();
                }
            }
            if (curr.getBottom() != null && (curr.getMonster().getMonsterIsDead() ||
                    (!curr.getMonster().getMonsterIsDead() && curr.getBottom().getIsVisted()))) {
                curr.setIsVisted(true);
                curr = curr.getBottom();
                Image imgBkgd = curr.getImageBkgd();
                BackgroundImage bkgdSet = new BackgroundImage(imgBkgd, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bkgd = new Background(bkgdSet);
                root.setBackground(bkgd);
                //button visibility
                exitTop.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 4
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 7
                        || curr.getRoomIdentifier() == 10);
                exitRight.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 3
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 7 || curr.getRoomIdentifier() == 8
                        || curr.getRoomIdentifier() == 11);
                exitBottom.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 4 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 8 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 10);
                exitLeft.setVisible(curr.getRoomIdentifier() == 1 || curr.getRoomIdentifier() == 2
                        || curr.getRoomIdentifier() == 3 || curr.getRoomIdentifier() == 5
                        || curr.getRoomIdentifier() == 6 || curr.getRoomIdentifier() == 9
                        || curr.getRoomIdentifier() == 11);
                if(!(curr.getMonster().monsterIsDead)) {
                    attackMonster.setVisible(true);
                } else {
                    attackMonster.setVisible(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}