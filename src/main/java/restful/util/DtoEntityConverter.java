package restful.util;

import restful.dto.AddressDTO;
import restful.dto.GeoLocationDTO;
import restful.entity.AddressEntity;
import restful.entity.GeoLocationEntity;

public class DtoEntityConverter {

    public GeoLocationDTO toDTO(GeoLocationEntity geoLocationEntity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry(geoLocationEntity.getAddress().getCountry());

        GeoLocationDTO geoLocationDTO = new GeoLocationDTO();
        geoLocationDTO.setGeoLocationId(geoLocationEntity.getGeoLocationId());
        geoLocationDTO.setOsmId(geoLocationEntity.getOsmId());
        geoLocationDTO.setOsmType(geoLocationEntity.getOsmType());
        geoLocationDTO.setType(geoLocationEntity.getType());
        geoLocationDTO.setLatitude(geoLocationEntity.getLatitude());
        geoLocationDTO.setLongitude(geoLocationEntity.getLongitude());
        geoLocationDTO.setDisplayName(geoLocationEntity.getDisplayName());
        geoLocationDTO.setAddress(addressDTO);

        return geoLocationDTO;
    }

    public GeoLocationEntity toEntity(GeoLocationDTO geoLocationDTO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(geoLocationDTO.getAddress().getCountry());

        GeoLocationEntity geoLocationEntity = new GeoLocationEntity();
        geoLocationEntity.setGeoLocationId(geoLocationDTO.getGeoLocationId());
        geoLocationEntity.setOsmId(geoLocationDTO.getOsmId());
        geoLocationEntity.setOsmType(geoLocationDTO.getOsmType());
        geoLocationEntity.setType(geoLocationDTO.getType());
        geoLocationEntity.setLatitude(geoLocationDTO.getLatitude());
        geoLocationEntity.setLongitude(geoLocationDTO.getLongitude());
        geoLocationEntity.setDisplayName(geoLocationDTO.getDisplayName());
        geoLocationEntity.setAddress(addressEntity);

        return geoLocationEntity;
    }
}
