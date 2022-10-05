package Base;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginpage;

    @BeforeClass
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohamed\\IdeaProjects\\SwinjiAzureWebsite\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://swinji.azurewebsites.net");
        driver.manage().window().maximize();
        loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }

    public static void main(String args[]){
        BaseTest Tester = new BaseTest();
        Tester.SetUP();
        Tester.TearDown();
    }


}
