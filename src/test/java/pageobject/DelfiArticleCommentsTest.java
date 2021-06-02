package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

public class DelfiArticleCommentsTest {
    private final Logger LOGGER = LogManager.getLogger(DelfiArticleCommentsTest.class);
    private final int ARTICLE_ID = 1;

    private BaseFunc baseFunc;

    @Test
    public void titleAndCommentsCountCheck() {
        baseFunc = new BaseFunc();
        baseFunc.openPage("http://delfi.lv");


        // ------------ HOME PAGE -------- //
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);


        // ------------ ARTICLE PAGE -------- //

        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentCount,articlePageCommentsCount,"Wrong comments count!");

        articlePage.openCommentsPage();

    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

