import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckOut {
    WebDriver driver;
    public CheckOut (WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private By homePage = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By addToCartButton = By.xpath("//a[@data-product-id=\"1\"]");
    private By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private By cartButton = By.xpath("//a[text()=' Cart']");
    private By shoppingCartheader = By.xpath("//Li[text()='Shopping Cart']");
    private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By login_SignUpButton = By.xpath("//u[text()='Register / Login']");
    private By signUpNameField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signUp_InputButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By signUp_HeaderHomePage = By.xpath("//a[@href=\"/login\"]");
    // Locators For SignUp Information
    private By maleGender_Input = By.xpath("//input[@id=\"id_gender1\"]");
    private By femaleGender_Input = By.xpath("//input[@id=\"id_gender2\"]");
    private By password_InputField = By.xpath("//input[@type=\"password\"]");
    private By newsLetter_CheckBox = By.xpath("//input[@name=\"newsletter\"]");
    private By specialOffers_CheckBox = By.xpath("//input[@name=\"optin\"]");
    private By firstName_InputField = By.xpath("//input[@data-qa=\"first_name\"]");
    private By lastName_InputField = By.xpath("//input[@data-qa=\"last_name\"]");
    private By company_Field = By.xpath("//input[@data-qa=\"company\"]");
    private By first_AddressField = By.xpath("//input[@data-qa=\"address\"]");
    private By second_AddressField = By.xpath("//input[@data-qa=\"address2\"]");
    private By state_InputField = By.xpath("//input[@data-qa=\"state\"]");
    private By city_InputField = By.xpath("//input[@data-qa=\"city\"]");
    private By zipcode_InputField = By.xpath("//input[@data-qa=\"zipcode\"]");
    private By mobileNumber_InputField = By.xpath("//input[@data-qa=\"mobile_number\"]");
    private By createAccount_Button = By.xpath("//button[@data-qa=\"create-account\"]");
    private By accountCreated_Header = By.xpath("//b[text()=\"Account Created!\"]");
    private By continue_Button = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By first_AddressBox = By.xpath("//uL[@class=\"address item box\"]");
    private By second_AddressBox = By.xpath("//uL[@class=\"address alternate_item box\"]");
    private By comment_Area = By.xpath("//textarea[@class=\"form-control\"]");
    private By placeOrder_Button = By.xpath("//a[@href=\"/payment\"]");
    private By nameOnCard_Field = By.xpath("//input[@name=\"name_on_card\"]");
    private By cardNumber_Field = By.xpath("//input[@data-qa=\"card-number\"]");
    private By CVC_InputField = By.xpath("//input[@data-qa=\"cvc\"]");
    private By expiryMonth_Input = By.xpath("//input[@class=\"form-control card-expiry-month\"]");
    private By expiryYear_Input = By.xpath("//input[@name=\"expiry_year\"]");
    private By payAndConfirm_Button = By.xpath("//button[@data-qa=\"pay-button\"]");
    private By successfulOrder_Message = By.xpath("//div[@id=\"success_message\"]");
    private By deleteAccount_Button = By.xpath("//a[@href=\"/delete_account\"]");
    private By deletedAccount_Header = By.xpath("//b[text()='Account Deleted!']");
    private By remove_FirstProduct = By.xpath("//a[@data-product-id=\"1\"]");
    private By remove_button = By.xpath("//a[@data-product-id=\"2\"]");
    private By add_SecondProduct = By.xpath("//a[@data-product-id=\"2\"]");
    private By emptyCart_Header = By.xpath("//b[text()='Cart is empty!']");
    // Category
    private By category_List = By.xpath("//div[@class=\"panel-group category-products\"]");
    private By category_Header = By.xpath("//h2[text()='Category']");
    private By women_Category = By.xpath("//a[@href=\"#Women\"]");
    private By dress_Category = By.xpath("//a[@href=\"/category_products/1\"]");
    private By women_Dress_header = By.xpath("//h2[@class=\"title text-center\"]");
    private By men_category = By.xpath("//a[@href=\"#Men\"]");
    private By men_SubCategory = By.xpath("//a[@href=\"/category_products/3\"]");
    private By men_SubCategoryHeader = By.xpath("//h2[text()='Men - Tshirts Products']");
    private By products_Button = By.xpath("//a[@href=\"/products\"]");
    private By brands_Header = By.xpath("//h2[text()='Brands']");
    private By subBrand_Button = By.xpath("//a[@href=\"/brand_products/H&M\"]");
    private By subBrand_Header = By.xpath("//h2[text()='Brand - H&M Products']");
    // Login Locators
    private By loginEmail_Field = By.xpath("//input[@data-qa=\"login-email\"]");
    private By login_PasswordField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By login_Button = By.xpath("//button[@data-qa=\"login-button\"]");
    private By allProductsHeader = By.xpath("//h2[text()='All Products']");
    private By searchField = By.xpath("//input[@name=\"search\"]");
    private By searchButton = By.xpath("//button[@id=\"submit_search\"]");
    private By searchedProductsHeader =By.xpath("//h2[text()='Searched Products']");
    private By search_results = By.xpath("//div[@class=\"features_items\"]");
    private By add_Product_ToCart = By.xpath("//a[@data-product-id=\"6\"]");
    private By products_InCart = By.xpath("//tr[@id=\"product-6\"]");



    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }
    // Add any product to Cart
    public void waitForAddToCart(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }
    public void clickOnSignUpHeader(){
        driver.findElement(signUp_HeaderHomePage).click();
    }
    public void addThe_FirstProductToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void waitForContinueShoppingButton(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
    }
    public void click_ContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }
    public void click_CartButton(){
        driver.findElement(cartButton).click();
    }
    public void click_ProceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
    }
    public void waitFor_LoginSignUp(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(login_SignUpButton));
    }
    public void click_LoginSignUp(){
        driver.findElement(login_SignUpButton).click();
    }
    public void fill_SignUpName(String Name){
        driver.findElement(signUpNameField).sendKeys(Name);
    }
    public void fill_SignUpEmail(String Email){
        driver.findElement(signUpEmailField).sendKeys(Email);
    }
    public void click_SignUpButton(){
        driver.findElement(signUp_InputButton).click();
    }
    public void choose_Gender(){
        driver.findElement(femaleGender_Input).click();
    }
    public void fill_Password(String Password){
        driver.findElement(password_InputField).sendKeys(Password);
    }
    public void click_NewsLetterCheckBox(){
        driver.findElement(newsLetter_CheckBox).click();
    }
    public void click_SpecialOffersCheckBox(){
        driver.findElement(specialOffers_CheckBox).click();
    }
    public void fill_FirstName(String FirstName){
        driver.findElement(firstName_InputField).sendKeys(FirstName);
    }
    public void fill_LastName(String LastName){
        driver.findElement(lastName_InputField).sendKeys(LastName);
    }
    public void fill_CompanyField(String Company){
        driver.findElement(company_Field).sendKeys(Company);
    }
    public void fill_FirstAddressField(String Address1){
        driver.findElement(first_AddressField).sendKeys(Address1);
    }
    public void fill_SecondAddressField(String Address2){
        driver.findElement(second_AddressField).sendKeys(Address2);
    }
    public void fill_State(String State){
        driver.findElement(state_InputField).sendKeys(State);
    }
    public void fill_City(String City){
        driver.findElement(city_InputField).sendKeys(City);
    }
    public void fill_ZipCode(String ZipCode){
        driver.findElement(zipcode_InputField).sendKeys(ZipCode);
    }
    public void fill_MobileNumber(String MobileNumber){
        driver.findElement(mobileNumber_InputField).sendKeys(MobileNumber);
    }
    public void click_CreateAccount(){
        driver.findElement(createAccount_Button).click();
    }
    public void click_Continue(){
        driver.findElement(continue_Button).click();
    }
    public void fill_CommentArea(String Comment){
        driver.findElement(comment_Area).sendKeys(Comment);
    }
    public void click_PlaceOrder(){
        driver.findElement(placeOrder_Button).click();
    }
    public void waitForOrderDetails(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(nameOnCard_Field));
    }
    public void fill_NameOnCard(String CardName){
        driver.findElement(nameOnCard_Field).sendKeys(CardName);
    }
    public void fill_CardNumber(String CardNumber){
        driver.findElement(cardNumber_Field).sendKeys(CardNumber);
    }
    public void fill_CVC(String CVC){
        driver.findElement(CVC_InputField).sendKeys(CVC);
    }
    public void fill_ExpiryMonth(String Month){
        driver.findElement(expiryMonth_Input).sendKeys(Month);
    }
    public void fill_ExpiryYear(String Year){
        driver.findElement(expiryYear_Input).sendKeys(Year);
    }
    public  void click_PayAndConfirm(){
        driver.findElement(payAndConfirm_Button).click();
    }
    public void click_DeleteAccount(){
        driver.findElement(deleteAccount_Button).click();
    }


    //Remove product Methods
    public void waitFor_SecondProduct(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(add_SecondProduct));
    }
    public void add_SecondProductToCart(){
        driver.findElement(add_SecondProduct).click();
    }
    public void remove_FirstProduct(){
        driver.findElement(remove_FirstProduct).click();
    }
    public void remove_Product(){
        driver.findElement(remove_button).click();
    }


    // Login Methods
    public void fill_LoginEmail(String login_Email){
        driver.findElement(loginEmail_Field).sendKeys(login_Email);
    }
    public void fill_LoginPasswordField(String login_Password){
        driver.findElement(login_PasswordField).sendKeys(login_Password);
    }
    public void click_LoginButton(){
        driver.findElement(login_Button).click();
    }

    // Category Methods

    public void click_WomenCategory(){
        driver.findElement(women_Category).click();
    }

    public void waitFor_DressCategory(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(dress_Category));
    }
    public void click_DressCategory(){
        driver.findElement(dress_Category).click();
    }
    public void click_MenCategory(){
        driver.findElement(men_category).click();
    }
    public void waitFor_MenSubCategory(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(men_SubCategory));
    }
    public void click_MenSubCategory(){
        driver.findElement(men_SubCategory).click();
    }
    public void click_Products_Button(){
        driver.findElement(products_Button).click();
    }
    public void click_AnyBrand(){
        driver.findElement(subBrand_Button).click();
    }
    public void search_For_Product(String Product){
        driver.findElement(searchField).sendKeys(Product);
    }
    public void click_Search_Button(){
        driver.findElement(searchButton).click();
    }
    public void waitFor_AddToCart(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(add_Product_ToCart));
    }
    public void add_ToCart(){
        driver.findElement(add_Product_ToCart).click();
    }






    //Assertions
    // Home Page Visibility
    public boolean homePageVisibility(){
        WebElement PageLogo = driver.findElement(homePage);
        return PageLogo.isDisplayed();
    }

    public void assertOnCartPage(String expectedCart_Header){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Cart = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartheader));
        String actualCart_Header = driver.findElement(shoppingCartheader).getText().trim();
        Assert.assertEquals(actualCart_Header,expectedCart_Header);
    }
    public void assertOn_AccountCreatedMessage(String expected_AccountCreated){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement AccountCreatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreated_Header));
        String actual_AccountCreated = driver.findElement(accountCreated_Header).getText().trim();
        Assert.assertEquals(actual_AccountCreated,expected_AccountCreated);
    }
    // Successful Order Message
    public boolean successOrder_Message() {
        WebElement successfulOrder = driver.findElement(successfulOrder_Message);
        return successfulOrder.isDisplayed();
    }
    public void assertOn_SuccessfulOrder(String expected_SuccessMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successfulOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(successfulOrder_Message));
        String actual_SuccessMessage = driver.findElement(successfulOrder_Message).getText().trim();
        Assert.assertEquals(actual_SuccessMessage,expected_SuccessMessage);
    }
    public void assertOn_DeletedAccountHeader(String expectedDeletedAccount ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DeletedAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(deletedAccount_Header));
        String actual_DeletedAccount = driver.findElement(deletedAccount_Header).getText().trim();
        Assert.assertEquals(actual_DeletedAccount,expectedDeletedAccount);

    }
    public void assertOn_EmptyCart(String expected_EmptyCartHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement EmptyCart = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart_Header));
        String actual_EmptyCartHeader = driver.findElement(emptyCart_Header).getText().trim();
        Assert.assertEquals(actual_EmptyCartHeader,expected_EmptyCartHeader);

    }
    public String categoryMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(category_Header));
        return categoryHeaderElement.getText();
    }
    public String preprocessCategoryName(String Category) {
        return Category.trim();
    }
    //public void assertOn_CategoryHeader(String expected_CategoryHeader){
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      //  WebElement Category = wait.until(ExpectedConditions.visibilityOfElementLocated(category_Header));
      //  String actual_CategoryHeader = driver.findElement(category_Header).getText().trim();
      //  Assert.assertEquals(actual_CategoryHeader,expected_CategoryHeader);

  //  }
    public String women_DressMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement women_DressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(women_Dress_header));
        return women_DressElement.getText();
    }
    public String preprocessWomen_Dress(String Dress) {
        return Dress.trim();
    }
    public void assertOn_Men_SubCategory_Header(String expected_men_subCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement men_Tshirts= wait.until(ExpectedConditions.visibilityOfElementLocated(men_SubCategoryHeader));
        String actual_menSubCategory = driver.findElement(men_SubCategoryHeader).getText().trim();
        Assert.assertEquals(actual_menSubCategory,expected_men_subCategory);

    }
    public boolean categoryList_Visibility(){
        WebElement Categories = driver.findElement(category_List);
        return Categories.isDisplayed();
    }
    public void assertOn_Brands(String expected_Brands){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Brands= wait.until(ExpectedConditions.visibilityOfElementLocated(brands_Header));
        String actual_Brands = driver.findElement(brands_Header).getText().trim();
        Assert.assertEquals(actual_Brands,expected_Brands);
    }
    public void assertOn_SubBrand(String expected_SubBrand){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement subBrand= wait.until(ExpectedConditions.visibilityOfElementLocated(subBrand_Header));
        String actual_subBrand = driver.findElement(subBrand_Header).getText().trim();
        Assert.assertEquals(actual_subBrand,expected_SubBrand);
    }
    public void assertOnAllProductsHeader(String expectedAllProducts){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement allProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader));
        String actualAllProducts = driver.findElement(allProductsHeader).getText().trim();
        Assert.assertEquals(actualAllProducts,expectedAllProducts);
    }
    public boolean searchResultsVisibility(){
        WebElement searchResults = driver.findElement(search_results);
        return searchResults.isDisplayed();
    }
    public boolean products_InCart_Visibility(){
        WebElement ShoppingCart = driver.findElement(products_InCart);
        return ShoppingCart.isDisplayed();
    }
    public void assertOnSearched_Products(String expectedSearchedProducts){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searched_ProductsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader));
        String actual_SearchedProducts = driver.findElement(searchedProductsHeader).getText().trim();
        Assert.assertEquals(actual_SearchedProducts,expectedSearchedProducts);
    }













}
