package AddCourse;

import Base.BaseTest;
import Pages.AccountHome;
import Pages.CoursesListPage;
import Pages.CoursesPage;
import Pages.FinalCoursePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class AddCourseTest extends BaseTest {
    public String courseName;
    String path;
    public By CourseNameTit;

    @Test
    public void TestScript() throws IOException, InterruptedException {
        FileInputStream TestData = new FileInputStream("C:\\Users\\Mohamed\\IdeaProjects\\SwinjiAzureWebsite\\src\\main\\resources\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(TestData);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String username = sheet.getRow(0).getCell(1).toString();
        String password = sheet.getRow(1).getCell(1).toString();
        AccountHome AccountDashboard = loginpage.GoToAccountHome(username, password);

        courseName = sheet.getRow(2).getCell(1).toString();
        path = "//*[text()='"+courseName+"']";
        CourseNameTit = By.xpath(path);
        CoursesPage courses = AccountDashboard.GoToCoursesPage();
        courses.ClickAddCourse();

        FinalCoursePage finalCourse = courses.WriteCourseDetails();

        if (driver.findElement(CourseNameTit).isDisplayed() == true){
            System.out.println("Course Saved Successfully");
        }
        CoursesListPage LastStep = finalCourse.BackToCoursesList();
        if (driver.findElement(CourseNameTit).isDisplayed() == true){
            System.out.println("Course Saved Successfully");
        }

    }


}
