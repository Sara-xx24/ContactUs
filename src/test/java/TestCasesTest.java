//public class TestCasesTest {}
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;


public class TestCasesTest {
    WebDriver driver;
    TestCases TestCasesPage;

    String expectedTestCasesHeader = " Cases";
    String expectedAllProductsText = "ALL PRODUCTS";
    String expectedProductName = "Blue Top";
    String expectedCategory = "Category: Women > Tops";
    String expectedPrice = "Rs. 500";
    String expectedAvailabilityHeader = "Availability:";
    String expectedAvailability="Availability: In Stock";
    String expectedConditionHeader = "Condition:";
    String expectedCondition="Condition: New";
    String expectedBrand = "Brand: Polo";
    String product = "Top";
    String expectedSearchedHeader = "SEARCHED PRODUCTS";
    String expectedSubscription = "SUBSCRIPTION";
    String subscriptionEmail = "www.sarahaly2000@gmail.com";
    String expectedSuccessMessage = "You have been successfully subscribed!";
    String BlousePrice = "Rs. 500";
    String totalPriceOfBlouse = "Rs. 500";
    String expectedPriceOfShirt = "Rs. 400";
    String totalPriceOfShirt = "Rs. 400";
    String expectedBlouseQuantity = "1";
    String expectedQuantityOfShirt = "1";
    String desiredQuantity = "4";
    String expectedTotalQuantity = "4";





    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestCasesPage = new TestCases(driver);
        TestCasesPage.navigateToURL("https://automationexercise.com");
    }

    // Test Cases
    @Test
    public void TC07(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        // Explicit wait before Clicking on Test Cases
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        TestCasesPage.waitForTestCasesHeader(wait);
        TestCasesPage.clickOnTestCasesHeader();
        // TestCasesPage.assertOnTestCasesPage(expectedTestCasesHeader);
    }

    @Test
    public void TC08(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.clickOnProducts();
        TestCasesPage.assertOnAllProductsHeader(expectedAllProductsText);
        TestCasesPage.clickOnViewProduct();
        TestCasesPage.assertOnProductName(expectedProductName);
        TestCasesPage.assertOnProductCategory(expectedCategory);
        TestCasesPage.assertOnProductPrice(expectedPrice);
        TestCasesPage.AssertOnAvailable(expectedAvailabilityHeader);
        TestCasesPage.assertOnProductAvailability(expectedAvailability);
        TestCasesPage.assertOnConditionHeader(expectedConditionHeader);
        TestCasesPage.assertOnProductCondition(expectedCondition);
        String actualBrandName = TestCasesPage.brandNameMethod();

        // Preprocess the brand name to trim it
         actualBrandName = TestCasesPage.preprocessBrandName(actualBrandName);

        // Assert the brand name
        Assert.assertEquals(actualBrandName, expectedBrand, "Brand name does not match!");
    }

    @Test
    public void TC09(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.clickOnProducts();
        TestCasesPage.assertOnAllProductsHeader(expectedAllProductsText);
        TestCasesPage.typeInSearchBar(product);
        TestCasesPage.clickOnSearchButton();
        TestCasesPage.assertOnSearchedProducts(expectedSearchedHeader);
        TestCasesPage.viewSearchResults();
    }

    @Test
    public void TC010(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.scrollToTheFooter();
        TestCasesPage.assertOnSubscriptionHeader(expectedSubscription);
        TestCasesPage.enterSubscriptionMail(subscriptionEmail);
        TestCasesPage.clickOnArrowButton();
        TestCasesPage.assertOnSuccessMessage(expectedSuccessMessage);
    }

    @Test
    public void TC011(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.clickOnCartButton();
        TestCasesPage.scrollToTheFooter();
        TestCasesPage.assertOnSubscriptionHeader(expectedSubscription);
        TestCasesPage.enterSubscriptionMail(subscriptionEmail);
        TestCasesPage.clickOnArrowButton();
        TestCasesPage.assertOnSuccessMessage(expectedSuccessMessage);
    }

    @Test
    public void TC012(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.clickOnProducts();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        TestCasesPage.waitForAddToCart(wait);
        TestCasesPage.clickAddToCart();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
        TestCasesPage.waitForContinueShoppingButton(waits);
        TestCasesPage.clickToContinueShopping();
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        TestCasesPage.waitForAddToCart2(Wait);
        TestCasesPage.clickAddToCart2();
        WebDriverWait Wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        TestCasesPage.waitForViewCart(Wait2);
        TestCasesPage.clickViewCart();
        TestCasesPage.assertOnFirstProductPrice(BlousePrice);
        TestCasesPage.assertOnTotalPrice(totalPriceOfBlouse);
        TestCasesPage.assertOnShirtPrice(expectedPriceOfShirt);
        TestCasesPage.assertOnTotalPriceOfShirt(totalPriceOfShirt);
        TestCasesPage.assertOnBlouseQuantity(expectedBlouseQuantity);
        TestCasesPage.assertOnShirtQuantity(expectedQuantityOfShirt);
    }
    @Test
    public void TC013(){
        boolean homePage = TestCasesPage.homePageVisibility();
        Assert.assertTrue(homePage);
        TestCasesPage.clickOnViewTheProduct();
        // Assert That all product's details are Visible
        boolean productDetails = TestCasesPage.productInformationVisibility();
        Assert.assertTrue(productDetails);
        TestCasesPage.setQuantity(desiredQuantity);
        TestCasesPage.clickOnAddToCart();
        WebDriverWait Wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        TestCasesPage.waitForViewCart(Wait2);
        TestCasesPage.clickViewCart();
        TestCasesPage.assertOnTheTotalQuantity(expectedTotalQuantity);
    }



    @AfterMethod
   public void teardown(){
      driver.quit();
   }

}



