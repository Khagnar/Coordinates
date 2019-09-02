package restful.service;

import restful.entity.GeoLocation;

import java.util.List;

public interface GeoLocationService {

    List<GeoLocation> getAllGeoLocation();
    void addGeoLocation(GeoLocation geoLocation);
}
