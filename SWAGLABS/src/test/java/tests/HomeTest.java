package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners({AllureTestNg.class})

public class HomeTest extends BaseTest{
    @Feature("homePage")
    @Story(" SWAGLABS - sort Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify that the cart work y")
    @DataProvider(name = "users")
    public Object[][] userProvider() {
        return new Object[][]{
                // username            password          shouldRedirect
                {"standard_user",       "secret_sauce",   true},
                {"problem_user",        "secret_sauce",   true},
                {"performance_glitch_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "users")
    public void hometest(String username, String password, boolean shouldRedirect ) {
        HomePage loginPage = new HomePage(webDriver);
        try {
            loginPage.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            HomePage homePage = new HomePage(webDriver);
            homePage.homepage();
        try {
            homePage.sort();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    }



