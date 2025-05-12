package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    private final int DEFAULT_TIMEOUT = 19;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage() {
    }

    protected WebElement get(By locator) {
        return waitForElementVisible(locator);
    }

    protected void click(By locator) {
        get(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = get(locator);
        element.clear();
        element.sendKeys(text);
    }



    public boolean isDisplayed(By locator) {
        try {
            return get(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElementVisible(By locator) {
        return waitForElementVisible(locator, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        waitForPageLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }

    public WebDriver getDriver() {
        return driver;
    }


}




