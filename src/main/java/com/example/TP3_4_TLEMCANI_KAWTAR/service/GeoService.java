package com.example.TP3_4_TLEMCANI_KAWTAR.service;

import com.example.TP3_4_TLEMCANI_KAWTAR.model.EtalabResponse;
import com.example.TP3_4_TLEMCANI_KAWTAR.model.MeteoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoService {

    @Value("${api.etalab.url}")
    private String etalabUrl;

    @Value("${api.meteo.url}")
    private String meteoUrl;

    // Appel HTTP GET à l'API Etalab pour obtenir les coordonnées GPS à partir de l'adresse
    public EtalabResponse getCoordinatesFromAddress(String address) {
        RestTemplate restTemplate = new RestTemplate();
        String etalabApiUrl = etalabUrl + "?q=" + address + "&limit=1";
        return restTemplate.getForObject(etalabApiUrl, EtalabResponse.class);
    }
    // Exemple de méthode pour appeler l'API météo avec les coordonnées
    public MeteoResponse getWeatherForCoordinates(double latitude, double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String meteoApiUrl = meteoUrl + "?lat=" + latitude + "&lon=" + longitude + "&token=YOUR_API_TOKEN";
        return restTemplate.getForObject(meteoApiUrl, MeteoResponse.class);
    }

}
