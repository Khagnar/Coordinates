package restful.util;

import org.junit.Before;
import org.junit.Test;
import restful.dto.AddressDTO;
import restful.dto.GeoLocationDTO;
import restful.entity.AddressEntity;
import restful.entity.GeoLocationEntity;

import static org.junit.Assert.*;

public class DtoEntityConverterTest {

    private GeoLocationEntity geoLocationEntity = new GeoLocationEntity();
    private AddressEntity addressEntity = new AddressEntity();
    private GeoLocationDTO geoLocationDTO = new GeoLocationDTO();
    private AddressDTO addressDTO = new AddressDTO();
    private DtoEntityConverter dtoEntityConverter = new DtoEntityConverter();

    @Before
    public void setUp() {
        addressDTO.setCountry("country");
        geoLocationDTO.setOsmId(123L);
        geoLocationDTO.setAddress(addressDTO);
        geoLocationDTO.setDisplayName("Name");
        geoLocationDTO.setLatitude(2.0);
        geoLocationDTO.setLongitude(3.0);
        geoLocationDTO.setOsmType("OsmType");
        geoLocationDTO.setType("type");

        addressEntity.setCountry("country");
        geoLocationEntity.setOsmId(123L);
        geoLocationEntity.setAddress(addressEntity);
        geoLocationEntity.setDisplayName("Name");
        geoLocationEntity.setLatitude(2.0);
        geoLocationEntity.setLongitude(3.0);
        geoLocationEntity.setOsmType("OsmType");
        geoLocationEntity.setType("type");
    }

    @Test
    public void toDTO() {
        assertEquals(geoLocationDTO, dtoEntityConverter.toDTO(geoLocationEntity));
    }

    @Test
    public void toEntity() {
        assertEquals(geoLocationEntity, dtoEntityConverter.toEntity(geoLocationDTO));
    }
}