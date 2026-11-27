package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SettingsPage {

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

    @Step("Abrir as definições")
    public SettingsPage openSettings() {
        settingsButton.shouldBe(visible).click();
        settingsHeader.shouldBe(visible);

        return this;
    }

    @Step("Abrir o menu de idioma")
    public SettingsPage openLanguageMenu() {
        languageMenuButton.shouldBe(visible).click();
        menu.shouldBe(visible);

        return this;
    }

    @Step("Selecionar Español")
    public SettingsPage selectSpanish() {
        spanishOption.shouldBe(visible).click();

        webdriver().shouldHave(urlContaining("/es/"));

        return this;
    }

    @Step("Verificar se o idioma ativo é espanhol")
    public boolean isSpanishLanguageActive() {
        return url().contains("/es/");
    }
}