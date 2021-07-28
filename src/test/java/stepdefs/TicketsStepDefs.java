package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;
import pageobject.tickets.pages.HomePage;
import pageobject.tickets.pages.PassengerInfoPage;
import pageobject.tickets.pages.SeatsPage;
import pageobject.tickets.pages.SuccessPage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private Reservation given = new Reservation();

    private BaseFunc baseFunc;

    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatsPage seatsPage;
    private SuccessPage successPage;

    @Given("flight from {string} to {string}")
    public void set_Airports(String from, String to) {
        given.setAfrom(from);
        given.setAto(to);
    }

    @Given("passenger info:")
    public void set_Info(Map<String, String> info) {
        given.setName(info.get("name"));
        given.setSurname(info.get("surname"));
        given.setDiscount(info.get("discount"));
        given.setAdults(Integer.parseInt(info.get("passenger count")));
        given.setChildren(Integer.parseInt(info.get("child count")));
        given.setBugs(Integer.parseInt(info.get("luggage")));
        given.setFullDate(info.get("date"));
    }

    @Given("seat number is: {int}")
    public void set_Seat_Nr(int nr) {
        given.setSeat(nr);
    }

    @When("we are opening home page")
    public void open_home_page() {
        baseFunc = new BaseFunc();
        baseFunc.openPage("qaguru.lv:8089/tickets");
        homePage = new HomePage(baseFunc);
    }

    @When("selecting airports")
    public void select_airports() {
        infoPage = homePage.selectAirports(given.getAfrom(), given.getAto());
    }

    @Then("airports are displayed on step 2")
    public void check_airports() {
        List<WebElement> airports = infoPage.getAirportnames();
        Assertions.assertEquals(given.getAfrom(), airports.get(0).getText(), "Wrong departure airport");
        Assertions.assertEquals(given.getAto(), airports.get(1).getText(), "Wrong departure airport");

    }

    @When("we are submitting passenger info")
    public void fill_passenger_info() {
        infoPage.submitPassengerInfo(given);
    }

    @Then("name appears in summary")
    public void check_name() {
        Assertions.assertEquals(given.getName(), infoPage.getName(), "Wrong name");
    }

    @Then("price calculated is: (.*)")
    public void check_price(BigDecimal price) {
        Assertions.assertEquals(price, infoPage.getPrice(), "Wrong price");
    }


    @When("we are pressing Book button")
    public void book() {
        seatsPage = infoPage.book();
    }

    @When("selecting seat number")
    public void select_seat() {
        seatsPage.selectSeat((given.getSeat()));
    }

    @Then("seat number appears in page")
    public void check_seat() {
        Assertions.assertEquals(given.getSeat(), seatsPage.getSeatNr(), "Wrong seat nr");
    }


    @When("we are booking flight")
    public void book_flight() {
        successPage = seatsPage.book();
    }

    @Then("success message appears")
    public void check_success_msg() {
        Assertions.assertEquals("Thank you for flying with us!", successPage.getMessage(), "Cant find success message!");
    }
}
