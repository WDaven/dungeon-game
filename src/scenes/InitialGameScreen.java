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
//import static org.hamcrest.core.IsInstanceOf.instanceOf;
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
    private static Button winGame;
    private static Label money;
    private static Label exitNotif;
    private static Maze maze;
    private static Node curr;
    private static BorderPane root;
    private static Label playerStatus;
    private static Label monsterStatus;
    private static Button inventoryButton;
    private static Button challengeButton;
    private static Button monsterOne;
    private static Button monsterTwo;
    private static MonsterGreen challengeOne;
    private static MonsterGreen challengeTwo;
    private static HBox holdM;


    public static Label getMonsterStatus() {
        return monsterStatus;
    }


    public static void hideMonster() {
        attackMonster.setVisible(false);
    }

    public static Node getCurr() {
        return curr;
    }

    public static Label getMoney() {
        return money;
    }

    public static void setMoney(Label money) {
        scenes.InitialGameScreen.money = money;
    }

    public static Scene start(Stage primaryStage, Maze mazeM) {

        maze = mazeM;
        //setting start room page
        curr = Maze.getCurr();

        // constants + panes
        HBox hBox = new HBox(370);
        VBox vBox = new VBox(bkgdHeight - 100);
        Pane centerText = new Pane();
        HBox statusBox = new HBox(10);

        //Status labels
        playerStatus = new Label("Player Health:");
        playerStatus.setStyle("-fx-stroke:red; -fx-stroke-Width: 1; -fx-font: 15 arial");
        playerStatus.setAlignment(Pos.CENTER_RIGHT);
        playerStatus.setText(String.format("Player Health: %d",
                getPlayer().getPlayerHealth()));
        monsterStatus = new Label(String.format("Monster Health: %d",
                curr.getMonster().getMonsterHealth()));
        monsterStatus.setStyle("-fx-stroke:red; -fx-stroke-Width: 1; -fx-font: 15 arial");
        monsterStatus.setAlignment(Pos.CENTER_LEFT);

        // Money label etc.
        money = new Label("Money:");
        money.setStyle("-fx-stroke:black; -fx-stroke-Width: 1; -fx-font: 15 arial");
        money.setAlignment(Pos.TOP_LEFT);
        int difficulty = getGameDifficulty();
        if (difficulty == 0) {
            money.setText(money.getText().concat(" 2000"));
        }
        if (difficulty == 1) {
            money.setText(money.getText().concat(" 1000"));
        }
        if (difficulty == 2) {
            money.setText(money.getText().concat(" 100"));
        }

        //adding text labels
        statusBox.getChildren().addAll(money, playerStatus, monsterStatus);
        centerText.getChildren().add(statusBox);

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
        winGame = new Button("End Game!");
        winGame.setVisible(false);
        inventoryButton = new Button("Inventory");
        challengeButton = new Button("Start Challenge");

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
        holdT.getChildren().add(winGame);
        holdT.setAlignment(Pos.CENTER);
        holdT.setSpacing(10);
        root.setTop(holdT);

        HBox holdB = new HBox();
        holdB.getChildren().add(inventoryButton);
        holdB.getChildren().add(exitBottom);
        holdB.getChildren().add(challengeButton);
        holdB.setAlignment(Pos.BOTTOM_LEFT);
        inventoryButton.setAlignment(Pos.BOTTOM_LEFT);
        exitBottom.setAlignment(Pos.CENTER);
        challengeButton.setAlignment(Pos.BASELINE_RIGHT);
        challengeButton.setVisible(false);
        holdB.setSpacing(350);
        root.setBottom(holdB);

        holdM = new HBox();
        monsterOne = new Button("Attack!");
        monsterTwo = new Button("Attack!");
        holdM.getChildren().addAll(monsterOne, attackMonster, monsterTwo);
        monsterTwo.setVisible(false);
        monsterOne.setVisible(false);
        holdM.setAlignment(Pos.CENTER);
        holdM.setSpacing(250);
        root.setCenter(holdM);


        Image imageBkgd = curr.getImageBkgd();
        BackgroundImage bkgdSettings = new BackgroundImage(imageBkgd, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(bkgdSettings);
        root.setBackground(background);

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
        if (curr.getMonster() instanceof MonsterBlue) {
            attackMonster.setStyle("-fx-background-color: blue");
        } else if (curr.getMonster() instanceof MonsterGreen) {
            attackMonster.setStyle("-fx-background-color: green");
        }else if (curr.getMonster() instanceof MonsterRed) {
            attackMonster.setStyle("-fx-background-color: red");
        } else {
            attackMonster.setStyle("-fx-background-color: purple");
        }

        setExitLeftAction();
        setExitRightAction();
        setExitTopAction();
        setExitBottomAction();
        setInventoryAction(primaryStage, maze);
        setAttackMonsterAction(primaryStage);

        setChallengeButtonAction(primaryStage);

        setWinGameAction(primaryStage);

        // final panes and showing scene
        primaryStage.setTitle("DungeonCrawler");
        primaryStage.setScene(new Scene(root, bkgdWidth, bkgdHeight));
        root.getChildren().addAll(hBox, vBox, centerText);
        return primaryStage.getScene();
    }
    public static void setWinGameAction(Stage primaryStage) {
        winGame.setOnAction(e -> {
            primaryStage.setScene(WinGameScreen.start(primaryStage));
        });
    }
    public static void setAttackMonsterAction(Stage primaryStage) {
        attackMonster.setOnAction(e -> {
            if (getPlayer().getCurrAttackNumber() >= 1) {
                getPlayer().setCurrAttackNumber(getPlayer().getCurrAttackNumber() - 1);
                if (getPlayer().getCurrAttackNumber() == 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() - 10);
                }
            }
            int playerHealth = getPlayer().getPlayerHealth();
            int monsterDamage = curr.getMonster().getMonsterDamage();
            int playerDamage = getPlayer().getPlayerDamage();
            int monsterHealth = curr.getMonster().getMonsterHealth();
            getPlayer().setPlayerHealth(playerHealth - monsterDamage);
            if (getPlayer().getPlayerHealth() <= 0) {
                primaryStage.setScene(GameOver.start(primaryStage));
            }
            curr.getMonster().setMonsterHealth(monsterHealth - playerDamage);
            if (curr.getMonster().getMonsterHealth() <= 0) {
                curr.getMonster().setMonsterIsDead(true);
            }
            monsterStatus.setText(String.format("Monster Health: %d",
                    curr.getMonster().getMonsterHealth()));
            playerStatus.setText(String.format("Player Health: %d",
                    getPlayer().getPlayerHealth()));
            if (curr.getMonster().getMonsterIsDead()) {
                attackMonster.setVisible(false);
                if (curr.getDropItem().equals("dagger")) {
                    System.out.println("dagger");
                    Inventory.setNumDaggers(Inventory.getNumDaggers() + 1); // adding to inventory
                } else if (curr.getDropItem().equals("sword")) {
                    System.out.println("sword" + Inventory.getNumSwords());
                    Inventory.setNumSwords(Inventory.getNumSwords() + 1);
                } else if (curr.getDropItem().equals("health potion")) {
                    System.out.println("health potion");
                    Inventory.setNumHPotion(Inventory.getNumHPotion() + 1);
                } else if (curr.getDropItem().equals("attack potion")) {
                    System.out.println("attack potion");
                    Inventory.setNumAPotion(Inventory.getNumAPotion() + 1);
                } else if (curr.getDropItem().equals("great sword")) {
                    System.out.println("great sword");
                    Inventory.setNumGSwords(Inventory.getNumGSwords() + 1);
                } else {
                    System.out.println("crystal");
                    Inventory.setNumCrystals(Inventory.getNumCrystals() + 1);
                }
                if (curr.getRoomNum() == -1) {
                    winGame.setVisible(true);
                }
                monsterStatus.setText("Monster Health: Dead");
                // display alert that an item was dropped !!!!!!!!!!!!!!!!!!!!!!!!
                String alertStr = String.format("The monster dropped a %s."
                        + " Check your inventory.", curr.getDropItem());
                Alert alertEmpty = new Alert(Alert.AlertType.WARNING,
                        (alertStr));
                alertEmpty.show();
                if (curr.getRoomNum() == 4) {
                    exitTop.setVisible(true);
                    exitLeft.setVisible(true);
                    exitBottom.setVisible(true);
                    curr.setIsChallenge(false);
                    challengeButton.setVisible(false);
                    inventoryButton.setVisible(true);
                    getPlayer().setPlayerHealth(500);
                    playerStatus.setText(String.format("Player Health: %d",
                            getPlayer().getPlayerHealth()));
                } else if (curr.getRoomNum() == 7) {
                    exitTop.setVisible(true);
                    exitRight.setVisible(true);
                    exitBottom.setVisible(true);
                    curr.setIsChallenge(false);
                    challengeButton.setVisible(false);
                    getPlayer().setPlayerHealth(500);
                    playerStatus.setText(String.format("Player Health: %d",
                            getPlayer().getPlayerHealth()));
                }
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
            if (curr.getLeft() != null && (curr.getMonster().getMonsterIsDead()
                    || (!curr.getMonster().getMonsterIsDead() && curr.getLeft().getIsVisted()))) {
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
                if (curr.getMonster() instanceof MonsterBlue) {
                    attackMonster.setStyle("-fx-background-color: blue");
                } else if (curr.getMonster() instanceof MonsterGreen) {
                    attackMonster.setStyle("-fx-background-color: green");
                }else if (curr.getMonster() instanceof MonsterRed) {
                    attackMonster.setStyle("-fx-background-color: red");
                } else {
                    attackMonster.setStyle("-fx-background-color: purple");
                }
                if (!(curr.getMonster().getMonsterIsDead()) && !(curr.getIsChallenge())) {
                    attackMonster.setVisible(true);
                    challengeButton.setVisible(false);
                } else if (curr.getIsChallenge()){
                    curr.getMonster().setMonsterIsDead(true);
                    attackMonster.setVisible(false);
                    challengeButton.setVisible(true);
                    String alertStr = "Click the challenge button if you wish to fight a few monsters "
                            + "to get full health back or you can proceed without completing it.";
                    Alert alertEmpty = new Alert(Alert.AlertType.WARNING,
                            (alertStr));
                    alertEmpty.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alertEmpty.show();
                } else {
                    attackMonster.setVisible(false);
                }
                monsterStatus.setText(String.format("Monster Health: %d",
                        curr.getMonster().getMonsterHealth()));
                if (curr.getMonster().getMonsterIsDead()) {
                    InitialGameScreen.hideMonster();
                    InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
                }
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
            if (curr.getRight() != null && (curr.getMonster().getMonsterIsDead()
                    || (!curr.getMonster().getMonsterIsDead() && curr.getRight().getIsVisted()))) {
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
                if (curr.getMonster() instanceof MonsterBlue) {
                    attackMonster.setStyle("-fx-background-color: blue");
                } else if (curr.getMonster() instanceof MonsterGreen) {
                    attackMonster.setStyle("-fx-background-color: green");
                }else if (curr.getMonster() instanceof MonsterRed) {
                    attackMonster.setStyle("-fx-background-color: red");
                } else {
                    attackMonster.setStyle("-fx-background-color: purple");
                }
                if (!(curr.getMonster().getMonsterIsDead()) && !(curr.getIsChallenge())) {
                    attackMonster.setVisible(true);
                    challengeButton.setVisible(false);
                } else if (curr.getIsChallenge()){
                    curr.getMonster().setMonsterIsDead(true);
                    attackMonster.setVisible(false);
                    challengeButton.setVisible(true);
                    String alertStr = "Click the challenge button if you wish to fight a few monsters "
                            + "to get full health back or you can proceed without completing it.";
                    Alert alertEmpty = new Alert(Alert.AlertType.WARNING,
                            (alertStr));
                    alertEmpty.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alertEmpty.show();
                } else {
                    attackMonster.setVisible(false);
                }
                monsterStatus.setText(String.format("Monster Health: %d",
                        curr.getMonster().getMonsterHealth()));
                if (curr.getMonster().getMonsterIsDead()) {
                    InitialGameScreen.hideMonster();
                    InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
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
            if (curr.getTop() != null && (curr.getMonster().getMonsterIsDead()
                    || (!curr.getMonster().getMonsterIsDead() && curr.getTop().getIsVisted()))) {
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
                if (curr.getMonster() instanceof MonsterBlue) {
                    attackMonster.setStyle("-fx-background-color: blue");
                } else if (curr.getMonster() instanceof MonsterGreen) {
                    attackMonster.setStyle("-fx-background-color: green");
                }else if (curr.getMonster() instanceof MonsterRed) {
                    attackMonster.setStyle("-fx-background-color: red");
                } else {
                    attackMonster.setStyle("-fx-background-color: purple");
                }
                if (!(curr.getMonster().getMonsterIsDead()) && !(curr.getIsChallenge())) {
                    attackMonster.setVisible(true);
                    challengeButton.setVisible(false);
                } else if (curr.getIsChallenge()){
                    curr.getMonster().setMonsterIsDead(true);
                    attackMonster.setVisible(false);
                    challengeButton.setVisible(true);
                    String alertStr = "Click the challenge button if you wish to fight a few monsters "
                            + "to get full health back or you can proceed without completing it.";
                    Alert alertEmpty = new Alert(Alert.AlertType.WARNING,
                            (alertStr));
                    alertEmpty.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alertEmpty.show();
                } else {
                    attackMonster.setVisible(false);
                }
                monsterStatus.setText(String.format("Monster Health: %d",
                        curr.getMonster().getMonsterHealth()));
                if (curr.getMonster().getMonsterIsDead()) {
                    InitialGameScreen.hideMonster();
                    InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
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
            if (curr.getBottom() != null && (curr.getMonster().getMonsterIsDead()
                    || (!curr.getMonster().getMonsterIsDead() && curr.getBottom().getIsVisted()))) {
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
                if (curr.getMonster() instanceof MonsterBlue) {
                    attackMonster.setStyle("-fx-background-color: blue");
                } else if (curr.getMonster() instanceof MonsterGreen) {
                    attackMonster.setStyle("-fx-background-color: green");
                }else if (curr.getMonster() instanceof MonsterRed) {
                    attackMonster.setStyle("-fx-background-color: red");
                } else {
                    attackMonster.setStyle("-fx-background-color: purple");
                }
                if (!(curr.getMonster().getMonsterIsDead()) && !(curr.getIsChallenge())) {
                    attackMonster.setVisible(true);
                    challengeButton.setVisible(false);
                } else if (curr.getIsChallenge()){
                    curr.getMonster().setMonsterIsDead(true);
                    attackMonster.setVisible(false);
                    challengeButton.setVisible(true);
                    String alertStr = "Click the challenge button if you wish to fight a few monsters "
                            + "to get full health back or you can proceed without completing it.";
                    Alert alertEmpty = new Alert(Alert.AlertType.WARNING,
                            (alertStr));
                    alertEmpty.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alertEmpty.show();
                } else {
                    attackMonster.setVisible(false);
                }
                monsterStatus.setText(String.format("Monster Health: %d",
                        curr.getMonster().getMonsterHealth()));
                if (curr.getMonster().getMonsterIsDead()) {
                    InitialGameScreen.hideMonster();
                    InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
                }
            }
        });
    }

    public static void setInventoryAction(Stage primaryStage, Maze maze) {
        inventoryButton.setOnAction(e -> {
            primaryStage.setScene(Inventory.start(primaryStage, maze, curr));
        });
    }
    public static void setChallengeButtonAction(Stage primaryStage) {
        challengeButton.setOnAction(e -> {
            inventoryButton.setVisible(false);
            challengeOne = new MonsterGreen();
            challengeOne.setMonsterIsDead(false);
            challengeTwo = new MonsterGreen();
            challengeTwo.setMonsterIsDead(false);
            attackMonster.setVisible(false);
            monsterOne.setVisible(true);
            monsterTwo.setVisible(true);
            setMonsterOneAction(primaryStage);
            setMonsterTwoAction(primaryStage);
            monsterStatus.setText(String.format("Monster Health: %d",
                    curr.getMonster().getMonsterHealth()));
            if (curr.getMonster().getMonsterIsDead()) {
                InitialGameScreen.hideMonster();
                InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
            }
            exitBottom.setVisible(false);
            exitTop.setVisible(false);
            exitLeft.setVisible(false);
            exitRight.setVisible(false);
        });
    }
    public static void setMonsterOneAction(Stage primaryStage) {
        monsterOne.setOnAction(e -> {
            if (getPlayer().getCurrAttackNumber() >= 1) {
                getPlayer().setCurrAttackNumber(getPlayer().getCurrAttackNumber() - 1);
                if (getPlayer().getCurrAttackNumber() == 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() - 10);
                }
            }
            int playerHealth = getPlayer().getPlayerHealth();
            int monsterDamage = challengeOne.getMonsterDamage();
            int playerDamage = getPlayer().getPlayerDamage();
            int monsterHealth = challengeOne.getMonsterHealth();
            getPlayer().setPlayerHealth(playerHealth - monsterDamage);
            if (getPlayer().getPlayerHealth() <= 0) {
                primaryStage.setScene(GameOver.start(primaryStage));
            }
            challengeOne.setMonsterHealth(monsterHealth - playerDamage);
            if (challengeOne.getMonsterHealth() <= 0) {
                System.out.println("enter if");
                challengeOne.setMonsterIsDead(true);
                monsterOne.setVisible(false);
                monsterStatus.setText("Monster Health: Dead");
            } else {
                monsterStatus.setText(String.format("Monster Health: %d",
                        challengeOne.getMonsterHealth()));
            }
            if (challengeOne.getMonsterHealth() <= 0 && challengeTwo.getMonsterHealth() <= 0) {
                attackMonster.setVisible(true);
                curr.getMonster().setMonsterIsDead(false);
            }
            playerStatus.setText(String.format("Player Health: %d",
                    getPlayer().getPlayerHealth()));

        });
    }
    public static void setMonsterTwoAction(Stage primaryStage) {
        monsterTwo.setOnAction(e -> {
            if (getPlayer().getCurrAttackNumber() >= 1) {
                getPlayer().setCurrAttackNumber(getPlayer().getCurrAttackNumber() - 1);
                if (getPlayer().getCurrAttackNumber() == 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() - 10);
                }
            }
            int playerHealth = getPlayer().getPlayerHealth();
            int monsterDamage = challengeTwo.getMonsterDamage();
            int playerDamage = getPlayer().getPlayerDamage();
            int monsterHealth = challengeTwo.getMonsterHealth();
            getPlayer().setPlayerHealth(playerHealth - monsterDamage);
            if (getPlayer().getPlayerHealth() <= 0) {
                primaryStage.setScene(GameOver.start(primaryStage));
            }
            challengeTwo.setMonsterHealth(monsterHealth - playerDamage);
            if (challengeTwo.getMonsterHealth() <= 0) {
                challengeTwo.setMonsterIsDead(true);
                monsterTwo.setVisible(false);
                monsterStatus.setText("Monster Health: Dead");
            } else {
                monsterStatus.setText(String.format("Monster Health: %d",
                        challengeTwo.getMonsterHealth()));
            }
            if (challengeOne.getMonsterHealth() <= 0 && challengeTwo.getMonsterHealth() <= 0) {
                attackMonster.setVisible(true);
                curr.getMonster().setMonsterIsDead(false);
            }
            playerStatus.setText(String.format("Player Health: %d",
                    getPlayer().getPlayerHealth()));

        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}