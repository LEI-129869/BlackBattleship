
package iscteiul.ista.blackbattleship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RobotGamePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput =
            By.cssSelector("input[formcontrolname='username']");

    private final By continueButton =
            By.xpath("//button[@type='submit' and normalize-space()='Continue']");

    private final By profileName =
            By.xpath("//span[@appprofileopener]");

    public RobotGamePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isUsernameInputPresent() {
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(usernameInput)
            );
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void enterUsername(String username) {
        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(usernameInput)
        );

        input.clear();
        input.sendKeys(username);
    }

    public void continueToGame() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(profileName)
        );
    }

    public String getDisplayedUsername() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(profileName)
        ).getText().trim();
    }
}
