package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object for Selenium IDE scenario.
 */
/**
 * Page Object for UserStoryTest6.
 * Encapsulates starting a robot game and checking that the chronometer is running.
 */
public class UserStory6 {
    private static final String URL = "https://papergames.io/en/battleship";
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading = By.xpath("//h1[normalize-space()='Battleship Online']");
    private final By playVsRobot = By.xpath("//button[@type='button' and .//span[normalize-space()='Play vs robot']]");
    private final By usernameInput = By.cssSelector("input[formcontrolname='username']");
    private final By continueButton = By.xpath("//button[@type='submit' and normalize-space()='Continue']");
    private final By profileName = By.xpath("//span[@appprofileopener]");
    private final By gameButton = By.cssSelector(".btn.btn-outline-dark.d-flex.align-items-center.ng-star-inserted");
    private final By playerTurn = By.cssSelector("div.attack-text");

    /** Creates the page object using the active browser session. */
    public UserStory6(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Opens the Battleship page. */
    public void openBattleship() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
        pause(400);
    }

    /** Starts a robot game with the given username. */
    public void startRobotGame(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobot)).click();
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        input.sendKeys(username);
        pause(350);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(gameButton));
        wait.until(ExpectedConditions.textToBe(profileName, username));
        pause(500);
    }

    /** Waits until it is the player's turn to attack. */
    public void waitForPlayerTurn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playerTurn));
    }

    /** Returns whether it is the player's turn to attack. */
    public boolean isPlayerTurnVisible() {
        return !driver.findElements(playerTurn).isEmpty()
                && driver.findElement(playerTurn).isDisplayed();
    }

    /** Waits briefly to simulate a human interaction pause. */
    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("A pausa do teste foi interrompida.", exception);
        }
    }
}
