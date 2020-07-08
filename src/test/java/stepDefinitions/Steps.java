package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass{

    @Before
    public void setup() throws IOException {
        //Reading Config properties file
        configProp = new Properties();
        //Load config file
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProp.load(configPropFile);

        logger = Logger.getLogger("Chaka_Assessment");
        PropertyConfigurator.configure("log4j.properties");

        String br = configProp.getProperty("browser");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromePath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        logger.info("***Launching browser***");
    }

    @Given("User launches the browser")
    public void user_launches_the_browser() {
       landingPage = new LandingPage(driver);
    }

    @When("user opens the URL {string}")
    public void user_opens_the_url(String url) {
        driver.get(url);
        logger.info("***Opening URL***");
    }

    //Sign Up Steps
    @Given("clicks on Sign Up")
    public void clicks_on_sign_up() {
        landingPage.clickSignUp();
        signUpPage = new SignUpPage(driver);
        logger.info("***Opening Sign up page***");
    }

    @When("User enters email as {string} and password as {string} and confirmed password {string}")
    public void user_enters_email_as_and_password_as_and_confirmed_password(String email, String pwd, String cPwd) throws InterruptedException
    {
     signUpPage.enterEmailAddress(email);
     signUpPage.enterPassword(pwd);
     signUpPage.confirmPassword(cPwd);
     logger.info("***Entered Sign up details***");
    }

    @When("clicks on Sign up button")
    public void clicks_on_sign_up_button() {
        signUpPage.clickSignUpBtn();
        logger.info("Attempting to Sign Up");
    }

    //Login Steps
    @And("clicks on Login")
    public void clicks_on_login() {
        landingPage.clickLogin();
        loginPage = new LoginPage(driver);
        logger.info("***Login page***");
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException
    {
        loginPage.typeEmail(email);
        loginPage.typePwd(password);
        logger.info("***Enter Username and Password***");
    }

    @And("Clicks on Login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
        logger.info("***Attempting to Login***");
    }

    //close browser
    @Then("close browser")
    public void close_browser() throws InterruptedException
    {
        Thread.sleep(5000);
        logger.info("***Closing browser***");
        driver.quit();
    }
}
