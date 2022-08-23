
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Data;
import pages.LogInPage;
import pages.SendMailPage;

public class MainTest {
    WebDriver driver;

    @BeforeMethod
    public void testSetup()  {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Data.URL);
    }


    @Test
    public void isImagePresent()  {
        getLogInPage().inputData(Data.LOGIN,Data.PASSWORD);
        getLogInPage().submitButtonClick();
        getSendMailPage().writeMailButtonClick();
        getSendMailPage().fillTheFields(Data.EMAIL_ADDRESS,Data.SUBJECT,Data.TEXT);
    }

    @AfterTest(alwaysRun = true)
    public void testFinish()
    {
        driver.quit();
    }

  public WebDriver getDriver(){
        return driver;
    }
    public LogInPage getLogInPage(){
        return new LogInPage(getDriver());
    }

    public SendMailPage getSendMailPage(){
        return new SendMailPage(getDriver());
    }

}
