package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartBtn = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");

    public void addFirstProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the first "Add to Cart" button
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")));
        addToCartBtn.click();

        // Wait for the modal to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='modal-content']")));

        // Click the "Continue Shopping" button
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[text()='Continue Shopping']")));
        continueBtn.click();
    }


    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@href='/view_cart']")));
        cartBtn.click();
    }

}
