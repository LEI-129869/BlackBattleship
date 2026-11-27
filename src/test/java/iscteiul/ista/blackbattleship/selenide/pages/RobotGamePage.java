package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class RobotGamePage {

    @FindBy(css = "input[formcontrolname='username']")
    private SelenideElement usernameInput;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Continue']")
    private SelenideElement continueButton;

    @FindBy(xpath = "//span[@appprofileopener]")
    private SelenideElement profileName;

    @Step("Verificar se o campo username existe")
    public boolean isUsernameInputPresent() {
        try {
            usernameInput.shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    @Step("Introduzir o username {username}")
    public RobotGamePage enterUsername(String username) {
        usernameInput.shouldBe(visible).setValue(username);

        return this;
    }

    @Step("Continuar para o jogo")
    public RobotGamePage continueToGame() {
        continueButton.shouldBe(visible).click();
        profileName.shouldBe(visible);

        return this;
    }

    @Step("Ler o username apresentado no perfil")
    public String getDisplayedUsername() {
        return profileName.shouldBe(visible).getText().trim();
    }

    @Step("Verificar se o perfil apresenta o username {username}")
    public RobotGamePage verifyUsername(String username) {
        profileName.shouldHave(exactText(username));

        return this;
    }
}