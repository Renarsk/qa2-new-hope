package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        LOGGER.info("Accept cookies");
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public WebElement getArticleId(int id) {
        LOGGER.info("Getting article Nr. " + (id + 1));
        List<WebElement> articles = baseFunc.findElements(ARTICLE);

        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        Assertions.assertTrue(articles.size() > id, "Article amount is less than id");

        return articles.get(id);
    }

    public String getTitle(int id) {
        LOGGER.info("Getting title for article with Nr. : " + (id + 1));
        return baseFunc.getText(getArticleId(id), TITLE);
    }

    public int getCommentsCount(int id) {
        LOGGER.info("Getting comments count for article with Nr. : " + (id + 1));

        if (baseFunc.findElements(getArticleId(id), COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(getArticleId(id), COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public ArticlePage openArticle(int id) {
        LOGGER.info("Opening article Nr. " + (id + 1));
        baseFunc.click(getArticleId(id));
        return new ArticlePage(baseFunc);
    }
}
