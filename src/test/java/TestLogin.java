import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {

    private WebDriver driver;
    private WebDriverWait wait;
    final String url = "http://localhost/litecart/admin/login.php";

    @Before
    public void start()
    {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void testLogin()
    {
        driver.get(url);
        WebElement inputLogin = driver.findElement(By.xpath("//input[@name='username']"));
        wait.until(ExpectedConditions.visibilityOf(inputLogin));
        inputLogin.sendKeys("admin");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys("admin");

        System.out.println("Data filled");

        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        btnLogin.click();

        WebElement loginText = driver.findElement(By.xpath("//*[contains(text(), 'You are now logged in as admin')]"));
        wait.until(ExpectedConditions.visibilityOf(loginText));

        System.out.println("login completed");

    }

    @After
    public  void stop()
    {
        driver.quit();
        driver = null;
    }
}
