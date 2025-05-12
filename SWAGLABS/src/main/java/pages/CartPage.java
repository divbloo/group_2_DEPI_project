package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
public CartPage(WebDriver driver) {
    super(driver);
}
    private final By addToCartButton = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
    private final By CartIcon = By.id("shopping_cart_container");
    private final By checkoutButton = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By checkoutContinueButton = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
    private final By checkoutFinishButton = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
    public void cart() {
        click(addToCartButton);
        click(CartIcon);

    }
    public void checkout(String firstName, String lastName, String zipcodde) {
click(checkoutButton);
type(firstNameField, firstName);
type(lastNameField, lastName);
type(zipCodeField, zipcodde);
click(checkoutContinueButton);
click(checkoutFinishButton);
    }
}



