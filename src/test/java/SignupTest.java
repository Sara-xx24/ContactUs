import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest {
    WebDriver driver;
    Signup signupPage;
    String expectedSignupHeader="New User Signup!" ;
    String Name = "Sara" ;
    String email = "www.sarahaly2024@gmail.com";
    String email2 = "www.sarahaly2000@gmail.com";
    String expectedAccountInfo = "ENTER ACCOUNT INFORMATION";
    String Password ="123abc" ;
    String FirstName = "Sara";
    String LastName = "Ali";
    String Company = "Machinfy";
    String Address1 = "Giza,Egypt";
    String Address2 = "Giza,Egypt";
    String State = "Giza";
    String City = "Giza";
    String ZipCode = "SW1A";
    String Mobile = "01157945461";
    String expectedAccountCreated = "ACCOUNT CREATED!";
    String expectedDeletedAccount = "ACCOUNT DELETED!";
    String expectedInvalidEmailMessage = "Email Address already exist!";




    //Set up the Environment for Test cases
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //Pass the Driver to the constructor
        signupPage = new Signup(driver);
        //Methods

        signupPage.navigateToURL("https://automationexercise.com/");
        signupPage.clickOnSignUpTab();}
    @Test
    public void RegisterTC01 () {
       // signupPage.assertOnNewUser(expectedSignupHeader);
        signupPage.fillSignupData(Name,email);
        signupPage.clickSignUp();
        signupPage.assertOnAccountInformation(expectedAccountInfo);
        signupPage.clickGender();
        signupPage.fillPassword(Password);
        signupPage.clickOnNewsLetter();
        signupPage.clickOnSpecialOffers();
        signupPage.fillFirstName(FirstName);
        signupPage.fillLastName(LastName);
        signupPage.fillCompany(Company);
        signupPage.fillAddress1(Address1);
        signupPage.fillAddress2(Address2);
        signupPage.fillState(State);
        signupPage.fillCity(City);
        signupPage.fillZipcode(ZipCode);
        signupPage.fillMobileNumber(Mobile);
        signupPage.clickCreateAccount();
        signupPage.assertonAccountCreation(expectedAccountCreated);
        signupPage.clickContinue();
        signupPage.clickDeleteAccount();
        signupPage.assertDeletedAccount(expectedDeletedAccount);
    }
    @Test
    public void InvalidRegisterTC05(){
        signupPage.assertOnNewUser(expectedSignupHeader);
        signupPage.fillSignupData(Name, email2);
        signupPage.clickSignUp();
        signupPage.assertOnInvalidEmailErrorMessage(expectedInvalidEmailMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); }
}
