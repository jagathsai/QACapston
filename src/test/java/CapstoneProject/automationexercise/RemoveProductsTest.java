package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Configuration.BaseConfiguration;

public class RemoveProductsTest extends BaseConfiguration {

    @Test
    public void testCartFlow() {
        driver.get("https://automationexercise.com/products");
        
        WebElement viewProductLink = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        viewProductLink.click();
        
        WebElement closeButton = null;
        try {
            closeButton = driver.findElement(By.cssSelector("CSS_SELECTOR_FOR_CLOSE_BUTTON"));
            closeButton.click();
            System.out.println("Popup closed successfully");
        } catch (NoSuchElementException e) {
            System.out.println("Popup already closed");
        }

        WebElement quantityInput = driver.findElement(By.cssSelector("input[name='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("5");

        // Click 'Add to cart' button
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
        addToCartButton.click();

        WebElement continueShoppingButton = driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block[data-dismiss='modal']"));
        continueShoppingButton.click();
        
        
        WebElement viewCartLink = driver.findElement(By.cssSelector("a[href='/view_cart']"));
        viewCartLink.click();

        // Click 'X' button corresponding to particular product
        WebElement removeProductButton = driver.findElement(By.cssSelector("a.cart_quantity_delete[data-product-id='1']"));
        removeProductButton.click();
        
        driver.quit();
    }
}
