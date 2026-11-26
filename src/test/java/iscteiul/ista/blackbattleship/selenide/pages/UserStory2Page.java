package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Page Object (Selenide + Page Factory) for UserStoryTest2.
 * Encapsulates entering a username and continuing to the game profile.
 */
public class UserStory2Page {
    private static final String URL = "https://papergames.io/en/battleship";

    @FindBy(css = "button.fc-cta-do-not-consent")
    private SelenideElement doNotConsentButton;

    @FindBy(xpath = "//h1[normalize-space()='Battleship Online']")
    private SelenideElement pageHeading;

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Play vs robot']]")
    private SelenideElement playVsRobot;

    @FindBy(css = "input[formcontrolname='username']")
    private SelenideElement usernameInput;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Continue']")
    private SelenideElement continueButton;

    @FindBy(xpath = "//span[@appprofileopener]")
    private SelenideElement profileName;

    /** Opens Battleship and waits for the page heading. */
    @Step("Abrir a página Battleship")
    public UserStory2Page openBattleship() {
        open(URL);
        doNotConsentButton.shouldBe(visible).click();
        pageHeading.shouldBe(visible);
        sleep(400);
        return this;
    }

    /** Opens the robot-game username form. */
    @Step("Abrir o formulário 'Play vs robot'")
    public UserStory2Page openRobotForm() {
        playVsRobot.shouldBe(visible).click();
        usernameInput.shouldBe(visible);
        sleep(300);
        return this;
    }

    /** Enters the requested username into the form. */
    @Step("Introduzir o username {username}")
    public UserStory2Page enterUsername(String username) {
        usernameInput.shouldBe(visible).setValue(username);
        sleep(350);
        return this;
    }

    /** Submits the username form and waits for the profile name to appear. */
    @Step("Continuar para o jogo")
    public UserStory2Page continueToGame() {
        continueButton.shouldBe(visible).click();
        profileName.shouldBe(visible);
        sleep(500);
        return this;
    }

    /** Reads the username displayed in the profile control. */
    @Step("Ler o username apresentado no perfil")
    public String getDisplayedUsername() {
        return profileName.shouldBe(visible).getText().trim();
    }
}