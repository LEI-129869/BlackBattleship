package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Page Object (Selenide + Page Factory) for UserStoryTest1.
 * Encapsulates navigation to Battleship and opening the robot-game form.
 */
public class UserStory1Page {
    private static final String URL = "https://papergames.io/en/battleship";

    @FindBy(css = "button.fc-cta-do-not-consent")
    private SelenideElement doNotConsentButton;

    @FindBy(xpath = "//h1[normalize-space()='Battleship Online']")
    private SelenideElement pageHeading;

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Play vs robot']]")
    private SelenideElement playVsRobot;

    @FindBy(css = "input[formcontrolname='username']")
    private SelenideElement usernameInput;

    /** Opens the Battleship page and waits until its main heading is visible. */
    @Step("Abrir a página Battleship")
    public UserStory1Page openBattleship() {
        open(URL);
        doNotConsentButton.shouldBe(visible).click();
        pageHeading.shouldBe(visible);
        sleep(400);
        return this;
    }

    /** Opens the form for playing against the robot. */
    @Step("Abrir o formulário 'Play vs robot'")
    public UserStory1Page openRobotForm() {
        playVsRobot.shouldBe(visible).click();
        usernameInput.should(com.codeborne.selenide.Condition.exist);
        sleep(300);
        return this;
    }

    /** Returns whether the username input is present in the page. */
    @Step("Verificar se o campo username existe")
    public boolean isUsernameInputPresent() {
        return usernameInput.exists();
    }
}