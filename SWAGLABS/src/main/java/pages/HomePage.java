package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By product_sort_container = By.className("product_sort_container");
    private final By product_sort_containerHtoL = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[4]");
    private final By product_sort_containerLtoH = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
    public void homepage(){
        click(product_sort_container);
    }
public void sort () throws InterruptedException {
    click(product_sort_containerHtoL);
    click(product_sort_containerLtoH);
}

}
