
package iscteiul.ista.blackbattleship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By settingsButton =
            By.xpath("//button[@mattooltip='Settings']");

    private final By settingsHeader =
            By.xpath("//header[.//h2[normalize-space()='Settings']]");

    private final By languageMenuButton =
            By.cssSelector("button.mat-mdc-menu-trigger[aria-haspopup='menu']");

    private final By menu =
            By.cssSelector("div[role='menu']");

    private final By spanishOption =
            By.xpath("//div[@role='menu']//button[@role='menuitem'][.//span[normalize-space()='Español']]");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSettings() {
        wait.until(
                ExpectedConditions.elementToBeClickable(settingsButton)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(settingsHeader)
        );
    }

    public void openLanguageMenu() {
        wait.until(
                ExpectedConditions.elementToBeClickable(languageMenuButton)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(menu)
        );
    }

    public void selectSpanish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(spanishOption)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/es/")
        );
    }

    public boolean isSpanishLanguageActive() {
        return driver.getCurrentUrl().contains("/es/");
    }
}
