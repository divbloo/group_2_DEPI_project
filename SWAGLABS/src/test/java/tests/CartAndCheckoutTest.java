package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;

@Listeners({AllureTestNg.class})
public class CartAndCheckoutTest extends BaseTest {
    @Feature("cart")
    @Story(" SWAGLABS - cart Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify that the cart work correctly")

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
    public void testcart(String username, String password, boolean shouldRedirect) {
        // Starting the test in Allure
        Allure.step("Step 1: click on cart icon");
        Allure.step("Step 2: Verify that the cart work correctly");
        CartPage loginPage = new CartPage(webDriver);
        try {
            loginPage.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
CartPage cartPage = new CartPage(webDriver);
        cartPage.cart();
        cartPage.checkout("mohamed","helmy","7474");


    }
}



