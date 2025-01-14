package com.example.TP3_4_TLEMCANI_KAWTAR.controller;

import com.example.TP3_4_TLEMCANI_KAWTAR.service.GeoService;
import com.example.TP3_4_TLEMCANI_KAWTAR.model.EtalabResponse;
import com.example.TP3_4_TLEMCANI_KAWTAR.model.MeteoResponse;
import com.example.TP3_4_TLEMCANI_KAWTAR.model.MeteoResponse.DailyForecastItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {

    private final GeoService geoService;

    public MeteoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @PostMapping("/meteo")
    public String getMeteo(@RequestParam(name = "address") String address, Model model) {
        EtalabResponse etalabResponse = geoService.getCoordinatesFromAddress(address);

        if (etalabResponse != null && !etalabResponse.getFeatures().isEmpty()) {
            double latitude = etalabResponse.getFeatures().get(0).getGeometry().getCoordinates().get(0);
            double longitude = etalabResponse.getFeatures().get(0).getGeometry().getCoordinates().get(1);
                System.out.println("lat "+latitude+ "log"+longitude);
            String meteoApiUrl = "https://api.meteo-concept.com/api/forecast/daily?token=77968e5d3fd016867e01617ed6343f0ea841b40e3e82db570c57c4fab04f1ca0&latlng="+longitude+","+latitude;

            RestTemplate restTemplate = new RestTemplate();
            MeteoResponse meteoResponse = restTemplate.getForObject(meteoApiUrl, MeteoResponse.class);

            System.out.println("urll "+meteoApiUrl);

            if (meteoResponse != null && meteoResponse.getForecast() != null && meteoResponse.getForecast().length > 0) {
                DailyForecastItem forecast = meteoResponse.getForecast()[0];

                model.addAttribute("address", address);
                model.addAttribute("latitude", latitude);
                model.addAttribute("longitude", longitude);
                model.addAttribute("weather", forecast.getWeather());
                model.addAttribute("temperatureMin",  + forecast.getTmin() + "°C");
                model.addAttribute("temperatureMax",  + forecast.getTmax() + "°C");
                model.addAttribute("windSpeed", forecast.getWind10m() + " km/h");
                model.addAttribute("gustSpeed", forecast.getGust10m() + " km/h");
                model.addAttribute("rainfall", forecast.getRr1() + " mm");
                model.addAttribute("rainProbability", forecast.getProbarain() + "%");
            } else {
                model.addAttribute("error", "No weather data available for this location.");
            }
        } else {
            model.addAttribute("error", "Coordinates not found for address: " + address);
        }

        return "meteo";

    }
}
