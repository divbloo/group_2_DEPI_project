package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage extends BasePage{

    public AboutPage(WebDriver driver) {
        super(driver);
    }
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By aboutLink = By.id("about_sidebar_link");

    public void openSidebarMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutLink));
    }

    public void clickAboutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink)).click();
    }
}

