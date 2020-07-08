package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class SignUpPage {

    private WebDriver driver;
    WaitHelper waitHelper;
    Actions actions;

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waitHelper = new WaitHelper(this.driver);
        actions = new Actions(driver);
    }

    @FindBy(css="form>div:nth-child(3)>label>input")
    @CacheLookup
    WebElement emailAddressField;

    @FindBy(css="form>div:nth-child(4)>label>input")
    @CacheLookup
    WebElement createPasswordField;

    @FindBy(css="form>div:nth-child(5)>label>input")
    @CacheLookup
    WebElement confirmPasswordField;

    //Enter sign up email address
    public void enterEmailAddress(String email) throws InterruptedException
    {
        Thread.sleep(3000);
        actions.sendKeys(emailAddressField, email).perform();
    }

    //Enter sign up password
    public void enterPassword(String password)
    {
        actions.sendKeys(createPasswordField, password).perform();
    }

    //Enter confirmed password
    public void confirmPassword(String password)
    {
        actions.sendKeys(confirmPasswordField, password).perform();
    }



}
