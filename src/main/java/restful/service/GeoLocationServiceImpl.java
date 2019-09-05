package restful.service;

import org.springframework.stereotype.Service;
import restful.dto.GeoLocationDTO;
import restful.entity.GeoLocationEntity;
import restful.repository.GeoLocationRepo;
import restful.util.DTOMapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    private GeoLocationRepo geoLocationRepo;
    private DTOMapper mapper = new DTOMapper();

    public GeoLocationServiceImpl(GeoLocationRepo geoLocationRepo) {
        this.geoLocationRepo = geoLocationRepo;
    }

    @Override
    public List<GeoLocationDTO> getAllGeoLocations() {
        List<GeoLocationEntity> listEntity = geoLocationRepo.findAll();
        List<GeoLocationDTO> listDTO = new ArrayList<>();
        for (GeoLocationEntity geoLocationEntity : listEntity) {
            listDTO.add(mapper.toDTO(geoLocationEntity));
        }
        return listDTO;
    }

    @Override
    public void addGeoLocation(GeoLocationDTO geoLocationDTO) {
        mapper.toDTO(geoLocationRepo.save(mapper.toEntity(geoLocationDTO)));
    }

    @Override
    public List<GeoLocationDTO> getAllGeoLocationsByCountry(String country) {
        List<GeoLocationEntity> listEntity = geoLocationRepo.findAllByAddress_Country(country);
        List<GeoLocationDTO> listDTO = new ArrayList<>();
        for (GeoLocationEntity geoLocationEntity : listEntity) {
            listDTO.add(mapper.toDTO(geoLocationEntity));
        }
        return listDTO;
    }
}
