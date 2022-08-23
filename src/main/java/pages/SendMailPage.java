package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendMailPage extends BasePage {

    @FindBy( css = ".button.primary.compose")
    WebElement writeMailButton;

    @FindBy(xpath = "//input[@name='toFieldInput']")
    WebElement inputTo;

    @FindBy(xpath = "//input[@name='subject']")
    WebElement inputSubject;

    @FindBy(id = "mce_0_ifr")
    WebElement textField;

    @FindBy(xpath="//div[@class='controls']/button[contains(@class,'button primary send')]")
    WebElement sendButton;

    public SendMailPage(WebDriver driver) {
        super(driver);
    }

    public void writeMailButtonClick(){
        waitVisibilityOfElement(Data.TIME_TO_WAIT,writeMailButton);
        writeMailButton.click();
        waitVisibilityOfElement(Data.TIME_TO_WAIT,inputTo);
    }


    public void fillTheFields(String email, String subject, String text){
        inputTo.sendKeys(email);
        inputSubject.sendKeys(subject);
        textField.sendKeys(text);
        sendButton.click();
    }


}
