package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Page Object (Selenide + Page Factory) for UserStoryTest5.
 * Encapsulates starting a robot game and firing at a specific opponent-board cell.
 */
public class UserStory5Page {
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
    private SelenideElement attackText;

    @FindBy(xpath = "(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]")
    private SelenideElement targetCell;

    @FindBy(xpath = "(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]"
            + "//*[contains(concat(' ',@class,' '),' no-hit ') or contains(concat(' ',@class,' '),' hit ')]")
    private SelenideElement targetCellResult;

    /** Opens the Battleship page, rejects the cookie banner and waits for the heading. */
    @Step("Abrir a página Battleship e rejeitar cookies")
    public UserStory5Page openBattleship() {
        open(URL);
        doNotConsentButton.shouldBe(visible).click();
        pageHeading.shouldBe(visible);
        sleep(400);
        return this;
    }

    /** Starts a robot game using the supplied player name. */
    @Step("Iniciar jogo contra o robot com o username {username}")
    public UserStory5Page startRobotGame(String username) {
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
    public UserStory5Page waitForPlayerTurn() {
        attackText.shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    /** Fires at cell 4-2 on the opponent's board. */
    @Step("Disparar sobre a célula 4-2")
    public UserStory5Page fireAtCellFourTwo() {
        targetCell.shouldBe(visible).click();
        sleep(300);
        targetCellResult.should(exist);
        return this;
    }

    /** Returns whether the target cell displays a hit or no-hit result. */
    @Step("Verificar se a célula 4-2 mostra hit/no-hit")
    public boolean hasShotResult() {
        return targetCellResult.exists();
    }
}