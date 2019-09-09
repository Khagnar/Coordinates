package restful.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import restful.dto.GeoLocationDTO;
import java.io.IOException;
import java.util.Collections;

@Service
public class NominatimService {

    private static final String NOMINATIM_API = "https://nominatim.openstreetmap.org";

    public String getJsonResponse(double latitude, double longitude) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "GeoLocation");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate template = new RestTemplate();

        ResponseEntity<String> response = template.exchange(
                NominatimService.buildCoordinatesURL(latitude, longitude),
                HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public GeoLocationDTO getGeoLocation(String response) {
        GeoLocationDTO geoLocationDTO = null;
        try {
            geoLocationDTO = new ObjectMapper().readValue(response, GeoLocationDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return geoLocationDTO;
    }

    private static String buildCoordinatesURL(double latitude, double longitude) {
        StringBuilder url = new StringBuilder(NOMINATIM_API);
        url.append("/reverse?format=json&lat=");
        url.append(latitude);
        url.append("&lon=");
        url.append(longitude);
        return new String(url);
    }
}
