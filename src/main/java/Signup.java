import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Signup {
    WebDriver driver;

    public Signup (WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By homeIcon = By.xpath("//i[@class=\"fa fa-home\"]");
    private By signUpTabButton = By.xpath("//a[@href=\"/login\"]");
    private By newUserSignup = By.xpath("//h2[text()=\"New User Signup!\"]");
    private By signUpNameField = By.xpath("//input[@data-qa=\"signup-name\"]") ;
    private By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]") ;
    private By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]") ;
    private By enterAccountInformation = By.xpath("//b[text()=\"Enter Account Information\"]");
    private By femaleGender = By.xpath("//input[@id=\"id_gender2\"]");
    private By maleGender = By.xpath("//input[@id=\"id_gender1\"]");
    private By passwordField = By.xpath("//input[@data-qa=\"password\"]");
    private By newsLetterCheckbox = By.xpath("//input[@name=\"newsletter\"]");
    private By specialOffersCheckbox = By.xpath("//input[@name=\"optin\"]");
    private By firstNameField = By.xpath("//input[@data-qa=\"first_name\"]");
    private By lastNameField = By.xpath("//input[@data-qa=\"last_name\"]");
    private By companyField = By.xpath("//input[@data-qa=\"company\"]");
    private By firstAddressField = By.xpath("//input[@data-qa=\"address\"]");
    private By secondAddressField = By.xpath("//input[@data-qa=\"address2\"]");
    private By stateField = By.xpath("//input[@data-qa=\"state\"]");
    private By cityField = By.xpath("//input[@data-qa=\"city\"]");
    private By zipcodeField = By.xpath("//input[@data-qa=\"zipcode\"]");
    private By mobileNumberField = By.xpath("//input[@data-qa=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private By accountCreated = By.xpath("//b[text()=\"Account Created!\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By accountDeleted = By.xpath("//b[text()=\"Account Deleted!\"]");
    private By invalidsignupMessage = By.xpath("//p[@style=\"color: red;\"]");


    //Actions

    //URL
    public void navigateToURL (String URL) {driver.get(URL);}
    //Signup Tab
    public void clickOnSignUpTab () { driver.findElement(signUpTabButton).click();}
    //Signup Name

    public void fillSignUpNameField (String Name) {
        driver.findElement(signUpNameField).sendKeys(Name);
    }
    public void fillSignUpEmailField (String Email) {
        driver.findElement(signUpEmailField).sendKeys(Email);
    }
    public void fillSignupData(String Name , String email){
        fillSignUpNameField(Name);
        fillSignUpEmailField(email);}
    public void clickSignUp () {
        driver.findElement(signUpButton).click();
    }
    public void clickGender () {driver.findElement(femaleGender).click(); }
    public void fillPassword (String Password){
        driver.findElement(passwordField).sendKeys(Password);
    }
    public void clickOnNewsLetter (){
        driver.findElement(newsLetterCheckbox).click();
    }
    public void clickOnSpecialOffers(){
        driver.findElement(specialOffersCheckbox).click();
    }
    public void fillFirstName (String FirstName){
        driver.findElement(firstNameField).sendKeys(FirstName);
    }
    public void fillLastName(String LastName){
        driver.findElement(lastNameField).sendKeys(LastName);
    }
    public void fillCompany(String Company){
        driver.findElement(companyField).sendKeys(Company);
    }
    public void fillAddress1(String Address1){
        driver.findElement(firstAddressField).sendKeys(Address1);
    }
    public void fillAddress2(String Address2){
        driver.findElement(secondAddressField).sendKeys(Address2);
    }
    public void fillState (String State){
        driver.findElement(stateField).sendKeys(State);
    }
    public void fillCity (String City){
        driver.findElement(cityField).sendKeys(City);
    }
    public void fillZipcode (String ZipCode){
        driver.findElement(zipcodeField).sendKeys(ZipCode);
    }
    public void fillMobileNumber (String Mobile){
        driver.findElement(mobileNumberField).sendKeys(Mobile);
    }
    public void clickCreateAccount(){
        driver.findElement(createAccountButton).click();
    }
    public void clickContinue(){driver.findElement(continueButton).click();}
    public void clickDeleteAccount (){driver.findElement(deleteAccountButton).click();
    }

    //Assertions

    public void assertOnNewUser (String expectedNewUser){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement newUserElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignup));
        String actualNewUser = driver.findElement(newUserSignup).getText();
        Assert.assertEquals(actualNewUser,expectedNewUser);

    }
    public void assertOnAccountInformation (String expectedAccountInformation){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement accountInformation = wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountInformation));
        String actualAccountInformation = driver.findElement(enterAccountInformation).getText().trim();
        Assert.assertEquals(actualAccountInformation,expectedAccountInformation);

    }
    public void assertonAccountCreation (String expectedAccountCreated){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement AccountCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreated));
        String actualAccountCreated = driver.findElement(accountCreated).getText().trim();
        Assert.assertEquals(actualAccountCreated,expectedAccountCreated);

    }
    public void assertDeletedAccount (String expectedDeleted){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement AccountDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeleted));
        String actualDeleted = driver.findElement(accountDeleted).getText().trim();
        Assert.assertEquals(actualDeleted,expectedDeleted);

    }
    public void assertOnInvalidEmailErrorMessage (String expectedInvalidEmail){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement invalidEmailMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidsignupMessage));
        String actualErrorMessage = driver.findElement(invalidsignupMessage).getText().trim();
        Assert.assertEquals(actualErrorMessage,expectedInvalidEmail);
    }



}
