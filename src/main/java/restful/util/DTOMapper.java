package restful.util;

import org.modelmapper.ModelMapper;
import restful.dto.GeoLocationDTO;
import restful.entity.GeoLocationEntity;

public class DTOMapper {

    public GeoLocationDTO toDTO(GeoLocationEntity geoLocationEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(geoLocationEntity, GeoLocationDTO.class);
    }

    public GeoLocationEntity toEntity(GeoLocationDTO geoLocationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(geoLocationDTO, GeoLocationEntity.class);
    }
}
