package Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BaseConfiguration {
    public void navigateToHomePage() {
        driver.get("https://automationexercise.com/");
    }

    public void verifyHomePageIsVisible() {
        try {
            WebElement homeElement = driver.findElement(By.cssSelector("a[href='/']"));
            Assert.assertTrue(homeElement.isDisplayed(), "Home page is not visible");
        } catch (NoSuchElementException e) {
            Assert.fail("Home element is not found on the page");
        }
    }

    public void clickSignupButton() {
        WebElement signupButton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupButton.click();
    }
}
