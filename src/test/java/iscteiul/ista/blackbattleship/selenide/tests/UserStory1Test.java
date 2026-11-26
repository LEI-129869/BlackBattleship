package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide.pages.UserStory1Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit test for UserStoryTest1 (Selenide version).
 * Verifies that the robot-game form exposes the username field.
 */
public class UserStory1Test {

    /** Global Selenide configuration and Allure listener, run once. */
    @BeforeAll
    static void setUpAll() {
        Configuration.browser =  "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.timeout = 10_000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /** Checks that opening the robot form makes the username field available. */
    @Test
    @DisplayName("US1 - Campo username visível ao jogar contra o robot")
    void shouldDisplayUsernameFieldWhenPlayingAgainstRobot() {
        UserStory1Page userStory1 = page(UserStory1Page.class);
        userStory1.openBattleship().openRobotForm();
        assertTrue(userStory1.isUsernameInputPresent(), "O campo username deveria estar presente.");
    }
}