package pageobject.tickets.pages;

import io.cucumber.java.sl.In;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageobject.BaseFunc;

public class SeatsPage {

    private final By BOOKING_COMPLETE = By.id("book3");
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_NR = By.xpath(".//div[@class = 'line']");
    private final By BOOK_BTN = By.id("book3");


    private BaseFunc baseFunc;

    public SeatsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public SeatsPage selectSeat(int nr) {
        WebElement seat = findSeat(nr);
        Assertions.assertNotNull(seat, "Cant find nr " + nr);
        baseFunc.click(seat);
        return this;
    }

    public int getSeatNr() {
        return Integer.parseInt(StringUtils.substringAfterLast(baseFunc.getText(SEAT_NR), "is: "));
    }

    public SeatsPage checkIfSelectedSeatIs(int nr){
        Assertions.assertEquals(nr, getSeatNr(), "Wrong seat nr");

        return this;
    }

    public SuccessPage book(){
        baseFunc.click(BOOK_BTN);
        return new SuccessPage(baseFunc);
    }

    private WebElement findSeat(int nr) {
        baseFunc.waitForElementsCountToBeMoreThan(SEAT, 10);
        for (WebElement we : baseFunc.findElements(SEAT)) {
            if (Integer.parseInt(we.getText()) == nr) {
                return we;
            }

        }
        return null;
    }

}
