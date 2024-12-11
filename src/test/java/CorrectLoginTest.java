import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CorrectLoginTest {
    WebDriver driver;
    CorrectLogin loginPage;
    String expectedLoginHeader = "Login to your account";
    String email = "www.sarahaly2000@gmail.com";
    String email2 = "www.sarahaly2000@gmail.com";
    String password = "123abc";
    String password2 = "1234";
    String expectedDeletedAccount = "ACCOUNT DELETED!";
    String expectedErrorMessage = "Your email or password is incorrect!";
    String expectedUser ="Sarah";


    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginPage = new CorrectLogin(driver);
        //Test Steps
        loginPage.navigateToURL("https://automationexercise.com");
        loginPage.clickOnLoginButton();
    }
    @Test
    public void loginTC02(){

        loginPage.assertOnLoginHeader(expectedLoginHeader);
        loginPage.fillEmailField(email);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        loginPage.clickDeleteAccount();
        loginPage.assertOnthatAccountDeleted(expectedDeletedAccount); }
    @Test
    public void incorrectLoginTC03(){

        loginPage.assertOnLoginHeader(expectedLoginHeader);
        loginPage.fillEmailField(email2);
        loginPage.fillPassword(password2);
        loginPage.clickLogin();
        loginPage.assertOnErrorMessage(expectedErrorMessage);
    }
    @Test
    public void logoutTC04(){

        loginPage.assertOnLoginHeader(expectedLoginHeader);
        loginPage.fillEmailField(email);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        loginPage.assertOnUser(expectedUser);
        loginPage.clickLogout();


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }





}
