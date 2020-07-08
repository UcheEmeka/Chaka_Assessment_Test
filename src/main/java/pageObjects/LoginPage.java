package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LoginPage {

    private WebDriver driver;
    WaitHelper waitHelper;
    private Actions actions;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waitHelper = new WaitHelper(this.driver);
        actions = new Actions(this.driver);
    }

    //Email field on login page
   @FindBy(css = "div:nth-child(3)>label.form__label>input.form__input")
    @CacheLookup
    WebElement txtEmail;

    //Password field on login page
    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    WebElement txtPwd;

    //Login button
    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement loginBtn;

    //Enter user Email Address
    public void typeEmail(String emailAdd) throws InterruptedException
    {
        Thread.sleep(3000);
        actions.sendKeys(txtEmail,emailAdd).perform();
    }

    //Enter User password
    public void typePwd(String pwd)
    {
        actions.sendKeys(txtPwd,pwd).perform();
    }

    //Click login button
    public void clickLoginButton()
    {
        loginBtn.click();
    }
}
