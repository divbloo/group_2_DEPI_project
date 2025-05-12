package tests;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.*;
import pages.AboutPage;
import pages.LoginPage;

@Listeners({AllureTestNg.class})
public class AboutTest extends BaseTest {

    private LoginPage loginPage;
    private AboutPage aboutPage;
    private static int successCount = 0;
    private static int bugCount = 0;

    @DataProvider(name = "users")
    public Object[][] userProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true},
                {"performance_glitch_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "users")
    public void testAboutButtonRedirect(String username, String password, boolean shouldRedirect) {
            try {
                loginPage = new LoginPage(webDriver);
                aboutPage = new AboutPage(webDriver);

                loginPage.login(username, password);

                // تحقق من تسجيل الدخول بناءً على وجود عنصر متوقع
                boolean loginSuccess = webDriver.getCurrentUrl().contains("inventory.html");

                if (!loginSuccess) {
                    if (!shouldRedirect) {
                        registerSuccess(username + " was correctly blocked from logging in.");
                    } else {
                        registerBug(username + " was unexpectedly blocked from logging in.");
                    }
                    return;
                }

                aboutPage.openSidebarMenu();
                aboutPage.clickAboutButton();

                String currentUrl = webDriver.getCurrentUrl().toLowerCase();
                boolean redirectSuccess = currentUrl.startsWith("https://saucelabs.com");

                if (redirectSuccess == shouldRedirect) {
                    registerSuccess(username + " redirect " + (shouldRedirect ? "worked" : "blocked"));
                } else {
                    registerBug(username + " redirect unexpectedly " + (redirectSuccess ? "worked" : "failed"));
                }

                if (redirectSuccess) {
                    webDriver.navigate().back();
                }

            } catch (Exception e) {
                registerBug("Test crashed for " + username + ": " + e.getMessage());
}

    }

    private void registerSuccess(String message) {
        successCount++;
        System.out.println("[SUCCESS] " + message);
    }

    private void registerBug(String message) {
        bugCount++;
        System.out.println("[BUG] " + message);
    }
}