package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver driver;
    protected By EmailField = By.id("Email");
    protected By PassField = By.id("inputPassword");
    protected By LoginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void SetEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }
    public void SetPassword(String pass){
        driver.findElement(PassField).sendKeys(pass);
    }
    public void SubmitLogin(){
        driver.findElement(LoginButton).click();
    }

    public AccountHome GoToAccountHome(String email, String password){
        SetEmail(email);
        SetPassword(password);
        SubmitLogin();
        return new AccountHome(driver);
    }

}
