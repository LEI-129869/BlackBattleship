package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import iscteiul.ista.blackbattleship.selenide.pages.BattleshipHomePage;
import iscteiul.ista.blackbattleship.selenide.pages.SettingsPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory13Test {

    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("US13 - Mudar idioma da aplicação para espanhol")
    void shouldChangeApplicationLanguageToSpanish() {

        BattleshipHomePage homePage = page(BattleshipHomePage.class);
        SettingsPage settingsPage = page(SettingsPage.class);

        homePage.openBattleship();

        settingsPage.openSettings()
                .openLanguageMenu()
                .selectSpanish();

        assertTrue(
                settingsPage.isSpanishLanguageActive(),
                "A aplicação deveria estar no idioma espanhol."
        );
    }
}