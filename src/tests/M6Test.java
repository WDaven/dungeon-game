package tests;
import generators.Maze;
import scenes.Main;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertTrue;
import static scenes.InitializeConfigScreen.getWeapon1;

public class M6Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new scenes.Main();
        main.start(primaryStage);
    }
    @Test
    public void challengeRoom4() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Exit Top");
        assertTrue(Maze.getCurr().getIsVisted());
    }
    @Test
    public void challengeRoom4Start() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        assertTrue(Maze.getPlayer().getPlayerHealth() == 482);
    }
    @Test
    public void mosterBossroom14() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Exit Bottom");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Left");
        clickOn("Exit Bottom");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Bottom");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Right");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Top");
        clickOn("Attack!");
        clickOn("Attack!");
    }
}
