package Configuration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseConfiguration {
    public void enterCredentialsAndLogin(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
}
