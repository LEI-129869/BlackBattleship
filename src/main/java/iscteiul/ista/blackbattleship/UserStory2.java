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
 * Page Object for UserStoryTest2.
 * Encapsulates entering a username and continuing to the game profile.
 */
public class UserStory2 {
    private static final String URL = "https://papergames.io/en/battleship";
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading = By.xpath("//h1[normalize-space()='Battleship Online']");
    private final By playVsRobot = By.xpath("//button[@type='button' and .//span[normalize-space()='Play vs robot']]");
    private final By usernameInput = By.cssSelector("input[formcontrolname='username']");
    private final By continueButton = By.xpath("//button[@type='submit' and normalize-space()='Continue']");
    private final By profileName = By.xpath("//span[@appprofileopener]");

    /** Creates the page object using the active browser session. */
    public UserStory2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Opens Battleship and waits for the page heading. */
    public void openBattleship() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
        pause(400);
    }

    /** Opens the robot-game username form. */
    public void openRobotForm() {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobot)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        pause(300);
    }

    /** Enters the requested username into the form. */
    public void enterUsername(String username) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        input.clear();
        input.sendKeys(username);
        pause(350);
    }

    /** Submits the username form and waits for the profile name to appear. */
    public void continueToGame() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileName));
        pause(500);
    }

    /** Reads the username displayed in the profile control. */
    public String getDisplayedUsername() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileName)).getText().trim();
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
