package restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.entity.GeoLocation;
import restful.repository.GeoLocationRepo;
import java.util.List;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    private GeoLocationRepo geoLocationRepo;

    @Autowired
    public void setGeoLocationRepo(GeoLocationRepo geoLocationRepo) {
        this.geoLocationRepo = geoLocationRepo;
    }

    @Override
    public List<GeoLocation> getAllGeoLocation() {
        return geoLocationRepo.findAll();
    }

    @Override
    public void addGeoLocation(GeoLocation geoLocation) {
        geoLocationRepo.save(geoLocation);
    }
}
