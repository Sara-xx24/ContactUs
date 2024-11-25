import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUs {
    WebDriver driver;
    public ContactUs (WebDriver driver){
        this.driver = driver;
    }
    private By contactUsHeader = By.xpath("//a[@href=\"/contact_us\"]");
    private By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
    private By nameField = By.xpath("//input[@name=\"name\"]");
    private By emailField = By.xpath("//input[@data-qa=\"email\"]");
    private By subjectField = By.xpath("//input[@data-qa=\"subject\"]");
    private By messageField = By.xpath("//textarea[@data-qa=\"message\"]");
    private By chooseFileButton = By.name("upload_file");
    private By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");
    private By successMessage = By.xpath("//div[@class=\"status alert alert-success\"]");
    private By homeButton = By.xpath("//i[@class=\"fa fa-angle-double-left\"]");
    private By homePageLogo = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");

   //Actions
    public void navigateToURL(String URL){
        driver.get(URL);
    }
    public void clickOnContactUs (){
        driver.findElement(contactUsHeader).click();
    }
    public void fillNameField(String Name){
        driver.findElement(nameField).sendKeys(Name);
    }
    public void fillEmailField(String Email){
        driver.findElement(emailField).sendKeys(Email);
    }
    public void fillSubject(String Subject){
        driver.findElement(subjectField).sendKeys(Subject);
    }
    public void fillMessage(String Message){
        driver.findElement(messageField).sendKeys(Message);
    }
    //Explicit wait until upload file function is clickable
    public void waitForFileInput(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(chooseFileButton));
    }
    public void uploadFile(String filePath){
        driver.findElement(chooseFileButton).sendKeys(filePath);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void clickHomeButton(){
        driver.findElement(homeButton).click();
    }
    public boolean homePageVisibility(){
        WebElement PageLogo = driver.findElement(homePageLogo);
        return PageLogo.isDisplayed();
    }




    //Assertions
    public void assertOnSuccessMessage(String expectedSuccessMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement RightSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        String actualSuccessMessage = driver.findElement(successMessage).getText().trim();
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

    }


}
