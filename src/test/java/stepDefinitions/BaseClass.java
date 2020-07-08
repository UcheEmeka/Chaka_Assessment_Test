package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

import java.util.Properties;


public class BaseClass {
    public WebDriver driver;
    public LandingPage landingPage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public static Logger logger;
    public Properties configProp;
}
