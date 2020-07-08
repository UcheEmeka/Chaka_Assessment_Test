package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LandingPage {

    WaitHelper waitHelper;

    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waitHelper = new WaitHelper(this.driver);
    }

    //Login element on landing page
    @FindBy(how = How.CSS, using ="nav>ul>li:nth-child(1)>a")
    @CacheLookup
    WebElement login;

    //Sign up element on landing page
    @FindBy(css = "nav>ul>li:nth-child(2)>a")
    @CacheLookup
    WebElement sign_up;

    //Click login on landing page
    public LoginPage clickLogin()
    {
        waitHelper.WaitForElement(login,3);
        login.click();
        return new LoginPage(driver);
    }

    //Click sign up on landing page
    public SignUpPage clickSignUp()
    {
        waitHelper.WaitForElement(sign_up,3);
        sign_up.click();
        return new SignUpPage(driver);
    }
}
