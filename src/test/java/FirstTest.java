import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    final String url = "https://www.raiffeisen.ru/";

    @Before
    public void start()
    {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void firstTest()
    {
        driver.get(url);

    }

    @After
    public  void stop()
    {
        driver.quit();
        driver = null;
    }

}
