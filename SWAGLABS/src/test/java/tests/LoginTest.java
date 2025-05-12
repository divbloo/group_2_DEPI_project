package tests;

import dev.failsafe.Timeout;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {

    @Feature("Login")
    @Story(" SWAGLABS - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that the user can successfully log in with valid username and password")
    public void testValidLogin() {
        // Starting the test in Allure
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);

        Allure.step("Step 2: Perform login action");
        loginPage.login("standard_user", "secret_sauce");


    }

    @Feature("Login")
    @Story("SWAGLABS - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid username and invalid password")
    public void testLoginWithInvalidPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("standard_user", "Khaled");

        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("swaglabs - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and valid password")
    public void testLoginWithInvalidUsername() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("khaled", "secret_sauce");
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("swaglabs - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and invalid password")
    public void testLoginWithInvalidUsernameAndPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("khaled", "khaled");
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("swaglabs - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "login without write a password")
    public void testLoginwithoutwriteapassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("khaled", "khaled");
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );


    }


    @Feature("Login")
    @Story("Swaglabs - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Login to the website and click go to back, then click go to forward")
    public void testLoginback() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(webDriver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("standard_user", "secret_sauce");
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");

        Allure.step("Step 4 : Navigate Back");
        webDriver.navigate().back();
        Allure.step("Step 5 : Navigate Forward");
        webDriver.navigate().forward();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

}