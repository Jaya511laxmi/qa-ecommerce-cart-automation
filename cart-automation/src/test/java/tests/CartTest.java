package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCartFlow() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.clickProducts();
        Thread.sleep(2000);

        product.addFirstProductToCart();
        Thread.sleep(2000);

        product.goToCart();
        Thread.sleep(2000);

        // Assertion: Check if cart page is opened
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Checkout") || actualTitle.contains("Cart"), "Cart page not opened.");

        // Assertion: Check if product name is present (simplified)
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Blue Top") || pageSource.contains("Product"), "Product not found in cart.");
    }
}
