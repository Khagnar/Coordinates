package restful.service;

import restful.dto.GeoLocationDTO;
import java.util.List;

public interface GeoLocationService {
    List<GeoLocationDTO> getAllGeoLocations();
    void addGeoLocation(GeoLocationDTO geoLocationDTO);
    List<GeoLocationDTO> getAllGeoLocationsByCountry(String country);
}
