package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city ID: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeatherData(cityId);
    }

    @Then("coordinates are:")
    public void check_coords(Map<String, Double> coords) {
        Assertions.assertEquals(coords.get("lon"), response.getCoord().getLon(), "Incorrect Coord Lon!");
        Assertions.assertEquals(coords.get("lat"), response.getCoord().getLat(), "Incorrect Coord Lat!");
    }

    @Then("sys is:")
    public void check_sys(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("type")), response.getSys().getType(), "Wrong ");
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getSys().getId(), "Wrong ID");
        Assertions.assertEquals(Double.parseDouble(params.get("message")), response.getSys().getMessage(), "Wrong message ");
        Assertions.assertEquals(params.get("country"), response.getSys().getCountry(), "Wrong Country ");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getSys().getSunrise(), "Wrong ");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getSys().getSunset(), "Wrong ");

        
    }

    @Then("weathers are:")
    public void check_weathers(DataTable dataTable) {
        List<Map<String, String>> weathers = dataTable.asMaps();

        Assertions.assertEquals(weathers.size(), response.getWeathers().size(), "Wrong ...");

        for (int i = 0; i < weathers.size(); i++) {
            Map<String, String> expectedWeather = weathers.get(i);
            Weather actualWeather = response.getWeathers().get(i);

            Assertions.assertEquals(Long.parseLong(expectedWeather.get("id")), actualWeather.getId(), "Wrong ...");
            Assertions.assertEquals(expectedWeather.get("main"), actualWeather.getMain(), "Wrong ...");
            Assertions.assertEquals(expectedWeather.get("description"), actualWeather.getDescription(), "Wrong ...");
            Assertions.assertEquals(expectedWeather.get("icon"), actualWeather.getIcon(), "Wrong ...");
        }

    }
}
