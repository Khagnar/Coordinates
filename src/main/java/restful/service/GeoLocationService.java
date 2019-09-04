package restful.service;

import restful.dto.GeoLocationDTO;
import java.util.List;

public interface GeoLocationService {

    List<GeoLocationDTO> getAllGeoLocations();
    GeoLocationDTO addGeoLocation(GeoLocationDTO geoLocationDTO);
}
