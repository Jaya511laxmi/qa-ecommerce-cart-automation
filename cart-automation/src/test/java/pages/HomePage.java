package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By productsMenu = By.xpath("//a[@href='/products']");

    public void clickProducts() {
        driver.findElement(productsMenu).click();
    }
}
