package Pages;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class CoursesPage {
    public WebDriver driver;
    public By AddCourseButton = By.id("btnListAddCourse");
    public By CourseName = By.xpath("//input[contains(@id, 'txtCourseName')][contains(@name, 'courseName')]");
    public By SubjectList = By.id("courseSubject");
    public By SelectGrade = By.xpath("//em[contains(@class, 'lms-margin-end-5 lms-position-relative-imp')]");
    public By ChooseGrade = By.id("courseGrade");
    //public By SelectGradeRange = By.xpath("//i[contains(@class, 'lms-margin-end-5 lms-position-relative-imp')]");
    //public WebElement RightSlider = driver.findElement(By.xpath("//*[@id='divAddEditTGradeRange']/span/table/tbody/tr/td/div[2]"));
    //public WebElement LeftSlider = driver.findElement(By.xpath("//*[@id='divAddEditTGradeRange']/span/table/tbody/tr/td/div[3]"));
    Dictionary GradeRangeDict = new Hashtable();
    public By SelectTeacher = By.xpath("//*[text()='Course Teacher']");
    public By Teacher = By.xpath("//span[contains(@class, 'ui-select-choices-row-inner')]");
    public By OverallAssessments = By.xpath("//*[@id='divCompletionCriteria']/div[1]/label/em");
    public By FinalAssessment = By.xpath("//*[@id='divCompletionCriteria']/div[2]/div/label/em");
    public By Videos = By.xpath("//*[@id='divCompletionCriteria']/div[3]/label/em");
    public By None = By.xpath("//*[@id='divCompletionCriteria']/div[4]/label/i");
    public By CourseSettingTab = By.xpath("//*[text()='Course Settings']");
    public By CourseCapacity = By.id("courseCapacity");
    public By CourseLocationField = By.id("txtCourseLocationName");
    public By InvitationOnly = By.xpath("//*[@id='divJoiningMethody']/div[1]/label/em");
    public By RequestToJoin = By.xpath("//*[@id='divJoiningMethody']/div[2]/label/em");
    public By AutoAcceptReq = By.xpath("//*[@id='lblAutoAccept']/i");
    public By EnableLearningPathsField = By.xpath("//*[@id='lblLearningPath']/i");
    public By EnableLockingField = By.xpath("//*[@id='lblSessionsSequentiallyLocked']/i");
    public By InClassField = By.xpath("//*[@id='lblInClassAchievementCoverageType']/i");
    public By QuizField = By.xpath("//*[@id='lblQuizAchievementCoverageType']/i");
    public By AssessmentField = By.xpath("//*[@id='lblAssessmentAchievementCoverageType']/i");
    public By EnableCourseTrialsField = By.xpath("//*[@id='lblResetCourse']/i");
    public By CourseTrialsNoField = By.id("resetCourseCount");
    public By VideoSettings = By.xpath("//*[text()='Video-Based Course Settings']");
    public By playCourseOptionField = By.xpath("//*[@id='lblPlayCourse']/i");
    public By CreateButton = By.id("btnSaveAsDraftCourse");


    public CoursesPage(WebDriver driver){
        this.driver = driver;
    }
    public void ClickAddCourse(){
        driver.findElement(AddCourseButton).click();
    }
    public FinalCoursePage WriteCourseDetails() throws IOException {

        FileInputStream TestData = new FileInputStream("C:\\Users\\Mohamed\\IdeaProjects\\SwinjiAzureWebsite\\src\\main\\resources\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(TestData);
        XSSFSheet sheet = workbook.getSheetAt(0);

        String courseNameIn = sheet.getRow(2).getCell(1).toString();
        driver.findElement(CourseName).sendKeys(courseNameIn);

        String subject = sheet.getRow(3).getCell(1).getStringCellValue();
        Select subLI = new Select(driver.findElement(SubjectList));
        subLI.selectByVisibleText(subject);

        String gradeType = sheet.getRow(4).getCell(1).getStringCellValue();

        if (gradeType.contains("A") == true){
            driver.findElement(SelectGrade).click();
            Select GradLI = new Select(driver.findElement(ChooseGrade));
            try {
                String grade = sheet.getRow(5).getCell(1).toString();
                double gradedo = Double.parseDouble(grade);
                int gradein = (int) gradedo;
                grade = String.valueOf(gradein);
                GradLI.selectByVisibleText(grade);
            }
            catch(Exception e){
                String grade = sheet.getRow(5).getCell(1).toString();
                GradLI.selectByVisibleText(grade);
            }

        }

        /*

        else if (gradeType == "B") {
            driver.findElement(SelectGradeRange).click();

            GradeRangeDict.put("1", 0);
            GradeRangeDict.put("2", 7.7);
            GradeRangeDict.put("3", 15.4);
            GradeRangeDict.put("4", 23.1);
            GradeRangeDict.put("5", 30.8);
            GradeRangeDict.put("6", 38.5);
            GradeRangeDict.put("7", 46.2);
            GradeRangeDict.put("8", 53.8);
            GradeRangeDict.put("9", 61.5);
            GradeRangeDict.put("10", 69.2);
            GradeRangeDict.put("11", 76.9);
            GradeRangeDict.put("12", 84.6);
            GradeRangeDict.put("Higher Education", 92.3);
            GradeRangeDict.put("Other", 100);

            String StartPoint = sheet.getRow(6).getCell(1).toString();
            String EndPoint = sheet.getRow(7).getCell(1).toString();

            double StartPointdo = Double.parseDouble(StartPoint);
            int StartPointin = (int) StartPointdo;

            double EndPointdo = Double.parseDouble(EndPoint);
            int EndPointin = (int) EndPointdo;

            StartPoint = String.valueOf(StartPointin);
            EndPoint = String.valueOf(EndPointin);

            int StartPointPercent = (int) GradeRangeDict.get(StartPoint);
            int EndPointPercent = (int) GradeRangeDict.get(EndPoint);

            int rwidth = RightSlider.getSize().getWidth();
            Actions move = new Actions(driver);
            move.dragAndDropBy(RightSlider, rwidth * 3, 0).build().perform();

            int lwidth = LeftSlider.getSize().getWidth();
            move = new Actions(driver);
            move.dragAndDropBy(LeftSlider, -lwidth * 2, 0).build().perform();

        }

         */

        driver.findElement(SelectTeacher).click();
        driver.findElement(Teacher).click();

        String CompCriteria = sheet.getRow(8).getCell(1).toString();
        if(CompCriteria.contains("A") == true){
            driver.findElement(OverallAssessments).click();
        }
        else if (CompCriteria.contains("B") == true) {
            driver.findElement(FinalAssessment).click();
        }
        else if (CompCriteria.contains("C") == true) {
            driver.findElement(Videos).click();
        }
        else if (CompCriteria.contains("D") == true) {
            driver.findElement(None).click();
        }


        driver.findElement(CourseSettingTab).click();

        String capacity = sheet.getRow(10).getCell(1).toString();
        driver.findElement(CourseCapacity).sendKeys(capacity);
        driver.findElement(CourseCapacity).sendKeys(Keys.BACK_SPACE);
        driver.findElement(CourseCapacity).sendKeys(Keys.BACK_SPACE);

        String courseLocation = sheet.getRow(11).getCell(1).toString();
        driver.findElement(CourseLocationField).sendKeys(courseLocation);

        String JoiningMethod = sheet.getRow(12).getCell(1).toString();
        if(JoiningMethod.contains("A") == true){
            driver.findElement(InvitationOnly).click();
        }
        else if (JoiningMethod.contains("B") == true) {
            driver.findElement(RequestToJoin).click();
            String AutoAcceptRequest = sheet.getRow(13).getCell(1).toString();
            if(AutoAcceptRequest.contains("Y") == true){
                driver.findElement(AutoAcceptReq).click();
            }
        }

        String EnableLearningPaths = sheet.getRow(14).getCell(1).toString();
        if(EnableLearningPaths.contains("Y") == true){
            driver.findElement(EnableLearningPathsField).click();
        }

        String EnableLocking = sheet.getRow(15).getCell(1).toString();
        if(EnableLocking.contains("Y") == true){
            driver.findElement(EnableLockingField).click();
        }

        String InClass = sheet.getRow(16).getCell(1).toString();
        if(InClass.contains("Y") == true){
            driver.findElement(InClassField).click();
        }

        String Quiz = sheet.getRow(17).getCell(1).toString();
        if(Quiz.contains("Y") == true){
            driver.findElement(QuizField).click();
        }

        String Assessment = sheet.getRow(18).getCell(1).toString();
        if(Assessment.contains("Y") == true){
            driver.findElement(AssessmentField).click();
        }

        String EnableCourseTrials = sheet.getRow(19).getCell(1).toString();
        if(EnableCourseTrials.contains("Y") == true){
            driver.findElement(EnableCourseTrialsField).click();
            String CourseTrials = sheet.getRow(20).getCell(1).toString();
            driver.findElement(CourseTrialsNoField).sendKeys(Keys.BACK_SPACE);
            driver.findElement(CourseTrialsNoField).sendKeys(CourseTrials);
            driver.findElement(CourseTrialsNoField).sendKeys(Keys.BACK_SPACE);
            driver.findElement(CourseTrialsNoField).sendKeys(Keys.BACK_SPACE);
        }

        driver.findElement(VideoSettings).click();
        String playCourseOption = sheet.getRow(21).getCell(1).toString();
        if(playCourseOption.contains("Y") == true){
            driver.findElement(playCourseOptionField).click();
        }

        driver.findElement(CreateButton).click();

        return new FinalCoursePage(driver);
    }
}
