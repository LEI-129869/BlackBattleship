package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class BattleshipHomePage {

    private static final String URL =
            "https://papergames.io/en/battleship";

    @FindBy(css = "button.fc-cta-consent")
    private SelenideElement doNotConsentButton;

    @FindBy(xpath = "//h1[normalize-space()='Battleship Online']")
    private SelenideElement pageHeading;

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Play vs robot']]")
    private SelenideElement playVsRobot;

    @Step("Abrir a página Battleship")
    public BattleshipHomePage openBattleship() {
        open(URL);

        doNotConsentButton.shouldBe(visible).click();
        pageHeading.shouldBe(visible);

        return this;
    }

    @Step("Abrir o formulário 'Play vs robot'")
    public BattleshipHomePage clickPlayVsRobot() {
        playVsRobot.shouldBe(visible).click();

        return this;
    }
}