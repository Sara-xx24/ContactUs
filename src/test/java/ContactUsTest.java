import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsTest {
    WebDriver driver;
    ContactUs contactusPage;
    String Name = "Sarah";
    String Email = "www.sarahaly2000@gmail.com";
    String Subject = "Add To Cart";
    String Message = "I'm Facing a problem with Add to Cart Function";
    String ExpectedSuccessMessage = "Success! Your details have been submitted successfully.";



    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        contactusPage= new ContactUs(driver);
        contactusPage.navigateToURL("https://automationexercise.com");
    }
    @Test
    public void contactUsTC06() {
        boolean homePage = contactusPage.homePageVisibility();
        Assert.assertTrue(homePage);
        contactusPage.clickOnContactUs();
        contactusPage.fillNameField(Name);
        contactusPage.fillEmailField(Email);
        contactusPage.fillSubject(Subject);
        contactusPage.fillMessage(Message);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        contactusPage.waitForFileInput(wait);
        contactusPage.uploadFile("D:\\Software Testing\\Testing\\Sarah.jpg");
        contactusPage.clickSubmit();
        contactusPage.acceptAlert();
        contactusPage.assertOnSuccessMessage(ExpectedSuccessMessage);
        contactusPage.clickHomeButton();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }











}
