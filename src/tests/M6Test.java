package tests;

import generators.Maze;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import scenes.Main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static scenes.InitializeConfigScreen.*;
import static scenes.InitialGameScreen.getCurr;

public class M6Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new Main();
        main.start(primaryStage);
    }
    @Test
    public void challengeButtonSkipFour() { // skips over first challenge
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Exit Bottom");
        int currRoomNum = getCurr().getRoomNum();
        assertEquals(6, currRoomNum);
    }
    @Test
    public void challengeButtonFourNoExit() { // can't leave room while in challenge
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        int currRoomNum = getCurr().getRoomNum();
        assertEquals(4, currRoomNum);
    }
    @Test
    public void challengeButtonAttackFour1() {  // player health decrease
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        int playerHp = Maze.getPlayer().getPlayerHealth();
        assertEquals(482, playerHp);
    }
    @Test
    public void challengeButtonAttackFour2() {  // player health decrease
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        int playerHp = Maze.getPlayer().getPlayerHealth();
        assertEquals(446, playerHp);
    }
    @Test
    public void challengeButtonAttackFour3() {  // player health should be 500 after completing challenge
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack!");
        clickOn("Attack!");
        int playerHp = Maze.getPlayer().getPlayerHealth();
        assertEquals(500, playerHp);
    }
    @Test
    public void challengeButtonAttackFour1Disappears() {  // Attack1! becomes invisible
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        verifyThat("Attack1!", NodeMatchers.isInvisible());
    }
    @Test
    public void challengeButtonAttackFour2Disappears() {  // Attack2! becomes invisible
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        verifyThat("Attack2!", NodeMatchers.isInvisible());
    }
    @Test
    public void challengeButtonAttackFour3Disappears() {  // Attack3! becomes invisible
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Bottom");
        clickOn("OK");
        clickOn("Start Challenge");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack1!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack2!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        verifyThat("Attack!", NodeMatchers.isInvisible());
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
        Maze.setRandExitRoom(4);
        clickOn("Exit Top");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("End Game!");
        assertTrue(Maze.getCurr().getMonster().getMonsterIsDead());
    }
    @Test
    public void mosterBossroom14IsExit() {
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
        Maze.setRandExitRoom(4);
        Maze.getPlayer().setPlayerHealth(2);
        clickOn("Exit Top");
        clickOn("Attack!");
        assertTrue(!Maze.getCurr().getIsExit());
    }
    @Test
    public void challengeRoom7() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Left");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Left");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Exit Bottom");
        clickOn("Start Challenge");
        assertTrue(Maze.getCurr().getIsVisted());
    }

}