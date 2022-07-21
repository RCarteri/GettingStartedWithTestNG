import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIPluralsightTest {
    WebDriver driver;

    @BeforeMethod
    public void startupBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/ruehlein/ftabb/navegadores/chrome/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://pluralsight.com");

        doBasicCheck();
    }

    @Test(description = "No exception thrown by findElement considered a successful test")
    public void checkSearchButtonIsPresent() {
        driver.findElement(By.id("searchMobile"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        System.out.println("Closing down the browser");
        driver.close();
    }

    private void doBasicCheck() {
        driver.findElement(By.className("psnav--logo"));
    }
}

