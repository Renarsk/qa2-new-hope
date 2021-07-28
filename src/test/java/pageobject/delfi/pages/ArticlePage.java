package pageobject.delfi.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class ArticlePage {
    private final By TITLE = By.xpath(".//article[contains(@class,'headline')]");
    private final By COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc){
     this.baseFunc = baseFunc;
    }

    public String getTitle(){
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount(){
        LOGGER.info("Getting article comments count");

        if(baseFunc.findElements(COMMENTS).isEmpty()){
            return 0;
        } else{
            String commentsCountToParse = baseFunc.getText(COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public void openCommentsPage(){
        LOGGER.info("Openting article comments page");
        baseFunc.click(COMMENTS);
    }

}
