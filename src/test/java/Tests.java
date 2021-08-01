import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class Tests {
    private static ChromeDriver chromeDriver;
    private static FirefoxDriver firefoxDriver;


    @BeforeClass
    public static void beforeAll() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\davidbi\\Downloads\\chromedriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Git\\chromewebdriver\\chromedriver.exe");
//        chromeDriver = new ChromeDriver();
//        firefoxDriver = new FirefoxDriver();
    }

    //1
    @Ignore
    public void test01_open_websites() {
        chromeDriver.get("https://www.walla.co.il");
        firefoxDriver.get("https://www.ynet.co.il");
    }

    @Test
    public void test02_print_webElements() throws InterruptedException {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://translate.google.com/");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.tagName("textarea")).sendKeys("TagName locator");
        System.out.println(chromeDriver.findElement(By.tagName("textarea")));
        Thread.sleep(5000);
        chromeDriver.findElement(By.tagName("textarea")).clear();
        chromeDriver.findElement(By.className("er8xn")).sendKeys("className locator");
        System.out.println(chromeDriver.findElement(By.className("er8xn")));
        Thread.sleep(5000);
        chromeDriver.close();
    }

    @Test
    public void test03_find_youTube_button() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://youtube.com");
        firefoxDriver.manage().window().maximize();
        System.out.println(firefoxDriver.findElement(By.id("logo-icon")));
        firefoxDriver.findElement(By.id("logo-icon"));
        firefoxDriver.close();
    }

    @Test
    public void test04_selenium_text_field() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.get("http://www.seleniumhq.org");
        firefoxDriver.findElement(By.name("search")).sendKeys("selenium");
        firefoxDriver.close();
    }

    @Test
    public void test05_amazon() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://amazon.com");
//        System.out.println(chromeDriver.getTitle());
        Assert.assertEquals(chromeDriver.getTitle(), "Amazon.com. Spend less. Smile more.");
//just to test xPath        chromeDriver.findElement(By.xpath("//input[@type='text' and @dir='auto']")).sendKeys("Leather shoes");
        chromeDriver.findElementById("twotabsearchtextbox").sendKeys("Leather shoes");
        chromeDriver.findElementById("nav-search-submit-button").click();
        chromeDriver.close();
    }

    @Test
    public void test06_google_translate_hebrew() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://translate.google.com/");
        chromeDriver.findElementByXPath("//textarea[@aria-label='Source text']").sendKeys("שלום");
        chromeDriver.close();
    }

    @Test
    public void test07_open_youtube_search_a_song() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://youtube.com/");
        chromeDriver.findElementById("search").sendKeys("eye of the tiger");
        chromeDriver.findElementById("search-icon-legacy").click();
        chromeDriver.close();
    }

    @Test
    public void test08_cheese_drop() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://dgotlieb.github.io/Controllers/");
        chromeDriver.findElementByXPath("//input[@type='radio' and @value='Cheese']").click();
        chromeDriver.findElementByName("dropdownmenu").click();
        chromeDriver.findElementByXPath("//option[@value='Milk']").click();
        chromeDriver.findElementByName("dropdownmenu").click();
        List<WebElement> dropDownList = chromeDriver.findElements(By.tagName("option"));
        for (WebElement e : dropDownList) {
            System.out.println(e.getText());
        }
        chromeDriver.close();
    }

    @Test
    public void test09_facebook_login() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.facebook.com/?_rdc=1&_rdr");
        chromeDriver.findElementById("email").sendKeys("myemail@gmail.com");
        chromeDriver.findElementById("pass").sendKeys("mypassword");
        chromeDriver.findElementByName("login").click();
        chromeDriver.close();
    }

    @Test
    public void test10_buttons_css() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator");
        System.out.println("2 button height is: " + chromeDriver.findElementById("two").getSize().height);
        System.out.println("6 button width is: " + chromeDriver.findElementById("six").getSize().width);
        chromeDriver.close();

    }

    @Test
    public void test11_click_with_java_script() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator");

        WebElement element = chromeDriver.findElement(By.id("two"));
        JavascriptExecutor executor = chromeDriver;
        executor.executeScript("arguments[0].click();", element);
        chromeDriver.close();

    }

    /*
    *
    * running tests on multiple browsers is possible using Grid
    * https://www.selenium.dev/documentation/en/grid/
    * */
}
