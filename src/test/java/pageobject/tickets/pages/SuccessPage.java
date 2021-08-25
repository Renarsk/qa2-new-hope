package pageobject.tickets.pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.BaseFunc;



public class SuccessPage {
    private final By SUCCESS_TXT = By.xpath(".//div[@class = 'finalTxt']");
    private BaseFunc baseFunc;
    private final String SUCCESS_MSG = "Thank You for flying with us!";

    public SuccessPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getMessage(){
        return baseFunc.getText(SUCCESS_TXT);
    }

    public SuccessPage checkIfSuccessMessageAppear (){
        Assertions.assertEquals("Thank You for flying with us!", getMessage(), "Cant find success message!");

        return this;
    }
}
