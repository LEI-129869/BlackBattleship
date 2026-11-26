package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Page Object (Selenide + Page Factory) for UserStoryTest6.
 * Encapsulates starting a robot game and checking when it is the player's turn.
 */
public class UserStory6Page {
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

    @FindBy(css = ".btn.btn-outline-dark.d-flex.align-items-center.ng-star-inserted")
    private SelenideElement gameButton;

    @FindBy(css = "div.attack-text")
    private SelenideElement playerTurn;

    /** Opens the Battleship page, rejects the cookie banner and waits for the heading. */
    @Step("Abrir a página Battleship e rejeitar cookies")
    public UserStory6Page openBattleship() {
        open(URL);
        doNotConsentButton.shouldBe(visible).click();
        pageHeading.shouldBe(visible);
        sleep(400);
        return this;
    }

    /** Starts a robot game with the given username. */
    @Step("Iniciar jogo contra o robot com o username {username}")
    public UserStory6Page startRobotGame(String username) {
        playVsRobot.shouldBe(visible).click();
        usernameInput.shouldBe(visible).setValue(username);
        sleep(350);
        continueButton.shouldBe(visible).click();
        gameButton.shouldBe(visible);
        profileName.shouldHave(exactText(username));
        sleep(500);
        return this;
    }

    /** Waits (up to 30 s) until it is the player's turn to attack. */
    @Step("Esperar pela vez do jogador")
    public UserStory6Page waitForPlayerTurn() {
        playerTurn.shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    /** Returns whether it is the player's turn to attack. */
    @Step("Verificar se é a vez do jogador")
    public boolean isPlayerTurnVisible() {
        return playerTurn.isDisplayed();
    }
}