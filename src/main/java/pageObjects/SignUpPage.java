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

    //Email address field
    @FindBy(css="form>div:nth-child(3)>label>input")
    @CacheLookup
    WebElement emailAddressField;

    //Password field
    @FindBy(css="form>div:nth-child(4)>label>input")
    @CacheLookup
    WebElement createPasswordField;

    //Confirm password field
    @FindBy(css="form>div:nth-child(5)>label>input")
    @CacheLookup
    WebElement confirmPasswordField;

    //Sign up button
    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement signUpBtn;

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

    public void clickSignUpBtn()
    {
        signUpBtn.click();
    }



}
