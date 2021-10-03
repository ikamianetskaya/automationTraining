package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameField = By.id("username");
    By passwordField = By.id("password");
    By continueButton = By.id("login-submit");

    public JiraTicketPage login(String userName, String password){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(continueButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(continueButton).click();
        JiraTicketPage jiraTicketPage = new JiraTicketPage(driver);
        return jiraTicketPage;
    }
}
