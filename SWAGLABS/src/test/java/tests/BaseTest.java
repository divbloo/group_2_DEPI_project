package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    @Parameters("baseUrl")
    public void start(@Optional("https://www.saucedemo.com/v1/index.html") String baseUrl) {
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);
    }
    @AfterMethod
    public void closeBrowser () {
        if (webDriver != null) {
            webDriver.quit();
        }
    }



}
