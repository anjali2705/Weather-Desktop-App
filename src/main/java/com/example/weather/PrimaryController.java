package com.example.weather;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.util.Map;

public class PrimaryController {

    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    private final String cityAPI = "http://api.openweathermap.org/data/2.5/weather?appid={apikey}&units=metric&q=";


    @FXML
    void getWeatherData(ActionEvent event) throws MalformedURLException {
        JSONObject todaysWeather =getWoeid();

        JSONObject main = (JSONObject) todaysWeather.get("main");

        System.out.println(main);

        weatherText.setText(
                "Min temperature: " + main.get("temp_min") + " Celsius" +
                        "\nCurrent temperature: " + main.get("temp") + " Celsius" +
                        "\nMax temperature: " + main.get("temp_max") +" Celsius"
        );
    }

    public JSONObject getWoeid() throws MalformedURLException {
        APIConnector apiConnectorCity = new APIConnector(cityAPI);

          JSONObject jsonData =  (apiConnectorCity.getJSONObject(cityInput.getText()));

        System.out.println(jsonData);
        return jsonData;
    }


}
