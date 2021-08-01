import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    private static WebDriver driver;
    private static WebDriver driver1;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Git\\chromewebdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.walla.co.il");
        driver.quit();

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\davidbi\\Downloads\\chromedriver\\geckodriver.exe");
        driver1 = new FirefoxDriver();
        driver1.get("https://www.ynet.co.il");
        driver1.quit();





    }
}
