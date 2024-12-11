import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutTest {
    WebDriver driver;
    CheckOut checkOutPage;
    String expected_CartHeader = "Shopping Cart";
    String signUpName = "Sarah";
    String signUpEmail = "www.Sarah2024@gmail.com";
    String Password ="abc123" ;
    String FirstName = "Sarah";
    String LastName = "Ali";
    String Company = "GBG";
    String Address1 = "New Cairo,Egypt";
    String Address2 = "New Cairo,Egypt";
    String State = "Cairo";
    String City = "Cairo";
    String Zip_Code = "SW123";
    String Mobile = "01157945461";
    String expected_AccountCreated = "ACCOUNT CREATED!";
    String Comment_Text = "Test Order";
    String Name_OnCard = "SARAH";
    String Card_Number = "123";
    String CVC = "311";
    String Expiry_Month = "06";
    String Expiry_Year = "2025";
    String SuccessfulOrderMessage = "Your order has been placed successfully!";
    String deletedAccount_Message = "ACCOUNT DELETED!";
    String login_Email = "Sarahaly24@gmail.com";
    String login_Password = "1234";
    String expected_EmptyCart = "Cart is empty!";
    String Category = "CATEGORY";
    String Dress_Header = "WOMEN - DRESS PRODUCTS";
    String men_subCategory = "MEN - TSHIRTS PRODUCTS";
    String brands_Header = "BRANDS";
    String sub_Brand = "BRAND - H&M PRODUCTS";
    String expectedAllProductsText = "ALL PRODUCTS";
    String Product = "White Top";
    String Searched_Products = "SEARCHED PRODUCTS";




    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        checkOutPage = new CheckOut(driver);
        checkOutPage.navigateToURL("https://automationexercise.com");
    }
    @Test

    public void TC014Register_WhileCheckout(){
        boolean homePage = checkOutPage.homePageVisibility();
        Assert.assertTrue(homePage);
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForAddToCart(Wait);
        checkOutPage.addThe_FirstProductToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(waits);
        checkOutPage.click_ContinueShopping();
        checkOutPage.click_CartButton();
        checkOutPage.assertOnCartPage(expected_CartHeader);
        checkOutPage.click_ProceedToCheckout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitFor_LoginSignUp(wait);
        checkOutPage.click_LoginSignUp();
        checkOutPage.fill_SignUpName(signUpName);
        checkOutPage.fill_SignUpEmail(signUpEmail);
        checkOutPage.click_SignUpButton();
        checkOutPage.choose_Gender();
        checkOutPage.fill_Password(Password);
        checkOutPage.click_NewsLetterCheckBox();
        checkOutPage.click_SpecialOffersCheckBox();
        checkOutPage.fill_FirstName(FirstName);
        checkOutPage.fill_LastName(LastName);
        checkOutPage.fill_CompanyField(Company);
        checkOutPage.fill_FirstAddressField(Address1);
        checkOutPage.fill_SecondAddressField(Address2);
        checkOutPage.fill_State(State);
        checkOutPage.fill_City(City);
        checkOutPage.fill_ZipCode(Zip_Code);
        checkOutPage.fill_MobileNumber(Mobile);
        checkOutPage.click_CreateAccount();
        checkOutPage.assertOn_AccountCreatedMessage(expected_AccountCreated);
        checkOutPage.click_Continue();
        checkOutPage.click_CartButton();
        checkOutPage.click_ProceedToCheckout();
        checkOutPage.fill_CommentArea(Comment_Text);
        checkOutPage.click_PlaceOrder();
        WebDriverWait Waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForOrderDetails(Waits);
        checkOutPage.fill_NameOnCard(Name_OnCard);
        checkOutPage.fill_CardNumber(Card_Number);
        checkOutPage.fill_CVC(CVC);
        checkOutPage.fill_ExpiryMonth(Expiry_Month);
        checkOutPage.fill_ExpiryYear(Expiry_Year);
        checkOutPage.click_PayAndConfirm();
        checkOutPage.click_DeleteAccount();
        checkOutPage.assertOn_DeletedAccountHeader(deletedAccount_Message);
        checkOutPage.click_Continue();
       //  boolean successfulOrder = checkOutPage.successOrder_Message();
      //  Assert.assertTrue(successfulOrder);
      //  checkOutPage.assertOn_SuccessfulOrder(SuccessfulOrderMessage);
    }
    @Test
    public void TC015Register_BeforeCheckout(){
        boolean homePage = checkOutPage.homePageVisibility();
        Assert.assertTrue(homePage);
        checkOutPage.clickOnSignUpHeader();
        checkOutPage.fill_SignUpName(signUpName);
        checkOutPage.fill_SignUpEmail(signUpEmail);
        checkOutPage.click_SignUpButton();
        checkOutPage.choose_Gender();
        checkOutPage.fill_Password(Password);
        checkOutPage.click_NewsLetterCheckBox();
        checkOutPage.click_SpecialOffersCheckBox();
        checkOutPage.fill_FirstName(FirstName);
        checkOutPage.fill_LastName(LastName);
        checkOutPage.fill_CompanyField(Company);
        checkOutPage.fill_FirstAddressField(Address1);
        checkOutPage.fill_SecondAddressField(Address2);
        checkOutPage.fill_State(State);
        checkOutPage.fill_City(City);
        checkOutPage.fill_ZipCode(Zip_Code);
        checkOutPage.fill_MobileNumber(Mobile);
        checkOutPage.click_CreateAccount();
        checkOutPage.assertOn_AccountCreatedMessage(expected_AccountCreated);
        checkOutPage.click_Continue();
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForAddToCart(Wait);
        checkOutPage.addThe_FirstProductToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(waits);
        checkOutPage.click_ContinueShopping();
        checkOutPage.click_CartButton();
        checkOutPage.assertOnCartPage(expected_CartHeader);
        checkOutPage.click_ProceedToCheckout();
        checkOutPage.fill_CommentArea(Comment_Text);
        checkOutPage.click_PlaceOrder();
        WebDriverWait Waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForOrderDetails(Waits);
        checkOutPage.fill_NameOnCard(Name_OnCard);
        checkOutPage.fill_CardNumber(Card_Number);
        checkOutPage.fill_CVC(CVC);
        checkOutPage.fill_ExpiryMonth(Expiry_Month);
        checkOutPage.fill_ExpiryYear(Expiry_Year);
        checkOutPage.click_PayAndConfirm();
        checkOutPage.click_DeleteAccount();
        checkOutPage.assertOn_DeletedAccountHeader(deletedAccount_Message);
        checkOutPage.click_Continue();
    }
    @Test
    public void TC016LoginBeforeCheckout(){
        boolean homePage = checkOutPage.homePageVisibility();
        Assert.assertTrue(homePage);
        checkOutPage.clickOnSignUpHeader();
        checkOutPage.fill_LoginEmail(login_Email);
        checkOutPage.fill_LoginPasswordField(login_Password);
        checkOutPage.click_LoginButton();
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForAddToCart(Wait);
        checkOutPage.addThe_FirstProductToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(waits);
        checkOutPage.click_ContinueShopping();
        checkOutPage.click_CartButton();
        checkOutPage.assertOnCartPage(expected_CartHeader);
        checkOutPage.click_ProceedToCheckout();
        checkOutPage.fill_CommentArea(Comment_Text);
        checkOutPage.click_PlaceOrder();
        WebDriverWait Waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForOrderDetails(Waits);
        checkOutPage.fill_NameOnCard(Name_OnCard);
        checkOutPage.fill_CardNumber(Card_Number);
        checkOutPage.fill_CVC(CVC);
        checkOutPage.fill_ExpiryMonth(Expiry_Month);
        checkOutPage.fill_ExpiryYear(Expiry_Year);
        checkOutPage.click_PayAndConfirm();
        checkOutPage.click_DeleteAccount();
        checkOutPage.assertOn_DeletedAccountHeader(deletedAccount_Message);
        checkOutPage.click_Continue();
    }
    @Test
    public void TC017RemoveProductFromCart(){
        boolean homePage = checkOutPage.homePageVisibility();
        Assert.assertTrue(homePage);
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForAddToCart(Wait);
        checkOutPage.addThe_FirstProductToCart();
        WebDriverWait WAITS = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(WAITS);
        checkOutPage.click_ContinueShopping();
        WebDriverWait Waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitFor_SecondProduct(Waits);
        checkOutPage.add_SecondProductToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(waits);
        checkOutPage.click_ContinueShopping();
        checkOutPage.click_CartButton();
        checkOutPage.assertOnCartPage(expected_CartHeader);
        checkOutPage.remove_FirstProduct();
        checkOutPage.remove_Product();
        checkOutPage.assertOn_EmptyCart(expected_EmptyCart);

    }
    @Test
    public void TC018Category(){
        boolean Categories = checkOutPage.categoryList_Visibility();
        Assert.assertTrue(Categories);
        String actualCategory = checkOutPage.categoryMethod();

        // Preprocess the brand name to trim it
        actualCategory = checkOutPage.preprocessCategoryName(actualCategory);

        // Assert the brand name
        Assert.assertEquals(actualCategory, Category );
      //  checkOutPage.assertOn_CategoryHeader(Category);

        checkOutPage.click_WomenCategory();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitFor_DressCategory(waits);
        checkOutPage.click_DressCategory();
        String actualWomen_Dress = checkOutPage.women_DressMethod();

        // Preprocess the brand name to trim it
        actualWomen_Dress = checkOutPage.preprocessWomen_Dress(actualWomen_Dress);

        // Assert the brand name
        Assert.assertEquals(actualWomen_Dress, Dress_Header, "Header Doesn't Match");
     //   checkOutPage.assertOn_Women_Dress_Header(Dress_Header);

        checkOutPage.click_MenCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitFor_MenSubCategory(wait);
        checkOutPage.click_MenSubCategory();
        checkOutPage.assertOn_Men_SubCategory_Header(men_subCategory);
    }
    @Test
    public void TC019(){
        checkOutPage.click_Products_Button();
        checkOutPage.assertOn_Brands(brands_Header);
        checkOutPage.click_AnyBrand();
        checkOutPage.assertOn_SubBrand(sub_Brand);
    }
    @Test
    public void TC020(){
        checkOutPage.click_Products_Button();
        checkOutPage.assertOnAllProductsHeader(expectedAllProductsText);
        checkOutPage.search_For_Product(Product);
        checkOutPage.click_Search_Button();
        checkOutPage.assertOnSearched_Products(Searched_Products);
        boolean searchResults = checkOutPage.searchResultsVisibility();
        Assert.assertTrue(searchResults);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitFor_AddToCart(wait);
        checkOutPage.add_ToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkOutPage.waitForContinueShoppingButton(waits);
        checkOutPage.click_ContinueShopping();
        checkOutPage.click_CartButton();
        boolean shoppingCart_Products = checkOutPage.products_InCart_Visibility();
        Assert.assertTrue(shoppingCart_Products);
        checkOutPage.clickOnSignUpHeader();
        checkOutPage.fill_LoginEmail(login_Email);
        checkOutPage.fill_LoginPasswordField(login_Password);
        checkOutPage.click_LoginButton();
        checkOutPage.click_CartButton();
        boolean shoppingCart = checkOutPage.products_InCart_Visibility();
        Assert.assertTrue(shoppingCart);

    }




}
