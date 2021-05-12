import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTvNetTest {

    //Example Locators
    private final By LOCATOR_BY_ID = By.id("elmentId"); // Get element by ID
    private final By LOCATOR_BY_NAME = By.name("elementName");// Get element by Name
    private final By LOCATOR_BY_TAGNAME = By.tagName("nameOfTag");//Get element by HTML tag
    private final By LOCATOR_BY_CLASS = By.className("elementByClass");//Get element by class
    private final By LOCATOR_BY_XPATH = By.xpath(".//*[contains(@class, 'list-article__meta-info flex')]");

    //Real locators
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");

    @Test
    public void firstTest() {
        //WebDriver = browser window
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver"); // Way to driver downloaded from i-net
        WebDriver browserWindow = new ChromeDriver();//New variable
        browserWindow.manage().window().maximize();// Maximize browser window
        browserWindow.get("http://tvnet.lv");// Enter web address
//        Thread.sleep(1000); // Don't use this
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        WebDriverWait mailWait = new WebDriverWait(browserWindow, 60, 2000);


        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
//        WebElement acceptButton = browserWindow.findElement(ACCEPT_COOKIES_BTN); //Find element
//        acceptButton.click();//Click btn(element)

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        // Comment for GIT

    }

}
