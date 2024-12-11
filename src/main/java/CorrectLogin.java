import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CorrectLogin {
    WebDriver driver;
    public CorrectLogin(WebDriver driver) {
        this.driver = driver;

    }
    //Element Locators

    private By loginButton = By.xpath("//a[@href=\"/login\"]");
    private By loginHeader = By.xpath("//h2[text()=\"Login to your account\"]");
    private By emailField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By passwordField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginClickButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By deleteHeader = By.xpath("//b[text()='Account Deleted!']");
    private By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By loggedinUser = By.xpath("//b[text()='Sarah']");
    private By logoutTab = By.xpath("//a[@href=\"/logout\"]");

    //Methods
    public void navigateToURL (String URL){
        driver.get(URL);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void fillEmailField(String Email){
        driver.findElement(emailField).sendKeys(Email);
    }
    public void fillPassword(String Password){
        driver.findElement(passwordField).sendKeys(Password);
    }
    public void clickLogin (){
        driver.findElement(loginClickButton).click();
    }
    public void clickDeleteAccount (){
        driver.findElement(deleteAccountButton).click();
    }
    public void clickLogout(){
        driver.findElement(logoutTab).click();
    }

    //Assertions, and Validations

    public void assertOnLoginHeader (String expectedLoginHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement topLoginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
        String actualLoginHeder = driver.findElement(loginHeader).getText();
        Assert.assertEquals(actualLoginHeder,expectedLoginHeader);
    }
    public void assertOnthatAccountDeleted(String expecteddeletedAccount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DeletedAccountHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteHeader));
        String actualDeletedAccount = driver.findElement(deleteHeader).getText();
        Assert.assertEquals(actualDeletedAccount, expecteddeletedAccount);

    }
    public void assertOnErrorMessage(String expectedError){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actualError = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualError,expectedError);

    }
    public void assertOnUser(String expectedUserName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedinUser));
        String actualUserName = driver.findElement(loggedinUser).getText();
        Assert.assertEquals(actualUserName,expectedUserName);

    }
}









