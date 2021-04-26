package tests;
import generators.Maze;

import scenes.Main;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static scenes.InitialGameScreen.getCurr;
import static scenes.InitializeConfigScreen.*;
import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class M3Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new scenes.Main();
        main.start(primaryStage);
    }
    //some of these test will need to be re-made to account for m4 conditions that
    //monster must be dead before continue'ing
    @Test
    public void deadEndRoomEighteen() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
        clickOn("Exit Left");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
        clickOn("Exit Bottom");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
    }
    @Test
    public void deadEndRoomFourteen() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(0);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        clickOn("Exit Top");
        //end of pathing
        clickOn("Exit Right");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
        clickOn("Exit Left");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
        clickOn("Exit Top");
        verifyThat("Please Choose another Exit", NodeMatchers.isVisible());
        clickOn("OK");
    }
    @Test
    public void randomRolls0() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(0);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls1() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(1);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Bottom");
        clickOn("Exit Bottom");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls2() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(2);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Top");
        clickOn("Exit Left");
        clickOn("Exit Bottom");
        clickOn("Exit Left");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls3() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(3);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls4() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Top");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls5() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(5);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Left");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void randomRolls6() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(6);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Right");
        clickOn("Exit Bottom");
        clickOn("Exit Right");
        clickOn("Exit Top");
        clickOn("Exit Left");
        assertEquals(-1, getCurr().getRoomNum());
    }
    @Test
    public void verifyStart() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        assertEquals(0, getCurr().getRoomNum());
    }
    @Test
    public void verifyEndGoBackIntegrity() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(6);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        int holder1 = getCurr().getRoomNum();
        clickOn("Exit Top");
        clickOn("Exit Bottom");
        int holder2 = getCurr().getRoomNum();
        assertEquals(holder1, holder2);
    }


}