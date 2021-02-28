import Scenes.Main;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import Scenes.initializeConfigScreen;

import static Scenes.InitialGameScreen.getMoney;
import static Scenes.initializeConfigScreen.*;
import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class MyGameTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new Scenes.Main();
        main.start(primaryStage);
    }
    @Test
    public void testMoneyEasy() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("EASY");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$2000"));
    }

    private void enterText(String s) {
        setUserInputName(s);
    }
    @Test
    public void testMoneyNormal() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("NORMAL");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$1000"));
    }
    @Test
    public void testMoneyHard() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$100"));
    }
    @Test
    public void testName() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        assertEquals("testName", getUserInputName());
    }
    @Test
    public void testWeapon1() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        assertEquals(getWeapon1(), getCurrWeaponList()[0]);
    }
    @Test
    public void testWeapon2() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        assertEquals(getWeapon1(), getCurrWeaponList()[0]);
    }
    @Test
    public void testWeapon3() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon3());
        assertEquals(getWeapon3(), getCurrWeaponList()[0]);
    }
    @Test
    public void testWeaponMissClick() {
        clickOn("START GAME");
        write("testName");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn(getWeapon3());
        assertEquals(getWeapon3(), getCurrWeaponList()[0]);
    }
    @Test
    public void textField() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        TextField tf = new TextField("");
        setTextInputName(tf);
        enterText("");
        clickOn("SET NAME");
        verifyThat("OK", NodeMatchers.isVisible());
    }
    public void testContinue() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        verifyThat("Pick an exit", NodeMatchers.isNotNull());
    }
}
