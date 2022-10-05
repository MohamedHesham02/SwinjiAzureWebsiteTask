package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalCoursePage {
    public WebDriver driver;
    public By CoursesButton = By.id("btnMyCoursesList");
    public FinalCoursePage(WebDriver driver){
        this.driver = driver;
    }

    public CoursesListPage BackToCoursesList(){
        driver.findElement(CoursesButton).click();
        return new CoursesListPage(driver);
    }

}
