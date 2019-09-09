package restful.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import restful.dto.AddressDTO;
import restful.dto.GeoLocationDTO;
import restful.entity.AddressEntity;
import restful.entity.GeoLocationEntity;
import restful.repository.GeoLocationRepo;
import restful.util.DtoEntityConverter;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoLocationServiceImplTest {

    @Autowired
    GeoLocationService geoLocationService;

    @MockBean
    GeoLocationRepo geoLocationRepo;

    private GeoLocationEntity geoLocationEntity = new GeoLocationEntity();
    private AddressEntity addressEntity = new AddressEntity();
    private GeoLocationDTO geoLocationDTO = new GeoLocationDTO();
    private AddressDTO addressDTO = new AddressDTO();
    private DtoEntityConverter converter = new DtoEntityConverter();
    private List<GeoLocationEntity> entityList = new ArrayList<>();
    private List<GeoLocationDTO> dtoList = new ArrayList<>();

    @Before
    public void setUp() {
        addressEntity.setCountry("country");
        geoLocationEntity.setOsmId(123L);
        geoLocationEntity.setAddress(addressEntity);
        geoLocationEntity.setDisplayName("Name");
        geoLocationEntity.setLatitude(2.0);
        geoLocationEntity.setLongitude(3.0);
        geoLocationEntity.setOsmType("OsmType");
        geoLocationEntity.setType("type");

        entityList.add(geoLocationEntity);
    }

    @Test
    public void addGeoLocation() {
        Mockito.when(geoLocationRepo.save(geoLocationEntity)).thenReturn(geoLocationEntity);
        geoLocationDTO = converter.toDTO(geoLocationEntity);
        Assert.assertEquals(geoLocationDTO, geoLocationService.addGeoLocation(geoLocationDTO));
    }

    @Test
    public void getAllGeoLocations() {
        Mockito.when(geoLocationRepo.findAll()).thenReturn(entityList);
        for(GeoLocationEntity geoLocationEntity : entityList) {
            dtoList.add(converter.toDTO(geoLocationEntity));
        }
        Assert.assertEquals(dtoList, geoLocationService.getAllGeoLocations());
    }

    @Test
    public void getAllGeoLocationsByCountry() {
        Mockito.when(geoLocationRepo.findAllByAddress_Country("country")).thenReturn(entityList);
        for(GeoLocationEntity geoLocationEntity : entityList) {
            dtoList.add(converter.toDTO(geoLocationEntity));
        }
        Assert.assertEquals(dtoList, geoLocationService.getAllGeoLocationsByCountry("country"));
    }
}
