package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide.pages.UserStory2Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test for UserStoryTest2 (Selenide version).
 * Verifies that the selected username is shown in the game profile.
 */
public class UserStory2Test {

    /** Global Selenide configuration and Allure listener, run once. */
    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /** Checks that the profile displays the username entered by the player. */
    @Test
    @DisplayName("US2 - Username introduzido aparece no perfil")
    void shouldDisplayEnteredUsernameInProfile() {
        UserStory2Page userStory2 = page(UserStory2Page.class);
        userStory2.openBattleship()
                .openRobotForm()
                .enterUsername("Teste")
                .continueToGame();
        assertEquals("Teste", userStory2.getDisplayedUsername());
    }
}