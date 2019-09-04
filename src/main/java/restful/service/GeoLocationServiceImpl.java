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
        List<GeoLocationDTO> listDTO = new ArrayList<>();
        List<GeoLocationEntity> listEntity = geoLocationRepo.findAll();
        for (GeoLocationEntity geoLocationEntity : listEntity) {
            listDTO.add(mapper.toDTO(geoLocationEntity));
        }
        return listDTO;
    }

    @Override
    public GeoLocationDTO addGeoLocation(GeoLocationDTO geoLocationDTO) {
        return mapper.toDTO(geoLocationRepo.save(mapper.toEntity(geoLocationDTO)));
    }
}
