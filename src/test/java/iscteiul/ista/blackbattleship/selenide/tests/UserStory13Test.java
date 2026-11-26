package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide.pages.UserStory13Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit test for UserStoryTest13 (Selenide version).
 * Verifies that selecting Español changes the application route to Spanish.
 */
public class UserStory13Test {

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

    /** Opens Settings, selects Español and checks that the Spanish route is active. */
    @Test
    @DisplayName("US13 - Mudar idioma da aplicação para espanhol")
    void shouldChangeApplicationLanguageToSpanish() {
        UserStory13Page userStory13 = page(UserStory13Page.class);
        userStory13.openBattleship()
                .openSettings()
                .openLanguageMenu()
                .selectSpanish();
        assertTrue(userStory13.isSpanishLanguageActive(), "A aplicação deveria estar no idioma espanhol.");
    }
}