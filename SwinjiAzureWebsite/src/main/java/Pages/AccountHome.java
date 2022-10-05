package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountHome {
    public WebDriver driver;
    public By CoursesButton = By.id("btnMyCoursesList");
    public AccountHome(WebDriver driver){
        this.driver = driver;
    }
    public CoursesPage GoToCoursesPage(){
        driver.findElement(CoursesButton).click();
        return new CoursesPage(driver);
    }
}
