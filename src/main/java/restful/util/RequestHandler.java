package restful.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import restful.json_object.Location;

import java.io.IOException;
import java.util.Collections;

public class RequestHandler {

    public static String getJsonResponce(double latitude, double longitude) {

        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitude + "&lon=" + longitude;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "GeoLocation");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate template = new RestTemplate();

        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public static Location getGeoLocation(String response) {
        Location location = null;
        try {
             location = new ObjectMapper().readValue(response, Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return location;
    }
}
