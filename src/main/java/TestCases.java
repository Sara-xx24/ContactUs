import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCases {

    WebDriver driver;
    public TestCases (WebDriver driver){
        this.driver = driver;

    }
    private By homePage = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By testCasesHeader = By.xpath("//a[@class=\"test_cases_list\"]");
    private By testCasesPage = By.xpath("//h2[@class=\"title text-center\"]");
    private By productsHeader = By.xpath("//a[@href=\"/products\"]");
    private By allProductsHeader = By.xpath("//h2[text()='All Products']");
    private By viewProductsButton = By.xpath("//a[@href=\"/product_details/1\"]");
    private By productName = By.xpath("//h2[text()='Blue Top']");
    private By productCategory = By.xpath("//p[text()='Category: Women > Tops']");
    private By productPrice = By.xpath("//span[text()='Rs. 500']");
    private By AvailabilityHeader = By.xpath("//b[text()='Availability:']");
    private By productAvailability = By.xpath("//p[text()=' In Stock']");
    private By conditionHeader = By.xpath("//b[text()='Condition:']");
    private By productsCondition = By.xpath("//p[text()=' New']");
    private By productsBrand = By.xpath("//p[text()=' Polo']");
    private By searchField = By.xpath("//input[@name=\"search\"]");
    private By searchButton = By.xpath("//button[@id=\"submit_search\"]");
    private By searchedProductsHeader =By.xpath("//h2[text()='Searched Products']");
    private By productSearchResults = By.xpath("//div[@class=\"col-sm-4\"]");
    private By pageFooter = By.xpath("//div[@class=\"footer-widget\"]");
    private By subscriptionHeader = By.xpath("//h2[text()='Subscription']");
    private By subscriptionEmailField = By.xpath("//input[@type=\"email\"]");
    private By arrowButton = By.xpath("//i[@class=\"fa fa-arrow-circle-o-right\"]");
    private By successfulSubscriptionMessage = By.xpath("//div[text()='You have been successfully subscribed!']");
    private By cartButton = By.xpath("//a[@href=\"/view_cart\"]");
    private By addToCartButton = By.xpath("//a[@data-product-id=\"1\"]");
    private By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private By addToCartButton2 = By.xpath("//a[@data-product-id=\"2\"]");
    private By viewCartButton = By.xpath("//u[text()='View Cart']");
    private By blousePrice = By.xpath("//p[text()='Rs. 500']");
    private By blouseTotalPrice = By.xpath("//p[text()='Rs. 500']");
    private By quantityOfBlouse = By.xpath("//button[text()='1']");
    private By shirtPrice = By.xpath("//p[text()='Rs. 400']");
    private By shirtTotalPrice = By.xpath("//p[text()='Rs. 400']");
    private By quantityOfTheShirt = By.xpath("//button[text()='1']");
    private By viewProductButton = By.xpath("//a[@href=\"/product_details/3\"]");
    private By productInformation = By.xpath("//div[@class=\"product-information\"]");
    private By quantityField = By.xpath("//input[@type=\"number\"]");
    private By addToCart = By.xpath("//button[@type=\"button\"]");
    private By theTotalQuantity = By.xpath("//button[text()='4']");







    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }
    //To assert that home page is visible
    public boolean homePageVisibility() {
        WebElement HomeLogo = driver.findElement(homePage);
        return HomeLogo.isDisplayed();
    }
    public void waitForTestCasesHeader(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(testCasesHeader));
    }
    public void clickOnTestCasesHeader(){
        driver.findElement(testCasesHeader).click();
    }
    public void clickOnProducts(){
        driver.findElement(productsHeader).click();
    }
    public void clickOnViewProduct(){
        driver.findElement(viewProductsButton).click();
    }
    // For Brand Assertion
    public String brandNameMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brandNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productsBrand));
        return brandNameElement.getText();
    }
    public String preprocessBrandName(String brandName) {
        return brandName.trim();
    }
    public void typeInSearchBar(String Product){
        driver.findElement(searchField).sendKeys(Product);
    }
    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }
    public List<WebElement> viewSearchResults(){
        driver.findElements(productSearchResults);
        return null;
    }

    //Method To scroll Down to the footer
    // This Method called JavaScriptExecutor
    public void scrollToTheFooter(){
       WebElement Footer =  driver.findElement(pageFooter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Footer);
    }

    public void clickOnCartButton(){
        driver.findElement(cartButton).click();
    }
    public void waitForAddToCart(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }
    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void waitForContinueShoppingButton(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
    }
    public void clickToContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }
    public void waitForAddToCart2(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton2));
    }
    public void clickAddToCart2(){
        driver.findElement(addToCartButton2).click();
    }
    public void waitForViewCart(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
    }
    public void clickViewCart(){
        driver.findElement(viewCartButton).click();
    }



    // Enter Subscription Email
    public void enterSubscriptionMail(String subscriptionEmail){
        driver.findElement(subscriptionEmailField).sendKeys(subscriptionEmail);
    }
    public void clickOnArrowButton(){
        driver.findElement(arrowButton).click();
    }

    public void clickOnViewTheProduct(){
        driver.findElement(viewProductButton).click();
    }
    public boolean productInformationVisibility() {
        WebElement productDetails = driver.findElement(productInformation);
        return productDetails.isDisplayed();
    }

    // a Method to insert the desired quantity of product
    public void setQuantity(String quantity) {
        WebElement quantityInput = driver.findElement(quantityField);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }
    public void clickOnAddToCart() {
        driver.findElement(addToCart).click();
    }





    //Assertions
    public void assertOnTestCasesPage (String expectedHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement testCasesHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesPage));
        String actualHeader = driver.findElement(testCasesPage).getText().trim();
        Assert.assertEquals(actualHeader,expectedHeader);
    }
    public void assertOnAllProductsHeader(String expectedAllProducts){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement allProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader));
        String actualAllProducts = driver.findElement(allProductsHeader).getText().trim();
        Assert.assertEquals(actualAllProducts,expectedAllProducts);
    }
    public void assertOnProductName(String expectedName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement nameOfTheProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        String actualName = driver.findElement(productName).getText().trim();
        Assert.assertEquals(actualName,expectedName);

    }
    public void assertOnProductCategory(String expectedCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement categoryOfProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory));
        String actualCategory = driver.findElement(productCategory).getText().trim();
        Assert.assertEquals(actualCategory,expectedCategory);
    }
    public void assertOnProductPrice(String expectedPrice){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Price = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        String actualPrice = driver.findElement(productPrice).getText().trim();
        Assert.assertEquals(actualPrice,expectedPrice);
    }
    public void assertOnProductAvailability(String expectedAvailability){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ProductAvailability = wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability));
        String actualAvailability = driver.findElement(productAvailability).getText().trim();
        Assert.assertEquals(actualAvailability,expectedAvailability);
    }
    public void AssertOnAvailable(String expectedAvailabilityHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ProductAvailable = wait.until(ExpectedConditions.visibilityOfElementLocated(AvailabilityHeader));
        String actualAvailable = driver.findElement(AvailabilityHeader).getText().trim();
        Assert.assertEquals(actualAvailable,expectedAvailabilityHeader);

    }
    public void assertOnConditionHeader(String expectedHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ConditionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionHeader));
        String actualCondition = driver.findElement(conditionHeader).getText().trim();

    }
    public void assertOnProductCondition(String expectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ProductCondition = wait.until(ExpectedConditions.visibilityOfElementLocated(productsCondition));
        String actualCondition = driver.findElement(productsCondition).getText().trim();
        Assert.assertEquals(actualCondition, expectedCondition);

    }
    public void assertOnSearchedProducts(String expectedSearchedProducts){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SearchedProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader));
        String actualSearchedProductsHeader = driver.findElement(searchedProductsHeader).getText().trim();
        Assert.assertEquals(actualSearchedProductsHeader,expectedSearchedProducts);

    }
    // Subscription Assertions

    public void assertOnSubscriptionHeader(String expectedSubscriptionHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionHeader));
        String actualSubscriptionHeader = driver.findElement(subscriptionHeader).getText().trim();
        Assert.assertEquals(actualSubscriptionHeader,expectedSubscriptionHeader);
    }

    public void assertOnSuccessMessage(String expectedSuccessMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successfulSubscriptionMessage));
        String actualSuccessMessage = driver.findElement(successfulSubscriptionMessage).getText().trim();
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

    }
    public void assertOnFirstProductPrice(String expectedPrice){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Price = wait.until(ExpectedConditions.visibilityOfElementLocated(blousePrice));
        String actualPrice = driver.findElement(blousePrice).getText().trim();
        Assert.assertEquals(actualPrice, expectedPrice);


    }
    public void assertOnTotalPrice(String expectedTotalPriceOfBlouse){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(blouseTotalPrice));
        String actualTotalPrice = driver.findElement(blouseTotalPrice).getText().trim();
        Assert.assertEquals(actualTotalPrice,expectedTotalPriceOfBlouse);
    }
    public void assertOnShirtPrice(String expectedPriceOfShirt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Price = wait.until(ExpectedConditions.visibilityOfElementLocated(shirtPrice));
        String actualShirtPrice = driver.findElement(shirtPrice).getText().trim();
        Assert.assertEquals(actualShirtPrice, expectedPriceOfShirt);
    }
    public void assertOnTotalPriceOfShirt(String expectedTotalPriceOfShirt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement totalPriceOfShirt = wait.until(ExpectedConditions.visibilityOfElementLocated(shirtTotalPrice));
        String actualTotalPriceOfShirt = driver.findElement(shirtTotalPrice).getText().trim();
        Assert.assertEquals(actualTotalPriceOfShirt,expectedTotalPriceOfShirt);
    }
    public void assertOnBlouseQuantity(String expectedQuantityOfBlouse){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityOfBlouse));
        String actualQuantityOfBlouse = driver.findElement(quantityOfBlouse).getText().trim();
        Assert.assertEquals(actualQuantityOfBlouse,expectedQuantityOfBlouse);
    }
    public void assertOnShirtQuantity(String expectedQuantityOfShirt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement QuantityOfShirt = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityOfTheShirt));
        String actualQuantityOfShirt = driver.findElement(quantityOfTheShirt).getText().trim();
        Assert.assertEquals(actualQuantityOfShirt,expectedQuantityOfShirt);
    }
    public void assertOnTheTotalQuantity(String expectedTotalQuantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement totalQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(theTotalQuantity));
        String actualTotalQuantity = driver.findElement(theTotalQuantity).getText().trim();
        Assert.assertEquals(actualTotalQuantity,expectedTotalQuantity);

    }

}
