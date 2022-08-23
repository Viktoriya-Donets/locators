package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(name = "login")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;


    public LogInPage(WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();

    }

    public void inputData(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
    }

    public void submitButtonClick(){
        submit.click();
        waitForPageLoadComplete(Data.TIME_TO_WAIT);
    }

}
