package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Page Object (Selenide + Page Factory) for UserStoryTest13.
 * Encapsulates opening Settings and changing the interface language to Spanish.
 */
public class UserStory13Page {
    private static final String URL = "https://papergames.io/en/battleship";

    @FindBy(xpath = "//h1[normalize-space()='Battleship Online']")
    private SelenideElement pageHeading;

    @FindBy(xpath = "//button[@mattooltip='Settings']")
    private SelenideElement settingsButton;

    @FindBy(xpath = "//header[.//h2[normalize-space()='Settings']]")
    private SelenideElement settingsHeader;

    @FindBy(css = "button.mat-mdc-menu-trigger[aria-haspopup='menu']")
    private SelenideElement languageMenuButton;

    @FindBy(css = "div[role='menu']")
    private SelenideElement menu;

    @FindBy(xpath = "//div[@role='menu']//button[@role='menuitem'][.//span[normalize-space()='Español']]")
    private SelenideElement spanishOption;

    /** Opens Battleship and waits for the main heading. */
    @Step("Abrir a página Battleship")
    public UserStory13Page openBattleship() {
        open(URL);
        pageHeading.shouldBe(visible);
        sleep(400);
        return this;
    }

    /** Opens the Settings panel. */
    @Step("Abrir as definições")
    public UserStory13Page openSettings() {
        settingsButton.shouldBe(visible).click();
        settingsHeader.shouldBe(visible);
        sleep(350);
        return this;
    }

    /** Opens the language menu inside Settings. */
    @Step("Abrir o menu de idioma")
    public UserStory13Page openLanguageMenu() {
        languageMenuButton.shouldBe(visible).click();
        menu.shouldBe(visible);
        sleep(250);
        return this;
    }

    /** Selects Spanish and waits for the route to change to /es/. */
    @Step("Selecionar Español")
    public UserStory13Page selectSpanish() {
        spanishOption.shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("/es/"));
        sleep(500);
        return this;
    }

    /** Returns whether the current URL indicates the Spanish-language route. */
    @Step("Verificar se o idioma ativo é espanhol")
    public boolean isSpanishLanguageActive() {
        return url().contains("/es/");
    }
}