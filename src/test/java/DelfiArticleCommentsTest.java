import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiArticleCommentsTest {

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");
    private final By HEADERS = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By TITLE = By.xpath(".//article[contains(@class,'headline')]");
    private final By COMMENTS =By.xpath(".//a[@class='comment-count text-red-ribbon']");

    @Test
    public void titleAndCommentsCountCheck() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://delfi.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN)).click();

//        List<WebElement> titles = driver.findElements(HEADERS);






        /*//----------------- FOR -----------------------
        for (int i = 0; i < titles.size(); i++) {

            if (!titles.get(i).getText().isEmpty()) {
                System.out.println(i + ": " + titles.get(i).getText());
            }
        }

        //----------------- FOREACH --------------------
        for (WebElement we : titles) {
            if (!we.getText().isEmpty()) {
                System.out.println(we.getText());
            } else {
                System.out.println("-------------");
            }
            // Short version of If Else   ? true : false (else)
            System.out.println(we.getText().isEmpty() ? "-------" : we.getText());*/

        }
    }
}
