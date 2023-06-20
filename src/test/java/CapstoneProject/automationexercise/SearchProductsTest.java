package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Configuration.BaseConfiguration;

import java.util.Arrays;
import java.util.List;

public class SearchProductsTest extends BaseConfiguration {

    @Test
    public void testCartFlow() {
        driver.get("http://automationexercise.com");

        WebElement productsButton = driver.findElement(By.cssSelector("a[href='/products']"));
        productsButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys("dress");
        WebElement searchButton = driver.findElement(By.cssSelector("button#submit_search"));
        searchButton.click();

        Dimension halfScreenSize = new Dimension(800, 600);
        driver.manage().window().setSize(halfScreenSize);

        List<String> productIds = Arrays.asList("4", "16", "19", "20", "21", "22", "23", "38");
        for (String productId : productIds) {
            WebElement addToCartButton = driver.findElement(By.cssSelector("a[data-product-id='" + productId + "']"));
            addToCartButton.click();
        }

        WebElement viewCartLink = driver.findElement(By.linkText("View Cart"));
        viewCartLink.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[href='/login']"));
        loginLink.click();

        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        emailInput.sendKeys("j@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        passwordInput.sendKeys("Asdfghjkl");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement cartLink = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a"));
        cartLink.click();
    }
}
