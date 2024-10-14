
// retreive weather data from API- this backed logic will fetch  the latest weather
// Data from the external API and return  it. The GUI will display to the user.

import org.example.Applauncher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

// Retrive weather data from API -This backend logic will fetch the latest weather
//Data from  the external API and return it.The GUI will display data to the user.

public class WeatherApp {

    public WeatherApp(){

    }

    // fetch data for the given location
    public static JSONObject getWeatherData(String locationName) {
        JSONArray locationData = getlocationData(locationName);

        return null;
    }

    public static JSONArray getlocationData(String locationName) {

        // replace any whitespace in location name to + to adhere to API's request format.

        // Get location cordinate using the geolocation API.

        JSONArray locationData = getlocationData(locationName);

        // extract lattitude and longitude Data

        JSONObject location  = (JSONObject) locationData.get(0);
        double latitude = (double) location.get("latitude");
        double logitude =(double) location.get("logitude");

        // Build API request URL with location coordinate.

        String urlString ="https://api.open-meteo.com/v1/forecast?"+"latitude ="+33.767+"&longitude=-118.1892"+"&hourly=temperature_2m,relative_humidity_2m,weather_code";


        // retirve geographical cordinate for given location name

        locationName = locationName.replaceAll("", "+");

        // build API url with location parameter

        String urlString  = "https//geocoding-api.open-metro.com/v1/search?name=" + locationName + "&count=10&language=en&forma=jason";

        try {

            // Call API and get a response

            HttpURLConnection conn = fetchApiResponse (urlString);


            // check response status
            //200 means successful connection

            if (conn.getResponseCode() != 200) {

                System.out.println("Error ! could not connect to API");
                return null;

            } else {

                // store the API  result

                StringBuilder resuljson = new StringBuilder();

                Scanner scannner = new Scanner(conn.getInputStream());


                // read and store the resulting json data into our string bulder


                while (scannner.hasNext()) {

                    resuljson.append(scannner.nextLine());
                }

                // close scanner

                scannner.close();

                // close url connection

                conn.disconnect();

                // Parse the JSON string into a JSON obj

                JSONParser parser = new JSONParser();
                JSONObject resultsJsonobj = (JSONObject) parser.parse(String.valueOf(resuljson));

                // Get the list of location data into the API generated from thr location name


                JSONArray locationData = (JSONArray) resultsJsonobj.get("result");

                return locationData;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }


        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) {

        try {

            // attempt to create connect

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            // Set request method to get

            conn.setRequestMethod("GET");

            //Connect  weather API

            conn.connect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // could not  connection
        return null;
    }


}